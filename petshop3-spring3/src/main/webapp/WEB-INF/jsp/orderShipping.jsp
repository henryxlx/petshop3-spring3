<%@ page contentType="text/html; charset=UTF-8" %>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@taglib tagdir="/WEB-INF/tags" prefix="petscontrol" %>

<HTML>
<HEAD>
    <title>Order Information</title>
    <link rel="stylesheet" href="css/styles.css">
</HEAD>
<body>
<petscontrol:NavBar id="header"/>
<blockquote>
    <form id="frmShip" method="post">
        <div id="enterShipAddress" style="display: ${enterShipAddressVisible ? "block" : "none"}">
            <SPAN class="title">Shipping Address</SPAN>
            <P>
                <petscontrol:AddressUI id="shipAddr" errorPath="address"/>
            <P>
                <input type="image" id="btnContinue" border="0" alt="Continue" src="images/buttonContinue.gif" onclick="this.form.submit();">
        </div>
        <div id="confirmAddress" style="display: ${confirmAddressVisible ? "block" : "none"}">
            <BLOCKQUOTE>Please confirm that the following information is correct and press the <B>Continue</B>
                button to process your order.
                <P><SPAN class="title">Billing Address</SPAN>
                <P>
                    <petscontrol:StaticAddress id="staticAddressBilling" value="${addressBilling}"/>
                <P><SPAN class="title">Shipping Address</SPAN>
                <P>
                    <petscontrol:StaticAddress id="staticAddressShipping" value="${addressShipping}"/>
                <P><A href="OrderProcess.aspx"><IMG alt="Continue" src="images/buttonContinue.gif" border="0"></A></P>
            </BLOCKQUOTE>
        </div>
    </form>
    <P></P>
</blockquote>
</body>
</HTML>
