<%--
    Document   : venta
    Created on : 22/07/2025, 17:34:01
    Author     : Titi
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Essenza & Co. | Gestión de Ventas</title>
   <link rel="stylesheet" href="Styles/cliente.css">
</head>
<body>
    <nav>
    </nav>
    <div class="fondo"></div>
    <div class="contenedor-principal">
        <div class="panel-formulario">
            <h1>Gestión de Ventas</h1>
                <form action="Controlador?menu=Venta" method="POST" class="formulario">

                    <input type="text" autocomplete="off" value="${venta.getCodigoVenta()}" id="txtCodigoVenta" name="txtCodigoVenta" class="input" placeholder="ID de la Venta" />
                    <input type="datetime-local" autocomplete="off" value="${venta.getFecha()}" id="txtFecha" name="txtFecha" class="input" placeholder="Fecha" required/>
                    <input type="text" autocomplete="off" value="${venta.getTotal()}" id="txtTotal" name="txtTotal" class="input" placeholder="Total" required/>
                    <input type="text" autocomplete="off" value="${venta.getCodCliente()}" id="txtCodigoCliente" name="txtCodigoCliente" class="input" placeholder="Codigo De Cliente" required/>
                    <input type="text" autocomplete="off" value="${venta.getCodEmpleado()}" id="txtCodigoEmpleado" name="txtCodigoEmpleado" class="input" placeholder="Código de Empleado" required/>

                <div class="botones">
                    <button type="submit" name="accion" value="Agregar" class="btn btn-warning me-2">Agregar</button>
                    <button type="submit" name="accion" value="Actualizar" class="btn btn-warning me-2">Actualizar</button>
                    <button>Buscar</button>
                    <button class="eliminar">Eliminar</button>
                </div>
                <div class="marca-interna">
                    Essenza & Co.
                </div>
            </form>
        </div>
                <div class="panel-tabla">
            <div class="tabla-contenedor">
                <table class="tabla">
                    <thead>
                        <tr>
                            <th>ID</th>
                            <th>Fecha</th>
                            <th>Total</th>
                            <th>ID Cliente</th>
                            <th>ID Empleado</th>
                            <th>Acciones</th> </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="venta" items="${ventas}">
                            <tr>
                                <td>${venta.codigoVenta}</td>
                                <td>${venta.fecha}</td>
                                <td>${venta.total}</td>
                                <td>${venta.codCliente.codigoCliente}</td>
                                <td>${venta.codEmpleado.codigoEmpleado}</td>
                                <td>
                                    <form action="Controlador?menu=Venta" method="POST" style="display:inline;">
                                        <input type="hidden" name="accion" value="Eliminar">
                                        <input type="hidden" name="id" value="${venta.codigoVenta}">
                                        <a href="Controlador?menu=Venta&accion=Eliminar&id=${venta.codigoVenta}" class="btn btn-warning">Eliminar</a>
                                    </form>
                                <a href="Controlador?menu=Venta&accion=Editar&id=${venta.codigoVenta}" class="btn btn-warning">Editar</a>
                                </td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>
    </div>
</body>
</html>