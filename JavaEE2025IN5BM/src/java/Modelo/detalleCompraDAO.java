package Modelo;

import Config.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class DetalleCompraDAO {

    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    int resp;

    public List<DetalleCompra> listar() {
        List<DetalleCompra> listaDetalle = new ArrayList<>();
        String sql = "call sp_listarDetalleCompras()";
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                DetalleCompra dc = new DetalleCompra();
                dc.setCodigoDetalleCompra(rs.getInt(1));
                dc.setCantidad(rs.getInt(2));
                dc.setPrecioUnitario(rs.getDouble(3));
                dc.setCodigoCompra(rs.getInt(4));
                dc.setCodigoProducto(rs.getInt(5));
                listaDetalle.add(dc);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listaDetalle;
    }

    public int agregar(DetalleCompra dc) {
        String sql = "call sp_agregarDetalleCompra(?,?,?,?)";
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.setInt(1, dc.getCantidad());
            ps.setDouble(2, dc.getPrecioUnitario());
            ps.setInt(3, dc.getCodigoCompra());
            ps.setInt(4, dc.getCodigoProducto());
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return resp;
    }

   public DetalleCompra listarCodigoPorDetalle(int id) {
    DetalleCompra dc = new DetalleCompra();
    String sql = "SELECT * FROM DetalleCompras WHERE codigoDetalleCompra = " + id;
    try {
        con = cn.Conexion();
        ps = con.prepareStatement(sql);
        rs = ps.executeQuery();
        if (rs.next()) {
            dc.setCodigoDetalleCompra(rs.getInt(1));
            dc.setCantidad(rs.getInt(2));          
            dc.setPrecioUnitario(rs.getDouble(3));
            dc.setCodigoCompra(rs.getInt(4));
            dc.setCodigoProducto(rs.getInt(5));
        }
    } catch (Exception e) {
        e.printStackTrace();
    }
    return dc;
}

public int actualizar(DetalleCompra dc) {
    String sql = "CALL sp_editarDetalleCompra(?,?,?,?,?)";
    try {
        con = cn.Conexion();
        ps = con.prepareStatement(sql);
        ps.setInt(1, dc.getCodigoDetalleCompra());
        ps.setInt(2, dc.getCantidad());
        ps.setDouble(3, dc.getPrecioUnitario());
        ps.setInt(4, dc.getCodigoCompra());
        ps.setInt(5, dc.getCodigoProducto());
        ps.executeUpdate();
       
    } catch (Exception e) {
        e.printStackTrace();

    }
return resp;
}

public void eliminar(int codigoDetalle) {
    String sql = "CALL sp_eliminarDetalleCompra(?)";
    try {
        con = cn.Conexion();
        ps = con.prepareStatement(sql);
        ps.setInt(1, codigoDetalle);
        ps.executeUpdate();
        
    } catch (Exception e) {
        e.printStackTrace();
        
    }
    
}

}
