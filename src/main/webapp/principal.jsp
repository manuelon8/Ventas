<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
		<link href="webjars/bootstrap/4.3.1/css/bootstrap.min.css"    rel="stylesheet">        
        <script src="webjars/bootstrap/4.3.1/js/bootstrap.min.js"></script>        
		<script src="webjars/jquery/1.9.1/jquery.min.js"></script>
<title>Principal</title>
</head>
<body>
<nav class="navbar navbar-expand-lg navbar-light bg-info">
  
   
  <div class="collapse navbar-collapse" id="navbarNav">
    <ul class="navbar-nav">
      <li class="nav-item active">
        <a class="nav-link" href="#">Home  </a>
      </li>
      <li class="nav-item">
        <a style="margin-left: 10px; border: none" class="btn btn-outline-light" href="Controlador?menu=Producto&accion=default" target="myFrame">Producto</a>
      </li>
      <li class="nav-item">
        <a style="margin-left: 10px; border: none" class="btn btn-outline-light" href="Controlador?menu=Empleados&accion=Listar" target="myFrame">Empleados</a>
      </li>
      <li class="nav-item">
        <a style="margin-left: 10px; border: none" class="btn btn-outline-light" href="Controlador?menu=Clientes" target="myFrame">Clientes</a>
      </li>
      <li class="nav-item">
        <a style="margin-left: 10px; border: none" class="btn btn-outline-light" href="Controlador?menu=NuevaVenta&accion=default" target="myFrame">Nueva Venta</a>
      </li>
    </ul>

  </div>
      <div class="dropdown"  >
  <button class="btn btn-outline-light dropdown-toggle" type="button" id="dropdownMenuButton" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
    ${usuario.getNom()}
  </button>
  <div class="dropdown-menu text-center"  aria-labelledby="dropdownMenuButton">
    <a class="dropdown-item" href="#">
	<img src="imaGenes/usuario.png"/>
	</a>
    <a class="dropdown-item" href="#">${usuario.getUser()}</a>
    <a class="dropdown-item" href="#">Usuario@gmail.com</a>
    <div class="dropdown-divider"></div>
    <form action="Validar" method="post">
    <button name="accion" value="Salir" class="dropdown-item" href="#">Salir</button>
    </form>
  </div>
</div>
</nav>

<div class="embed-responsives m-4" style="height: 530px;">
	 <iframe class="embed-responsive-item" name="myFrame"  style="height: 100%; width: 100%; border:navy; border: none;"></iframe>
</div>

</body>
</html>