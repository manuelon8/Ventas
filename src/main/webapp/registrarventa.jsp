<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Ventas</title>
<style>
            @media print{
                .parte01,img, .btn, .accion{
                    display: none;
                }
            }
        </style>
<link href="webjars/bootstrap/4.3.1/css/bootstrap.min.css"
	rel="stylesheet">
<script src="webjars/bootstrap/4.3.1/js/bootstrap.min.js"></script>
<script src="webjars/jquery/1.9.1/jquery.min.js"></script>
</head>
<body>
<div class="d-flex">
	<div class="col-lg-5 parte01">
		<div class="card">
		<form action="Controlador?menu=NuevaVenta" method="POST">
		<div class="card-body">
		<!--Datos del Producto -->
		<div class="form-group"><label>Datos del CLiente</label></div>
		
		<div class="form-group d-flex">
		<div class="col-sm-6 d-flex">
			<input type="text"   name="codigoCLiente" value="${c.getDni()}" class="form-control" placeholder="Codigo">
			<button type="submit" name="accion" value="BuscarCliente" class="btn btn-outline-info">Buscar</button>
		</div>
		
		<div class="col-sm-6">
			<input type="text"   name="nombresCLiente" class="form-control" value="${c.getNom()}" placeholder="Datos Cliente">
		</div>			 
		</div>
		<!--DATOS DEL PRODUCTO-->
		<div class="form-group"><label>Datos  Producto</label></div>
		<div class="form-group d-flex">
		<div class="col-sm-6 d-flex">
			<input type="text"   name="codigoProducto" value="${producto.getId()}" class="form-control" placeholder="Codigo">
			<button type="submit" name="accion" value="BuscarProducto" class="btn btn-outline-info">Buscar</button>
		</div>
			 <div class="col-sm-6">
             <input type="text" name="nomproducto" value="${producto.getNom()}" placeholder="Datos Producto" class="form-control">
             </div>  
		</div>
		
		
		<div class="form-group d-flex">
			<div class="col-sm-6 d-flex">
			<input type="text"   name="precio" value="${producto.getPre()}" class="form-control" placeholder="S/.0.00">			 
		</div>
		<div class="col-sm-3">
			<input type="number"   name="cant" value="1" class="form-control" placeholder="">
		</div>
		<div class="col-sm-3">
			<input type="text"   name="stock" value="${producto.getStock()}" class="form-control" placeholder="Stock">
		</div>
		</div>
		
		<!--BOTON AGREGAR PRODUCTO AL REGISTRO-->
        <div class="form-group">
        <div class="col-sm">
        <button type="submit" name="accion" value="Agregar" class="btn btn-outline-primary">Agregar Producto</button>
        </div>
        </div>
		</div>
		 </form>
		</div>
	
	</div>
 	<div class="col-sm-7">
 		<div class="card">
 			<div class="card-body">
 				<div class="d-flex col-sm-5 ml-auto"> 
 				<label>Numero de Serie</label>				
 				<input type="text"   name="NroSerie" value="${nserie}" class="form-control"> 				
 				</div>
 				
 				 <table class="table table-hover">
                            <thead>
                                <tr class="text-center">
                                    <th>N°</th>
                                    <th>ID</th>
                                    <th>PRODUCTO</th>
                                    <th>PRECIO</th>
                                    <th>CANTIDAD</th>
                                    <th>SUBTOTAL</th>                                    
                                    <th class="accion">ACCION</th>                                    
                                </tr>
                            </thead>
                            <tbody>
                                <c:forEach var="list" items="${lista}">
                                    <tr class="text-center">
                                        <td>${list.getItem()}</td>
                                        <td>${list.getIdproducto()}</td>
                                        <td>${list.getDescripcionP()}</td>
                                        <td>${list.getPrecio()}</td>
                                        <td>${list.getCantidad()}</td>
                                        <td>${list.getSubtotal()}</td>
                                        <td class="d-flex">
                                            <a href="#" class="btn btn-warning">Editar</a>
                                            <a href="#" class="btn btn-danger" style="margin-left: 5px">Delete</a>
                                        </td>
                                    </tr>
                                </c:forEach>

                            </tbody>
                        </table>
                        
 			</div>
 			<div class="card-footer d-flex">
 					<div class="col-sm-6">
 					<a href="Controlador?menu=NuevaVenta&accion=GenerarVenta">Generar Venta</a>
 				<input type="submit" name="accion" value="Generar Venta" class="btn btn-success">
 				<input type="submit" name="accion" value="Cancelar" class="btn btn-dan">
 					</div>
 				<div class="col-sm-4 ml-auto">
 				<input type="text" name="txtTotal" value="S/.${totalpagar}0" class="form-control text-center font-weight-bold" style="font-size: 18px;"> 				
 					</div>
 			</div>
 		</div>
 	
 			
 	</div>
</div>


</body>
</html>