<%-- 
    Document   : mensaje
    Created on : 26/04/2024, 1:33:55 a. m.
    Author     : luisf
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Mensaje del Sistema</title>
    </head>
    <body>
    <center>
        <h1>
           <%=request.getParameter("mensaje")%>
        </h1>
        <hr/>
        <a href="usuario/login.jsp"><<< Volver :::</a>
    </center>
</body>
</html>
