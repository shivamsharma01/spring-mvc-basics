<%@ page language="java" import="java.util.List" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<%@ page isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    <!DOCTYPE html>
    <html>

    <head>
        <meta charset="ISO-8859-1">
        <title>Tech Page</title>
    </head>
    <body>
        <h1>This is Continent's Page With ModelAndView Data & Expression Language</h1>
        <h1>Called by home controller</h1>
        <h1>url /continents</h1>
        <h1>${title}</h1>
        <h1>${continents}</h1>
        <h2>Or loop the data using the jstl library</h2>
        <ul>
        	<c:forEach var="item" items="${continents}">
         		<li>${item}</li>
      		</c:forEach>
        </ul>
    </body>

    </html>