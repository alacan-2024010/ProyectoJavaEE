
package Modelo;

import Config.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;


public class VentaDAO {
    
    Conexion cn= new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    int resp;
    public List listar(){
        String sql = "call sp_ListarVentas()";
        List<Venta> listaVenta = new ArrayList<>();
        
        try {
            con = cn.Conexion();
            ps= con.prepareStatement(sql);
            rs= ps.executeQuery();
            
            while (rs.next()) {
                Venta prov = new Venta();
                Cliente cl = new Cliente();
                Empleado em = new Empleado();
                
                prov.setCodigoVenta(rs.getInt(1));
                prov.setFecha(rs.getTimestamp(2).toLocalDateTime());
                prov.setTotal(rs.getBigDecimal(3));
                cl.setCodigoCliente(rs.getInt(4));
                em.setCodigoEmpleado(rs.getInt(5));
                
                prov.setCodCliente(cl);
            prov.setCodEmpleado(em);
                listaVenta.add(prov);
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listaVenta;
    }
     public int agregar(Venta ven){
        String sql= "call sp_AgregarVenta(?,?,?,?)";
        
        try {
            con = cn.Conexion();
            ps=con.prepareStatement(sql);
            ps.setTimestamp(1, Timestamp.valueOf(ven.getFecha()));
            ps.setBigDecimal(2, ven.getTotal());
            ps.setInt(3, ven.getCodCliente().getCodigoCliente());
            ps.setInt(4, ven.getCodEmpleado().getCodigoEmpleado());
            
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return resp;
    }
     
     
                // Operación eliminar
           public void eliminar(int codigoVenta){
               String sql = "call sp_eliminarVenta(?);";
               try {
                   con = cn.Conexion();
                   ps = con.prepareStatement(sql);
                   ps.setInt(1, codigoVenta);
                   ps.executeUpdate();
               } catch (Exception e) {
                   e.printStackTrace();
               }
           }



            public int actualizar(Venta venta){
                int resp = 0;
                String sql = "call sp_editarVenta(?, ?, ?, ?, ?);";
                try {
                    con = cn.Conexion();
                    ps = con.prepareStatement(sql);
                    ps.setInt(1, venta.getCodigoVenta());
                    ps.setTimestamp(2, Timestamp.valueOf(venta.getFecha())); 
                    ps.setBigDecimal(3, venta.getTotal());
                    ps.setInt(4, venta.getCodCliente().getCodigoCliente());
                    ps.setInt(5, venta.getCodEmpleado().getCodigoEmpleado());
                    resp = ps.executeUpdate();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                return resp;
            }
            
            public Venta buscar(int id){
                Venta ventaEncontrada = null;
                String sql = "call sp_buscarVenta(?);";
                try {
                    con = cn.Conexion();
                    ps= con.prepareStatement(sql);
                    ps.setInt(1, id);
                    rs= ps.executeQuery();
                    if (rs.next()) {
                        ventaEncontrada = new Venta();
                        Cliente cl = new Cliente();
                        Empleado em = new Empleado();
                        ventaEncontrada.setCodigoVenta(rs.getInt("codigoVenta"));
                        ventaEncontrada.setFecha(rs.getTimestamp("fecha").toLocalDateTime());
                        ventaEncontrada.setTotal(rs.getBigDecimal("total"));
                        cl.setCodigoCliente(rs.getInt("codCliente"));
                        em.setCodigoEmpleado(rs.getInt("codEmpleado"));
                        ventaEncontrada.setCodCliente(cl);
                        ventaEncontrada.setCodEmpleado(em);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
                return ventaEncontrada;
            }
}
