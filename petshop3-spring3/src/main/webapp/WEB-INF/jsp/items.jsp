<%@ page contentType="text/html; charset=UTF-8" %>

<%@taglib uri="http://www.jostutor.edu/petshop/controls" prefix="controls" %>
<%@taglib tagdir="/WEB-INF/tags" prefix="petscontrol" %>

<HTML>
<HEAD>
    <title>Items</title>
    <link rel="stylesheet" href="css/styles.css">
</HEAD>
<body>
<petscontrol:NavBar id="header"/>
<blockquote>
			<span class="title">
				<span id="productName">${productName}</span>
			</span><p>
    <%
        String productId = request.getParameter("productId");
        Object[] args = new Object[]{productId};
        pageContext.setAttribute("itemsByProductIdQueryPager", args);
    %>
    <controls:SimplePager id="items" beanName="itemsByProductIdQueryPager" pageSize="4" emptyText="No items found.">
        <jsp:attribute name="headerTemplate">
            <table cellpadding="0" cellspacing="0">
                <tr class="gridHead">
                    <td>Item ID</td>
                    <td>Name</td>
                    <td>Price</td>
                    <td>&nbsp;</td>
                </tr>
        </jsp:attribute>
        <jsp:attribute name="itemTemplate">
            <tr class="gridItem">
                <td>${item.id}</td>
                <td><a href='ItemDetails.aspx?itemId=${item.id}'>${item.name}</a></td>
                <td class="num">${item.price}</td>
                <td><a href='ShoppingCart.aspx?itemId=${item.id}'><img src="images/buttonAdd.gif" alt="Add to Cart" border="0"></a></td>
            </tr>
        </jsp:attribute>
        <jsp:attribute name="footerTemplate">
            </table>
        </jsp:attribute>
    </controls:SimplePager></p>
</blockquote>
</body>
</HTML>
