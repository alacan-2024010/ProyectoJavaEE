<%--
    Document   : producto
    Created on : 23 jul 2025, 07:05:17
    Author     : informatica
--%>

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
            <form action="" method="post" class="formulario">
                <input type="text" name="txtIdProducto" placeholder="ID del producto" />
                <input type="text" name="txtNombreProducto" placeholder="Nombre del Producto" />
                <input type="text" name="txtDescripcionProducto" placeholder="Descripción del Producto" />
                <input type="text" name="txtPrecioProducto" placeholder="Precio" />
                <input type="text" name="txtExistenciasProducto" placeholder="Existencias" />
                <input type="text" name="txtIdCategoria" placeholder="ID Categoría" />
                <input type="text" name="txtIdMarca" placeholder="ID Marca" />
                <div class="botones">
                    <button type="button" class="agregar">Agregar</button>
                    <button type="button" class="actualizar">Actualizar</button>
                    <button type="button" class="buscar">Buscar</button>
                    <button type="button" class="eliminar">Eliminar</button>
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
                        </tr>
                    </thead>
                    <tbody>
                    </tbody>
                </table>
            </div>
        </div>
    </div>

    <!-- Modal de confirmación de eliminación -->
    <div id="confirmacionContenedor" class="modal">
        <div class="contenedorElimnar">
            <div class="notificacionEliminar">
                <div class="fondo">
                    <div class="fondoTxt">
                        <div class="txt">
                            <svg class="fondo-svg" xmlns="http://www.w3.org/2000/svg" viewBox="0 0 20 20" fill="currentColor" aria-hidden="true">
                                <path fill-rule="evenodd" d="M10 18a8 8 0 100-16 8 8 0 000 16zm3.707-9.293a1 1 0 00-1.414-1.414L9 10.586 7.707 9.293a1 1 0 00-1.414 1.414l2 2a1 1 0 001.414 0l4-4z" clip-rule="evenodd"></path>
                            </svg>
                        </div>
                        <div class="fondoWarning">
                            <p class="encabezadoWarning">¿Estas seguro de que quieres eliminar el registro?</p>
                            <div class="descripcionWarning">
                                <p>Este registro se eliminará permanentemente de la base de datos.</p>
                            </div>
                            <div class="fondoBtnWarning">
                                <button class="btnConfirmarDelete" id="confirmarEliminacion">Si, Eliminar</button>
                                <button class="noDelete" id="cancelarEliminacion">Cancelar</button>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>

    <script>
        document.addEventListener('DOMContentLoaded', () => {
            const botonEliminar = document.querySelector('.eliminar');
            const modal = document.querySelector('.modal');
            const confirmarEliminacion = document.querySelector('.btnConfirmarDelete');
            const cancelarEliminacion = document.querySelector('.noDelete');

            if (modal) {
                modal.style.display = 'none';
            }

            if (botonEliminar) {
                botonEliminar.addEventListener('click', () => {
                    if (modal) {
                        modal.style.display = 'flex';
                    }
                });
            }

            if (confirmarEliminacion) {
                confirmarEliminacion.addEventListener('click', () => {
                    alert('¡El registro ha sido eliminado!');
                    if (modal) {
                        modal.style.display = 'none';
                    }
                });
            }

            if (cancelarEliminacion) {
                cancelarEliminacion.addEventListener('click', () => {
                    if (modal) {
                        modal.style.display = 'none';
                    }
                });
            }

            if (modal) {
                modal.addEventListener('click', (event) => {
                    if (event.target === modal) {
                        modal.style.display = 'none';
                    }
                });
            }
        });
    </script>

</body>
</html>
