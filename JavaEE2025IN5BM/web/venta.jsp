<%--
    Document   : venta
    Created on : 22/07/2025, 17:34:01
    Author     : Titi
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Essenza & Co. | Gestión de Ventas</title>
   <link rel="stylesheet" href="Styles/cliente.css">
</head>
<body>
    <nav>
    </nav>
    <div class="fondo"></div>
    <div class="contenedor-principal">
        <div class="panel-formulario">
            <h1>Gestión de Ventas</h1>
            <form action="" method="post" class="formulario">
                <input type="text" name="txtIdVenta" placeholder="ID de venta" required />
                <input type="datetime-local" name="txtFecha" placeholder="Fecha" required />
                <input type="text" name="txtTotal" placeholder="Total" required />
                <input type="number" name="txtIdCliente" placeholder="ID Cliente" required />
                <input type="number" name="txtIdEmpleado" placeholder="ID Empleado" required />
                <div class="botones">
                    <button>Agregar</button>
                    <button>Actualizar</button>
                    <button>Buscar</button>
                    <button class="eliminar">Eliminar</button>
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
                            <th>Fecha</th>
                            <th>Total</th>
                            <th>ID Cliente</th>
                            <th>ID Empleado</th>
                        </tr>
                    </thead>
                    <tbody>
                    </tbody>
                </table>
            </div>
        </div>
    </div>
</body>
</html>