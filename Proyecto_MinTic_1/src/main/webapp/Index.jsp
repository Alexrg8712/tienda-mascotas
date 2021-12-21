<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Tienda de mascotas</title>
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css"
	integrity="sha512-1ycn6IcaQQ40/MKBW2W4Rhis/DbILU74C1vSrLJxCq57o941Ym01SwNsOMqvEBFlcgUa6xLiPY/NS5R+E6ztJQ=="
	crossorigin="anonymous" referrerpolicy="no-referrer" />
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/css/bootstrap.min.css"
	integrity="sha384-F3w7mX95PdgyTmZZMECAngseQB83DfGTowi0iMjiWaeVhAn4FJkqJByhZMI3AhiU"
	crossorigin="anonymous">
<link rel="stylesheet" href="css/main.css">
<link rel="icon" href="favicon.ico" type="image/x-icon">
<!-- <script src="js/Validacion.js" type="text/javascript"></script> -->
</head>
<body class="background-login">
	<div class="fluid-container h-100">
		<div class="row h-100 justify-content-center align-items-center">
			<div class="col-12 ">
				<div class="card shadow p-3 mb-5 bg-body rounded custom-card">
					
					<div class="card-header text-center bg-light">
						<h1 style="color: #073550;">Tienda Mascotas</h1>
						<h3>Login </h3>
					
					</div>
					<div class="card-body  bg-dark text-white">
						<form method="get" action="./DemoServlet" > 
							<div class="form-group mt-3">
								<label>Usuario</label>
								<div class="input-group">
									<div class="input-group-prepend">
										<div class="input-group-text">
											<span style="border: none; padding: .375rem 0.1rem !important;" class="input-group-text"><i class="fas fa-user"></i></span>
										</div>
									</div>
									<input class="form-control" type="text" name="txt_usuario" placeholder="Usuario" required>
								</div>
								<label>Contraseña</label>
								<div class="input-group">
									<div class="input-group-prepend">
										<div class="input-group-text">
											<span style="border: none; padding: .375rem 0.1rem !important;" class="input-group-text"><i class="fas fa-key"></i></span>
										</div>
									</div>
									<input class="form-control " type="password" name="txt_password" placeholder="Contraseña" required>
								</div>
							</div>
							<div class="mt-5 text-center">
							<center><span style="color:red;">${feedback}</span> </center>
								<input  type="submit" name="accion" value="Ingresar" class="btn btn-primary" >
								 <button onclick="irLogin()" type="button" class="btn btn-danger">Cancelar</button>
							</div>
						</form>
				</div>
			</div>
			
		</div>
	</div>
	<script type="text/javascript">
		function irLogin() {
			window.location="Index.jsp";
		}
	</script>
</body>
</html>