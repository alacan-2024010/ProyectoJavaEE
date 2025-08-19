<%-- 
    Document   : detalleCompras
    Created on : 22/07/2025, 17:57:26
    Author     : danny
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Essenza | Detalle de Compras</title>
    <link rel="stylesheet" href="Styles/cliente.css">
</head>
<body>

    <nav>
        
    </nav>

    <div class="fondo"></div>

    <div class="contenedor-principal">

  
       
        <div class="panel-formulario">
            <h1>Gestión de Detalle de Compras</h1>
            <form action="Controlador?menu=DetalleCompra" method="post" class="formulario">

                <input type="text" autocomplete="off" value="${detalleCompra.getCodigoDetalleCompra()}" name="txtCodigoDetalleCompra" placeholder="Código Detalle Compra" />
                <input type="text" autocomplete="off" value="${detalleCompra.getCantidad()}" name="txtCantidad" placeholder="Cantidad" required />
                <input type="text" autocomplete="off" value="${detalleCompra.getPrecioUnitario()}" name="txtPrecio" placeholder="Precio Unitario" required />
                <input type="text" autocomplete="off" value="${detalleCompra.getCodigoCompra()}" name="txtCodigoCompra" placeholder="Código Compra" required />
                <input type="text" autocomplete="off" value="${detalleCompra.getCodigoProducto()}" name="txtCodigoProducto" placeholder="Código Producto" required />
                <div class="botones">
                    <button type="submit" name="accion" value="agregar">Agregar</button>
                    <button type="submit" name="accion" value="actualizar"> Actualizar</button>
                    <button type="submit" name="accion" value="buscar">Buscar</button>
                    <button type="submit" name="accion" value="eliminar">Eliminar</button>
                </div>
                 </form>
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
                            <th>Codigo</th>
                            <th>Cantidad</th>
                            <th>Precio Unitario</th>
                            <th>Codigo Compra</th>
                            <th>Codigo Producto</th>
                        </tr>
                    </thead>
                    <tbody>
                    <c:forEach var="detalleCompra" items="${detalleCompras}">
                        <tr>
                            <td>${detalleCompra.codigoDetalleCompra}</td>
                            <td>${detalleCompra.cantidad}</td>
                            <td>${detalleCompra.precioUnitario}</td>
                            <td>${detalleCompra.codigoCompra}</td>
                            <td>${detalleCompra.codigoProducto}</td>
                        </tr>
                    </c:forEach>
                </tbody>

                </table>
            </div>
        </div>

    </div>

</body>
</html>
