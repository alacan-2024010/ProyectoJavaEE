<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8" />
    <title>Essenza | Detalle de Ventas</title>
    <link rel="stylesheet" href="Styles/proveedor.css" />
</head>
<body>
    <nav>
    </nav>

    <div class="contenedor-principal">
        <div class="form-container">
            <h2>Gestión de Detalle de Ventas</h2>
            <form action="Controlador?menu=DetalleVenta" method="POST" class="formulario">
                <input type="text" value="${detalles.getCodigoDetalleVenta()}" name="txtCodigoDetalle" placeholder="Código de Detalle Venta"/>
                <input type="text" value="${detalles.getCantidad()}" name="txtCantidad" placeholder="Cantidad del producto" required/>
                <input type="text" value="${detalles.getPrecioUnitario()}" name="txtPrecioUnitario" placeholder="Precio Unitario" required/>
                <input type="text" value="${detalles.getVenta()}" name="txtCodigoVenta" placeholder="Código de Venta" required/>
                <input type="text" value="${detalles.getProducto()}" name="txtCodigoProducto" placeholder="Código de Producto" required/>

                <div class="botones">
                    <button type="submit" name="accion" value="Agregar">Agregar</button>
                    <button type="submit" name="accion" value="Actualizar">Actualizar</button>
                    <button type="submit" name="accion" value="Buscar">Buscar</button>
                    <button type="submit" name="accion" value="Eliminar">Eliminar</button>
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
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
</body>
</html>