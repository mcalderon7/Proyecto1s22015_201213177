<%-- 
    Document   : index
    Created on : Sep 12, 2015, 12:09:22 AM
    Author     : Marvin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html method="POST">
    <head>
        <script type="text/javascript">
            function validLogin(login, pass){
                if(login !== "admin" && pass !== "admin") {
                    alert("Usuario incorrecto");
                    document.forms[0].action = "index.jsp";
                    document.forms[0].method = "post"; // "get"
                    document.forms[0].submit();
                }else {
                    alert("Bienvenido Administrador!");
                    document.forms[0].action = "crear_administrador.jsp";
                    document.forms[0].method = "post"; // "get"
                    document.forms[0].submit();
                }
            }
        </script>
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
                            <!--<a href="crear_administrador.jsp">Soy Administrador</a>-->
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
                            <input type="password" name='password' placeholder="Contraseña" required> 
                        </p>

                        <p>
                            <input type="submit" name="submit" value="Continuar" onclick="validLogin(document.getElementById('login').value);">
                        </p>       
                    </form>​
            </section>
       </div>
    </body>
</html>
