package Modelo;

public class Compra {
    private int codigoCompra;
    private String fechaCompra;
    private double total;
    private int codigoProveedor;
    private int codigoEmpleado;
 
    public Compra() {
    }
    
    public Compra(String fechaCompra, double total, int codigoProveedor, int codigoEmpleado) {
        this.fechaCompra = fechaCompra;
        this.total = total;
        this.codigoProveedor = codigoProveedor;
        this.codigoEmpleado = codigoEmpleado;
    }
    
    public int getCodigoCompra() {
        return codigoCompra;
    }
    
    public void setCodigoCompra(int codigoCompra) {
        this.codigoCompra = codigoCompra;
    }
    
    public String getFechaCompra() {
        return fechaCompra;
    }
    
    public void setFechaCompra(String fechaCompra) {
        this.fechaCompra = fechaCompra;
    }
    
    public double getTotal() {
        return total;
    }
    
    public void setTotal(double total) {
        this.total = total;
    }
    
    public int getCodigoProveedor() {
        return codigoProveedor;
    }
    
    public void setCodigoProveedor(int codigoProveedor) {
        this.codigoProveedor = codigoProveedor;
    }
    
    public int getCodigoEmpleado() {
        return codigoEmpleado;
    }
    
    public void setCodigoEmpleado(int codigoEmpleado) {
        this.codigoEmpleado = codigoEmpleado;
    }
}