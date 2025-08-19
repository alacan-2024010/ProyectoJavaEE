package Modelo;
 
import Config.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
 
 
public class DetalleVentaDAO {
    
    Conexion cn= new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    int resp;
    
    public List listar(){
        String sql = "call sp_listarDetalleVentas()";
        List<DetalleVenta> listaDetalleVenta = new ArrayList<>();
        
        try {
            con = cn.Conexion();
            ps= con.prepareStatement(sql);
            rs= ps.executeQuery();
            
            while (rs.next()) {
                DetalleVenta deV = new DetalleVenta();
                Venta ven = new Venta();
                Producto pro = new Producto();
                
                deV.setCodigoDetalleVenta(rs.getInt(1));
                deV.setCantidad(rs.getInt(2));
                deV.setPrecioUnitario(rs.getBigDecimal(3));
                
                ven.setCodigoVenta(rs.getInt(4));
                deV.setVenta(ven);
                
                pro.setCodigoProducto(rs.getInt(5));
                deV.setProducto(pro);
                
                listaDetalleVenta.add(deV);
            }
            
        } catch (SQLException e) {
        }
        return listaDetalleVenta;
    }
    
    public int agregar(DetalleVenta deV){
            String sql= "call sp_agregarDetalleVenta(?,?,?,?)";
        try {
            con = cn.Conexion();
            ps=con.prepareStatement(sql);
 
            ps.setInt(1, deV.getCantidad());
            ps.setBigDecimal(2, deV.getPrecioUnitario());
           ps.setInt(5, deV.getVenta().getCodigoVenta());
            ps.setInt(6, deV.getProducto().getCodigoProducto());
            
            resp = ps.executeUpdate();
        } catch (SQLException e) {
        }
        return resp;
    }
   
}