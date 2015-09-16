<%-- 
    Document   : crear_ruta
    Created on : Sep 14, 2015, 11:18:05 PM
    Author     : Marvin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
            <head>
	<!-- General meta information -->
	<title>Registro de Rutas</title>
	<meta charset="utf-8" />
	<!-- // General meta information -->
	
	
	<!-- Load Javascript -->
	<script type="text/javascript" src="forms/js/jquery.js"></script>
	<script type="text/javascript" src="forms/js/jquery.query-2.1.7.js"></script>
	<script type="text/javascript" src="forms/js/rainbows.js"></script>
	<!-- // Load Javascipt -->

	<!-- Load stylesheets -->
	<link type="text/css" rel="stylesheet" href="forms/css/style.css" media="screen" />
        <link rel="stylesheet" type="text/css" href="login_x/css/style.css" />
	<!-- // Load stylesheets -->
	
<script>


	$(document).ready(function(){
 
	$("#submit1").hover(
	function() {
	$(this).animate({"opacity": "0"}, "slow");
	},
	function() {
	$(this).animate({"opacity": "1"}, "slow");
	});
 	});


</script>
	
</head>
<body>
    
    <!-- Codrops top bar -->
    <div class="codrops-top">
        <span class="right">
            <a href="index.jsp">
                <strong>Logout</strong>
            </a>
        </span>
    </div>
    <!--/ Codrops top bar -->
    
    <br><br><header><h1><b><center><font size="8">Bienvenido <strong>Administrador!</strong></font></center></b></h1></header><br><br>
    
    <nav class="codrops-demos">
        <a href="crear_administrador.jsp">Crear Administrador</a>
        <a href="crear_chofer.jsp">Crear Choferes</a>
        <a href="crear_estacion_general.jsp">Crear Estaciones Generales</a>
        <a href="crear_estacion_clave.jsp">Crear Estaciones Clave</a>
        <a class="current-demo" href="crear_ruta.jsp">Crear Ruta</a>
        <a href="crear_bus.jsp">Crear Bus</a>
    </nav>
    
    <div id="wrapper">
    <div id="wrappertop"></div>

    <div id="wrappermiddle">

            <h2><center>Registro de Rutas</center></h2>
            <br>
            <div id="username_input">

                    <div id="username_inputleft"></div>

                    <div id="username_inputmiddle">
                    <form>
                            <input type="text" name="link" id="url" value="Nombre" onclick="this.value = ''">
                            <img id="url_user" src="forms/images/user.png" alt="">
                    </form>
                    </div>

                    <div id="username_inputright"></div>

            </div>
            <div id="wrappermiddle">
                
                <div id="submit">
                        <form>
                        <input type="image" src="forms/images/submit_hover.png" id="submit1" value="Registrar">
                        <input type="image" src="forms/images/submit.png" id="submit2" value="Registrar">
                        </form>
                </div>
            </div>
            <div id="wrapperbottom"></div>
	</div>
</body>
</html>
