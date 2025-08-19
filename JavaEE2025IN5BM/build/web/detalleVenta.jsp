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
            <form class="formulario" action="Controlador?menu=DetalleVenta" method="POST">
                <input type="text" autocomplete="off" name="txtCodigoDetalle" placeholder="Código de Detalle Venta" />
                <input type="text" autocomplete="off" name="txtCantidad" placeholder="Cantidad del producto" />
                <input type="text" autocomplete="off" name="txtPrecioUnitario" placeholder="Precio Unitario" />
                <input type="text" autocomplete="off" name="txtCodigoVenta" placeholder="Código de Venta" />
                <input type="text" autocomplete="off" name="txtCodigoProducto" placeholder="Código de Producto" />

                <div class="botones">
                    <button type="submit" name="accion" value="Agregar" class="btn-accion">Agregar</button>
                    <button type="submit" name="accion" value="Actualizar" class="btn-accion">Actualizar</button>
                    <button type="submit" name="accion" value="Buscar" class="btn-accion">Buscar</button>
                    <button type="submit" name="accion" value="Eliminar" class="eliminar-nuevo">Eliminar</button>
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
                    <c:forEach var="detalle" items="${detalles}">
                        <tr>
                            <td>${detalle.codigoDetalleVenta}</td>
                            <td>${detalle.cantidad}</td>
                            <td>${detalle.precioUnitario}</td>
                            <td>${detalle.codigoVenta}</td>
                            <td>${detalle.codigoProducto}</td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
</body>
</html>