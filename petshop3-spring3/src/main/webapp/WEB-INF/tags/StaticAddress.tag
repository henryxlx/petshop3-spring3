<%@ attribute name="id" rtexprvalue="true" required="false"%>
<%@ attribute name="value" rtexprvalue="true" required="false" type="java.lang.Object" %>

<table cellpadding="2" cellspacing="0" border="0">
    <tr>
        <td>
            <font class="text">
                <span id="lblFirstName">${value.firstName}</span>
                <span id="lblLastName">${value.lastName}</span>
            </font>
        </td>
    </tr>
    <tr>
        <td>
            <font class="text">
                <span id="lblAdr1">${value.address1}</span>
            </font>
        </td>
    </tr>
    <tr>
        <td>
            <font class="text">
                <span id="lblAdr2">${value.address2}</span>
            </font>
        </td>
    </tr>
    <tr>
        <td>
            <font class="text">
                <span id="lblCity">${value.city}</span>,
                <span id="lblState">${value.state}</span>
                <span id="lblPostalCode">${value.zip}</span>
            </font>
        </td>
    </tr>
</table>
