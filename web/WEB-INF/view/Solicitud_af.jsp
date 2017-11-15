<%@page import="co.edu.ucatolica.bds.BD"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<!--A Design by W3layouts
Author: W3layout
Author URL: http://w3layouts.com
License: Creative Commons Attribution 3.0 Unported
License URL: http://creativecommons.org/licenses/by/3.0/
-->
<!DOCTYPE html>
<html lang="en">
    <head>
        <title>Centauros Bank</title>
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
        <meta name="keywords" content="Hosting City Responsive web template, Bootstrap Web Templates, Flat Web Templates, Android Compatible web template, 
              Smartphone Compatible web template, free webdesigns for Nokia, Samsung, LG, SonyEricsson, Motorola web design" />
        <script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
        <!-- bootstrap-css -->
        <link href="css/bootstrap.css" rel="stylesheet" type="text/css" media="all" />
        <!--// bootstrap-css -->
        <!-- css -->
        <link rel="stylesheet" href="css/style.css" type="text/css" media="all" />
        <!--// css -->
        <!-- font-awesome icons -->
        <link href="css/font-awesome.css" rel="stylesheet"> 
        <!-- //font-awesome icons -->
        <!-- font -->
        <link href="//fonts.googleapis.com/css?family=Roboto:100,100i,300,300i,400,400i,500,500i,700,700i,900,900i" rel="stylesheet">
        <link href='//fonts.googleapis.com/css?family=Roboto+Condensed:400,700italic,700,400italic,300italic,300' rel='stylesheet' type='text/css'>
        <!-- //font -->
        <script src="js/jquery-1.11.1.min.js"></script>
        <script src="js/bootstrap.js"></script>
        <script src="js/SmoothScroll.min.js"></script>
        <script type="text/javascript">
            jQuery(document).ready(function ($) {
                $(".scroll").click(function (event) {
                    event.preventDefault();
                    $('html,body').animate({scrollTop: $(this.hash).offset().top}, 1000);
                });
            });
        </script>
    </head>
    <body>
        <!-- header-top -->
        <div class="header-top">
            <div class="container">
                <div class="clearfix"> </div>
            </div>
        </div>
        <!-- //header-top -->
        <!-- header -->
        <div class="header">
            <div class="container">
                <nav class="navbar navbar-default">
                    <!-- Brand and toggle get grouped for better mobile display -->
                    <div class="navbar-header">
                        <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
                            <span class="sr-only">Toggle navigation</span>
                            <span class="icon-bar"></span>
                            <span class="icon-bar"></span>
                            <span class="icon-bar"></span>
                        </button>
                        <div class="w3layouts-logo">
                            <h1><a href="index.html"><span>Centauros Bank</span></a></h1>
                        </div>
                    </div>

                    <!-- Collect the nav links, forms, and other content for toggling -->
                    <div class="collapse navbar-collapse nav-wil" id="bs-example-navbar-collapse-1">
                        <nav>
                            <ul class="nav navbar-nav">
                                <li><a href="helloworld.htm" class="hvr-sweep-to-bottom">Inicio</a></li>
                                <li class="active"><a href="#" class="dropdown-toggle hvr-sweep-to-bottom" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Persona<span class="caret"></span></a>
                                    <ul class="dropdown-menu">
                                        <li><a class="hvr-sweep-to-bottom" href="personaCrear.htm">Crear</a></li>
                                        <li><a class="hvr-sweep-to-bottom" href="personaConsultar.htm">Consultar</a></li>
                                        <li><a class="hvr-sweep-to-bottom" href="personaEditar.htm">Editar</a></li>
                                    </ul>
                                </li>
                                <li><a href="#" class="dropdown-toggle hvr-sweep-to-bottom" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Solicitud tarjeta de credito<span class="caret"></span></a>
                                    <ul class="dropdown-menu">
                                        <li><a class="hvr-sweep-to-bottom" href="SolicitudCrear.htm">Crear Solicitud</a></li>
                                        <li><a class="hvr-sweep-to-bottom" href="SolicitudConsultar.htm">Consultar Solicitud</a></li>
                                        <li><a class="hvr-sweep-to-bottom" href="SolicitudEditar.htm">Editar Solicitud</a></li>
                                    </ul>
                                </li>
                                <li><a href="#" class="dropdown-toggle hvr-sweep-to-bottom" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Reportes<span class="caret"></span></a>
                                    <ul class="dropdown-menu">
                                        <li><a class="hvr-sweep-to-bottom" href="SolicitudAceptada.htm">Solicitudes Aceptadas</a></li>
                                        <li><a class="hvr-sweep-to-bottom" href="SolicitudRechazada.htm">Solicitudes Rechazadas</a></li>
                                        <li><a class="hvr-sweep-to-bottom" href="SolicitudCliente.htm">Solicitudes por Producto</a></li>
                                    </ul>
                                </li> 
                                <li><a href="#" class="dropdown-toggle hvr-sweep-to-bottom" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Aprobar Solicitud de tarjeta<span class="caret"></span></a>
                                    <ul class="dropdown-menu">
                                        <li><a class="hvr-sweep-to-bottom" href="SolicitudAprobar.htm">Aprobar Solicitudes</a></li>
                                    </ul>
                                </li> 
                            </ul>
                        </nav>
                    </div>
                    <!-- /.navbar-collapse -->
                </nav>
            </div>
        </div>
        <!-- //header -->
        <div class="about-heading">
            <h2>Aceptar  <span>Solicitudes</span></h2>
        </div>
        <!-- //about-heading -->
        <div class="registration">
            <form action="SolicitudEstadoUp.htm" method="post">
                <div class="table-responsive">        
                    <p>${mensaje}</p>
                    <table id="tablaResultado" class="table table-striped table-hover table-bordered" >

                        <thead>       
                            <tr>
                                <th>Id Cliente</th>
                                <th>Cliente</th>
                                <th>Ingreso Mensual</th>
                                <th>Ocupacion</th>
                                <th>Producto</th>
                                <th>Aceptar Solicitud</th>
                            </tr>
                        </thead>                  
                        <tbody>   



                            <tr>
                                <td> <input type="text" id="combo" value="<%=request.getParameter("pal")%>" name="idCliente" readonly="" ></td>
                                <td><input type="text" id="combo" value="<%=request.getParameter("pal1")%>" name="cliente" readonly="" ></td>
                                <td><input type="text" id="combo" value="<%=request.getParameter("pal2")%>" name="ingMensual" readonly="" ></td>
                                <td><input type="text" id="combo" value="<%=request.getParameter("pal3")%>" name="ocupacion" readonly="" ></td>
                                <td><input type="text" id="combo" value="<%=request.getParameter("pal4")%>" name="Productoname" readonly="" ></td>

                                <td >
                                    <select name="estado" required="" placeholder="Estado">
                                        <option value="pendiente">pendiente</option>
                                        <option value="aceptado">aceptado</option>
                                        <option value="rechazado">rechazado</option>

                                    </select>
                                </td> 
                                <td><input type="text" id="combo" value="<%=request.getParameter("pal5")%>" name="Producto" readonly="" hidden="" ></td>
                            </tr>

                        </tbody>
                    </table>



                    <input type="submit" value="REGISTRAR"> 

                </div>   
            </form>

        </div>      

    </div>
</div>

<!-- //footer -->
<script type="text/javascript" src="js/move-top.js"></script>
<script type="text/javascript" src="js/easing.js"></script>
<!-- here stars scrolling icon -->
<script type="text/javascript">
            $(document).ready(function () {
                /*
                 var defaults = {
                 containerID: 'toTop', // fading element id
                 containerHoverID: 'toTopHover', // fading element hover id
                 scrollSpeed: 1200,
                 easingType: 'linear' 
                 };
                 */

                $().UItoTop({easingType: 'easeOutQuart'});

            });
</script>
<!-- //here ends scrolling icon -->
</body>	
</html>
