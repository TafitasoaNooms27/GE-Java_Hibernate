<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head >
<%
String path = request.getContextPath();
String basePath = request.getScheme() + "://"
	+ request.getServerName() + ":"
	+ request.getServerPort()
	+ path + "/";
%>
<base href="<%= basePath %>"></base>

<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <!-- Tell the browser to be responsive to screen width -->
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="keywords"
        content="wrappixel, admin dashboard, html css dashboard, web dashboard, bootstrap 5 admin, bootstrap 5, css3 dashboard, bootstrap 5 dashboard, Ample lite admin bootstrap 5 dashboard, frontend, responsive bootstrap 5 admin template, Ample admin lite dashboard bootstrap 5 dashboard template">
    <meta name="description"
        content="Ample Admin Lite is powerful and clean admin dashboard template, inpired from Bootstrap Framework">
    <meta name="robots" content="noindex,nofollow">
    <title>Gestion d'Affectaions</title>
 
   
    <!-- Custom CSS -->
    <link href="assets/templ/plugins/bower_components/chartist/dist/chartist.min.css" rel="stylesheet">
    <link rel="stylesheet" href="assets/templ/plugins/bower_components/chartist-plugin-tooltips/dist/chartist-plugin-tooltip.css">
    <!-- Custom CSS -->
    <link href="assets/templ/css/style.min.css" rel="stylesheet">

    <!-- POUR RECHERCHE -->
    
   <link rel="stylesheet" href="assets/css/bootstrap.min.css">
  <script src="assets/js/jquery.slim.min.js"></script>
  <script src="assets/js/popper.min.js"></script>
  <script src="assets/js/bootstrap.bundle.min.js"></script>
     <!--------------------------------------------  FORMS  ---------------------------------------------------- -->
    
	<link rel="stylesheet" type="text/css" href="assets/form/vendor/bootstrap/css/bootstrap.min.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="assets/form/fonts/font-awesome-4.7.0/css/font-awesome.min.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="assets/form/fonts/iconic/css/material-design-iconic-font.min.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="assets/form/vendor/animate/animate.css">
<!--===============================================================================================-->	
	<link rel="stylesheet" type="text/css" href="assets/form/vendor/css-hamburgers/hamburgers.min.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="assets/form/vendor/animsition/css/animsition.min.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="assets/form/vendor/select2/select2.min.css">
<!--===============================================================================================-->	
	<link rel="stylesheet" type="text/css" href="assets/form/vendor/daterangepicker/daterangepicker.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="assets/form/css/util.css">
	<link rel="stylesheet" type="text/css" href="assets/form/css/main.css">
<!--===========================================  NEW FORMS====================================================-->

<!-- Icons font CSS-->
 <link href="assets/newforms/vendor/mdi-font/css/material-design-iconic-font.min.css" rel="stylesheet" media="all">
 <link href="assets/newforms/vendor/font-awesome-4.7/css/font-awesome.min.css" rel="stylesheet" media="all">
 <!-- Font special for pages-->
 <link href="assets/https://fonts.googleapis.com/css?family=Roboto:100,100i,300,300i,400,400i,500,500i,700,700i,900,900i" rel="stylesheet">

 <!-- Vendor CSS-->
 <link href="assets/newforms/vendor/select2/select2.min.css" rel="stylesheet" media="all">
 <link href="assets/newforms/vendor/datepicker/daterangepicker.css" rel="stylesheet" media="all">

 <!-- Main CSS-->
 <link href="assets/newforms/css/main.css" rel="stylesheet" media="all">
 
 
 </head>
<body>
