package Modelo;

import Config.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ClienteDAO {
    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    int resp;

     public List listar() {
        String sql = "call sp_ListarClientes()";
        List<Cliente> listaCliente = new ArrayList<>();
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Cliente c = new Cliente();
                c.setCodigoCliente(rs.getInt(1));
                c.setNombreCliente(rs.getString(2));
                c.setApellidoCliente(rs.getString(3));
                c.setEmailCliente(rs.getString(4));
                c.setContrasenia(rs.getString(5));
                listaCliente.add(c);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listaCliente;
    }

    public int agregar(Cliente cli) {
        String sql = "call sp_AgregarCliente(?,?,?,?)";
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.setString(1, cli.getNombreCliente());
            ps.setString(2, cli.getApellidoCliente());
            ps.setString(3, cli.getEmailCliente());
            ps.setString(4, cli.getContrasenia());
            resp = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return resp;
    }
    
    public Cliente listarCodigoPorCliente(int id){
        Cliente c=new Cliente();
        String sql = "Select * from Clientes where codigoCliente ="+id;
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            rs=ps.executeQuery();
            while (rs.next()) {
                c.setCodigoCliente(rs.getInt(1));
                c.setNombreCliente(rs.getString(2));
                c.setApellidoCliente(rs.getString(3));
                c.setEmailCliente(rs.getString(4));
                c.setContrasenia(rs.getString(5));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return c;
        
    }
    
    public int actualizar(Cliente c){
       String sql = "call sp_EditarCliente(?,?,?,?,?)" ;
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.setInt(1, c.getCodigoCliente());
            ps.setString(2,c.getNombreCliente());
            ps.setString(3,c.getApellidoCliente());
            ps.setString(4, c.getEmailCliente());
            ps.setString(5, c.getContrasenia());
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return resp;
    }
    
    public void eliminar(int codigoC){
        String sql="call sp_EliminarCliente(?)";
        try {
            con = cn.Conexion();
            ps=con.prepareStatement(sql);
            ps.setInt(1, codigoC);   
            ps.executeUpdate();  
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }
}