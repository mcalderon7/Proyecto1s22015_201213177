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
        <link rel="stylesheet" type="text/css" href="login/css/style.css" />
    </head>
    <body>
        <form name="form" method="POST" onsubmit="return validLogin();">
            <div class="container">
                <header>

                        <h1>Flujo de <strong>Transmetro</strong></h1>
                        <h2>El mejor automatizador de procesos</h2><br><br><br>

                        <nav class="codrops-demos">
                                <a class="current-demo" href="index.jsp">Soy Administrador</a>
                                <a href="chofer.jsp">Login Choferes</a>
                                <a href="estacion_general.jsp">Login Estaciones Generales</a>
                                <a href="estacion_clave.jsp">Login Estaciones Clave</a>
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
        </form>
    <%-- start web service invocation --%><hr/>
    <%
    try {
	String flag = request.getParameter("submit");
        
        if("Continuar".equals(flag)) {
            String correo_x = request.getParameter("login");
            String contraseña = request.getParameter("password");

            //edd.webserviceexterno.datos.Datos_Service service = new edd.webserviceexterno.datos.Datos_Service();
            //edd.webserviceexterno.datos.Datos port = service.getDatosPort();
             // TODO initialize WS operation arguments here
            java.lang.String correo = correo_x;
            java.lang.String password = contraseña;
            
            // TODO process result here
            //java.lang.String result = port.crearAdministrador(correo, password);
            //System.out.println("Result = "+result);
        }
    } catch (Exception ex) {
	// TODO handle custom exceptions here
    }
    %>
    <%-- end web service invocation --%><hr/>
    <script>
        function validLogin() {
            if (document.form.login.value !== "admin" && document.form.password.value !== "admin"){
                alert ("Nombre de usuario o contraseña inválida!");
                document.loginform.login.focus();
                document.loginform.password.focus();
                return false;
            }else {
                alert ("Bienvenido Admin!");
                return true;
            }
        }
    </script>
    
    </body>
</html>
