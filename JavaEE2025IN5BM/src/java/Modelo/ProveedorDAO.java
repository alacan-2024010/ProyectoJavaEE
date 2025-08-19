package Modelo;

import Config.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ProveedorDAO {
    
    Conexion cn= new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    int resp;
    
    public List listar(){
        String sql = "call sp_ListarProveedores()";
        List<Proveedor> listaProveedor = new ArrayList<>();
        try {
            con = cn.Conexion();
            ps= con.prepareStatement(sql);
            rs= ps.executeQuery();
            while (rs.next()) {
                Proveedor pr = new Proveedor();
                pr.setCodigoProveedor(rs.getInt(1));
                pr.setNombreProveedor(rs.getString(2));
                pr.setDireccionProveedor(rs.getString(3));
                pr.setTelefonoProveedor(rs.getString(4));
                pr.setCorreoProveedor(rs.getString(5));
                listaProveedor.add(pr);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listaProveedor;
    }
    
    public int agregar(Proveedor pro){
        String sql= "call sp_AgregarProveedores(?,?,?,?)";
        try {
            con = cn.Conexion();
            ps=con.prepareStatement(sql);
            ps.setString(1,pro.getNombreProveedor());
            ps.setString(2,pro.getDireccionProveedor());
            ps.setString(3,pro.getTelefonoProveedor());
            ps.setString(4,pro.getCorreoProveedor());
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return resp;
    }
}


