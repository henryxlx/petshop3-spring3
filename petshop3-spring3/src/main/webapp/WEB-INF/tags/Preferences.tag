<%@ attribute name="id" rtexprvalue="true" required="false"%>
<%@ attribute name="value" rtexprvalue="true" required="false" type="java.lang.Object"%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<table cellpadding="1" cellspacing="0">
    <tr>
        <td colspan="2">
            <table cellpadding="0" cellspacing="0">
                <tr>
                    <td>Show the .NET Pet Shop in&nbsp;</td>
                    <td>
                        <select id="listLanguage" name="language">
                            <option value="English" <c:if test="${'English' == value.language}">selected="true"</c:if>>English</option>
                            <option value="Japanese" <c:if test="${'Japanese' == value.language}">selected="true"</c:if>>Japanese</option>
                        </select>
                    </td>
                </tr>
            </table>
        </td>
    </tr>
    <tr>
        <td colspan="2">
            <table cellpadding="0" cellspacing="0">
                <tr>
                    <td>My favorite category is&nbsp;</td>
                    <td>
                        <select id="listCategory" name="category">
                            <option value="FISH" <c:if test="${'FISH' == value.category}">selected="true"</c:if>>Fish</option>
                            <option value="DOGS" <c:if test="${'DOGS' == value.category}">selected="true"</c:if>>Dogs</option>
                            <option value="REPTILES" <c:if test="${'REPTILES' == value.category}">selected="true"</c:if>>Reptiles</option>
                            <option value="CATS" <c:if test="${'CATS' == value.category}">selected="true"</c:if>>Cats</option>
                            <option value="BIRDS" <c:if test="${'BIRDS' == value.category}">selected="true"</c:if>>Birds</option>
                        </select>
                    </td>
                </tr>
            </table>
        </td>
    </tr>
    <tr>
        <td><input type="checkbox" id="chkShowFavorites" name="showFavorites" <c:if test="${1 == value.showFavorites}">checked="true"</c:if> value="1"/></td>
        <td>Make items in my favorite category more prominent as I shop.</td>
    </tr>
    <tr>
        <td><input type="checkbox" id="chkShowBanners" name="showBanners" <c:if test="${1 == value.showBanners}">checked="true"</c:if> value="1"/></td>
        <td>Show pet tips based on my favorite category.</td>
    </tr>
</table>
