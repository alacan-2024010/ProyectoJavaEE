/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controlador;

import Modelo.Categoria;
import Modelo.Cliente;
import Modelo.ClienteDAO;
import Modelo.detalleCompraDAO;
import Modelo.detalleCompra;
import Modelo.DetalleVenta;
import Modelo.DetalleVentaDAO;
import Modelo.EmpleadoDAO;
import Modelo.Proveedor;
import Modelo.ProveedorDAO;
import Modelo.Empleado;
import Modelo.Factura;
import Modelo.FacturaDAO;
import Modelo.Producto;
import Modelo.ProductoDAO;
import Modelo.Venta;
import Modelo.VentaDAO;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

/**
 *
 * @author informatica
 */
public class Controlador extends HttpServlet {

    Cliente cliente = new Cliente();
    ClienteDAO clienteDAO = new ClienteDAO();
    Empleado empleado = new Empleado();
    EmpleadoDAO empleadoDao = new EmpleadoDAO();
    int codEmpleado;
    Proveedor proveedor = new Proveedor();
    ProveedorDAO proveedorDAO = new ProveedorDAO();
    Producto producto = new Producto();
    ProductoDAO productoDao = new ProductoDAO();
    Categoria categoria = new Categoria();
    Factura factura = new Factura();
    FacturaDAO facturaDAO = new FacturaDAO();
    Venta venta = new Venta();
    VentaDAO ventaDAO = new VentaDAO();
    DetalleVenta detalleVenta = new DetalleVenta();
    DetalleVentaDAO detalleVentaDAO = new DetalleVentaDAO();
    detalleCompra detalleCompra = new detalleCompra();
    detalleCompraDAO detalleCompraDAO = new detalleCompraDAO();

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String menu = request.getParameter("menu");
        String accion = request.getParameter("accion");

        if (menu.equals("Principal")) {
            request.getRequestDispatcher("admin.jsp").forward(request, response);
        }

        if (menu != null) {
            switch (menu) {
                case "Cliente":
                    switch (accion) {
                        case "Listar":
                            List listaClientes = clienteDAO.listar();
                            request.setAttribute("clientes", listaClientes);
                            break;
                        case "Agregar":
                            String nombre = request.getParameter("txtNombreCliente");
                            String apellido = request.getParameter("txtApellidoCliente");
                            String correo = request.getParameter("txtCorreoCliente");
                            String contra = request.getParameter("txtContraseniaCliente");
                            cliente.setNombreCliente(nombre);
                            cliente.setApellidoCliente(apellido);
                            cliente.setEmailCliente(correo);
                            cliente.setContrasenia(contra);
                            clienteDAO.agregar(cliente);
                            request.getRequestDispatcher("Controlador?menu=Cliente&accion=Listar").forward(request, response);
                            break;
                        case "Editar":
                            int codigo = Integer.parseInt(request.getParameter("codigoCliente"));
                            Cliente c = clienteDAO.listarCodigoPorCliente(codigo);
                            request.setAttribute("cliente", c);
                            request.getRequestDispatcher("Controlador?menu=Cliente&accion=Listar").forward(request, response);
                            break;
                        case "Actualizar":
                            int codigoC = Integer.parseInt(request.getParameter("txtCodigoCliente"));
                            String nombreC = request.getParameter("txtNombreCliente");
                            String apellidoC = request.getParameter("txtApellidoCliente");
                            String correoC = request.getParameter("txtCorreoCliente");
                            String contraC = request.getParameter("txtContraseniaCliente");
                            cliente.setCodigoCliente(codigoC);
                            cliente.setNombreCliente(nombreC);
                            cliente.setApellidoCliente(apellidoC);
                            cliente.setEmailCliente(correoC);
                            cliente.setContrasenia(contraC);
                            clienteDAO.actualizar(cliente);
                            request.getRequestDispatcher("Controlador?menu=Cliente&accion=Listar").forward(request, response);
                            break;
                        case "Eliminar":
                            codigoC = Integer.parseInt(request.getParameter("codigoCliente"));
                            clienteDAO.eliminar(codigoC);
                            request.getRequestDispatcher("Controlador?menu=Cliente&accion=Listar").forward(request, response);
                            break;
                        case "Buscar":
                            break;
                        default:
                            throw new AssertionError();
                    }
                    request.getRequestDispatcher("cliente.jsp").forward(request, response);
                    break;
                case "Proveedor":
                    switch (accion) {
                        case "Listar":
                            List listaProveedores = proveedorDAO.listar();
                            request.setAttribute("proveedores", listaProveedores);
                            break;
                        case "Agregar":
                            String nombreProveedor = request.getParameter("txtNombreProveedor");
                            String direccionProveedor = request.getParameter("txtDireccionProveedor");
                            String telefonoProveedor = request.getParameter("txtTelefonoProveedor");
                            String correoProveedor = request.getParameter("txtCorreoProveedor");

                            proveedor.setNombreProveedor(nombreProveedor);
                            proveedor.setDireccionProveedor(direccionProveedor);
                            proveedor.setTelefonoProveedor(telefonoProveedor);
                            proveedor.setCorreoProveedor(correoProveedor);

                            proveedorDAO.agregar(proveedor);
                            request.getRequestDispatcher("Controlador?menu?Proveedor&accion=Listar").forward(request, response);
                            break;

                        case "Editar":
                            int codProveedor = Integer.parseInt(request.getParameter("codigoProveedor"));
                            Proveedor p = proveedorDAO.listarCodigoProveedor(codProveedor);
                            request.setAttribute("proveedor", p);

                            List listaProveedoresEditar = proveedorDAO.listar();
                            request.setAttribute("proveedores", listaProveedoresEditar);

                            request.getRequestDispatcher("proveedor.jsp").forward(request, response);
                            break;

                        case "Actualizar":
                            int codProveedorActualizar = Integer.parseInt(request.getParameter("txtCodigoProveedor"));
                            nombreProveedor = request.getParameter("txtNombreProveedor");
                            direccionProveedor = request.getParameter("txtDireccionProveedor");
                            telefonoProveedor = request.getParameter("txtTelefonoProveedor");
                            correoProveedor = request.getParameter("txtCorreoProveedor");

                            proveedor.setCodigoProveedor(codProveedorActualizar);
                            proveedor.setNombreProveedor(nombreProveedor);
                            proveedor.setDireccionProveedor(direccionProveedor);
                            proveedor.setTelefonoProveedor(telefonoProveedor);
                            proveedor.setCorreoProveedor(correoProveedor);

                            proveedorDAO.actualizar(proveedor);
                            request.getRequestDispatcher("Controlador?menu=Proveedor&accion=Listar").forward(request, response);
                            break;

                        case "Eliminar":
                            codProveedor = Integer.parseInt(request.getParameter("codigoProveedor"));

                            proveedorDAO.eliminar(codProveedor);

                            request.getRequestDispatcher("Controlador?menu=Proveedor&accion=Listar").forward(request, response);
                            break;
                        default:
                            throw new AssertionError();
                    }

                    request.getRequestDispatcher("proveedor.jsp").forward(request, response);
                    break;
                case "Producto":
                    switch (accion) {
                        case "Listar":
                            List listaProducto = productoDao.listar();
                            request.setAttribute("productos", listaProducto);
                            break;
                        case "Agregar":
                            String nombreProducto = request.getParameter("txtNombreProducto");
                            String descripcionProducto = request.getParameter("txtDescripcionProducto");
                            String precioProducto = request.getParameter("txtPrecioProducto");
                            String stock = request.getParameter("txtExistenciasProducto");
                            String idCategoria = request.getParameter("txtIdCategoria");
                            String idMarca = request.getParameter("txtIdMarca");

                            producto.setNombreProducto(nombreProducto);
                            producto.setDescripcionProducto(descripcionProducto);
                            producto.setPrecioProducto(BigDecimal.valueOf(Double.parseDouble(precioProducto)));
                            producto.setStock(Integer.parseInt(stock));

                            categoria.setCodigoCategoria(Integer.parseInt(idCategoria));
                            producto.setCategoria(categoria);

                            proveedor.setCodigoProveedor(Integer.parseInt(idMarca));
                            producto.setProveedor(proveedor);

                            productoDao.agregar(producto);
                            request.getRequestDispatcher("Controlador?menu=Producto&accion=Listar").forward(request, response);
                            break;
                        case "Editar":
                            int codP = Integer.parseInt(request.getParameter("codigoProducto"));
                            Producto prod = productoDao.listarPorProducto(codP);
                            request.setAttribute("producto", prod);
                            request.getRequestDispatcher("Controlador?menu=Producto&accion=Listar").forward(request, response);
                            break;
                        case "Actualizar":
                            String codigo = request.getParameter("txtIdProducto");
                            String nombreP = request.getParameter("txtNombreProducto");
                            String descripcionP = request.getParameter("txtDescripcionProducto");
                            String precioP = request.getParameter("txtPrecioProducto");
                            String stockP = request.getParameter("txtExistenciasProducto");
                            String codCat = request.getParameter("txtIdCategoria");
                            String codMarca = request.getParameter("txtIdMarca");

                            producto.setCodigoProducto(Integer.parseInt(codigo));
                            producto.setNombreProducto(nombreP);
                            producto.setDescripcionProducto(descripcionP);
                            producto.setPrecioProducto(BigDecimal.valueOf(Double.parseDouble(precioP)));
                            producto.setStock(Integer.parseInt(stockP));

                            categoria.setCodigoCategoria(Integer.parseInt(codCat));
                            producto.setCategoria(categoria);

                            proveedor.setCodigoProveedor(Integer.parseInt(codMarca));
                            producto.setProveedor(proveedor);
                            productoDao.actualizar(producto);
                            request.getRequestDispatcher("Controlador?menu=Producto&accion=Listar").forward(request, response);
                            break;
                        case "Eliminar":
                            codP = Integer.parseInt(request.getParameter("codigoProducto"));
                            productoDao.eliminar(codP);
                            request.getRequestDispatcher("Controlador?menu=Producto&accion=Listar").forward(request, response);
                            break;
                        default:
                            throw new AssertionError();
                    }
                    request.getRequestDispatcher("producto.jsp").forward(request, response);
                    break;
                case "Empleado":
                    switch (accion) {
                        case "Listar":
                            List listaEmpleados = empleadoDao.listar();
                            request.setAttribute("empleados", listaEmpleados);
                            break;
                        case "Agregar":
                            try {
                                String nombre = request.getParameter("txtNombre");
                                String apellido = request.getParameter("txtApellido");
                                String direccion = request.getParameter("txtDireccion");
                                String telefono = request.getParameter("txtTelefono");
                                String correo = request.getParameter("txtCorreo");
                                String puesto = request.getParameter("txtPuesto");
                                Part filePart = request.getPart("txtImagen");

                                InputStream inputStream = filePart.getInputStream();
                                byte[] imagenBytes;
                                try (ByteArrayOutputStream outputStream = new ByteArrayOutputStream()) {
                                    byte[] buffer = new byte[4096];
                                    int bytesRead;
                                    while ((bytesRead = inputStream.read(buffer)) != -1) {
                                        outputStream.write(buffer, 0, bytesRead);
                                    }
                                    imagenBytes = outputStream.toByteArray();
                                }

                                empleado.setNombreEmpleado(nombre);
                                empleado.setApellidoEmpleado(apellido);
                                empleado.setDireccionEmpleado(direccion);
                                empleado.setTelefonoEmpleado(telefono);
                                empleado.setEmailEmpleado(correo);
                                empleado.setPuestoEmpleado(puesto);
                                empleado.setImagenPerfil(imagenBytes);

                                empleadoDao.agregar(empleado);
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                            request.getRequestDispatcher("Controlador?menu=Empleado&accion=Listar").forward(request, response);
                            break;
                        case "Editar":
                            codEmpleado = Integer.parseInt(request.getParameter("id"));
                            Empleado emp = empleadoDao.buscar(codEmpleado);
                            request.setAttribute("empleado", emp);
                            break;
                        case "Actualizar":
                            try {
                                String id = request.getParameter("txtId");
                                String nombre = request.getParameter("txtNombre");
                                String apellido = request.getParameter("txtApellido");
                                String direccion = request.getParameter("txtDireccion");
                                String telefono = request.getParameter("txtTelefono");
                                String correo = request.getParameter("txtCorreo");
                                String puesto = request.getParameter("txtPuesto");
                                Part filePart = request.getPart("txtImagen");

                                InputStream inputStream = filePart.getInputStream();
                                byte[] imagenBytes;
                                try (ByteArrayOutputStream outputStream = new ByteArrayOutputStream()) {
                                    byte[] buffer = new byte[4096];
                                    int bytesRead;
                                    while ((bytesRead = inputStream.read(buffer)) != -1) {
                                        outputStream.write(buffer, 0, bytesRead);
                                    }
                                    imagenBytes = outputStream.toByteArray();
                                }

                                empleado.setCodigoEmpleado(Integer.parseInt(id));
                                empleado.setNombreEmpleado(nombre);
                                empleado.setApellidoEmpleado(apellido);
                                empleado.setDireccionEmpleado(direccion);
                                empleado.setTelefonoEmpleado(telefono);
                                empleado.setEmailEmpleado(correo);
                                empleado.setPuestoEmpleado(puesto);
                                empleado.setImagenPerfil(imagenBytes);

                                empleadoDao.actualizar(empleado);
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                            request.getRequestDispatcher("Controlador?menu=Empleado&accion=Listar").forward(request, response);
                            break;
                        case "Eliminar":
                            codEmpleado = Integer.parseInt(request.getParameter("id"));
                            empleadoDao.eliminar(codEmpleado);
                            request.getRequestDispatcher("Controlador?menu=Empleado&accion=Listar").forward(request, response);
                            break;
                        default:
                            System.out.println("Opcion no valida");
                    }
                    request.getRequestDispatcher("empleado.jsp").forward(request, response);
                            break;
                case "Venta":
                    switch (accion) {
                        case "Listar":
                            List listaVenta = ventaDAO.listar();
                            request.setAttribute("ventas", listaVenta);
                            break;
                        
                        case "Agregar":
                            String fecha = request.getParameter("txtFecha");
                            String total = request.getParameter("txtTotal");
                            String codCliente = request.getParameter("txtCodigoCliente");
                            String codEmpleado = request.getParameter("txtCodigoEmpleado");

                            DateTimeFormatter formato = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm");
                            LocalDateTime fechaEmision = LocalDateTime.parse(fecha, formato);
                            Venta nuevaVenta = new Venta(); 
                            nuevaVenta.setFecha(fechaEmision);
                            nuevaVenta.setTotal(BigDecimal.valueOf(Double.parseDouble(total)));

                            Cliente nuevoCliente = new Cliente();
                            Empleado nuevoEmpleado = new Empleado();

                          
                            nuevoCliente.setCodigoCliente(Integer.parseInt(codCliente));
                            nuevoEmpleado.setCodigoEmpleado(Integer.parseInt(codEmpleado));

                            nuevaVenta.setCodCliente(nuevoCliente);
                            nuevaVenta.setCodEmpleado(nuevoEmpleado);

                            ventaDAO.agregar(nuevaVenta);

                            request.getRequestDispatcher("Controlador?menu=Venta&accion=Listar").forward(request, response);
                            break;
                        case "Editar":

                        String codigoEditar = request.getParameter("id");
                            try {
                                int idVenta = Integer.parseInt(codigoEditar);
                                Venta ventaSeleccionada = ventaDAO.buscar(idVenta);
                                request.setAttribute("venta", ventaSeleccionada);
                            } catch (NumberFormatException e) {
                                e.printStackTrace();
                            }
                        
                        request.getRequestDispatcher("Controlador?menu=Venta&accion=Listar").forward(request, response);

                            break;
                        // Controlador.java - Inside the switch(accion)
                        case "Actualizar":
                            String codVenta = request.getParameter("txtCodigoVenta");
                             fecha = request.getParameter("txtFecha");
                             total = request.getParameter("txtTotal");
                             codCliente = request.getParameter("txtCodigoCliente");
                             codEmpleado = request.getParameter("txtCodigoEmpleado");

                            try {
                                Venta v = new Venta();
                                v.setCodigoVenta(Integer.parseInt(codVenta));

                                 formato = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm");
                                v.setFecha(LocalDateTime.parse(fecha, formato));

                                v.setTotal(new BigDecimal(total));

                                Cliente cl = new Cliente();
                                cl.setCodigoCliente(Integer.parseInt(codCliente));
                                v.setCodCliente(cl);

                                Empleado em = new Empleado();
                                em.setCodigoEmpleado(Integer.parseInt(codEmpleado));
                                v.setCodEmpleado(em);

                                ventaDAO.actualizar(v);
                            } catch (Exception e) {
                                e.printStackTrace();
                            }

                            request.getRequestDispatcher("Controlador?menu=Venta&accion=Listar").forward(request, response);
                            break;

                        case "Eliminar":
                            String codigoEliminar = request.getParameter("id");
                                try {
                                    int codEliminar = Integer.parseInt(codigoEliminar);
                                    ventaDAO.eliminar(codEliminar);
                                } catch (NumberFormatException e) {
                                    e.printStackTrace();
                                }
                            
                            request.getRequestDispatcher("Controlador?menu=Venta&accion=Listar").forward(request, response);
                            break;
                        case "Buscar":
                            break;
                        default:
                            throw new AssertionError();
                    }
                    request.getRequestDispatcher("venta.jsp").forward(request, response);
                    break;
                case "DetalleVenta":
                    switch (accion) {
                        case "Listar":
                            List listaDetalleVenta = detalleVentaDAO.listar();
                            request.setAttribute("detalleVentas", listaDetalleVenta);
                            break;
                        case "Agregar":
                            String cantidad = request.getParameter("txtCantidad");

                            String precioUnitario = request.getParameter("txtPrecioUnitario");

                            String Codventa = request.getParameter("txtCodigoVenta");

                            String Codproducto = request.getParameter("txtCodigoProducto");

                            detalleVenta.setCantidad(Integer.parseInt(cantidad));
                            detalleVenta.setPrecioUnitario(BigDecimal.valueOf(Double.parseDouble(precioUnitario)));

                            venta.setCodigoVenta(Integer.parseInt(Codventa));
                            detalleVenta.setVenta(venta);

                            producto.setCodigoProducto(Integer.parseInt(Codproducto));
                            detalleVenta.setProducto(producto);

                            detalleVentaDAO.agregar(detalleVenta);
                            request.getRequestDispatcher("Controlador?menu=DetalleVenta&accion=Listar").forward(request, response);
                            break;
                        default:
                            throw new AssertionError();
                    }
                    request.getRequestDispatcher("detalleVenta.jsp").forward(request, response);
                    break;
                case "Factura":
                    switch (accion) {
                        case "Listar":
                            List listaFactura = facturaDAO.listar();
                            request.setAttribute("facturas", listaFactura);
                            break;
                        case "Agregar":
                            String numeroFactura = request.getParameter("txtNumeroFactura");

                            String fechaEmisionStr = request.getParameter("txtFechaEmision");
                            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm");
                            LocalDateTime fechaEmision = LocalDateTime.parse(fechaEmisionStr, formatter);

                            String totalFactura = request.getParameter("txtTotal");
                            String codVenta = request.getParameter("txtCodigoVenta");

                            factura.setNumeroFactura(numeroFactura);
                            factura.setFechaEmision(fechaEmision);
                            factura.setTotalFactura(BigDecimal.valueOf(Double.parseDouble(totalFactura)));

                            venta.setCodigoVenta(Integer.parseInt(codVenta));
                            factura.setCodVenta(venta);

                            facturaDAO.agregar(factura);
                            request.getRequestDispatcher("Controlador?menu=Factura&accion=Listar").forward(request, response);
                            break;
                        case "Editar":
                            int codF = Integer.parseInt(request.getParameter("codigoFactura"));
                            Factura fac = facturaDAO.listarPorFactura(codF);
                            request.setAttribute("factura", fac);
                            request.getRequestDispatcher("Controlador?menu=Factura&accion=Listar").forward(request, response);
                            break;
                        case "Actualizar":
                            String noFactura = request.getParameter("txtNumeroFactura");

                            String fechaE = request.getParameter("txtFechaEmision");
                            DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm");
                            LocalDateTime fechaEmi = LocalDateTime.parse(fechaE, format);

                            String totFactura = request.getParameter("txtTotal");
                            String codVen = request.getParameter("txtCodigoVenta");

                            factura.setNumeroFactura(noFactura);
                            factura.setFechaEmision(fechaEmi);
                            factura.setTotalFactura(BigDecimal.valueOf(Double.parseDouble(totFactura)));

                            venta.setCodigoVenta(Integer.parseInt(codVen));
                            factura.setCodVenta(venta);
                            productoDao.actualizar(producto);
                            request.getRequestDispatcher("Controlador?menu=Factura&accion=Listar").forward(request, response);
                            break;
                        case "Eliminar":
                            codF = Integer.parseInt(request.getParameter("codigoFactura"));
                            facturaDAO.eliminar(codF);
                            request.getRequestDispatcher("Controlador?menu=Factura&accion=Listar").forward(request, response);
                            break;
                        default:
                            throw new AssertionError();
                    }
                    request.getRequestDispatcher("factura.jsp").forward(request, response);
                    break;

                case "Compra":
                    request.getRequestDispatcher("compras.jsp").forward(request, response);
                    break;
                case "DetalleCompra":
                    switch (accion) {
                        case "Listar":
                            List listaDetalleCompra = detalleCompraDAO.listar();
                            request.setAttribute("detalleCompras", listaDetalleCompra);
                            break;
                        case "Agregar":
                            String cantidadStr = request.getParameter("txtCantidad");
                            String precioUnitarioStr = request.getParameter("txtPrecio");
                            String codCompra = request.getParameter("txtCodigoCompra");
                            String codProducto = request.getParameter("txtCodigoProducto");

                            detalleCompra.setCantidad(Integer.parseInt(cantidadStr));
                            detalleCompra.setPrecioUnitario(Double.parseDouble(precioUnitarioStr));
                            detalleCompra.setCodigoCompra(Integer.parseInt(codCompra));
                            detalleCompra.setCodigoProducto(Integer.parseInt(codProducto));

                            detalleCompraDAO.agregar(detalleCompra);
                            request.getRequestDispatcher("Controlador?menu=DetalleCompra&accion=Listar").forward(request, response);
                            break;

                        default:
                            throw new AssertionError();
                    }
                    request.getRequestDispatcher("detalleCompra.jsp").forward(request, response);
                    break;
                case "Cambiar":
                    request.getRequestDispatcher("principal.jsp").forward(request, response);
                    break;
                case "Cerrar":
                    request.getRequestDispatcher("index.jsp").forward(request, response);
                    break;
                default:
                    throw new AssertionError();
            }
        }

    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
