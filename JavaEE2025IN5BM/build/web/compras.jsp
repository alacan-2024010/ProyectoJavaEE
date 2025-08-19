<%-- 
    Document   : compras
    Created on : 22/07/2025, 21:05:03
    Author     : HP
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <title>Essenza | Gestión de Compras</title>
    <link rel="stylesheet" href="Styles/proveedor.css">
</head>
<body>
    <nav>
        
    </nav>
    <div class="contenedor-principal">

        <div class="form-container">
            <h2>Gestión de Compras</h2>
            <form action=""method="post" class="formulario">
                <input type="text" name="txtCodigoCompra" placeholder="Codigo Compra"  />
                <input type="text" name="txtTotal" placeholder="Total" required />
                <input type="text" name="txtCodigoProveedor" placeholder="Codigo Proveedor" required />
                <input type="text" name="txtCodigoEmpleado" placeholder="Codigo Empleado" required />
                
                <div class="botones">
                    <button type="submit" name="btnAgregar">Agregar</button>
                    <button type="submit" name="btnActualizar">Actualizar</button>
                    <button type="submit" name="btnBuscar">Buscar</button>
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
                            <th>Código </th>
                            <th>Fecha Compra</th>
                            <th>Total</th>
                            <th>Proveedor</th>
                            <th>Empleado</th>
                        </tr>
                    </thead>
                    <tbody>
                        <tr>
                        </tr>
                    </tbody>
                </table>
            </div>
    </div>
</body>
</html>