<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="co.com.tienda.mascotas.Ventas"%>
<!--<@page import="java.util.ArrayList"%>-->

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

<title>Tienda Mascotas | Ventas</title>
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
				<a
					class="nav-item nav-link active"
					href="Controlador?menu=Reportes&accion=default" target="myFrame">Reportes</a> 

			</div>
		</div>
	</nav>
	<div class="row">
		<div class="col-md-5 Seccion1">
			<form method="get" action="Controlador">
				<div class="card">
					<div class="card-body">
						<div class="form-group">
							<label>Datos Clientes</label>
          </div>
          <input type="hidden" name="menu" value="Reportes">
          <div class="form-group d-flex">
           <div class="col-sm-6 d-flex">
             <input type="submit" name="accion" value="ReporteUsuarios" class="btn btn-primary">
             <input type="submit" name="accion" value="ReporteClientes" class="btn btn-success">
             <input type="submit" name="accion" value="ReporteVentas" class="btn btn-danger">
             </div>
             </div>
             </div>
             </div>
             </form>
             </div>
               <div class="col-md7 seccion2">
                 <div class="card">
                  <div class="card-body">
                  <div class="form-group">
                  <label>Detalle de reporte</label>
                  </div>
                  
                  <table class="table">
                  <c:if test="${opcion==1}">
                  <thead class="thead-dark">
                  <tr>
                     <th scope="col">Cedula</th>
					 <th scope="col">Nombre</th>
					 <th scope="col">Email</th>
					 <th scope="col">Usuario</th>
                   </tr>
                   </thead>
                   <tbody>
                     <c:forEach var="lista" items="${listaUsuarios}">
                      <tr>
                     <td>${lista.getCedula_usuario()}</td>
					 <td>${lista.getNombre_usuario()}</td>
					 <td>${lista.getEmail_usuario()}</td>
					 <td>${lista.getUsuario()}</td>
                   </tr>
                   </c:forEach>
                   </tbody>
                   </c:if>
                   <c:if test="${opcion==2}">
                     <thead class="thead-dark">
                  <tr>
                     <th scope="col">Cedula</th>
					 <th scope="col">Direccion</th>
					 <th scope="col">Email</th>
					 <th scope="col">Nombre</th>
					 <th scope="col">Telefono</th>
                   </tr>
                   </thead>
                   <tbody>
                     <c:forEach var="lista" items="${listaClientes}">
                      <tr>
                     <td>${lista.getCedula_cliente()}></td>
					 <td>${lista.getDireccion_cliente()}</td>
					 <td>${lista.getEmail_cliente()}</td>
					 <td>${lista.getNombre_cliente()}</td>
					 <td>${lista.getTelefono_cliente()}</td>
                   </tr>
                   </c:forEach>
                   </tbody>
                   </c:if>
                   <c:if test="${opcion==3}">
                   <thead class="thead-dark">
                  <tr>
                     <th scope="col">CodigoVentas</th>
					 <th scope="col">CedulaCliente</th>
					 <th scope="col">CedulaUsuario</th>
					 <th scope="col">IvaVenta</th>
					 <th scope="col">TotalVenta</th>
					 <th scope="col">ValorVenta</th>
                   </tr>
                   </thead>
                   <tbody>
                     <c:forEach var="lista" items="${listaVentas}">
						<tr>
							<th>${lista.getCodigo_venta()}</th>
							<td>${lista.getCedula_cliente()}</td>
							<td>${lista.getCedula_usuario()}</td>
							<td>${lista.getIvaventa()}</td>
							<td>${lista.getTotal_venta()}</td>
							<td>${lista.getValor_venta()}</td>
						</tr>
					</c:forEach>
                   </tbody>
                   </c:if>
                   </table>
                   </div>
                   </div>
                   </div>
                   </div>
                   
	<div class="m-5">
	<h1>Módulo Reportes</h1>
	</div>


	<footer class="bg-dark text-center text-white"
		style="position: absolute; bottom: 0px; width: 100%">
		<!-- Grid container -->

		<div class="text-center p-3"
			style="background-color: rgba(0, 0, 0, 0.2);">
			© 2021 Copyright <a class="text-white" href="#">TiendaMascotas</a>
		</div>

	</footer>

	<script>
		$(function() {
			$('[data-toggle="tooltip"]').tooltip()
		})
	</script>
</body>
</html>