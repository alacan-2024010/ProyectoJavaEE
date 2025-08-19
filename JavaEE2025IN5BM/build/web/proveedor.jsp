<%-- 
    Document   : proveedores
    Created on : 22/07/2025, 17:10:03
    Author     : User
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8" />
    <title>Essenza | Gestión de Proveedores</title>
    <link rel="stylesheet" href="Styles/proveedor.css" />
</head>
<body>

    <nav>
        
    </nav>

    <div class="contenedor-principal">

        <div class="form-container">
            <h2>Gestión de Proveedores</h2>
            <form action="Controlador?menu=Proveedor"method="POST" class="formulario">
                <input type="text" value="${proveedor.getCodigoProveedor()}" name="txtCodigoProveedor" placeholder="Código del Proveedor" />
                <input type="text" value="${proveedor.getNombreProveedor()}" name="txtNombreProveedor" placeholder="Nombre" required />
                <input type="text" value="${proveedor.getDireccionProveedor()}" name="txtDireccion" placeholder="Dirección" required />
                <input type="text" value="${proveedor.getTelefonoProveedor()}" name="txtCelular" placeholder="Celular" required />
                <input type="email" value="${proveedor.getCorreoProveedor()}" name="txtCorreo" placeholder="Correo" required />

                <div class="botones">
                    <button type="submit" name="accion" value="Agregar">Agregar</button>
                    <button type="submit" name="accion" value="Actualizar">Actualizar</button>
                    <button type="submit" name="accion" value="Buscar">Buscar</button>
                     <button type="submit"name="accion" value="Eliminar" class="eliminar-nuevo">Eliminar</button>
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
                        <th>Código</th>
                        <th>Nombre</th>
                        <th>Dirección</th>
                        <th>Celular</th>
                        <th>Correo</th>
                    </tr>
                </thead>
                <tbody>
                        <c:forEach var="proveedor" items="${proveedores}">
                        <tr>
                            <td>${proveedor.getCodigoProveedor()}</td>
                            <td>${proveedor.getNombreProveedor()}</td>
                            <td>${proveedor.getDireccionProveedor()}</td>
                            <td>${proveedor.getTelefonoProveedor()}</td>
                            <td>${proveedor.getCorreoProveedor()}</td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </div>

    </div>

</body>
</html>

