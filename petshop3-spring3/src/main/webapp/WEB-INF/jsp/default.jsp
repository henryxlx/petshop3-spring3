<%@ page contentType="text/html; charset=UTF-8" %>
<%--
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@taglib uri="http://shiro.apache.org/tags" prefix="shiro" %>
--%>
<%@taglib tagdir="/WEB-INF/tags" prefix="petscontrol" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>

<HTML>
<HEAD>
    <title>PetShop</title>
    <meta name="vs_targetSchema" content="http://schemas.microsoft.com/intellisense/ie5">
    <LINK href="css/styles.css" type="text/css" rel="stylesheet">
</HEAD>
<body>
<table height="100%" cellspacing="0" cellpadding="0" width="100%" border="0">
    <tr>
        <td valign="top">
            <petscontrol:NavBarNoMenu id="header" hidecategorymenu="true" />
            <table cellspacing="0" cellpadding="0" border="0">
                <tr>
                    <td colspan="4" valign="top"><img alt="" src="images/lizardC.gif" width="210" height="74"></td>
                    <td rowspan="2" valign="top">
                        <img src="images/space.gif" width="1" height="26"><br>
                        <map name="mainMap">
                            <area href="Category.aspx?categoryId=BIRDS" alt="Birds" coords="408,133,514,239"
                                  shape="RECT">
                            <area href="Category.aspx?categoryId=FISH" alt="Fish" coords="2,250,108,356" shape="RECT">
                            <area href="Category.aspx?categoryId=DOGS" alt="Dogs" coords="108,326,214,432" shape="RECT">
                            <area href="Category.aspx?categoryId=REPTILES" alt="Reptiles" coords="348,254,454,358"
                                  shape="RECT">
                            <area href="Category.aspx?categoryId=CATS" alt="Cats" coords="242,334,348,440" shape="RECT">
                            <area href="Category.aspx?categoryId=BIRDS" alt="Birds" coords="280,180,350,250"
                                  shape="RECT">
                        </map>
                        <img src="images/splash.jpg" usemap="#mainMap" width="548" height="466" border="0">
                    </td>
                </tr>
                <tr>
                    <td valign="top" width="20"><img src="images/space.gif" width="20" height="1"></td>
                    <td bgcolor="#f6e19e" valign="top" width="40"><img src="images/space.gif" width="40" height="1">
                    </td>
                    <td valign="top" bgcolor="#f6e19e" width="132">
                        <a href="Category.aspx?categoryId=FISH" class="catLink">Fish</a><br>
                        <font class="text">&nbsp;&nbsp;Saltwater<br>
                            &nbsp;&nbsp;Freshwater<p></p>
                        </font><a href="Category.aspx?categoryId=DOGS" class="catLink">Dogs</a><br>
                        <font class="text">&nbsp;&nbsp;Poodle<br>
                            &nbsp;&nbsp;Greyhounds<p></p>
                        </font><a href="Category.aspx?categoryId=REPTILES" class="catLink">Reptiles</a><br>
                        <font class="text">&nbsp;&nbsp;Iguanas<br>
                            &nbsp;&nbsp;Snakes<br>
                            &nbsp;&nbsp;Turtles<p></p>
                        </font><a href="Category.aspx?categoryId=CATS" class="catLink">Cats</a><br>
                        <font class="text">&nbsp;&nbsp;Manx<br>
                            &nbsp;&nbsp;Persian<p></p>

                            <P>
                        </font><a href="Category.aspx?categoryId=BIRDS" class="catLink">Birds</a><br>
                        <font class="text">&nbsp;&nbsp;Eclectus<br>
                            &nbsp;&nbsp;African Greys<br>
                            &nbsp;&nbsp;Macaws </font></P>
                        <br>
                        <a href="WebServices.asmx" class="webServiceTestLabel">Test Web Service</a>

                        <p></p>
                        </FONT><img src="images/space.gif" width="1" height="30"><br>
                    </td>
                    <td width="20"><img src="images/space.gif" width="20" height="1"></td>
                </tr>
            </table>
        </td>
    </tr>
    <tr valign="bottom">
        <td>
            <petscontrol:Banner id="Banner1"/>
        </td>
    </tr>
</table>
</body>
</HTML>
