<%-- 
    Document   : buscar
    Created on : 25/04/2024, 11:22:42 p. m.
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
        <title>Consultar Usuario</title>
    </head>
    <body>
    <center>
        <h1>Buscar Usuario</h1>
        <hr/>
        <form action="/ejemplo_sesion_jsp/usuario?accion=buscar&redir=buscar" method="post">
            <table>
                <tr>
                    <th style="text-align: right">ID:</th>
                    <th><input type="text" name="id" id="id"/></th>
                </tr>
                <tr>
                    <th><input type="submit" value="Buscarr"/></th>
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
        <p style="color: #FF0000"><%= (mensaje!=null && ! mensaje.isEmpty())?mensaje:""%></p>
        <% request.getSession().setAttribute("usuario.buscar",null); %>


    </center>
</body>
</html>
