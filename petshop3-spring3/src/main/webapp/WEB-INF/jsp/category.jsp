<%@ page contentType="text/html; charset=UTF-8" %>

<%@taglib uri="http://www.jostutor.edu/petshop/controls" prefix="controls" %>
<%@taglib tagdir="/WEB-INF/tags" prefix="petscontrol" %>

<HTML>
<HEAD>
    <title>Category</title>
    <LINK href="css/styles.css" type="text/css" rel="stylesheet">
</HEAD>
<body>
<petscontrol:NavBar id="header"/><br>
<blockquote>
    <form id="form" method="post">
        <!-- page header -->
        <span id="lblPage" class="pageHeader">${param.categoryId}</span>
        <%
            String categoryId = request.getParameter("categoryId");
            Object[] args = new Object[]{categoryId};
            pageContext.setAttribute("productsByCategoryQueryPager", args);
        %>
        <P><controls:SimplePager id="products" beanName="productsByCategoryQueryPager" pageSize="4" emptyText="No products found.">
            <jsp:attribute name="headerTemplate">
                <TABLE cellSpacing="0" cellPadding="0">
                    <TBODY>
                    <TR class="gridHead">
                        <TD>Product ID</TD>
                        <TD>Name</TD>
                    </TR>
            </jsp:attribute>
            <jsp:attribute name="itemTemplate">
                <TR class="gridItem">
                    <TD>${product.id}</TD>
                    <TD><A href='Items.aspx?productId=${product.id}'>${product.name}</A></TD>
                </TR>
            </jsp:attribute>
            <jsp:attribute name="footerTemplate"></TBODY></TABLE></jsp:attribute>
        </controls:SimplePager></P>
    </form>
</blockquote>
</body>
</HTML>
