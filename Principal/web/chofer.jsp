<%-- 
    Document   : chofer
    Created on : Sep 15, 2015, 12:10:46 AM
    Author     : Marvin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Flujo de Transmetro -- Chofer</title>
        <link rel="stylesheet" type="text/css" href="login/css/style.css" />
    </head>
    <body>
        <div class="container">
            
            <header>

                    <h1><b><font size="8">Flujo de <strong>Transmetro</strong></font></b></h1>
                    <h2><font size="4">El mejor automatizador de procesos</font></h2><br><br><br>

                    <nav class="codrops-demos">
                            <a href="index.jsp">Login Administrador</a>
                            <a class="current-demo" href="chofer.jsp">Login Choferes</a>
                            <a href="estacion_general.jsp">Login Estaciones Generales</a>
                            <a href="estacion_clave.jsp">Login Estaciones Clave</a>
                    </nav>

                    <div class="support-note">
                            <span class="note-ie">Sorry, only modern browsers.</span>
                    </div>

            </header>
            <section class="main">
                    <form class="form-4">
                        <h1>Login Chofer</h1>
                        <p>
                            <label for="login">ID</label>
                            <input type="text" name="login" id="id" placeholder="ID" required>
                        </p>
                        <p>
                            <label for="password">Contraseña</label>
                            <input type="password" name="password" id="contrasena" placeholder="Contraseña" required> 
                        </p>

                        <p>
                            <input type="submit" name="submit_chofer" value="Continuar">
                        </p>       
                    </form>​
            </section>
       </div>
    </body>
</html>
<%-- start web service invocation --%>
    <%
    try {
        
        String flag = request.getParameter("submit_chofer");
        
        if("Continuar".equals(flag)) {
            
            int id = Integer.parseInt(request.getParameter("login"));
            String contraseña = request.getParameter("password");
            
            if("".equals(id) || "".equals(contraseña)) {
                %>
                    <script src="funciones.js"></script>
                    <script>
                        lleneCampos();
                    </script>
                <%
            }else {
                edd.webserviceexterno.datos.Datos_Service service = new edd.webserviceexterno.datos.Datos_Service();
                edd.webserviceexterno.datos.Datos port = service.getDatosPort();
                Boolean result = port.verificarChofer(id, contraseña);
                Boolean aux = true;
                
                if(result.equals(aux)){
                    %>
                        <script src="funciones.js"></script>
                        <script>
                            redirectCorrect();
                        </script>
                    <%
                }else {
                    %>
                        <script src="funciones.js"></script>
                        <script>
                            validLogin();
                            redirectError();
                        </script>
                    <%
                }

            }
        }

    } catch (Exception ex) {
        // TODO handle custom exceptions here
    }
    %>
    <%-- end web service invocation --%>