<%--
    Document   : producto
    Created on : 23 jul 2025, 07:05:17
    Author     : informatica
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">

    <head>
        <meta charset="UTF-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1.0" />
        <title>Gestión de Productos</title>
        <link rel="stylesheet" href="Styles/producto.css" />
        <link rel="stylesheet" href="fonts.css" />
    </head>

    <body>

        <nav>
        </nav>
        <div class="fondo"></div>

        <div class="contenedor-principal">
            <div class="panel-formulario">
                <h1>Gestión de Productos</h1>
                <form action="Controlador?menu=Producto" method="POST" class="formulario">
                    <input type="text" value="${producto.getCodigoProducto}" name="txtIdProducto" placeholder="ID del producto" />
                    <input type="text" value="${producto.getNombreProducto}" name="txtNombreProducto" placeholder="Nombre del Producto" required/>
                    <input type="text" value="${producto.getDescripcionProducto}" name="txtDescripcionProducto" placeholder="Descripción del Producto" required/>
                    <input type="text" value="${producto.getPrecioProducto}" name="txtPrecioProducto" placeholder="Precio" required/>
                    <input type="text" value="${producto.getStock}" name="txtExistenciasProducto" placeholder="Existencias" required/>
                    <input type="text" value="${producto.getCategoria}" name="txtIdCategoria" placeholder="ID Categoría" required/>
                    <input type="text" value="${producto.getProveedor}" name="txtIdMarca" placeholder="ID Marca" required/>
                    <div class="botones">
                        <button type="submit" name="accion" class="agregar" value="Agregar">Agregar</button>
                        <button type="submit" name="accion" class="buscar" value="Buscar">Buscar</button>
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
                                <th>Nombre</th>
                                <th>Descripción</th>
                                <th>Precio</th>
                                <th>Existencias</th>
                                <th>ID Categoría</th>
                                <th>ID Marca</th>
                                <th>ACCIONES</th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach  var="producto" items="${productos}">

                                <tr>
                                    <td>${producto.codigoProducto}</td>
                                    <td>${producto.nombreProducto}</td>
                                    <td>${producto.descripcionProducto}</td>
                                    <td>${producto.precioProducto}</td>
                                    <td>${producto.stock}</td>
                                    <td>${producto.categoria.codigoCategoria}</td>
                                    <td>${producto.proveedor.codigoProveedor}</td>
                                    <td>
                                        <button type="submit" name="accion" class="actualizar" value="Actualizar">Actualizar</button>
                                        <button type="submit" name="accion" class="eliminar" value="Eliminar">Eliminar</button>
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