<%-- 
    Document   : reporteria
    Created on : Sep 14, 2015, 11:36:36 PM
    Author     : Marvin
--%>

<%@page import="java.io.File"%>
<%@page import="java.awt.Graphics2D"%>
<%@page import="java.awt.image.BufferedImage"%>
<%@page import="java.awt.Image"%>
<%@page import="javax.imageio.ImageReadParam"%>
<%@page import="javax.imageio.stream.ImageInputStream"%>
<%@page import="javax.imageio.ImageReader"%>
<%@page import="javax.imageio.ImageIO"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.io.ByteArrayInputStream"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

    <head>
	<meta charset="UTF-8" />
        <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1"> 
	<meta name="viewport" content="width=device-width, initial-scale=1.0"> 
        <title>Reporteria</title>
        <link rel="stylesheet" type="text/css" href="login_xy/css/style.css" />
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
        
        <div class="container">
            <header>

                <br><br><header><h1><center><font size="8">Area de <strong>Reporteria</strong></font></center></h1></header><br><br>
                
                <table border="0" cellpadding="5" width="300">
                    <tr>
                        <td>
                            <section class="main">
                                <form class="form-3">
                                    <p class="clearfix">
                                        <input type="submit" name="submit_hit" value="AVL Administrador">
                                    </p>
                                </form>​
                            </section>
                        </td>
                        
                        <td>
                            <section class="main">
                                <form class="form-3">
                                    <p class="clearfix">
                                        <input type="submit" name="submit_hit" value="AVL Chofer">
                                    </p>
                                </form>​
                            </section>
                        </td>
                        
                        <td>
                            <section class="main">
                                <form class="form-3">
                                    <p class="clearfix">
                                        <input type="submit" name="submit_hit" value="AVL Estacion Clave">
                                    </p>
                                </form>​
                            </section>
                        </td>
                        
                        <td>
                            <section class="main">
                                <form class="form-3">
                                    <p class="clearfix">
                                        <input type="submit" name="submit_hit" value="AVL Estacion General">
                                    </p>
                                </form>​
                            </section>
                        </td>
                        
                        <td>
                            <section class="main">
                                <form class="form-3">
                                    <p class="clearfix">
                                        <input type="submit" name="submit_hit" value="Lista Buses">
                                    </p>
                                </form>​
                            </section>
                        </td>
                        
                        <td>
                            <section class="main">
                                <form class="form-3">
                                    <p class="clearfix">
                                        <input type="submit" name="submit_hit" value="Lista Ruta">
                                    </p>
                                </form>​
                            </section>
                        </td>
                    </tr>
                </table>
            </header>
        </div>
    <%-- start web service invocation --%>
    <%
    try {
	
        String flag = request.getParameter("submit_hit");
        
        if(flag != null) {
            
            String tipo = "";
            edd.webserviceexterno.datos.Datos_Service service = new edd.webserviceexterno.datos.Datos_Service();
            edd.webserviceexterno.datos.Datos port = service.getDatosPort();
            
            if("AVL Administrador".equals(flag)) {
                port.reporteAdministrador();
                tipo = "admin";
                byte[] result = port.imageToByteArray(tipo);
                System.out.println(result);

                /*BYTE ARRAY TO IMAGE FILE*/

                ByteArrayInputStream bis = new ByteArrayInputStream(result);
                Iterator<?> readers = ImageIO.getImageReadersByFormatName("jpg");

                ImageReader reader = (ImageReader) readers.next();
                Object source = bis; 
                ImageInputStream iis = ImageIO.createImageInputStream(source); 
                reader.setInput(iis, true);
                ImageReadParam param = reader.getDefaultReadParam();

                Image image = reader.read(0, param);

                BufferedImage bufferedImage = new BufferedImage(image.getWidth(null), image.getHeight(null), BufferedImage.TYPE_INT_RGB);

                Graphics2D g2 = bufferedImage.createGraphics();
                g2.drawImage(image, null, null);

                File imageFile = new File("C:/Users/Marvin/Documents/NetBeansProjects/Proyecto1s22015_201213177/Principal/web/diagramas/diagrama_admin.jpg");
                ImageIO.write(bufferedImage, "jpg", imageFile);

                System.out.println("*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*");
                System.out.println("Se ha creado la imagen en la ruta: " + imageFile.getPath());
                System.out.println("*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*");
                
                %>
                    <br><center><img src="diagramas/diagrama_admin.jpg"/></center>
                <%
                
            }else if("AVL Chofer".equals(flag)) {
                tipo = "chofer";
                port.reporteChofer();
                byte[] result = port.imageToByteArray(tipo);

                /*BYTE ARRAY TO IMAGE FILE*/

                ByteArrayInputStream bis = new ByteArrayInputStream(result);
                Iterator<?> readers = ImageIO.getImageReadersByFormatName("jpg");

                ImageReader reader = (ImageReader) readers.next();
                Object source = bis; 
                ImageInputStream iis = ImageIO.createImageInputStream(source); 
                reader.setInput(iis, true);
                ImageReadParam param = reader.getDefaultReadParam();

                Image image = reader.read(0, param);

                BufferedImage bufferedImage = new BufferedImage(image.getWidth(null), image.getHeight(null), BufferedImage.TYPE_INT_RGB);

                Graphics2D g2 = bufferedImage.createGraphics();
                g2.drawImage(image, null, null);

                File imageFile = new File("C:/Users/Marvin/Documents/NetBeansProjects/Proyecto1s22015_201213177/Principal/web/diagramas/diagrama_chofer.jpg");
                ImageIO.write(bufferedImage, "jpg", imageFile);

                System.out.println("*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*");
                System.out.println("Se ha creado la imagen en la ruta: " + imageFile.getPath());
                System.out.println("*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*");
                
                %>
                    <br><center><img src="diagramas/diagrama_chofer.jpg"/></center>
                <%
                
            }else if("AVL Estacion Clave".equals(flag)) {
                tipo = "estacion_clave";
                port.reporteEstacionClave();
                byte[] result = port.imageToByteArray(tipo);

                /*BYTE ARRAY TO IMAGE FILE*/

                ByteArrayInputStream bis = new ByteArrayInputStream(result);
                Iterator<?> readers = ImageIO.getImageReadersByFormatName("jpg");

                ImageReader reader = (ImageReader) readers.next();
                Object source = bis; 
                ImageInputStream iis = ImageIO.createImageInputStream(source); 
                reader.setInput(iis, true);
                ImageReadParam param = reader.getDefaultReadParam();

                Image image = reader.read(0, param);

                BufferedImage bufferedImage = new BufferedImage(image.getWidth(null), image.getHeight(null), BufferedImage.TYPE_INT_RGB);

                Graphics2D g2 = bufferedImage.createGraphics();
                g2.drawImage(image, null, null);

                File imageFile = new File("C:/Users/Marvin/Documents/NetBeansProjects/Proyecto1s22015_201213177/Principal/web/diagramas/diagrama_estacion_clave.jpg");
                ImageIO.write(bufferedImage, "jpg", imageFile);

                System.out.println("*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*");
                System.out.println("Se ha creado la imagen en la ruta: " + imageFile.getPath());
                System.out.println("*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*");
                
                %>
                    <br><center><img src="diagramas/diagrama_estacion_clave.jpg"/></center>
                <%
                
            }else if("AVL Estacion General".equals(flag)) {
                tipo = "estacion_general";
                port.reporteEstacionGeneral();
                byte[] result = port.imageToByteArray(tipo);

                /*BYTE ARRAY TO IMAGE FILE*/

                ByteArrayInputStream bis = new ByteArrayInputStream(result);
                Iterator<?> readers = ImageIO.getImageReadersByFormatName("jpg");

                ImageReader reader = (ImageReader) readers.next();
                Object source = bis; 
                ImageInputStream iis = ImageIO.createImageInputStream(source); 
                reader.setInput(iis, true);
                ImageReadParam param = reader.getDefaultReadParam();

                Image image = reader.read(0, param);

                BufferedImage bufferedImage = new BufferedImage(image.getWidth(null), image.getHeight(null), BufferedImage.TYPE_INT_RGB);

                Graphics2D g2 = bufferedImage.createGraphics();
                g2.drawImage(image, null, null);

                File imageFile = new File("C:/Users/Marvin/Documents/NetBeansProjects/Proyecto1s22015_201213177/Principal/web/diagramas/diagrama_estacion_general.jpg");
                ImageIO.write(bufferedImage, "jpg", imageFile);

                System.out.println("*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*");
                System.out.println("Se ha creado la imagen en la ruta: " + imageFile.getPath());
                System.out.println("*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*");
                
                %>
                    <br><center><img src="diagramas/diagrama_estacion_general.jpg"/></center>
                <%
                
            }else if("Lista Buses".equals(flag)) {
                tipo = "bus";
                port.reporteBus();
                byte[] result = port.imageToByteArray(tipo);

                /*BYTE ARRAY TO IMAGE FILE*/

                ByteArrayInputStream bis = new ByteArrayInputStream(result);
                Iterator<?> readers = ImageIO.getImageReadersByFormatName("jpg");

                ImageReader reader = (ImageReader) readers.next();
                Object source = bis; 
                ImageInputStream iis = ImageIO.createImageInputStream(source); 
                reader.setInput(iis, true);
                ImageReadParam param = reader.getDefaultReadParam();

                Image image = reader.read(0, param);

                BufferedImage bufferedImage = new BufferedImage(image.getWidth(null), image.getHeight(null), BufferedImage.TYPE_INT_RGB);

                Graphics2D g2 = bufferedImage.createGraphics();
                g2.drawImage(image, null, null);

                File imageFile = new File("C:/Users/Marvin/Documents/NetBeansProjects/Proyecto1s22015_201213177/Principal/web/diagramas/diagrama_bus.jpg");
                ImageIO.write(bufferedImage, "jpg", imageFile);

                System.out.println("*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*");
                System.out.println("Se ha creado la imagen en la ruta: " + imageFile.getPath());
                System.out.println("*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*");
                
                %>
                    <br><center><img src="diagramas/diagrama_bus.jpg"/></center>
                <%
                
            }else if("Lista Ruta".equals(flag)) {
                tipo = "ruta";
                port.reporteRuta();
                byte[] result = port.imageToByteArray(tipo);

                /*BYTE ARRAY TO IMAGE FILE*/

                ByteArrayInputStream bis = new ByteArrayInputStream(result);
                Iterator<?> readers = ImageIO.getImageReadersByFormatName("jpg");

                ImageReader reader = (ImageReader) readers.next();
                Object source = bis; 
                ImageInputStream iis = ImageIO.createImageInputStream(source); 
                reader.setInput(iis, true);
                ImageReadParam param = reader.getDefaultReadParam();

                Image image = reader.read(0, param);

                BufferedImage bufferedImage = new BufferedImage(image.getWidth(null), image.getHeight(null), BufferedImage.TYPE_INT_RGB);

                Graphics2D g2 = bufferedImage.createGraphics();
                g2.drawImage(image, null, null);

                File imageFile = new File("C:/Users/Marvin/Documents/NetBeansProjects/Proyecto1s22015_201213177/Principal/web/diagramas/diagrama_ruta.jpg");
                ImageIO.write(bufferedImage, "jpg", imageFile);

                System.out.println("*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*");
                System.out.println("Se ha creado la imagen en la ruta: " + imageFile.getPath());
                System.out.println("*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*");
                
                %>
                    <br><center><img src="diagramas/diagrama_ruta.jpg"/></center>
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
