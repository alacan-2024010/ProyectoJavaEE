<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">

    <head>
        <meta charset="UTF-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1.0" />
        <title>Gestión de Facturas</title>
        <link rel="stylesheet" href="Styles/cliente.css" />
        <link rel="stylesheet" href="font.css" />
    </head>

    <body>

        <nav>
        </nav>
        <div class="fondo"></div>

        <div class="contenedor-principal">
            <div class="panel-formulario">
                <h1>Gestión de Facturas</h1>

                <form action="Controlador?menu=Factura" method="POST" class="formulario">

                    <input type="text" autocomplete="off" value="${factura.getCodigoFactura()}" id="txtCodigoFactura" name="txtCodigoFactura" class="input" placeholder="ID de la Factura" />
                    <input type="text" autocomplete="off" value="${factura.getNumeroFactura()}" id="txtNumeroFactura" name="txtNumeroFactura" class="input" placeholder="Número de la factura" required/>
                    <input type="datetime-local" autocomplete="off" value="${factura.getFechaEmision()}" id="txtFechaEmision" name="txtFechaEmision" class="input" placeholder="Fecha de Emisión" required/>
                    <input type="text" autocomplete="off" value="${factura.getTotalFactura()}" id="txtTotal" name="txtTotal" class="input" placeholder="Total" required/>
                    <input type="text" autocomplete="off" value="${factura.getCodVenta()}" id="txtCodigoVenta" name="txtCodigoVenta" class="input" placeholder="Código de venta" required/>

                    <div class="botones">
                        <button type="submit" name="accion" value="Agregar" >Agregar</button>
                        <button type="submit" name="accion" value="Buscar" >Buscar</button>
                    </div>
                </form>

            </div>

            <div class="panel-tabla">
                <div class="tabla-contenedor">
                    <table class="tabla">
                        <thead>
                            <tr>
                                <th>ID</th>
                                <th>Número</th>
                                <th>Fecha</th>
                                <th>Total</th>
                                <th>ID Venta</th>
                                <th>Actualizar</th>
                                <th>Eliminar</th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach var="factura" items="${facturas}">
                                <tr>
                                    <td>${factura.codigoFactura}</td>
                                    <td>${factura.numeroFactura}</td>
                                    <td>${factura.fechaEmision}</td>
                                    <td>${factura.totalFactura}</td>
                                    <td>${factura.codVenta.codigoVenta}</td>
                                    <td> <button type="submit" name="accion" value="Actualizar" class="actualizar" >Actualizar</button></td>
                                    <td><button type="submit" name="accion" value="Eliminar" class="eliminar">Eliminar</button></td>
                                </tr>
                            </c:forEach>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
    </body>

</html>