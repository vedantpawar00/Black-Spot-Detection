<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>


<center>


<%@ page import = "java.sql.*" %>
<%@ page import = "BlackPack.BlackCon" %>

<form action="SuccessPolice.html">

<%

Connection con = BlackCon.connect();
String blname = request.getParameter("blname");

PreparedStatement pstmt = con.prepareStatement("delete from blackspot where BLocationName=?");
pstmt.setString(1, blname);

int i=pstmt.executeUpdate();

if(i>0){

	response.sendRedirect("sucPDBlac.html");

%>
<hr>
<h1>Account Deleted</h1> <%} %>
</hr>
<button>Go to Previous</button>


</form>

</center>


</body>
</html>