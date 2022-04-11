<%@ page language="java" import="java.util.List" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
    <!DOCTYPE html>
    <html>

    <head>
        <meta charset="ISO-8859-1">
        <title>Tech Page</title>
    </head>
<% 	String title = (String)request.getAttribute("title");
	List<String> techs = (List<String>)request.getAttribute("techs"); 
%>
    <body>
        <h1>This is Tech Page With ModelAndView Data</h1>
        <h1>Tech Page</h1>
        <h1>Called by home controller</h1>
        <h1>url /technologies</h1>
        <h1><%=title%></h1>
        <ul>
        	<% for (String t: techs) { %>
	   			<li><%=t%></li>	        		
        	<% } %>
        </ul>
    </body>

    </html>