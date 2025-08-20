package Modelo;

import Config.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DetalleVentaDAO {

    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    int resp;

    // Método Listar
    public List<DetalleVenta> listar() {
        String sql = "CALL sp_listarDetalleVentas()";
        List<DetalleVenta> listaDetalleVenta = new ArrayList<>();

        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                DetalleVenta dv = new DetalleVenta();
                Venta v = new Venta();
                Producto p = new Producto();

                dv.setCodigoDetalleVenta(rs.getInt(1));
                dv.setCantidad(rs.getInt(2));
                dv.setPrecioUnitario(rs.getBigDecimal(3));
                v.setCodigoVenta(rs.getInt(4));
                p.setCodigoProducto(rs.getInt(5));

                dv.setVenta(v);
                dv.setProducto(p);

                listaDetalleVenta.add(dv);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return listaDetalleVenta;
    }

    // Método Agregar
    public int agregar(DetalleVenta dv) {
        String sql = "CALL sp_agregarDetalleVenta(?, ?, ?, ?)";

        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);

            ps.setInt(1, dv.getCantidad());
            ps.setBigDecimal(2, dv.getPrecioUnitario());
            ps.setInt(3, dv.getVenta().getCodigoVenta());
            ps.setInt(4, dv.getProducto().getCodigoProducto());

            resp = ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return resp;
    }

    // Método Buscar por código
    public DetalleVenta listarPorCodigo(int id) {
        DetalleVenta dv = new DetalleVenta();
        Venta v = new Venta();
        Producto p = new Producto();

        String sql = "CALL sp_buscarDetalleVenta(" + id + ")";
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                dv.setCodigoDetalleVenta(rs.getInt(1));
                dv.setCantidad(rs.getInt(2));
                dv.setPrecioUnitario(rs.getBigDecimal(3));
                v.setCodigoVenta(rs.getInt(4));
                p.setCodigoProducto(rs.getInt(5));

                dv.setVenta(v);
                dv.setProducto(p);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return dv;
    }

    // Método Actualizar
    public int actualizar(DetalleVenta dv) {
        String sql = "CALL sp_editarDetalleVenta(?, ?, ?, ?, ?)";
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);

            ps.setInt(1, dv.getCodigoDetalleVenta());
            ps.setInt(2, dv.getCantidad());
            ps.setBigDecimal(3, dv.getPrecioUnitario());
            ps.setInt(4, dv.getVenta().getCodigoVenta());
            ps.setInt(5, dv.getProducto().getCodigoProducto());

            resp = ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return resp;
    }

    // Método Eliminar
    public void eliminar(int codDV) {
        String sql = "CALL sp_eliminarDetalleVenta(?)";
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.setInt(1, codDV);
            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}