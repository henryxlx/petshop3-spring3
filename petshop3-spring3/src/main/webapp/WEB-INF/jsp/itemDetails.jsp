<%@ page contentType="text/html; charset=UTF-8" %>

<%@taglib tagdir="/WEB-INF/tags" prefix="petscontrol" %>

<HEAD>
    <title>Item Details</title>
    <meta name="vs_targetSchema" content="http://schemas.microsoft.com/intellisense/ie5">
    <link rel="stylesheet" href="css/styles.css">
</HEAD>
<body>
<petscontrol:NavBar id="header"/>
<blockquote>
    <span id="lblSearchResults"></span>
    <p></p>
    <table cellpadding="0" cellspacing="0">
        <tr valign="top">
            <td class="desc" width="130"><span id="lblDescription">${item.productDesc}</span></td>
            <td>
						<span class="title">
							<span id="lblName">${item.name}</span>
							<span id="lblProductName">${item.productName}</span>
						</span>

                <p>
                <table cellpadding="1" cellspacing="0">
                    <tr>
                        <td class="label">Price:</td>
                        <td><span id="lblPrice">${item.price}</span></td>
                    </tr>
                    <tr>
                        <td class="label">Quantity:</td>
                        <td><span id="lblQty">${item.quantity}</span></td>
                    </tr>
                </table>
                <p><a href='ShoppingCart.aspx?itemId=${param.itemId}'>
                    <img src="images/buttonAdd.gif" alt="Add to Cart" border="0"></a></p>
            </td>
        </tr>
    </table>
</blockquote>
</body>
</HTML>
