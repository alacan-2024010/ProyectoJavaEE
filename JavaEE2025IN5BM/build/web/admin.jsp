<%-- 
    Document   : admin
    Created on : 22/07/2025, 16:43:15
    Author     : Francisco
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Essenza & Co. | Ventana de Administrador</title>
        <link rel="stylesheet" href="Styles/admin.css">

    </head>
    <body>
        <nav>
            <ul>
                <li><a href="Controlador?menu=Cliente&accion=Listar" target="contentFrame">Clientes</a></li>
                <li><a href="Controlador?menu=Proveedor&accion=Listar" target="contentFrame">Proveedores</a></li>
                <li><a href="Controlador?menu=Producto" target="contentFrame">Productos</a></li>
                <li><a href="Controlador?menu=Empleado&accion=Listar" target="contentFrame">Empleados</a></li>
                <li><a href="Controlador?menu=Venta&accion=Listar" target="contentFrame">Ventas</a></li>
                <li><a href="Controlador?menu=DetalleVenta" target="contentFrame">Detalle Ventas</a></li>
                <li><a href="Controlador?menu=Factura" target="contentFrame">Facturas</a></li>
                <li><a href="Controlador?menu=Compra&accion=Listar" target="contentFrame">Compras</a></li>
                <li><a href="Controlador?menu=DetalleCompra&accion=Listar" target="contentFrame">Detalle Compras</a></li>
                <li class="avatar">
                    <img src="img/UsuarioAdmin.png" alt="Avatar">
                    <ul class="avatar-menu">
                        <li><a href="principal.jsp">Cambiar Cuenta</a></li>
                        <li><a href="index.jsp">Cerrar sesión</a></li>
                    </ul>
                </li>
            </ul>
        </nav>


        
        <iframe name="contentFrame"   width="100%" height="700" style="border: 0;"></iframe>
   
            
            
    
</body>
</html>