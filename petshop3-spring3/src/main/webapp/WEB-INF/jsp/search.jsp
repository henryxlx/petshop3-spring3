<%@ page contentType="text/html; charset=UTF-8" %>

<%@taglib uri="http://www.jostutor.edu/petshop/controls" prefix="controls" %>
<%@taglib tagdir="/WEB-INF/tags" prefix="petscontrol" %>

<HTML>
<HEAD>
    <title>Search</title>
    <META http-equiv="Content-Type" content="text/html; charset=windows-1252">
    <link rel="stylesheet" href="css/styles.css">
</HEAD>
<body>
<petscontrol:NavBar id="header"/><br>
<blockquote>
    <span class="title">Search Results</span><p>
    <%
        String keywords = request.getParameter("keywords");
        if (keywords != null && !"".equals(keywords.trim())) {
            String[] keywordArray = keywords.split("\\\\s*,\\\\s*");
            pageContext.setAttribute("productsBySearchQueryPager", keywordArray);
        }

    %>
    <controls:SimplePager id="products" beanName="productsBySearchQueryPager" pageSize="4" emptyText="No products found.">
        <jsp:attribute name="headerTemplate">
            <table cellpadding="0" cellspacing="0">
                <tr class="gridHead">
                    <td>Product ID</td>
                    <td>Name</td>
                    <td>Description</td>
                </tr>
        </jsp:attribute>
        <jsp:attribute name="itemTemplate">
            <tr class="gridItem">
                <td>${product.id}</td>
                <td><a href='Items.aspx?productId=${product.id}'>${product.name}</a></td>
                <td>${product.description}</td>
            </tr>
        </jsp:attribute>
        <jsp:attribute name="footerTemplate">
            </tbody>
            </table>
        </jsp:attribute>
    </controls:SimplePager></p>
</blockquote>
</body>
</HTML>
