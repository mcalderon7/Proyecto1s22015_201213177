<%-- 
    Document   : index
    Created on : Sep 12, 2015, 12:09:22 AM
    Author     : Marvin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form method="POST">
        <h1>Formulario para crear usuarios administradores:</h1><br><br>
        Correo:
        <input type="text" name="correo"><br><br>
        Contraseña:
        <input type="password" name="contrasena"><br><br>
        <input type="submit" name="action" value="Enviar">
    <%-- start web service invocation --%><hr/>
    <%
    try {
	String flag = request.getParameter("action");
        
        if("Enviar".equals(flag)) {
            String correo_x = request.getParameter("correo");
            String contraseña = request.getParameter("contrasena");

            edd.webserviceexterno.datos.Datos_Service service = new edd.webserviceexterno.datos.Datos_Service();
            edd.webserviceexterno.datos.Datos port = service.getDatosPort();
             // TODO initialize WS operation arguments here
            java.lang.String correo = correo_x;
            java.lang.String password = contraseña;
            // TODO process result here
            java.lang.String result = port.crearAdministrador(correo, password);
            out.println("Result = "+result);
        }
    } catch (Exception ex) {
	// TODO handle custom exceptions here
    }
    %>
    <%-- end web service invocation --%><hr/>
    </body>
</html>
