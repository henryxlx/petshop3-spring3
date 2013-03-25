<%@ page contentType="text/html; charset=UTF-8" %>

<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib tagdir="/WEB-INF/tags" prefix="petscontrol" %>

<HTML>
<HEAD>
    <title>Edit Account</title>
    <link rel="stylesheet" href="css/styles.css">
</HEAD>
<body>
<petscontrol:NavBar id="header"/>
<blockquote>
    <form id="frmEditAcct" runat="server" method="post">
        <span class="title">My Account</span><p>
        <table cellpadding="1" cellspacing="0">
            <tr>
                <td class="label" width="125">User ID:</td>
                <td colspan="3"><span id="lblUserId">${account.userId}</span>
                    <input type="hidden" id="hidUserId" name="userId" value="${account.userId}"/>
                    <input type="hidden" id="hidPassword" name="password" value="****holder****"/>
                </td>
            </tr>
            <tr>
                <td class="label">E-mail Address:</td>
                <td colspan="3">
                    <input id="txtEmail" name="email" type="text" size="30"  maxlength="80" value="${account.email}"/>
                    <form:errors path="account.email"/>
                </td>
            </tr>
        </table>
        <p><span class="title">My Address</span>
        <p>
            <petscontrol:AddressUI id="addr" bindBeanPrefix="address" value="${account.address}" errorPath="account.address"/>
        <p><span class="title">My Preferences</span>
        <p>
            <petscontrol:Preferences id="prefs" value="${account}"/>
        <p>
        <input id="btnSubmit" type="submit" value="<%--Submit--%>" style="background:url(images/buttonSubmit.gif);border:none; width: 67px" alt="Submit" />
    </form>
    </P> </blockquote>
</body>
</HTML>
