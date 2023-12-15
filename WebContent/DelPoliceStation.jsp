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

<%
int PID = Integer.parseInt(request.getParameter("PID"));

Connection con = BlackCon.connect();

PreparedStatement pstmt = con.prepareStatement("delete from policestation where PID=?");
pstmt.setInt(1, PID);

int i = pstmt.executeUpdate();

if(i>0)
{
	response.sendRedirect("ViewPoliceStation.jsp");
}

%>



</center>


</body>
</html>