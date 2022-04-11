<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
    <!DOCTYPE html>
    <html>

    <head>
        <meta charset="ISO-8859-1">
        <title>Home Page</title>
    </head>
<% String name = request.getAttribute("name"); %>
    <body>
        <h1>This is Home Page</h1>
        <h1>Name is <%=name%></h1>
        <h1>Called by home controller</h1>
        <h1>url /home</h1>
    </body>

    </html>