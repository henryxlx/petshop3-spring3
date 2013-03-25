<%
    if (request != null)
    {
        response.sendRedirect(request.getContextPath() + "/Default.aspx");
        return;
    }
%>
<html>
	<head>
		<title>Go to Home</title>
	</head>
	<body>
		<strong><a href="<%= request.getContextPath() %>/Default.aspx">Click here!</a></strong> to go to Home.
    </body>
</html>
