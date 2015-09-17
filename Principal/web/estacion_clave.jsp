<%-- 
    Document   : estacion_clave
    Created on : Sep 15, 2015, 12:10:59 AM
    Author     : Marvin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <script type="text/javascript">
            function validLogin(){
                alert("Usuario incorrecto");
            }
        </script>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Flujo de Transmetro -- Estacion Clave</title>
        <link rel="stylesheet" type="text/css" href="login/css/style.css" />
    </head>
    <body>
        <div class="container">
            
            <header>

                    <h1><b><font size="8">Flujo de <strong>Transmetro</strong></font></b></h1>
                    <h2><font size="4">El mejor automatizador de procesos</font></h2><br><br><br>

                    <nav class="codrops-demos">
                            <a href="index.jsp">Login Administrador</a>
                            <a href="chofer.jsp">Login Choferes</a>
                            <a href="estacion_general.jsp">Login Estaciones Generales</a>
                            <a class="current-demo" href="estacion_clave.jsp">Login Estaciones Clave</a>
                    </nav>

                    <div class="support-note">
                            <span class="note-ie">Sorry, only modern browsers.</span>
                    </div>

            </header>
            <section class="main">
                    <form class="form-4">
                        <h1>Login Estacion Clave</h1>
                        <p>
                            <label for="login">ID</label>
                            <input type="text" name="login" id="id" placeholder="ID" required>
                        </p>
                        <p>
                            <label for="password">Contraseña</label>
                            <input type="password" name="password" id="contrasena" placeholder="Contraseña" required> 
                        </p>

                        <p>
                            <input type="submit" name="submit" value="Continuar" onclick="validLogin();">
                        </p>       
                    </form>​
            </section>
       </div>
    </body>
</html>
