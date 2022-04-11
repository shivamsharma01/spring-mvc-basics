<%@ page language="java" import="java.util.List" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
    <!DOCTYPE html>
    <html>

    <head>
        <meta charset="ISO-8859-1">
        <title>New Home Page</title>
    </head>
<% 	String name = (String)request.getAttribute("name"); 
	int age = (Integer)request.getAttribute("age"); 
	List<String> friends = (List<String>)request.getAttribute("friends"); 
%>
    <body>
        <h1>This is Home Page With Model Data</h1>
        <h1>Name is <%=name%></h1>
        <h1>Called by home controller</h1>
        <h1>url /new-home</h1>
        <h1><%=name%>'s Friends are</h1>
        <ul>
        	<% for (String friend: friends) { %>
	   			<li><%=friend%></li>	        		
        	<% } %>
        	<%-- 
	        	<% for (String friend: friends) {
	        		out.println(friend);
	        		}
	   			%>
        	--%>
        </ul>
    </body>

    </html>