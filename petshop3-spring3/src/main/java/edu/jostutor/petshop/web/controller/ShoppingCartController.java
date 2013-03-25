package edu.jostutor.petshop.web.controller;

import edu.jostutor.petshop.dao.ItemDao;
import edu.jostutor.petshop.entity.Cart;
import edu.jostutor.petshop.entity.CartItem;
import edu.jostutor.petshop.entity.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import java.util.Enumeration;

/**
 * Created with IntelliJ IDEA.
 * User: xulixin
 * Date: 2013-3-15
 * Time: 上午8:57
 * To change this template use File | Settings | File Templates.
 */
@Controller
@RequestMapping("ShoppingCart.aspx")
public class ShoppingCartController {

    @Autowired
    private ItemDao itemDao;

    @RequestMapping(method = RequestMethod.GET)
    public String loadShoppingCart(HttpServletRequest request) {
        // Fetch the cart object from session state
        Cart myCart = (Cart) request.getSession().getAttribute(Cart.CART_KEY);
        if (myCart == null) {
            myCart = new Cart();
            request.getSession().setAttribute(Cart.CART_KEY, myCart);
        }

        // Get the itemdId from the query string
        String itemId = request.getParameter("itemId");
        if (itemId != null) {
            // Clean the input string
            itemId = itemId.trim();
            // myCart.Add(itemId);
            if (myCart.containsItemId(itemId)) {
                myCart.incrementQuantityByItemId(itemId);
            } else {
                // isInStock is a "real-time" property that must be updated
                // every time an item is added to the cart, even if other
                // item details are cached.
                boolean isInStock = itemDao.isItemInStock(itemId);
                Item item = itemDao.getItem(itemId);
                myCart.addItem(item, isInStock);
            }
        }

        // Get the user's favourite category


        return "shoppingCart";
    }

    @RequestMapping(params = "commandName=remove", method = RequestMethod.GET)
    public String deleteItem(HttpServletRequest request)
            throws Exception {

        Cart myCart = (Cart) request.getSession().getAttribute(Cart.CART_KEY);
        if (myCart != null) {
            String itemId = request.getParameter("itemId");
            if (myCart.containsItemId(itemId)) {
                myCart.removeItem(itemId);
            }
        }

        return "shoppingCart";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String update(HttpServletRequest request)
            throws Exception {

        Cart myCart = (Cart) request.getSession().getAttribute(Cart.CART_KEY);
        if (myCart != null) {
            Enumeration names = request.getParameterNames();
            while (names.hasMoreElements()) {
                String name = (String) names.nextElement();
                if (name.startsWith("txtQty.")) {
                    String itemId = name.substring(7);
                    int value = Integer.valueOf(request.getParameter(name));
                    if (value <= 0) {
                        myCart.removeItem(itemId);
                    } else {
                        CartItem cartItem = myCart.getCartItem(itemId);
                        cartItem.setQuantity(value);
                    }
                }
            }
        }
        return "shoppingCart";
    }
}
