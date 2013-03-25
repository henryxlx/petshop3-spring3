<%@ page contentType="text/html; charset=UTF-8" %>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<%@taglib uri="http://www.jostutor.edu/petshop/controls" prefix="controls" %>
<%@taglib tagdir="/WEB-INF/tags" prefix="petscontrol" %>

<HTML>
<HEAD>
    <title>Order Processed</title>
    <META http-equiv="Content-Type" content="text/html; charset=windows-1252">
    <LINK href="css/styles.css" rel="stylesheet">
</HEAD>
<body>
<petscontrol:NavBar id="header"/>
<blockquote>
    <span class="title">Order Complete!</span>
    <p>
    <table cellSpacing="0" cellPadding="4">
        <TBODY>
        <tr>
            <td class="label">Date:</td>
            <td><span id="lblOrderDate"><fmt:formatDate value="${order.date}"/></span></td>
        </tr>
        <tr>
            <td class="label">User ID:</td>
            <td><span id="lblUserId">${order.userId}</span></td>
        </tr>
        <tr>
            <td class="label">Order ID:</td>
            <td><span id="lblOrderId">${order.orderId}</span></td>
        </tr>
        <tr>
            <td class="label">Status:</td>
            <td>P</td>
        </tr>
        <tr vAlign="top">
            <td class="label">Payment Information:</td>
            <td><span id="lblCardType">${order.creditCard.cardType}</span><br>
                <span id="lblCardNumber">${order.creditCard.cardNumber}</span><br>
                <span id="lblCardExpiration">${order.creditCard.cardExpiration}</span></td>
        </tr>
        <tr vAlign="top">
            <td class="label">Billing Address:</td>
            <td><petscontrol:StaticAddress id="statAddrBill" value="${order.billingAddress}"/></td>
        </tr>
        <tr vAlign="top">
            <td class="label">Shipping Address:</td>
            <td><petscontrol:StaticAddress id="statAddrShip" value="${order.shippingAddress}"/></td>
        </tr>
        <tr vAlign="top">
            <td class="label">Items:</td>
            <td>

                <table cellpadding="0" cellspacing="0">
                    <tr class="gridHead">
                        <td>Item ID</td>
                        <td>Product</td>
                        <td>Price</td>
                        <td>Quantity</td>
                        <td>Subtotal</td>
                    </tr>
                <c:set var="orderTotal" value="0.0"/>
                <c:forEach var="item" items="${order.lineItems}">
                    <tr class="gridItem">
                        <td>${item.id}</td>
                        <td><a href='ItemDetails.aspx?itemId=${item.id}'>${item.productName}</a></td>
                        <td class="num">${item.price}</td>
                        <td class="num">${item.quantity}</td>
                        <td class="num">${item.subtotal}</td>
                    </tr>
                    <c:set var="orderTotal" value="${orderTotal + item.subtotal}"/>
                </c:forEach>
                </table>
    </TD></TR>
    <tr>
        <td label class="label">Total:</td>
        <td class="numFooter" colspan="5">
            <span class="label"><span id="lblOrderTotal">${orderTotal}</span></span>
        </td>
    </tr>
    </TBODY></TABLE></p>
</blockquote>
</body>
</HTML>
