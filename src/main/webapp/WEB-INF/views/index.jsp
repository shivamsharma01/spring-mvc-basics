<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    <!DOCTYPE html>
    <html>

    <head>
    	<link href="<c:url value="/resources/css/style.css" />">
        <meta charset="ISO-8859-1">
        <title>Home Page</title>
    </head>

    <body>
        <h1>Name is Shivam Sharma</h1>
        <h1>This is Home Page</h1>
        <h1>Called by home controller</h1>
        <h1>url /home</h1>
        <img alt="mountain image" src="<c:url value="resources/images/mountain.jpg" />">
    </body>
	
    </html>