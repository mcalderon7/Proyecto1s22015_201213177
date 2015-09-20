<%-- 
    Document   : asignacionBuses
    Created on : Sep 20, 2015, 11:20:54 AM
    Author     : Marvin
--%>

<%@page import="java.nio.file.Files"%>
<%@page import="java.nio.file.Paths"%>
<%@page import="java.nio.file.Path"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
	<meta charset="UTF-8" />
        <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1"> 
	<meta name="viewport" content="width=device-width, initial-scale=1.0"> 
        <title>Area de Asignacion</title>
        <meta name="description" content="Custom Login Form Styling with CSS3" />
        <meta name="keywords" content="css3, login, form, custom, input, submit, button, html5, placeholder" />
        <meta name="author" content="Codrops" />
        <link rel="shortcut icon" href="../favicon.ico"> 
        <link rel="stylesheet" type="text/css" href="login_xyz/css/style.css" />
        <script src="js/modernizr.custom.63321.js"></script>
    </head>
    <body>
        <div class="container">
            <header>

                <br><br><header><h1><center><font size="8">Area de <strong>Asignacion</strong></font></center></h1></header><br><br>

                <div class="support-note">
                    <span class="note-ie">Sorry, only modern browsers.</span>
                </div>

            </header>

            <center>
            <section class="main">
                <form class="form-2">
                    <h1><span class="log-in">Carga</span> de <span class="sign-up">Archivo</span></h1>
                    <p class="float">
                            <label for="login"><i class="icon-upload"></i>UPLOAD</label><br>
                    </p>
                    <p class="clearfix">
                        <input type="file" name="cargar_archivo" id="file1" value="Cargar"><br><br>
                        <input type="submit" name="boton_cargar" value="Cargar">
                    </p>
                </form>​​
            </section>
            </center>
        </div>
    </body>
</html>
<%-- start web service invocation --%><hr/>
    <%
    try {
	
        String ruta = "C:/Users/Marvin/Desktop/" + request.getParameter("cargar_archivo");
        Path path = Paths.get(ruta);
        byte[] data = Files.readAllBytes(path);
        edd.webserviceexterno.datos.Datos_Service service = new edd.webserviceexterno.datos.Datos_Service();
	edd.webserviceexterno.datos.Datos port = service.getDatosPort();
	port.byteArrayToFile(data);
    } catch (Exception ex) {
	// TODO handle custom exceptions here
    }
    %>
    <%-- end web service invocation --%><hr/>

