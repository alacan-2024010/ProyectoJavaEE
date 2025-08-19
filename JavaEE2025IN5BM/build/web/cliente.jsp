<%-- 
Document   : cliente
Created on : 22/07/2025, 16:46:08
Author     : Francisco
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Ventana de Clientes</title>
        <link rel="stylesheet" href="Styles/cliente.css">
    </head>
    <body>

        <nav>
            
        </nav>

        <div class="fondo"></div>

        <div class="contenedor-principal">
            <div class="panel-formulario">
                <h1>Gestión de Clientes</h1>
                 <form action="Controlador?menu=Cliente" method="POST" class="formulario">
                    <input type="text" autocomplete="off" value="${cliente.getCodigoCliente()}" name="txtCodigoCliente" placeholder="Codigo del cliente" />
                    <input type="text" autocomplete="off" value="${cliente.getNombreCliente()}" name="txtNombreCliente" placeholder="Nombre del Cliente" required/>
                    <input type="text" autocomplete="off" value="${cliente.getApellidoCliente()}" name="txtApellidoCliente" placeholder="Apellido del Cliente"required />
                    <input type="text" autocomplete="off" value="${cliente.getEmailCliente()}"name="txtCorreoCliente" placeholder="Correo del Cliente"required />
                    <input type="text" autocomplete="off" value="${cliente.getContrasenia()}"name="txtContraseniaCliente" placeholder="Contraseña" required/>
                    <div class="botones">
                        <button type="submit" name="accion" value="Agregar">Agregar</button>
                        <button type="submit" name="accion" value="Actualizar">Actualizar</button>
                        <button type="submit" name="accion" value="Buscar">Buscar</button>
                        <button type="submit" name="accion" value="Eliminar" class="eliminar">Eliminar</button>
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
                                <th>Codigo del Cliente</th>
                                <th>Nombre</th>
                                <th>Apellido</th>
                                <th>Correo</th>
                                <th>Contraseña</th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach var="cliente" items="${clientes}">
                                <tr>
                                        <td>${cliente.getCodigoCliente()}</td>
                                        <td>${cliente.getNombreCliente()}</td>
                                        <td>${cliente.getApellidoCliente()}</td>
                                        <td>${cliente.getEmailCliente()}</td>
                                        <td>${cliente.getContrasenia()}</td>
                                 </tr>
                            </c:forEach>
                        </tbody>
                    </table>
                </div> 
            </div> 
        </div>  
    </body>
</html>