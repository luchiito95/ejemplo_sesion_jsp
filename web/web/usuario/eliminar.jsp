<%-- 
    Document   : eliminar
    Created on : 25/04/2024, 11:22:49 p. m.
    Author     : luisf
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    if(request.getSession().getAttribute("usuario.login")==null){
        getServletContext().getRequestDispatcher("/web/usuario/login.jsp").forward(request,response);
    }
    
String mensaje = request.getParameter("mensaje");
Usuario alguien = (Usuario)request.getSession().getAttribute("usuario.buscar");
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Eliminar Usuario</title>
    </head>
    <body>
    <center>
        <h1>Eliminar Usuario</h1>
        <hr/>
        <form action="/ejemplo_sesion_jsp/usuario?accion=buscar&redir=borrar" method="post">
            <table>
                <tr>
                    <th style="text-align: right">ID:</th>
                    <th><input type="text" name="id"/></th>
                </tr>
                <tr>
                    <th><input type="submit" value="Buscar"/></th>
                    <th><input type="reset" name="Limpiar"/></th>
                </tr>
                <tr>
                    <th style="text-align: right">Password:</th>
                    <td style="text-align: left"><% (alguien != null)?"******":"" %></td>
                </tr>
                <tr>
                    <th style="text-align: right">Nombre:</th>
                    <td style="text-align: left"><% (alguien != null)?alguien.getNombre():"" %></td>
                </tr>
                <tr>
                    <th style="text-align: right">Apellido:</th>
                    <td style="text-align: left"><% (alguien != null)?alguien.getApellido():"" %></td>
                </tr>
                <tr>
                    <th style="text-align: right">Email:</th>
                    <td style="text-align: left"><% (alguien != null)?alguien.getEmail():"" %></td>
                </tr>
                <tr>
                    <th style="text-align: right">Tipo:</th>
                    <td style="text-align: left"><% (alguien != null)?alguien.getTipo():"" %></td>
                </tr>


            </table>
        </form>
        <hr/>
        <% 
            if (alguien != null){
        %>

        <form action="/ejemplo_sesion_jsp/usuario?accion=borrar" method="post">
            <input type="hidden" name="id" value="<% alguien.getId() %>"/>
            <table>
                <tr>
                    <td><input type="submit" value="Eliminar"/></td>
                </tr>
            </table>
        </form>

        <% 
            }
        %>
        <p style="color: #FF0000"><%= (mensaje!=null && ! mensaje.isEmpty())?mensaje:""%></p>
        <% request.getSession().setAttribute("usuario.buscar",null); %>


    </center>
</body>
</html>
