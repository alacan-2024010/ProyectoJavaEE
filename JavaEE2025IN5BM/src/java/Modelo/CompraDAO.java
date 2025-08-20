package Modelo;
import Config.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class CompraDAO {
    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    int resp;
    
    public List<Compra> listar() {
        List<Compra> listaCompra = new ArrayList<>();
        String sql = "call sp_listarCompras()";
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Compra c = new Compra();
                c.setCodigoCompra(rs.getInt(1));
                c.setFechaCompra(rs.getString(2));
                c.setTotal(rs.getDouble(3));
                c.setCodigoProveedor(rs.getInt(4));
                c.setCodigoEmpleado(rs.getInt(5));
                listaCompra.add(c);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listaCompra;
    }
    
    public int agregar(Compra c) {
        String sql = "call sp_agregarCompra(?,?,?,?)";
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.setString(1, c.getFechaCompra());
            ps.setDouble(2, c.getTotal());
            ps.setInt(3, c.getCodigoProveedor());
            ps.setInt(4, c.getCodigoEmpleado());
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return resp;
    }
    
    public Compra listarCodigoPorCompra(int id) {
        Compra c = new Compra();
        String sql = "SELECT * FROM Compras WHERE codigoCompra = " + id;
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            if (rs.next()) {
                c.setCodigoCompra(rs.getInt(1));
                c.setFechaCompra(rs.getString(2));          
                c.setTotal(rs.getDouble(3));
                c.setCodigoProveedor(rs.getInt(4));
                c.setCodigoEmpleado(rs.getInt(5));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return c;
    }
    
    public int actualizar(Compra c) {
        String sql = "CALL sp_editarCompra(?,?,?,?,?)";
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.setInt(1, c.getCodigoCompra());
            ps.setString(2, c.getFechaCompra());
            ps.setDouble(3, c.getTotal());
            ps.setInt(4, c.getCodigoProveedor());
            ps.setInt(5, c.getCodigoEmpleado());
            ps.executeUpdate();
           
        } catch (Exception e) {
            e.printStackTrace();
        }
        return resp;
    }
    
    public void eliminar(int codigoCompra) {
        String sql = "CALL sp_eliminarCompra(?)";
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.setInt(1, codigoCompra);
            ps.executeUpdate();
            
        } catch (Exception e) {
            e.printStackTrace();
            
        }
        
    }
}