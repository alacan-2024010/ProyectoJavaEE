package Modelo;
 
import java.math.BigDecimal;
 
public class Producto {
 
    
    private int codigoProducto;
    private String nombreProducto;
    private String descripcionProducto;
    private BigDecimal precioProducto; 
    private int stock;
    private Categoria categoria;
 
    private Proveedor proveedor;
 
    public Producto() {
    }
 
    public Producto(int codigoProducto, String nombreProducto, String descripcionProducto, BigDecimal precioProducto, int stock, Categoria categoria, Proveedor proveedor) {
        this.codigoProducto = codigoProducto;
        this.nombreProducto = nombreProducto;
        this.descripcionProducto = descripcionProducto;
        this.precioProducto = precioProducto;
        this.stock = stock;
        this.categoria = categoria;
        this.proveedor = proveedor;
    }
 
    public int getCodigoProducto() {
        return codigoProducto;
    }
 
    public void setCodigoProducto(int codigoProducto) {
        this.codigoProducto = codigoProducto;
    }
 
    public String getNombreProducto() {
        return nombreProducto;
    }
 
    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }
 
    public String getDescripcionProducto() {
        return descripcionProducto;
    }
 
    public void setDescripcionProducto(String descripcionProducto) {
        this.descripcionProducto = descripcionProducto;
    }
 
    public BigDecimal getPrecioProducto() {
        return precioProducto;
    }
 
    public void setPrecioProducto(BigDecimal precioProducto) {
        this.precioProducto = precioProducto;
    }
 
    public int getStock() {
        return stock;
    }
 
    public void setStock(int stock) {
        this.stock = stock;
    }
 
    public Categoria getCategoria() {
        return categoria;
    }
 
    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }
 
    public Proveedor getProveedor() {
        return proveedor;
    }
 
    public void setProveedor(Proveedor proveedor) {
        this.proveedor = proveedor;
    }
 
    @Override
    public String toString() {
        return "Producto{" + "codigoProducto=" + codigoProducto + ", nombreProducto=" + nombreProducto + ", descripcionProducto=" + descripcionProducto + ", precioProducto=" + precioProducto + ", stock=" + stock + ", categoria=" + categoria + ", proveedor=" + proveedor + '}';
    }

}