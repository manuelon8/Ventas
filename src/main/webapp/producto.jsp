<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link href="webjars/bootstrap/4.3.1/css/bootstrap.min.css"
	rel="stylesheet">
<script src="webjars/bootstrap/4.3.1/js/bootstrap.min.js"></script>
<script src="webjars/jquery/1.9.1/jquery.min.js"></script>
</head>
<body>
<div class="d-flex">
	<div class="col-sm-4">
		<div class="card">
			<div  class="card-body">
					<form action="Controlador?menu=Producto" method="post">
						<div class="form-group">
							<label>Id</label>
							<input type="text" name="txtId"	class="form-control">
						</div>
						<div class="form-group">
							<label>Descripcion</label>
							<input type="text" name="txtDescripcion"	class="form-control">
						</div>
						<div class="form-group">
							<label>Precio</label>
							<input type="text" name="txtPrecio"			class="form-control">
						</div>
						<div class="form-group">
							<label>Stock</label>
							<input type="text" name="txtStock"			class="form-control">
						</div>
						<div class="form-group">
							<label>Estado</label>
							<input type="text" name="txtEstado"			class="form-control">
						</div>
						 <input type="submit" name="accion" value="Agregar" class="btn btn-primary">
                         <input type="submit" name="accion" value="Actualizar" class="btn btn-success">


					</form>
				</div>		
		</div>	
	</div>
</div> 

</body>
</html>