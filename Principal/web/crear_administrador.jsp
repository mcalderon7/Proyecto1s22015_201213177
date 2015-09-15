<%-- 
    Document   : crear_administrador
    Created on : Sep 14, 2015, 11:15:43 PM
    Author     : Marvin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
		<meta charset="UTF-8" />
		<meta http-equiv="X-UA-Compatible" content="IE=edge"> 
		<meta name="viewport" content="width=device-width, initial-scale=1"> 
		<title>HTML5 Contact Form | Codeconvey</title>
		<meta name="description" content="HTML5 comes with many awesome features. One of the feature is form validation without using any kind of javascript or jquery." />
		<meta name="keywords" content="form,html form,css form,html5 contact form,contact form" />
		<meta name="author" content="Codeconvey" />
		<link rel="shortcut icon" href="../favicon.ico">
		<link rel="stylesheet" type="text/css" href="forms/css/demo.css" />
        <link rel="stylesheet" type="text/css" href="forms/css/component.css" />
		<!--[if IE]>
  		<script src="http://html5shiv.googlecode.com/svn/trunk/html5.js"></script>
		<![endif]-->
        <script>
		  (function(i,s,o,g,r,a,m){i['GoogleAnalyticsObject']=r;i[r]=i[r]||function(){
		  (i[r].q=i[r].q||[]).push(arguments)},i[r].l=1*new Date();a=s.createElement(o),
		  m=s.getElementsByTagName(o)[0];a.async=1;a.src=g;m.parentNode.insertBefore(a,m)
		  })(window,document,'script','//www.google-analytics.com/analytics.js','ga');
		  ga('create', 'UA-47356263-1', 'codeconvey.com');
		  ga('send', 'pageview');
		</script>
	</head>
	<body>
		<div class="container">
			<!-- Top Navigation -->
			<div class="cctop clearfix">
               <a href="http://codeconvey.com/Tutorials/CSSFeedbackcommentForm/"><span>Previous Demo</span></a>
               <span class="right"><a href="http://codeconvey.com/?p=130"><span>Back to the Codeconvey Article</span></a></span>
			</div>
			<header class="ccheader">
				<h1>HTML5 Contact Form</h1>	
			</header>
			<div class="wrapper">
				<form method="post" action="" class="ccform">
                <div class="ccfield-prepend">
                    <span class="ccform-addon"><i class="fa fa-user fa-2x fa-spin"></i></span>
                    <input class="ccformfield" type="text" placeholder="Full Name" required>
                </div>
                <div class="ccfield-prepend">
                    <span class="ccform-addon"><i class="fa fa-envelope fa-2x"></i></span>
                    <input class="ccformfield" type="text" placeholder="Email" required>
                </div>
                <div class="ccfield-prepend">
                    <span class="ccform-addon"><i class="fa fa-mobile-phone fa-2x"></i></span>
                    <input class="ccformfield" type="text" placeholder="Phone">
                </div>
                 <div class="ccfield-prepend">
                    <span class="ccform-addon"><i class="fa fa-info fa-2x"></i></span>
                    <input class="ccformfield" type="text" placeholder="Subject" required>
                </div>
                <div class="ccfield-prepend">
                    <span class="ccform-addon"><i class="fa fa-comment fa-2x"></i></span>
                    <textarea class="ccformfield" name="comments" rows="8" placeholder="Message" required></textarea>
                </div>
                <div class="ccfield-prepend">
                    <input class="ccbtn" type="submit" value="Submit">
                </div>
                </form>
			</div>
			
		</div><!-- /container -->
		
	</body>
</html>
