package Modelo;

import Config.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ProductoDAO {

    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    int resp;

    //Método Listar
    public List listar() {
        String sql = "call sp_listarProductos()";
        List<Producto> listaProducto = new ArrayList<>();

        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                Producto prod = new Producto();
                Categoria cat = new Categoria();
                Proveedor prv = new Proveedor();

                prod.setCodigoProducto(rs.getInt(1));
                prod.setNombreProducto(rs.getString(2));
                prod.setDescripcionProducto(rs.getString(3));
                prod.setPrecioProducto(rs.getBigDecimal(4));
                prod.setStock(rs.getInt(5));
                cat.setCodigoCategoria(rs.getInt(6));
                prod.setCategoria(cat);
                prv.setCodigoProveedor(rs.getInt(7));
                prod.setProveedor(prv);
                listaProducto.add(prod);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return listaProducto;
    }

    public int agregar(Producto prod) {
        String sql = "call sp_agregarProducto(?, ?, ?, ?, ?, ?)";

        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);

            ps.setString(1, prod.getNombreProducto());
            ps.setString(2, prod.getDescripcionProducto());
            ps.setBigDecimal(3, prod.getPrecioProducto());
            ps.setInt(4, prod.getStock());
            ps.setInt(5, prod.getCategoria().getCodigoCategoria());
            ps.setInt(6, prod.getProveedor().getCodigoProveedor());
            ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return resp;
    }

}
