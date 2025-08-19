<%-- 
Document   : cliente
Created on : 22/07/2025, 16:46:08
Author     : Francisco
--%>

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
                <form action=""method="post" class="formulario">
                    <input type="text" name="txtCodigoCliente" placeholder="Codigo del cliente" />
                    <input type="text" name="txtNombreCliente" placeholder="Nombre del Cliente" />
                    <input type="text" name="txtApellidoCliente" placeholder="Apellido del Cliente" />
                    <input type="text" name="txtCorreoCliente" placeholder="Correo del Cliente" />
                    <input type="text" name="txtContraseniaCliente" placeholder="Contraseña" />
                    <input type="text" name="txtImagen" placeholder="(Solo poner '' o null)" />
                    <div class="botones">
                        <button>Agregar</button>
                        <button>Actualizar</button>
                        <button >Buscar</button>
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
                                <th>Codigo del Cliente</th>
                                <th>Nombre</th>
                                <th>Apellido</th>
                                <th>Correo</th>
                                <th>Contraseña</th>
                            </tr>
                        </thead>
                    </table>
                </div> 
            </div> 
        </div>  
    </body>
</html>