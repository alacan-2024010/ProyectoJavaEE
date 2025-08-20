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

    public Producto listarPorProducto(int id) {
        Producto prod = new Producto();
        Proveedor prv = new Proveedor();
        Categoria cat = new Categoria();

        String sql = "Select * from Productos where codigoProducto =" + id;
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                prod.setCodigoProducto(rs.getInt(1));
                prod.setNombreProducto(rs.getString(2));
                prod.setDescripcionProducto(rs.getString(3));
                prod.setPrecioProducto(rs.getBigDecimal(4));
                prod.setStock(rs.getInt(5));
                cat.setCodigoCategoria(rs.getInt(6));
                prod.setCategoria(cat);
                prv.setCodigoProveedor(rs.getInt(7));
                prod.setProveedor(prv);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return prod;

    }

    public int actualizar(Producto prod) {
        String sql = "call sp_editarProducto(?,?,?,?,?,?,?)";
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.setInt(1, prod.getCodigoProducto());
            ps.setString(2, prod.getNombreProducto());
            ps.setString(3, prod.getDescripcionProducto());
            ps.setBigDecimal(4, prod.getPrecioProducto());
            ps.setInt(5, prod.getStock());
            ps.setInt(6, prod.getCategoria().getCodigoCategoria());
            ps.setInt(7, prod.getProveedor().getCodigoProveedor());

            resp = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return resp;
    }

    public void eliminar(int codP) {
        String sql = "call sp_eliminarProducto(?)";
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.setInt(1, codP);
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
