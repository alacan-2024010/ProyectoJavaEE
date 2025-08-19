
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
                listaVenta.add(prov);
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listaVenta;
    }
     public int agregar(Venta ven){
        //Llamar al procedimiento almacenado
        String sql= "call sp_AgregarVenta(?,?,?,?)";
        
        try {
            //Conectar a la base de datos para preparar la consulta
            con = cn.Conexion();
            ps=con.prepareStatement(sql);
            
            //Los parametros del procedimiento
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
}
