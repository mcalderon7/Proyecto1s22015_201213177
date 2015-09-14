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
        <title>Flujo de Transmetro</title>
        <link rel="stylesheet" type="text/css" href="css/style.css" />
    </head>
    <body>
    <div class="container">
        <header>

                <h1>Flujo de <strong>Transmetro</strong></h1>
                <h2>El mejor automatizador de procesos</h2>

                <nav class="codrops-demos">
                        <%--<a href="index.html">Registrarse</a>
                        <a href="index2.html">Demo 2</a>
                        <a href="index3.html">Demo 3</a>
                        <a class="current-demo" href="index4.html">Demo 4</a>
                        <a href="index5.html">Demo 5</a> --%>
                </nav>

                <div class="support-note">
                        <span class="note-ie">Sorry, only modern browsers.</span>
                </div>

        </header>

        <section class="main">
                <form class="form-4">
                    <h1>Login</h1>
                    <p>
                        <label for="login">Correo</label>
                        <input type="text" name="login" placeholder="Correo" required>
                    </p>
                    <p>
                        <label for="password">Contraseña</label>
                        <input type="password" name='password' placeholder="Contraseña" required> 
                    </p>

                    <p>
                        <input type="submit" name="submit" value="Continuar">
                    </p>       
                </form>​
        </section>
   </div>
    <%-- start web service invocation --%><hr/>
    <%
    try {
	String flag = request.getParameter("submit");
        
        if("Continuar".equals(flag)) {
            String correo_x = request.getParameter("login");
            String contraseña = request.getParameter("password");

            edd.webserviceexterno.datos.Datos_Service service = new edd.webserviceexterno.datos.Datos_Service();
            edd.webserviceexterno.datos.Datos port = service.getDatosPort();
             // TODO initialize WS operation arguments here
            java.lang.String correo = correo_x;
            java.lang.String password = contraseña;
            // TODO process result here
            java.lang.String result = port.crearAdministrador(correo, password);
            System.out.println("Result = "+result);
        }
    } catch (Exception ex) {
	// TODO handle custom exceptions here
    }
    %>
    <%-- end web service invocation --%><hr/>
    </body>
</html>
