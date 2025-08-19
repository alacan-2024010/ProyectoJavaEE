/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controlador;

import Modelo.Cliente;
import Modelo.ClienteDAO;
import Modelo.EmpleadoDAO;
import Modelo.Proveedor;
import Modelo.ProveedorDAO;
import com.alanlacan.modelo.Empleado;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
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
            
            if(menu!=null){
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
                                request.getRequestDispatcher("Controlador?menu=Cliente&accion=Listar").forward(request,response);
                                break;
                            case "Editar":
                                break;
                            case "Actualizar":
                                break;
                            case "Eliminar":
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
                            default:
                                throw new AssertionError();
                        }

                        request.getRequestDispatcher("proveedor.jsp").forward(request, response);
                        break;
                    case "Producto":
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
                    case "Venta":
                        request.getRequestDispatcher("venta.jsp").forward(request, response);
                        break;
                    case "DetalleVenta":
                        request.getRequestDispatcher("detalleVenta.jsp").forward(request, response);
                        break;
                    case "Factura":
                        request.getRequestDispatcher("factura.jsp").forward(request, response);
                        break;
                    case "Compra":
                        request.getRequestDispatcher("compras.jsp").forward(request, response);
                        break;
                    case "DetalleCompra":
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
