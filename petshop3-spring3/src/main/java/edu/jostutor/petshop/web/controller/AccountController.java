package edu.jostutor.petshop.web.controller;

import edu.jostutor.petshop.dao.AccountDao;
import edu.jostutor.petshop.entity.Account;
import edu.jostutor.petshop.web.controller.util.SecurityUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import java.util.Locale;

/**
 * Created with IntelliJ IDEA.
 * User: xulixin
 * Date: 2013-3-14
 * Time: 下午9:41
 * To change this template use File | Settings | File Templates.
 */
@Controller
public class AccountController {

    @Autowired
    private AccountDao accountDao;

    @RequestMapping(value = "CreateAccount.aspx", method = RequestMethod.GET)
    public String createAccount() {
        return "createAccount";
    }

    @RequestMapping(value = "CreateAccount.aspx", method = RequestMethod.POST)
    public String createAccount(@Validated @ModelAttribute("account") Account account, BindingResult result) {
        if (result.hasErrors()) {
            return "createAccount";
        }
        accountDao.insertObject(account);
        return "redirect:MyAccount.aspx?action=create";
    }

    @RequestMapping(value = "EditAccount.aspx", method = RequestMethod.GET)
    public String editAccount(Model model) {
        model.addAttribute("account", accountDao.getAccountByUsername(SecurityUtil.getUsername(null)));
        return "editAccount";
    }

    @InitBinder
    protected void initBinder(WebDataBinder binder) {
        binder.setValidator(new AccountValidator());
    }

    @RequestMapping(value = "EditAccount.aspx", method = RequestMethod.POST)
    public String editAccount(@Validated @ModelAttribute("account") Account account, BindingResult result) {
        if (result.hasErrors()) {
            return "editAccount";
        }
        accountDao.updateObject(account);
        return "redirect:MyAccount.aspx?action=update";
    }

    @Autowired
    ResourceBundleMessageSource messageSource;

    @RequestMapping("MyAccount.aspx")
    public String myAccount(Locale locale, String action, Model model) {
        String lblMessage = "No Message.";
        if ("create".equals(action)) {
            lblMessage = messageSource.getMessage("MSG_CREATE_ACCOUNT", null, locale);
        }
        if ("update".equals(action)) {
            lblMessage = messageSource.getMessage("MSG_UPDATE_ACCOUNT", null, locale);;
        }
        if ("signIn".equals(action)) {
            lblMessage = messageSource.getMessage("MSG_SIGN_IN_ACCOUNT", null, locale);;
        }
        model.addAttribute("lblMessage", lblMessage);
        return "myAccount";
    }

    private class AccountValidator implements Validator {

        @Override
        public boolean supports(Class<?> clazz) {
            return clazz.equals(Account.class);
        }

        @Override
        public void validate(Object target, Errors errors) {
            ValidationUtils.rejectIfEmpty(errors, "userId", "account.email.userId", "Please enter user ID.");
            ValidationUtils.rejectIfEmpty(errors, "password", "account.email.password", "Please enter password.");
            ValidationUtils.rejectIfEmpty(errors, "email", "account.email.required", "Please enter e-mail address.");
            ValidationUtils.rejectIfEmpty(errors, "address.firstName", "account.address.firstName.required", "Please enter first name.");
            ValidationUtils.rejectIfEmpty(errors, "address.lastName", "account.address.lastName.required", "Please enter last name.");
            ValidationUtils.rejectIfEmpty(errors, "address.address1", "account.address.address1.required", "Please enter street address.");
            ValidationUtils.rejectIfEmpty(errors, "address.city", "account.address.city.required", "Please enter city.");
            ValidationUtils.rejectIfEmpty(errors, "address.zip", "account.address.zip.required", "Please enter postal code.");
            ValidationUtils.rejectIfEmpty(errors, "address.phone", "account.address.phone.required", "Please enter telephone number.");
        }
    }
}
