<%-- 
    Document   : detalleCompras
    Created on : 22/07/2025, 17:57:26
    Author     : danny
--%>

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

        <!-- Panel Formulario -->
        <div class="panel-formulario">
            <h1>Gestión de Detalle de Compras</h1>
            <form action="" method="post" class="formulario">
                <input type="text" name="txtCodigoDetalleCompra" placeholder="Cantidad" >
                <input type="text" name="txtCantidad" placeholder="Cantidad" required>
                <input type="text" name="txtPrecio" placeholder="Precio Unitario" required>
                <input type="text" name="txtCodigoCompra" placeholder="Codigo Compra" required>
                <input type="text" name="txtCodigoProducto" placeholder="Codigo Producto" required>

                <div class="botones">
                    <button type="submit" name="btnAgregar">Agregar</button>
                    <button type="submit" name="btnActualizar">Actualizar</button>
                    <button type="submit" name="btnBuscar">Buscar</button>
                    <button type="submit" name="btnEliminar" class="eliminar">Eliminar</button>
                </div>

                <div class="marca-interna">
                    Essenza & Co.
                </div>
            </form>
        </div>

        <!-- Panel Tabla -->
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
                        <tr>
                  
                        </tr>
                    </tbody>
                </table>
            </div>
        </div>

    </div>

</body>
</html>
