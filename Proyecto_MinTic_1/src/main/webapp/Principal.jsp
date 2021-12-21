<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
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
<meta charset="ISO-8859-1">

<title>Tienda Mascotas | Principal</title>
<script src="https://code.jquery.com/jquery-3.6.0.js"
	integrity="sha256-H+K7U5CnXl1h5ywQfKtSj8PCmoN9aaq30gDh27Xc0jk="
	crossorigin="anonymous"></script>
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
	crossorigin="anonymous"></script>
<style type="text/css">
.bg-custom-1 {
	background-color: #85144b;
}

.bg-custom-2 {
	background-image: linear-gradient(15deg, #13547a 0%, #80d0c7 100%);
}
</style>
</head>
<body style="overflow-x: hidden;">
	<nav class="navbar navbar-expand-lg navbar-dark bg-dark"
		style="padding-left: 20px; padding-right: 20px;">

		<a style="color: #45cfef;" class="navbar-brand" href="./Principal.jsp">
			<img src="img/logo.png" width="40" height="40"
			class="d-inline-block align-top" alt=""> Tienda Mascotas
		</a>
		<button class="navbar-toggler" type="button" data-bs-toggle="collapse"
			data-bs-target="#navbar-list" aria-expanded="false"
			aria-controls="navbar-list" aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>
		<div class="collapse navbar-collapse" id="navbarNav">
			<div class="navbar-nav">
				<a class="nav-item nav-link "
					href="Controlador?menu=Usuarios&accion=Listar" target="myFrame">Usuarios <span
					class="sr-only">(current)</span></a> <a class="nav-item nav-link"
					href="Controlador?menu=Clientes&accion=Listar" target="myFrame">Clientes</a> <a
					class="nav-item nav-link"
					href="Controlador?menu=Proveedores&accion=Listar" target="myFrame">Proveedores</a> <a
					class="nav-item nav-link"
					href="Controlador?menu=Productos&accion=Listar" target="myFrame">Productos</a> <a
					class="nav-item nav-link"
					href="Controlador?menu=Ventas&accion=default&UsuarioActivo=${usuario.getCedula_usuario()}" target="myFrame">Ventas</a> <a
					class="nav-item nav-link"
					href="Controlador?menu=Reportes&accion=default" target="myFrame">Reportes</a>
					
					

			</div>


		</div>
		<ul class="navbar-nav d-flex justify-content-end">
			<li class="nav-item dropdown"><a
				class="nav-link dropdown-toggle" id="navbarDropdownMenuLink"
				data-bs-toggle="collapse" href="#user-menu" role="button"
				aria-expanded="false" aria-controls="user-menu"> <img
					src="https://karateinthewoodlands.com/wp-content/uploads/2017/09/default-user-image.png"
					width="40" height="40" class="rounded-circle"> <span>
						${usuario.getNombre_usuario()}</span>
			</a>
				<div class="dropdown-menu collapse"
					style="position: absolute; right: -10px;" id="user-menu"
					aria-labelledby="navbarDropdownMenuLink">
					<a class="dropdown-item" href="#">Dashboard</a> <a
						class="dropdown-item" href="Index.jsp">Salir</a>
				</div></li>
		</ul>
	</nav>



	<div class="container ">

		<div class="row">
			<div class="col-12 ">
				<h2>Bienvenido</h2>
			</div>
			<div id="carouselExampleControls" class="carousel slide"
				data-bs-ride="carousel">
				<div class="carousel-inner">
					<div class="carousel-item active">
						<img src="img/slide1.jpg" class="d-block w-100" alt="...">
					</div>
					<div class="carousel-item">
						<img src="img/slide2.jpg" class="d-block w-100" alt="...">
					</div>
					<div class="carousel-item">
						<img src="img/slide3.png" class="d-block w-100" alt="...">
					</div>
				</div>
				<button class="carousel-control-prev" type="button"
					data-bs-target="#carouselExampleControls" data-bs-slide="prev">
					<span class="carousel-control-prev-icon" aria-hidden="true"></span>
					<span class="visually-hidden">Previous</span>
				</button>
				<button class="carousel-control-next" type="button"
					data-bs-target="#carouselExampleControls" data-bs-slide="next">
					<span class="carousel-control-next-icon" aria-hidden="true"></span>
					<span class="visually-hidden">Next</span>
				</button>
			</div>
		</div>
	</div>

	<!-- 	<footer class="bg-dark text-center text-white" -->
	<!-- 		style="position: absolute; bottom: 0px; width: 100%"> -->
	<!-- 		<!-- Grid container -->
	-->

	<!-- 		<div class="text-center p-3" -->
	<!-- 			style="background-color: rgba(0, 0, 0, 0.2);"> -->
	<!-- 			© 2021 Copyright <a class="text-white" href="#">TiendaMascotas</a> -->
	<!-- 		</div> -->

	<!-- 	</footer> -->

	<script>
		$(function() {
			$('[data-toggle="tooltip"]').tooltip()
		})
	</script>
</body>
</html>