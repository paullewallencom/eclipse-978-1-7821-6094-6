<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="java.util.Date" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Warm Greeting</title>
</head>
<body>
<h1> <% out.println("Hello, World!"); %> </h1>
<% Date date = new Date(); %>
<ul> <li>current time: <%= date %> </li></ul> 
</body>
</html>