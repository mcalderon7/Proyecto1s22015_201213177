<%-- 
    Document   : index
    Created on : Sep 12, 2015, 12:09:22 AM
    Author     : Marvin
--%>

<%@page import="javax.script.ScriptEngine"%>
<%@page import="javax.script.ScriptEngineManager"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html method="POST">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Flujo de Transmetro</title>
        <link rel="stylesheet" type="text/css" href="login/css/style.css" />
    </head>
    <body>
        <div class="container">
            
            <header>

                    <h1><b><font size="8">Flujo de <strong>Transmetro</strong></font></b></h1>
                    <h2><font size="4">El mejor automatizador de procesos</font></h2><br><br><br>

                    <nav class="codrops-demos">
                            <a class="current-demo" href="index.jsp">Login Administrador</a>
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
                        <h1>Login Administradores</h1>
                        <p>
                            <label for="login">Correo</label>
                            <input type="text" name="login" id="login" placeholder="Correo" required>
                        </p>
                        <p>
                            <label for="password">Contraseña</label>
                            <input type="password" name="password" id="contrasena" placeholder="Contraseña" required> 
                        </p>

                        <p>
                            <input type="submit" name="submit" value="Continuar">
                        </p>       
                    </form>​
            </section>
       </div>
    <%-- start web service invocation --%>
    <%
    try {
	
        String flag = request.getParameter("submit");
        
        if("Continuar".equals(flag)) {
            
            String correo_x = request.getParameter("login");
            String contraseña = request.getParameter("password");
            
            /*Código de JavaScript*/
            ScriptEngineManager manager = new ScriptEngineManager();
            ScriptEngine engine = manager.getEngineByName("JavaScript");
            
            String script1 = (String)"function validLogin(){alert(\"Usuario incorrecto\");}";
            String script2 = (String)"document.forms[0].action = \"crear_administrador.jsp\"; document.forms[0].method = \"post\"; document.forms[0].submit();";
            String script3 = (String)"document.forms[0].action = \"index.jsp\"; document.forms[0].method = \"post\"; document.forms[0].submit();";
            
            if(correo_x == "admin" && contraseña == "admin") {
                engine.eval(script2);
            }else {
                edd.webserviceexterno.datos.Datos_Service service = new edd.webserviceexterno.datos.Datos_Service();
                edd.webserviceexterno.datos.Datos port = service.getDatosPort();
                // TODO process result here
                boolean result = port.verificarAdministrador(correo_x, contraseña);
                
                if(result == true){
                    engine.eval(script2);
                }else {
                    engine.eval(script1);
                    engine.eval(script3);
                }
                
            }
        }
        
    } catch (Exception ex) {
	// TODO handle custom exceptions here
    }
    %>
    <%-- end web service invocation --%>
    </body>
</html>
