<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<link href="webjars/bootstrap/4.3.1/css/bootstrap.min.css"
	rel="stylesheet">
<script src="webjars/bootstrap/4.3.1/js/bootstrap.min.js"></script>
<script src="webjars/jquery/1.9.1/jquery.min.js"></script>

<title>Login</title>

</head>
<body>


	<div class="container mt-4 col-lg-4">

		<div class="card col-sm-10">

			<div class="card-body">
				<form class="form-sign" action="Validar" method="post">
					<div class="form-group text-center">
						<h3>Login</h3>
						<label>Bienvenidos al Sistema</label>
					</div>
					<div class="form-group">
						<label>Usuario:</label> <input type="text" name="txtuser"
							class="form-control">
					</div>
					<div class="form-group">
						<label>Password:</label> <input type="password" name="txtpass"
							class="form-control">
					</div>
					<input type="submit" name="accion" value="Ingresar"
						class="btn btn-primary btn-block">
				</form>
			</div>
		</div>
	</div>


</body>
</html>