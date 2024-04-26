<%-- 
    Document   : listar
    Created on : 25/04/2024, 11:22:55 p. m.
    Author     : luisf
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page session="true"%>
<%@page import="luissalas.modelo.Usuario"%>

<%
    Usuario listado[] = (Usuario[]) session.getAttribute("usuario.listar");
    String mensaje= null;
    if(listado== null || listado.length<= 0){
        mensaje = "Resultado: 0 Usuarios encontrados en el Sistema"
    }
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Listar Usuarios</title>
    </head>
    <body>
    <center>
        <h1>Todos los Usuarios Agregados al Sistema</h1>
        <%
            if(mensaje != null){
                out.print(mensaje);
            } else { 
        %>

        <table>
            <thead>
                <tr>
                    <th>Item</th>
                    <th>ID</th>
                    <th>Nombre</th>
                    <th>Apellido</th>
                    <th>Email</th>
                    <th>Tipo</th>
                </tr>
            </thead>
            <tbody>
                <%
                    int contador =0;
                    for (Usuario alguien : listado){
                    contador = contador+1
                    
                %>
                <tr>
                    <td><%= contador%></td>
                    <td><%= alguien.getId()%></td>
                    <td><%= alguien.getNombre()%></td>
                    <td><%= alguien.getApellido()%></td>
                    <td><%= alguien.getEmail()%></td>
                    <td><%= alguien.getTipo()%></td>
                </tr>
                <%
                    }
                %>
            </tbody>
        </table>
        <%
            }
        %> 
        <hr>
        <a href="../../index.jsp"></a>
    </center>
</body>
</html>
