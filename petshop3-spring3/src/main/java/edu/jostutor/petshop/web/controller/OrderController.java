package edu.jostutor.petshop.web.controller;

import edu.jostutor.petshop.dao.AccountDao;
import edu.jostutor.petshop.dao.OrderDao;
import edu.jostutor.petshop.entity.*;
import edu.jostutor.petshop.web.controller.util.CartUtil;
import edu.jostutor.petshop.web.controller.util.SecurityUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * User: xulixin
 * Date: 2013-3-19
 * Time: 上午10:22
 * To change this template use File | Settings | File Templates.
 */
@Controller
public class OrderController {

    @Autowired
    private OrderDao orderDao;

    @Autowired
    private AccountDao accountDao;

    @RequestMapping(value="/OrderBilling.aspx", method = RequestMethod.GET)
    public String startOrderBilling(Model model) throws Exception {
        Account account = accountDao.getAccountByUsername(SecurityUtil.getUsername(null));
        if (account != null) {
            model.addAttribute("address", account.getAddress());
        }
        model.addAttribute("enterAddressVisible", true);
        model.addAttribute("confirmAddressVisible", false);
        return "orderBilling";
    }

    @RequestMapping(value="/OrderBilling.aspx", method = RequestMethod.POST)
    public String confirmOrderBilling(CreditCard creditCard, Address address,
                                      HttpServletRequest request, Model model) throws Exception {

        Cart cart = CartUtil.getCartFromSession(request);
        String expYear = request.getParameter("expYear");
        String expMonth = request.getParameter("expMonth");
        creditCard.setCardExpiration(expMonth + "/" + expYear);
        cart.setCreditCard(creditCard);
        cart.setBillingAddress(address);
        String shipBilling = request.getParameter("shipBilling");
        if (shipBilling == null) { // 没有提交与账单地址相同的标志
            return "redirect:OrderShipping.aspx";
        }
        cart.setShippingAddress(address);
        model.addAttribute("addressBilling", address);
        model.addAttribute("addressShipping", address);
        model.addAttribute("enterAddressVisible", false);
        model.addAttribute("confirmAddressVisible", true);
        return "orderBilling";
    }

    @RequestMapping(value="/OrderShipping.aspx", method = RequestMethod.GET)
    public String startOrderShipping(Model model) throws Exception {
        model.addAttribute("enterShipAddressVisible", true);
        model.addAttribute("confirmAddressVisible", false);
        return "orderShipping";
    }

    @RequestMapping(value="/OrderShipping.aspx", method = RequestMethod.POST)
    public String confirmOrderShipping(@ModelAttribute Address address, BindingResult result,
                                       HttpServletRequest request, Model model) throws Exception {

        AddressValidator validator = new AddressValidator();
        validator.validate(address, result);
        if (result.hasErrors()) {
            model.addAttribute("enterShipAddressVisible", true);
            model.addAttribute("confirmAddressVisible", false);
            return "orderShipping";
        }
        Cart cart = CartUtil.getCartFromSession(request);
        cart.setShippingAddress(address);
        model.addAttribute("addressBilling", cart.getBillingAddress());
        model.addAttribute("addressShipping", address);
        model.addAttribute("enterShipAddressVisible", false);
        model.addAttribute("confirmAddressVisible", true);
        return "orderShipping";
    }

    private class CreditCardValidator implements Validator {

        @Override
        public boolean supports(Class<?> clazz) {
            return clazz.equals(CreditCard.class);
        }

        @Override
        public void validate(Object target, Errors errors) {
            ValidationUtils.rejectIfEmpty(errors, "cardNumber", "creditcard.cardNumber.required", "Please enter card number.");
        }
    }

        private class AddressValidator implements Validator {

            @Override
            public boolean supports(Class<?> clazz) {
                return clazz.equals(Address.class);
            }

            @Override
            public void validate(Object target, Errors errors) {
                ValidationUtils.rejectIfEmpty(errors, "firstName", "address.firstName.required", "Please enter first name.");
                ValidationUtils.rejectIfEmpty(errors, "lastName", "address.lastName.required", "Please enter last name.");
                ValidationUtils.rejectIfEmpty(errors, "address1", "address.address1.required", "Please enter street address.");
                ValidationUtils.rejectIfEmpty(errors, "city", "address.city.required", "Please enter city.");
                ValidationUtils.rejectIfEmpty(errors, "zip", "address.zip.required", "Please enter postal code.");
                ValidationUtils.rejectIfEmpty(errors, "phone", "address.phone.required", "Please enter telephone number.");
            }
        }

        @RequestMapping("/OrderProcess.aspx")
        public String orderProcess(HttpServletRequest request, Model model) throws Exception {
            Cart cart = CartUtil.getCartFromSession(request);
            Order newOrder = new Order();

            newOrder.setUserId(SecurityUtil.getUsername(request));
            newOrder.setCreditCard(cart.getCreditCard());
            newOrder.setBillingAddress(cart.getBillingAddress());
            newOrder.setShippingAddress(cart.getShippingAddress());

            newOrder.setLineItems(CartUtil.getOrderLineItemsArray(cart));

            newOrder.setOrderTotal(cart.getTotal());
            newOrder.setDate(new Date());

            // Send the order to the middle tier
            orderDao.insertObject(newOrder);
            CartUtil.removeCartFromSession(request);
            model.addAttribute("order", newOrder);
            return "orderProcess";
        }
    }
