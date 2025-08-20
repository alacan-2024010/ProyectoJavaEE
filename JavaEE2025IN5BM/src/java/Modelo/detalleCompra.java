package Modelo;

public class DetalleCompra {
    private int codigoDetalleCompra;
    private int cantidad;
    private double precioUnitario;
    private int codigoCompra;
    private int codigoProducto;

 
    public DetalleCompra() {
    }

    
    public DetalleCompra(int cantidad, double precioUnitario, int codigoCompra, int codigoProducto) {
        this.cantidad = cantidad;
        this.precioUnitario = precioUnitario;
        this.codigoCompra = codigoCompra;
        this.codigoProducto = codigoProducto;
    }

    public int getCodigoDetalleCompra() {
        return codigoDetalleCompra;
    }

    public void setCodigoDetalleCompra(int codigoDetalleCompra) {
        this.codigoDetalleCompra = codigoDetalleCompra;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getPrecioUnitario() {
        return precioUnitario;
    }

    public void setPrecioUnitario(double precioUnitario) {
        this.precioUnitario = precioUnitario;
    }

    public int getCodigoCompra() {
        return codigoCompra;
    }

    public void setCodigoCompra(int codigoCompra) {
        this.codigoCompra = codigoCompra;
    }

    public int getCodigoProducto() {
        return codigoProducto;
    }

    public void setCodigoProducto(int codigoProducto) {
        this.codigoProducto = codigoProducto;
    }
}
