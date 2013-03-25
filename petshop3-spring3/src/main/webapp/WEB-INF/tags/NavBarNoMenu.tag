<%@taglib uri="http://shiro.apache.org/tags" prefix="shiro" %>

<%@ attribute name="id" rtexprvalue="true" required="false"%>
<%@ attribute name="hidecategorymenu" rtexprvalue="true" required="true"%>

<!-- top bar -->
<table cellspacing="0" cellpadding="0" width="100%" height="49" background="images/top_stripe1.gif" border="0">
    <tr>
        <td valign="top"><img src="images/space.gif" width="1" height="13"><br>
            <img src="images/space.gif" width="14" height="1"><a href="Default.aspx"><img alt="" src="images/title.gif" border="0"></a></td>
    </tr>
</table>
<table cellspacing="0" cellpadding="0" width="100%" height="38" background="images/top_stripe2.gif" border="0">
    <form id="search" method="get" action="Search.aspx">
        <tr>
            <td><img src="images/liz_5.gif" id="lizard5"></td>
            <td align="right" nowrap>
                <font class="menuOrange">
                    <shiro:authenticated>
                    <span id="areaLoggedIn">
                        <a href="SignOut.aspx" class="menuOrange">SIGN OUT</a>&nbsp;&nbsp;|&nbsp;&nbsp;
                        <a href="EditAccount.aspx" class="menuOrange">MY ACCOUNT</a>&nbsp;
                    </span></shiro:authenticated>
                    <shiro:notAuthenticated>
                    <span id="areaLoggedOut">
                        <a href="SignIn.aspx" class="menuOrange">SIGN IN</a>&nbsp;
                    </span></shiro:notAuthenticated>
                    |<a href="ShoppingCart.aspx"><img src="images/cart.gif" align="absMiddle" border="0"></a>|&nbsp;
                    <a href="Help.aspx" class="menuOrange">HELP</a> <img src="images/space.gif" width="20" height="1">
                    <input type="text" size="14" name="keywords" style="COLOR:#ffffff; BACKGROUND-COLOR:#336669">&nbsp;
                    <a href="javascript:search.submit()" class="menuOrange">SEARCH</a> </font><img src="images/space.gif" width="20" height="1">
            </td>
        </tr>
    </form>
</table>
<!-- third bar -->
<table cellspacing="0" cellpadding="0" width="100%" height="35" background="images/top_stripe3.gif" border="0">
    <tr>
		<span id="areaNoMenu">
			<td valign="top"><img src="images/liz_6.gif"></td>
		</span>
    </tr>
</table>