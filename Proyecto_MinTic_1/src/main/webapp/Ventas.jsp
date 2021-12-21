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
					href="Controlador?menu=Ventas&accion=default&UsuarioActivo=${usuario.getCedula_usuario()}" target="myFrame">Ventas</a>
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
						<input type="hidden" name="menu" value="Ventas">
						<input type="hidden" name="UsuarioActivo" value="${usuarioSeleccionado.getCedula_usuario()}">
						<div class="form-group d-flex">
							<div class="col-sm-6 d-flex">
								<input type="number" name="cedulacliente" class="form-control" placeholder="Cédula Cliente" value="${clienteSeleccionado.getCedula_cliente()}">
								<button data-toggle="tooltip" data-placement="top" title="BuscarClientes" type="submit" class="btn btn-outline-primary" name="accion" value="BuscarCliente">
									<i class="fas fa-search"></i>
								</button>
							</div>
						</div>
					<div class="col-sm-6">
						<input type="text" name="nombrecliente" class="form-control" placeholder="Nombre Cliente" value="${clienteSeleccionado.getNombre_cliente()}">
					</div>
					</div>
				</div>
					<div class="card"> 
						<div class="card-body"> 
							<div class="form-group"> 
								<label>Datos Productos</label> 
							</div>
								<div class="form-group d-flex"> 
									<div class="col-sm-6 d-flex"> 
										<input type="number" name="codigoproducto" class="form-control" placeholder="codigo producto" value="${productoSeleccionado.getCodigo_producto()}"> 
										<button data-toggle="tooltip" data-placement="top" title="BuscarProducto" type="submit" class="btn btn-outline-primary" name="accion" value="BuscarProducto">
									<i class="fas fa-search"></i>
								</button>
									</div> 
										<div class="col-sm-6"> 
											<input type="text" name="nombreproducto" class="form-control" placeholder="Nombre Producto" value="${productoSeleccionado.getNombre_producto()}"> 
										</div> 
								</div>
									<div class="form-group d-flex"> 
										<div class="col-sm-6 d-flex"> 
											<input type="text" name="precioproducto" class="form-control" placeholder="$ 0000.00" value="${productoSeleccionado.getPrecio_compra()}"> 
										</div> 
											<div class="col-sm-3"> 
												<input type="number" name="cantidadproducto" class="form-control" placeholder="Cantidad"> 
											</div> 
												<div class="col-sm-3"> 
													<input type="text" name="ivaproducto" class="form-control" placeholder="Valor iva" value="${productoSeleccionado.getIvacompra()}"> 
												</div> 
									</div>
									<div>	
									<button data-toggle="tooltip" data-placement="top" title="AgregarProducto"
									type="submit" name="accion" value="AgregarProducto"
									class="btn btn-outline-success">
									<i class="fas fa-plus"></i>
								</button>
					 				</div> 
					 	</div> 
					 	</div> 
					 </form> 
					 </div>
	<div class="col-md-7 seccion2">
		<div class="card">
			<div class="card-header">
				<div class="form-group row">
					<label class="col-sm 3 col-form-label">Número de Factura</label>
					<input class="form-control col-md-4" type="text" name="numerofactura" value="${numeroFactura}">
				</div>
			</div>
			<div class="card body">
				<table class="table">
					<thead class="thead-dark">
						<tr>
							<th>#</th>
							<th>Codigo</th>
							<th>Producto</th>
							<th>Precio</th>
							<th>Cantidad</th>
							<th>Iva</th>
							<th>Total</th>
						</tr>
					</thead>
					<tbody>
					<c:forEach var="lista" items="${listaventas}">
						<tr>
							<th>${lista.getCodigo_detalle_venta()}</th>
							<td>${lista.getCodigo_producto()}</td>
							<td>${lista.getDescripcion_producto()}</td>
							<td>${lista.getPrecio_producto()}</td>
							<td>${lista.getCantidad_producto()}</td>
							<td>${lista.getValoriva()}</td>
							<td>${lista.getValor_venta()}</td>
						</tr>
					</c:forEach>
					</tbody>
				</table>
			</div>
				<div class="card-footer d-flex">
					<div class="col-md-6">
						<label>SubTotal</label><br>
						<label>Iva</label><br>
						<label>Total a Pagar</label>
					</div>
					<div class="col-md-8">
						<input type="text" name="txtsubtotal" class="form-control" placeholder="$ 00.000.00" disabled="disabled" value="${totalsubtotal}">
						<input type="text" name="txttotaliva" class="form-control" placeholder="$ 00.000.00" disabled="disabled" value="${totaliva}">
						<input type="text" name="txttotalapagar" class="form-control" placeholder="$ 00.000.00" disabled="disabled" value="${totalapagar}">
					</div>
				</div>
		</div>
		<div class="card-footer d-flex">
			<div class="col-md-8">
				<a class="btn btn-success" onclick="print()" href="Controlador?menu=Ventas&accion=GenerarVenta&cedulacliente=${clienteSeleccionado.getCedula_cliente()}&UsuarioActivo=${usuarioSeleccionado.getCedula_usuario()}&numerofactura=${numeroFactura}">Generar Venta</a>
				<a class="btn btn-danger" href="VentasControlador?menu=Ventas&accion=NuevaVenta">Nueva Venta</a>
			</div>
		</div>
	</div>
		
	
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