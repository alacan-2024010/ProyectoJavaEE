package Controlador;

import Modelo.EmpleadoDAO;

import com.alanlacan.modelo.Empleado;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Validar extends HttpServlet {

    EmpleadoDAO empleadoDAO = new EmpleadoDAO();
    Empleado empleado = new Empleado();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String btnIngresar = request.getParameter("btnIngresar");
        if (btnIngresar.equalsIgnoreCase("Ingresar")) {
            String correo = request.getParameter("txtCorreo");
            String pass = request.getParameter("txtContrasena");
            empleado = empleadoDAO.validar(correo, pass);
            if (empleado.getEmailEmpleado() != null) {
                HttpSession session = request.getSession();
                session.setAttribute("usuarioLogueado", empleado);
                request.getRequestDispatcher("Controlador?menu=Principal").forward(request, response);
            } else {
                request.getRequestDispatcher("index.jsp").forward(request, response);
            }
        } else {
            request.getRequestDispatcher("index.jsp").forward(request, response);
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }
}