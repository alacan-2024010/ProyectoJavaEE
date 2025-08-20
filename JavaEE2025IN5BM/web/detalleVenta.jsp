<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
    <head>
        <meta charset="UTF-8" />
        <title>Essenza | Detalle de Ventas</title>
        <link rel="stylesheet" href="Styles/DetalleVenta.css" />
    </head>
    <body>
        <nav>
        </nav>

        <div class="contenedor-principal">
            <div class="form-container">
                <h2>Gestión de Detalle de Ventas</h2>
                <form action="Controlador?menu=DetalleVenta" method="POST" class="formulario">
                    <input type="text" value="${detalles.getCodigoDetalleVenta()}" name="txtCodigoDetalleVenta" placeholder="Código de Detalle Venta"/>
                    <input type="text" value="${detalles.getCantidad()}" name="txtCantidad" placeholder="Cantidad del producto"/>
                    <input type="text" value="${detalles.getPrecioUnitario()}" name="txtPrecioUnitario" placeholder="Precio Unitario"/>
                    <input type="text" value="${detalles.getVenta().getCodigoVenta()}" name="txtCodigoVenta" placeholder="Código de Venta"/>
                    <input type="text" value="${detalles.getProducto().getCodigoProducto()}" name="txtCodigoProducto" placeholder="Código de Producto"/>


                    <div class="botones">
                        <button type="submit" name="accion" value="Agregar">Agregar</button>
                        <button type="submit" name="accion" value="Actualizar">Actualizar</button>
                        <form action="Controlador?menu=DetalleVenta" method="POST" class="formulario" style="margin-top: 20px;">
                    <input type="number" name="txtBuscarCodigo" placeholder="Buscar por código..."  />
                    <button type="submit" name="accion" value="Buscar">Buscar</button>
                </form>

                    </div>
                </form>

                <div class="marca-interna">
                    Essenza & Co.
                </div>
            </div>

            <div class="table-container">
                <table>
                    <thead>
                        <tr>
                            <th>Código de Detalle Venta</th>
                            <th>Cantidad</th>
                            <th>Precio Unitario</th>
                            <th>Código de Venta</th>
                            <th>Código de Producto</th>
                            <th>Acciones</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="detalles" items="${detalleVentas}">
                            <tr>
                                <td>${detalles.getCodigoDetalleVenta()}</td>
                                <td>${detalles.getCantidad()}</td>
                                <td>${detalles.getPrecioUnitario()}</td>
                                <td>${detalles.venta.codigoVenta}</td>
                                <td>${detalles.producto.codigoProducto}</td>
                                <td>
                                    <a href="Controlador?menu=DetalleVenta&accion=Editar&codigoDetalleVenta=${detalles.getCodigoDetalleVenta()}" class="btn editar">Editar</a>
                                    <a href="Controlador?menu=DetalleVenta&accion=Eliminar&codigoDetalleVenta=${detalles.getCodigoDetalleVenta()}" class="btn eliminar">Eliminar</a>
                                </td> 
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>
    </body>
</html>