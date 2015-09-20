<%-- 
    Document   : crear_estacion_clave
    Created on : Sep 14, 2015, 11:17:22 PM
    Author     : Marvin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <!-- General meta information -->
        <title>Registro de Estaciones Clave</title>
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
        <a class="current-demo" href="crear_estacion_clave.jsp">Crear Estaciones Clave</a>
        <a href="crear_ruta.jsp">Crear Ruta</a>
        <a href="crear_bus.jsp">Crear Bus</a>
        <a href="reporteria.jsp">Reporteria</a>
        <a href="asignacionBus.jsp">Asignacion de Buses</a>
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
                    <input type="text" name="identificador" placeholder="ID">
                    <i class="icon-star icon-large"></i>
                </p>
                <p class="field">
                    <input type="text" name="nombre" placeholder="Nombre de la estacion">
                    <i class="icon-user icon-large"></i>
                </p>
                    <p class="field">
                    <input type="password" name="password" placeholder="Contraseña">
                    <i class="icon-lock icon-large"></i>
                </p>
                <p class="submit">
                    <button type="submit" name="boton_clave" value="continue"><i class="icon-arrow-right icon-large"></i></button>
                </p>
            </form>
        </section>
    </div>
    <%-- start web service invocation --%>
    <%
    try {
	
        String flag = request.getParameter("boton_clave");
        
        if("continue".equals(flag)) {
            int idEstacionClave = Integer.parseInt(request.getParameter("identificador"));
            String nombre = request.getParameter("nombre");
            String password = request.getParameter("password");
            
            edd.webserviceexterno.datos.Datos_Service service = new edd.webserviceexterno.datos.Datos_Service();
            edd.webserviceexterno.datos.Datos port = service.getDatosPort();
            java.lang.String result = port.crearEstacionClave(idEstacionClave, nombre, password);
            
            /*Con esta bandera verifico si ya fue creado ese administrador*/
            Boolean resultado = port.verificacion("estacion_clave");
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
                
                System.out.println("Result = " + result);
                /*Javascript*/
                %>
                    <script src="funciones.js"></script>
                    <script>
                        claveCorrecto();
                    </script>
                <%
            }
            
        }
    } catch (Exception ex) {
	// TODO handle custom exceptions here
    }
    %>
    <%-- end web service invocation --%>
</body>
</html>

