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
        <link rel="stylesheet" type="text/css" href="login_x/css/style.css" />
	<!-- // Load stylesheets -->
	
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
        <a href="reporteria.jsp">Reporteria</a>
    </nav>
    <head>
	<meta charset="UTF-8" />
        <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1"> 
	<meta name="viewport" content="width=device-width, initial-scale=1.0"> 
        <meta name="description" content="Custom Login Form Styling with CSS3" />
        <meta name="keywords" content="css3, login, form, custom, input, submit, button, html5, placeholder" />
        <meta name="author" content="Codrops" />
        <link rel="shortcut icon" href="../favicon.ico"> 
        <link rel="stylesheet" type="text/css" href="css/style.css" />
	<script src="js/modernizr.custom.63321.js"></script>
	<!--[if lte IE 7]><style>.main{display:none;} .support-note .note-ie{display:block;}</style><![endif]-->
    </head>
    
    <div class="container">
        <section class="main">
            <form class="form-1">
                <p class="field">
                    <input type="text" name="nombre" placeholder="Nombre de la ruta">
                    <i class="icon-user icon-large"></i>
                </p>
                <p class="field">
                    <input type="text" name="estaciones" placeholder="Estaciones por las que pasa">
                    <i class="icon-star icon-large"></i>
                </p>
                <p class="submit">
                    <button type="submit" name="boton_ruta" value="continue"><i class="icon-arrow-right icon-large"></i></button>
                </p>
            </form>
        </section>
    </div>
</body>
</html>
<%-- start web service invocation --%>
    <%
    try {
	
        String flag = request.getParameter("boton_ruta");
        
        if("continue".equals(flag)) {
            String nombre = request.getParameter("nombre");
            String estaciones = request.getParameter("estaciones");
            int valor = (nombre.hashCode() > 0) ? nombre.hashCode() : nombre.hashCode() * -1;
            
            edd.webserviceexterno.datos.Datos_Service service = new edd.webserviceexterno.datos.Datos_Service();
            edd.webserviceexterno.datos.Datos port = service.getDatosPort();
            
            /*Con esta bandera verifico si ya fue creada esa ruta*/
            Boolean resultado = port.verifyRuta(valor);
            Boolean auxiliar = true;
            
            System.out.println(resultado);
            System.out.println(auxiliar);
            
            if(auxiliar.equals(resultado)) {
                %>
                    <script src="funciones.js"></script>
                    <script>
                        mensajeCreacion();
                    </script>
                <%
            }else {
                
                java.lang.String result = port.crearRuta(nombre, estaciones);
                
                System.out.println("Result = " + result);
                /*Javascript*/
                %>
                    <script src="funciones.js"></script>
                    <script>
                        adminCorrecto();
                    </script>
                <%
            }
            
        }
    } catch (Exception ex) {
	// TODO handle custom exceptions here
    }
    %>
    <%-- end web service invocation --%>

