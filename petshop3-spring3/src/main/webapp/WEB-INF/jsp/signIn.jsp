<%@ page contentType="text/html; charset=UTF-8" %>

<%@taglib tagdir="/WEB-INF/tags" prefix="petscontrol" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<HTML>
<HEAD>
    <title>Sign In</title>
    <link rel="stylesheet" href="css/styles.css">
</HEAD>
<body>
<petscontrol:NavBar id="header"/>
<blockquote>
    <form id="frmSignIn" method="post">
        <span class="title">Are you a new user?</span><p>
        <a href="CreateAccount.aspx"><img src="images/buttonRegister.gif" alt="Register Now" border="0"></a>
        <p>
            <span class="title">Or a registered user?</span>
        <p>
        <form:errors path="string"/>
        <table cellpadding="1" cellspacing="0">
            <tr>
                <td class="label">User ID:</td>
                <td>
                    <input id="txtUsername" name="username" type="text" value="DotNet" size="15"  maxlength="20"/>
                    <form:errors path="string" title="Please enter user ID."/>
                </td>
            </tr>
            <tr>
                <td class="label">Password:</td>
                <td>
                    <input id="txtPassword" name="password" type="password" value="DotNet" size="15" maxlength="20"/>
                    <asp:requiredfieldvalidator id="valPassword" runat="server" controltovalidate="txtPassword" errormessage="Please enter password." enableclientscript="False" />
                </td>
            </tr>
        </table>
        <p><input id="btnSubmit" type="submit" value="<%--Submit--%>" style="background:url(images/buttonSubmit.gif);border:none; width: 67px" alt="Submit" />
    </form>
    </P> </blockquote>
</body>
</HTML>
