<%@ page contentType="text/html; charset=UTF-8" %>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<%@taglib tagdir="/WEB-INF/tags" prefix="petscontrol" %>

<HTML>
<HEAD>
    <title>Order Information</title>
    <link rel="stylesheet" href="css/styles.css">
</HEAD>
<body>
<petscontrol:NavBar id="header"/>
<blockquote>
    <form id="frmBill" method="post">
        <div id="enterAddress" style="display: ${enterAddressVisible ? "block" : "none"}">
            <SPAN class="title">Payment Information</SPAN>
            <P>
            <TABLE cellSpacing="0" cellPadding="1">
                <TR>
                    <TD class="label" width="125">Credit Card Type:</TD>
                    <TD>
                        <select id="listCardType" name="cardType">
                            <option value="Visa">Visa</option>
                            <option value="MasterCard">MasterCard</option>
                            <option value="American Express">American Express</option>
                        </select>
                    </TD>
                </TR>
                <TR>
                    <TD class="label">Card Number:</TD>
                    <TD>
                        <input id="txtCardNumber" name="cardNumber" type="text" size="20"  maxlength="20" format="9999 9999 9999 9999"/>
                        <form:errors path="creditcard.cardNumber"/></TD>
                </TR>
                <TR>
                    <TD class="label">Expiration Date:</TD>
                    <TD>
                        <TABLE cellSpacing="0" cellPadding="0">
                            <TR>
                                <TD class="label">Month:</TD>
                                <TD>
                                    <select id="listMonth" name="expMonth">
                                        <option value="01">01</option>
                                        <option value="02">02</option>
                                        <option value="03">03</option>
                                        <option value="04">04</option>
                                        <option value="05">05</option>
                                        <option value="06">06</option>
                                        <option value="07">07</option>
                                        <option value="08">08</option>
                                        <option value="09">09</option>
                                        <option value="10">10</option>
                                        <option value="11">11</option>
                                        <option value="12">12</option>
                                    </select>
                                </TD>
                                <TD class="label" width="50">Year:</TD>
                                <TD>
                                    <select id="listYear" name="expYear">
                                        <option value="2002">2002</option>
                                        <option value="2003">2003</option>
                                        <option value="2004">2004</option>
                                        <option value="2005">2005</option>
                                        <option value="2006">2006</option>
                                    </select>
                                </TD>
                            </TR>
                        </TABLE>
                    </TD>
                </TR>
            </TABLE>
            <P><SPAN class="title">Billing Address</SPAN>
            <P>
                <petscontrol:AddressUI id="billAddr" value="${address}" />
            <P>
            <TABLE cellSpacing="0" cellPadding="1">
                <TR>
                    <TD>
                        <input type="checkbox" id="chkShipBilling" name="shipBilling" checked="true" value="1"/>
                    </TD>
                    <TD>Ship to billing address</TD>
                </TR>
            </TABLE>
            <P>
                <input type="image" id="btnContinue" border="0" alt="Continue" src="images/buttonContinue.gif" onclick="this.form.submit();">
        </div>
        <br>
        <div id="confirmAddress" style="display: ${confirmAddressVisible ? "block" : "none"}">
            <BLOCKQUOTE>Please confirm that the following information is correct and press the <B>Continue</B>
                button to process your order.
                <P><SPAN class="title">Billing Address</SPAN>
                <P>
                    <petscontrol:StaticAddress id="staticAddressBilling" value="${addressBilling}"/>
                <P><SPAN class="title">Shipping Address</SPAN>
                <P>
                    <petscontrol:StaticAddress id="staticAddressShipping" value="${addressShipping}"/>
                <P><a href="OrderProcess.aspx"><img alt="Continue" src="images/buttonContinue.gif" border="0"></a></P>
            </BLOCKQUOTE>
        </div>
    </form>
    <P></P>
</blockquote>
</body>
</HTML>
