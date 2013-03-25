package edu.jostutor.petshop.web.controller.util;

import edu.jostutor.petshop.entity.Cart;
import edu.jostutor.petshop.entity.CartItem;
import edu.jostutor.petshop.entity.LineItem;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: xulixin
 * Date: 2013-3-19
 * Time: 下午8:00
 * To change this template use File | Settings | File Templates.
 */
public abstract class CartUtil {

    public static Cart getCartFromSession(HttpServletRequest request) {
        return (Cart) request.getSession().getAttribute(Cart.CART_KEY);
    }

    public static void removeCartFromSession(HttpServletRequest request) {
        request.getSession().removeAttribute(Cart.CART_KEY);
    }

    public static LineItem[] getOrderLineItemsArray(Cart cart) {
        List<CartItem> cartItemList = cart.getCartItemList();
        LineItem[] lineItems = new LineItem[cartItemList.size()];
        for (int i = 0; i < cartItemList.size(); i++) {
            lineItems[i] = new LineItem();
            lineItems[i].setId(cartItemList.get(i).getItemId());
            lineItems[i].setLine(i);
            lineItems[i].setPrice(cartItemList.get(i).getPrice());
            lineItems[i].setQuantity(cartItemList.get(i).getQuantity());
            lineItems[i].setProductName(cartItemList.get(i).getName());
        }
        return lineItems;
    }
}
