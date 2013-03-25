<%@ page import="edu.jostutor.petshop.entity.Cart" %>
<%@ page contentType="text/html; charset=UTF-8" %>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@taglib uri="http://www.jostutor.edu/petshop/controls" prefix="controls" %>
<%@taglib tagdir="/WEB-INF/tags" prefix="petscontrol" %>

<HTML>
<HEAD>
    <title>Checkout</title>
    <META http-equiv="Content-Type" content="text/html; charset=windows-1252">
    <link rel="stylesheet" href="css/styles.css">
</HEAD>
<body>
<petscontrol:NavBar id="header"/>
<blockquote>
    <span class="title">Shopping Cart</span><p>
    <%
        Cart cart = (Cart) request.getSession().getAttribute(Cart.CART_KEY);
        if (cart != null) {
            Object[] args = new Object[]{cart.getCartItemList()};
            pageContext.setAttribute("shoppingCartQueryPager", args);
        }
    %>
    <controls:SimplePager id="cart" beanName="shoppingCartQueryPager" pageSize="4" emptyText="Your cart is empty.">
        <jsp:attribute name="headerTemplate">
            <table cellpadding="0" cellspacing="0">
                <tr class="gridHead">
                    <td>Item ID</td>
                    <td>Product</td>
                    <td>In Stock</td>
                    <td>Price</td>
                    <td>Quantity</td>
                    <td>Subtotal</td>
                </tr>
        </jsp:attribute>
        <jsp:attribute name="itemTemplate">
            <tr class="gridItem">
                <td>${cart.itemId}</td>
                <td><a href='ItemDetails.aspx?itemId=${cart.itemId}'>${cart.name}</a></td>
                <td>${cart.inStock}</td>
                <td class="num">${cart.price}</td>
                <td class="num">${cart.quantity}</td>
                <td class="num">${cart.subtotal}</td>
            </tr>
        </jsp:attribute>
        <jsp:attribute name="footerTemplate">
            <tr class="gridFoot">
                <td class="num" colspan="6"><span class="label">Total:</span>${petshopCart.total}</td>
            </tr>
            </table>
        </jsp:attribute>
    </controls:SimplePager>
    <p><a id="link" href="OrderBilling.aspx"><img src="images/buttonContinue.gif" alt="Continue" border="0"></a></p>
</blockquote>
</body>
</HTML>
