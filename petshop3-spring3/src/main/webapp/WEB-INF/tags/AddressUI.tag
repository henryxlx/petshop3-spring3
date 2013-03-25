<%@ attribute name="id" rtexprvalue="true" required="false"%>
<%--　用于传递Bean对象，必须指定type为java.lang.Object，这样才能接收任意类型对象，因为默认的type为java.lang.String　--%>
<%@ attribute name="value" rtexprvalue="true" required="false" type="java.lang.Object" %>
<%--　使用自动绑定功能映射Address对象或Account中的Address子对象，需要指明绑定Bean所在对象的名称　--%>
<%@ attribute name="bindBeanPrefix" rtexprvalue="true" required="false"%>
<%-- 显示错误标签必须指定path属性，由调用本标签文件的JSP页面指定，才能根据检验注入的情况显示错误信息　--%>
<%@ attribute name="errorPath" rtexprvalue="true" required="false"%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<table cellpadding="1" cellspacing="0">
    <tr>
        <td class="label" width="125">First Name:</td>
        <td>
            <input id="txtFirstName" name="<c:if test='${not empty bindBeanPrefix}'>${bindBeanPrefix}.</c:if>firstName" type="text" size="30"  maxlength="80" value="${value.firstName}"/>
            <form:errors path="${errorPath}.firstName"/>
        </td>
    </tr>
    <tr>
        <td class="label">Last Name:</td>
        <td>
            <input id="txtLastName" name="<c:if test='${not empty bindBeanPrefix}'>${bindBeanPrefix}.</c:if>lastName" type="text" size="30"  maxlength="80" value="${value.lastName}"/>
            <form:errors path="${errorPath}.lastName"/>
        </td>
    </tr>
    <tr>
        <td class="label">Street Address:</td>
        <td>
            <input id="txtAddress1" name="<c:if test='${not empty bindBeanPrefix}'>${bindBeanPrefix}.</c:if>address1" type="text" size="55"  maxlength="80" value="${value.address1}"/>
            <form:errors path="${errorPath}.address1"/>
        </td>
    </tr>
    <tr>
        <td></td>
        <td>
            <input id="txtAddress2" name="<c:if test='${not empty bindBeanPrefix}'>${bindBeanPrefix}.</c:if>address2" type="text" size="55"  maxlength="80" value="${value.address2}"/>
        </td>
    </tr>
    <tr>
        <td class="label">City:</td>
        <td>
            <input id="txtCity" name="<c:if test='${not empty bindBeanPrefix}'>${bindBeanPrefix}.</c:if>city" type="text" size="55"  maxlength="80" value="${value.city}"/>
            <form:errors path="${errorPath}.city"/>
        </td>
    </tr>
    <tr>
        <td class="label">State / Province:</td>
        <td>
            <table cellpadding="0" cellspacing="0">
                <tr>
                    <td>
                        <select id="listState" name="<c:if test='${not empty bindBeanPrefix}'>${bindBeanPrefix}.</c:if>state">
                            <option value="CA" <c:if test="${'CA' == value.state}">selected="true"</c:if>>California</option>
                            <option value="NY" <c:if test="${'NY' == value.state}">selected="true"</c:if>>New York</option>
                            <option value="TS" <c:if test="${'TS' == value.state}">selected="true"</c:if>>Texas</option>
                        </select>
                    </td>
                    <td class="label" width="100">Postal Code:</td>
                    <td>
                        <input id="txtZip" name="<c:if test='${not empty bindBeanPrefix}'>${bindBeanPrefix}.</c:if>zip" type="text" size="12"  maxlength="20" value="${value.zip}"/>
                        <form:errors path="${errorPath}.zip"/>
                    </td>
                </tr>
            </table>
        </td>
    </tr>
    <tr>
        <td class="label">Country:</td>
        <td>
            <select id="listCountry" name="<c:if test='${not empty bindBeanPrefix}'>${bindBeanPrefix}.</c:if>country">
                <option value="USA" <c:if test="${'USA' == value.country}">selected="true"</c:if>>USA</option>
                <option value="Canada" <c:if test="${'Canada' == value.country}">selected="true"</c:if>>Canada</option>
                <option value="Japan" <c:if test="${'Japan' == value.country}">selected="true"</c:if>>Japan</option>
            </select>
        </td>
    </tr>
    <tr>
        <td class="label">Telephone Number:</td>
        <td>
            <input id="txtPhone" name="<c:if test='${not empty bindBeanPrefix}'>${bindBeanPrefix}.</c:if>phone" type="text" size="20"  maxlength="20" value="${value.phone}"/>
            <form:errors path="${errorPath}.phone"/>
        </td>
    </tr>
</table>
