package Modelo;

import Config.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


public class EmpleadoDAO {
    
    Conexion cn= new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    int resp;
    
    public Empleado validar(String emailEmpleado, String telefonoEmpleado){
        //Instanciar el objetdo de la entidad Empleado
        
        Empleado empleado = new Empleado();
        //Agregar una variable de tipo String para mostrar consulta de sql
        String sql = "call sp_validarEmpleado(?,?)";
        try {
            con = cn.Conexion();
            ps = con.prepareCall(sql);
            ps.setString(1, emailEmpleado);
            ps.setString(2, telefonoEmpleado);
            rs = ps.executeQuery();
            while (rs.next()) {
                empleado.setCodigoEmpleado(rs.getInt("codigoEmpleado"));
                empleado.setNombreEmpleado(rs.getString("nombreEmpleado"));
                empleado.setApellidoEmpleado(rs.getString("apellidoEmpleado"));
                empleado.setEmailEmpleado(rs.getString("emailEmpleado"));
                empleado.setTelefonoEmpleado(rs.getString("telefonoEmpleado"));    
            }
        } catch (Exception e) {
            System.out.println("El usuario o contrasena son incorrectos");
            e.printStackTrace();
        }
        return empleado; //Empleado encontrado
    }
    
    public List listar(){
        String sql = "call sp_listarEmpleados()";
        List<Empleado> listaEmpleado = new ArrayList<>();
        try {
            con = cn.Conexion();
            ps= con.prepareStatement(sql);
            rs= ps.executeQuery();
            while (rs.next()) {
                Empleado em = new Empleado();
                em.setCodigoEmpleado(rs.getInt(1));
                em.setNombreEmpleado(rs.getString(2));
                em.setApellidoEmpleado(rs.getString(3));
                em.setDireccionEmpleado(rs.getString(4));
                em.setTelefonoEmpleado(rs.getString(5));
                em.setEmailEmpleado(rs.getString(6));
                em.setPuestoEmpleado(rs.getString(7));
                listaEmpleado.add(em);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listaEmpleado;
    }
    
    public int agregar(Empleado emp){
        String sql= "call sp_agregarEmpleado(?,?,?,?,?,?)";
        try {
            con = cn.Conexion();
            ps=con.prepareStatement(sql);
            ps.setString(1,emp.getNombreEmpleado());
            ps.setString(2,emp.getApellidoEmpleado());
            ps.setString(3,emp.getDireccionEmpleado());
            ps.setString(4,emp.getTelefonoEmpleado());
            ps.setString(5,emp.getEmailEmpleado());
            ps.setString(6,emp.getPuestoEmpleado());
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return resp;
    }
}
