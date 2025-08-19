<%--
    Document   : empleado
    Created on : 22 jul 2025, 17:08:43
    Author     : User
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8" />
    <title>Essenza | Gestión de Empleados</title>
    <link rel="stylesheet" href="Styles/proveedor.css" />
</head>
<body>
    <nav>
    </nav>
    <div class="contenedor-principal">
        <div class="form-container">
            <h2>Gestión de Empleados</h2>
            <form action="Controlador?menu=Empleado" method="POST" class="formulario">
                <input type="text" autocomplete="off" value="${empleado.getCodigoEmpleado()}" name="txtCodigoEmpleado" placeholder="Código Empleado" />
                <input type="text" autocomplete="off" value="${empleado.getNombreEmpleado()}" name="txtNombreEmpleado" placeholder="Nombre Empleado" required />
                <input type="text" autocomplete="off" value="${empleado.getApellidoEmpleado()}" name="txtApellidoEmpleado" placeholder="Apellido" required />
                <input type="text" autocomplete="off" value="${empleado.getDireccionEmpleado()}" name="txtDireccion" placeholder="Dirección" required />
                <input type="text" autocomplete="off" value="${empleado.getTelefonoEmpleado()}" name="txtTelefono" placeholder="Teléfono" required />
                <input type="text" autocomplete="off" value="${empleado.getEmailEmpleado()}" name="txtCorreoElectronico" placeholder="Correo Electrónico" required />
                <input type="text" autocomplete="off" value="${empleado.getPuestoEmpleado()}" name="txtPuesto" placeholder="Puesto" required />
                <div class="botones">
                    <button type="submit" name="accion" value="Agregar">Agregar</button>
                    <button type="submit" name="accion" value="Actualizar">Actualizar</button>
                    <button type="submit" name="accion" value="Buscar">Buscar</button>
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
                        <th>Código</th>
                        <th>Nombre</th>
                        <th>Apellido</th>
                        <th>Dirección</th>
                        <th>Teléfono</th>
                        <th>Correo Electrónico</th>
                        <th>Puesto</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="empleado" items="${empleados}">
                        <tr>
                            <td>${empleado.getCodigoEmpleado()}</td>
                            <td>${empleado.getNombreEmpleado()}</td>
                            <td>${empleado.getApellidoEmpleado()}</td>
                            <td>${empleado.getDireccionEmpleado()}</td>
                            <td>${empleado.getTelefonoEmpleado()}</td>
                            <td>${empleado.getEmailEmpleado()}</td>
                            <td>${empleado.getPuestoEmpleado()}</td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
</body>
</html>