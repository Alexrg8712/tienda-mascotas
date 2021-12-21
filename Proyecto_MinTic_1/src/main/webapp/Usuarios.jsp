<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="co.com.tienda.mascotas.Usuarios"%>
<%@page import="java.util.ArrayList"%>

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

<title>Tienda Mascotas | Usuarios</title>
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
		<div class="collapse navbar-collapse" id="navbar-list">
			<div class="navbar-nav">
				<a class="nav-item nav-link active "
					href="Controlador?menu=Usuarios&accion=Listar" target="myFrame">Usuarios </a>
					
			</div>


		</div>
	</nav>
	<div class="m-5">
		<div class="row">
			<div class="col-4">
				<div class="card" style="width: 90%; margin: auto;">

					<div class="card-header bg-light">Usuarios</div>

					<div class="card-body">

						<form method="get" action="Controlador">
							<div class="form-group mt-3">
								<div class="row">
									<div class="col-12">
										<input type="hidden" name="menu" value="Usuarios"> <label>C�dula</label>
										<input autocomplete="off" class="form-control" type="text"
											name="txt_cedula" placeholder="C�dula" value="${usuarioSeleccionado.getCedula_usuario()}" required> <label>Nombre
											Completo</label> <input autocomplete="off" class="form-control"
											type="text" name="txt_nombre_completo" 
											placeholder="Nombre Completo" value="${usuarioSeleccionado.getNombre_usuario()}"> <label>Correo</label>
										<input autocomplete="off" class="form-control" type="email"
											name="txt_correo" placeholder="Correo" value="${usuarioSeleccionado.getEmail_usuario()}"> <label>Usuario</label>
										<input autocomplete="off" class="form-control" type="text"
											name="txt_usuario" placeholder="Usuario" value="${usuarioSeleccionado.getUsuario()}"> <label>Contrase�a</label>
										<input name="txt_password" autocomplete="off"
											class="form-control" type="password" placeholder="Contrase�a" value="${usuarioSeleccionado.getPassword()}">
									
										<!-- <br><br>
										<div class="card-header bg-light">Consultar por C�dula</div>
									
										<input autocomplete="off" class="form-control" type="text"
											name="txt_cedula_consultar" placeholder="C�dula" >-->									
									</div>

								</div>

							</div>
							<div class="mt-5 text-center">
								
								<!--<input type="submit" class="btn btn-primary" name="accion" value="Agregar">
		        				<input type="submit" class="btn btn-success" name="accion" value="Actualizar">
		       				 	<input type="submit" class="btn btn-danger" name="accion" value="Consultar">-->
								
								<button data-toggle="tooltip" data-placement="top" title="Crear"
									type="submit" name="accion" value="Agregar"
									class="btn btn-outline-success">
									<i class="fas fa-plus"></i>
								</button>
									
								<button data-toggle="tooltip" data-placement="top" title="Buscar" 
									type="submit" class="btn btn-outline-primary" name="accion" value="Consultar">
									<i class="fas fa-search"></i>
								</button>
								
								<button data-toggle="tooltip" data-placement="top" title="Actualizar"
								 type="submit" name="accion" value="Actualizar"
									class="btn btn-outline-warning">
									<i class="fas fa-edit"></i>
									</button>
									
								<!--<button data-toggle="tooltip" data-placement="top"
									title="Limpiar" type="reset" value="Limpiar">
									class="btn btn-outline-prevent">
									<i class="fas fa-clean"></i>
									</button>-->
									
								<!--  <button data-toggle="tooltip" data-placement="top"
									title="Eliminar" type="submit" name="accion" value="Eliminar"
									class="btn btn-outline-danger">
									<i class="fas fa-trash-alt"></i>
									</button>-->
							</div>
						</form>
					</div>
				</div>
			</div>
			<div class="col-8 ">
				<div class="table-responsive">

					<table class="table table-sm table-bordered">
						<thead class="table-light">
							<tr>
								<th scope="col">Cedula</th>
								<th scope="col">Nombre</th>
								<th scope="col">Email</th>
								<th scope="col">Usuario</th>
								<th scope="col">Password</th>
								<th>Acci�n</th>
							</tr>
						</thead>
						<tbody>
							<% ArrayList<Usuarios> lista = (ArrayList<Usuarios>) request.getAttribute("lista");
							for (Usuarios usuario : lista) {
							%>
							<tr>
								<td><%=usuario.getCedula_usuario()%></td>
								<td><%=usuario.getNombre_usuario()%></td>
								<td><%=usuario.getEmail_usuario()%></td>
								<td><%=usuario.getUsuario()%></td>
								<td><%=usuario.getPassword()%></td>
								<td><a class="btn btn-sm btn-warning"
									href="Controlador?menu=Usuarios&accion=Cargar&id=<%=usuario.getCedula_usuario()%>">Editar</a>
									<a class="btn btn-sm btn-danger"
									href="Controlador?menu=Usuarios&accion=Eliminar&id=<%=usuario.getCedula_usuario()%>">Eliminar</a>
								</td>
							</tr>
							<%
							}
							%>
						</tbody>
					</table>

				</div>
			</div>
		</div>
	</div>







	<footer class="bg-dark text-center text-white"
		style="position:absolute; bottom: 0px; width: 100%">
		<!-- Grid container -->

		<div class="text-center p-3"
			style="background-color: rgba(0, 0, 0, 0.2);">
			� 2021 Copyright <a class="text-white" href="#">TiendaMascotas</a>
		</div>
	</footer>
	<script>
		$(function() {
			$('[data-toggle="tooltip"]').tooltip()
		})
	</script>
</body>
</html>