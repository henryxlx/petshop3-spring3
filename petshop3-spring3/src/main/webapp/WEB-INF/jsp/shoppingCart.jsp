<%@ page import="edu.jostutor.petshop.entity.Cart" %>
<%@ page contentType="text/html; charset=UTF-8" %>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@taglib uri="http://www.jostutor.edu/petshop/controls" prefix="controls" %>
<%@taglib tagdir="/WEB-INF/tags" prefix="petscontrol" %>

<HTML>
<HEAD>
    <title>Shopping Cart</title>
    <link rel="stylesheet" href="css/styles.css">
</HEAD>
<body>
<table cellpadding="0" cellspacing="0" border="0" height="100%" width="100%">
    <TBODY>
    <tr valign="top">
        <td>
            <petscontrol:NavBar id="header"/>
            <blockquote>
                <form id="frmCart" method="post">
                    <table cellpadding="0" cellspacing="0">
                        <TBODY>
                        <tr valign="top">
                            <td class="cart">
                                <span class="title">Shopping Cart</span><p>
                                <%
                                    Cart cart = (Cart) request.getSession().getAttribute(Cart.CART_KEY);
                                    if (cart != null) {
                                        Object[] args = new Object[]{cart.getCartItemList()};
                                        pageContext.setAttribute("shoppingCartQueryPager", args);
                                    }
                                %>
                                <c:set var="total" value="0.0" />
                                <controls:ViewStatePager id="cart" beanName="shoppingCartQueryPager" pageSize="4" emptyText="Your cart is empty.">
                                    <jsp:attribute name="headerTemplate">
                                        <table cellpadding="0" cellspacing="0">
                                            <tr class="gridHead">
                                                <td>&nbsp;</td>
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
                                            <td>
                                                <a href="?itemId=${cart.itemId}&commandName=remove">
                                                    <img src="images/buttonRemove.gif" title="Remove" alt="Remove" border="0"></a>
                                            </td>
                                            <td>${cart.itemId}</td>
                                            <td><a href='ItemDetails.aspx?itemId=${cart.itemId}'>${cart.name}</a></td>
                                            <td>${cart.inStock}</td>
                                            <td class="num">${cart.price}</td>
                                            <td>
                                                <input type="text" name="txtQty.${cart.itemId}" value="${cart.quantity}" size="3" maxlength="5" cssclass="num" />
                                            </td>
                                            <td class="num">${cart.subtotal}</td>
                                        </tr>
                                        <c:set var="total" value="${total + cart.subtotal}" />
                                    </jsp:attribute>
                                    <jsp:attribute name="footerTemplate">
                                        <tr class="gridFoot">
                                            <td>
                                                <input type="image" id="btnUpdate" src="images/buttonUpdate.gif" alt="Update" border="0" onclick="" />
                                            </td>
                                            <c:set target="${sessionScope.petshopCart}" property="total" value="${total}"/>
                                            <td class="num" colspan="6"><span class="label">Total:</span>${total}</td>
                                        </tr>
            </table>
                    </jsp:attribute> </controls:ViewStatePager>
                    <p>
                        <c:if test="${sessionScope.petshopCart.size > 0}">
                        <a id="link" href="Checkout.aspx"><img src="images/buttonCheckout.gif" alt="Proceed to Checkout" border="0"></a>
                        </c:if>
                    </p>
        </td>
        <td>
            <controls:ViewStatePager id="favorites" beanName="none" pageSize="3" visible="false">
                <jsp:attribute name="headerTemplate">
                    <span class="title">Pet Favorites</span>
                    <p>
                    <table cellpadding="0" cellspacing="0">
                        <tr class="gridHead">
                            <td>Shop for more of your favorite pets here.</td>
                        </tr>
                </jsp:attribute>
                <jsp:attribute name="itemTemplate">
                    <tr class="gridItem">
                        <td><a href='Items.aspx?productId=${favorite.id}'>${favorite.name}(${favorite.id})</a></td>
                    </tr>
                </jsp:attribute>
                <jsp:attribute name="footerTemplate">
                    </table>
                </jsp:attribute>
            </controls:ViewStatePager></TD></TR></TBODY></TABLE></form></BLOCKQUOTE></TD></TR>
<tr valign="bottom">
    <td>
        <petscontrol:Banner id="Banner1"/>
    </td>
</tr>
</TBODY></TABLE>
</body>
</HTML>
