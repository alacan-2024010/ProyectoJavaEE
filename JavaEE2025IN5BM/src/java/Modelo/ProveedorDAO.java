package Modelo;
 
import Config.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet   ;
import java.util.ArrayList;
import java.util.List;
 
public class ProveedorDAO {
   
    Conexion cn= new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    int resp;
   
    //Metodo para poder permitir que se puedan listar todos los proveedores existentes
    public List listar(){
        String sql = "call sp_ListarProveedores()";
        List<Proveedor> listaProveedor = new ArrayList<>();
       
        try {
            con = cn.Conexion();
            ps= con.prepareStatement(sql);
            rs= ps.executeQuery();
           
            while (rs.next()) {
                Proveedor prov = new Proveedor();
               
                prov.setCodigoProveedor(rs.getInt(1));
                prov.setNombreProveedor(rs.getString(2));
                prov.setDireccionProveedor(rs.getString(3));
                prov.setTelefonoProveedor(rs.getString(4));
                prov.setCorreoProveedor(rs.getString(5));
                listaProveedor.add(prov);
            }
           
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listaProveedor;
    }
   
    //Metodo para poder permitir que se pueda agregar un nuevo proveedor
    public int agregar(Proveedor prov){
        //Llamar al procedimiento almacenado
        String sql= "call sp_AgregarProveedores(?,?,?,?)";
       
        try {
            //Conectar a la base de datos para preparar la consulta
            con = cn.Conexion();
            ps=con.prepareStatement(sql);
           
            //Los parametros del procedimiento
            ps.setString(1, prov.getNombreProveedor());
            ps.setString(2, prov.getDireccionProveedor());
            ps.setString(3, prov.getTelefonoProveedor());
            ps.setString(4, prov.getCorreoProveedor());
           
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return resp;
    }
}
 
 
 