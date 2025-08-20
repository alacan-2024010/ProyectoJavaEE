package Modelo;

import Config.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class FacturaDAO {

    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    int resp;

    //Método Listar
    public List listar() {
        String sql = "call sp_listarFacturas()";
        List<Factura> listaFactura = new ArrayList<>();

        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                Factura fac = new Factura();
                Venta vt = new Venta();

                fac.setCodigoFactura(rs.getInt(1));
                fac.setNumeroFactura(rs.getString(2));
                fac.setFechaEmision(rs.getTimestamp(3).toLocalDateTime());
                fac.setTotalFactura(rs.getBigDecimal(4));

                vt.setCodigoVenta(rs.getInt(5));
                fac.setCodVenta(vt);
                listaFactura.add(fac);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return listaFactura;
    }

    public int agregar(Factura fac) {
        String sql = "call sp_agregarFactura(?,?,?,?)";

        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);

            ps.setString(1, fac.getNumeroFactura());
            ps.setTimestamp(2, Timestamp.valueOf(fac.getFechaEmision()));
            ps.setBigDecimal(3, fac.getTotalFactura());
            ps.setInt(4, fac.getCodVenta().getCodigoVenta());

            resp = ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return resp;
    }

    public Factura listarPorFactura(int id) {
        Factura fac = new Factura();
        Venta vt = new Venta();

        String sql = "Select * from Facturas where codigoFactura =" + id;
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                fac.setCodigoFactura(rs.getInt(1));
                fac.setNumeroFactura(rs.getString(2));
                fac.setFechaEmision(rs.getTimestamp(3).toLocalDateTime());
                fac.setTotalFactura(rs.getBigDecimal(4));

                vt.setCodigoVenta(rs.getInt(5));
                fac.setCodVenta(vt);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return fac;

    }

    public int actualizar(Factura fac) {
        String sql = "call sp_editarFactura(?,?,?,?,?)";
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.setInt(1, fac.getCodigoFactura());
            ps.setString(2, fac.getNumeroFactura());
            ps.setTimestamp(3, Timestamp.valueOf(fac.getFechaEmision()));
            ps.setBigDecimal(4, fac.getTotalFactura());
            ps.setInt(5, fac.getCodVenta().getCodigoVenta());

            resp = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return resp;
    }

    public void eliminar(int codF) {
        String sql = "call sp_eliminarFactura(?)";
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.setInt(1, codF);
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
