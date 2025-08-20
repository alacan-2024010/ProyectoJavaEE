<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">

<head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Gestión de Facturas</title>
    <link rel="stylesheet" href="Styles/factura.css" />
    <link rel="stylesheet" href="font.css" />
</head>

<body>
    <nav>
        
    </nav>

    <div class="contenedor-principal">
        <div class="panel-formulario">
            <h1>Gestión de Facturas</h1>

            <form action="Controlador?menu=Factura" method="POST" class="formulario">

                <input type="text" autocomplete="off" value="${factura.getCodigoFactura()}" 
                       name="txtCodigoFactura" placeholder="ID de la Factura" />

                <input type="text" autocomplete="off" value="${factura.getNumeroFactura()}" 
                       name="txtNumeroFactura" placeholder="Número de la factura" required />

                <input type="datetime-local" autocomplete="off" value="${factura.getFechaEmision()}" 
                       name="txtFechaEmision" placeholder="Fecha de Emisión" required />

                <input type="text" autocomplete="off" value="${factura.getTotalFactura()}" 
                       name="txtTotal" placeholder="Total" required />

                <input type="text" autocomplete="off" value="${factura.codVenta.codigoVenta}" 
                       name="txtCodigoVenta" placeholder="Código de venta" required />

                <div class="botones">
                    <button type="submit" name="accion" class="btn agregar" value="Agregar">Agregar</button>
                    <button type="submit" name="accion" class="btn buscar" value="Actualizar">Actualizar</button>
                </div>
            </form>
        </div>

        <div class="panel-tabla">
            <div class="tabla-contenedor">
                <div class="tabla-scroll">
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
                                    <td>
                                        <a href="Controlador?menu=Factura&accion=Editar&codigoFactura=${factura.getCodigoFactura()}"
                                           class="btn editar">Editar</a>
                                    </td>
                                    <td>
                                        <a href="Controlador?menu=Factura&accion=Eliminar&codigoFactura=${factura.getCodigoFactura()}"
                                           class="btn eliminar">Eliminar</a>
                                    </td>
                                </tr>
                            </c:forEach>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
    </div>
</body>

</html>
