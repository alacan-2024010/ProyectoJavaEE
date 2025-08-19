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

                <form action="" method="post" class="formulario">

                    <input type="text" autocomplete="off" id="txtCodigoFactura" name="txtCodigoFactura" class="input" placeholder="ID de la Factura" />
                    <input type="text" autocomplete="off" id="txtNumeroFactura" name="txtNumeroFactura" class="input" placeholder="Número de la factura" />
                    <input type="text" autocomplete="off" id="txtFechaEmision" name="txtFechaEmision" class="input" placeholder="Fecha de Emisión" />
                    <input type="text" autocomplete="off" id="txtTotal" name="txtTotal" class="input" placeholder="Total" />
                    <input type="text" autocomplete="off" id="txtCodigoVenta" name="txtCodigoVenta" class="input" placeholder="Código de venta" />

                    <div class="botones">
                        <button>Agregar</button>
                        <button>Actualizar</button>
                        <button>Buscar</button>
                        <button class="eliminar">Eliminar</button>
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
