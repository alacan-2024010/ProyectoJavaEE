package Modelo;
import java.math.BigDecimal;
import java.time.LocalDateTime;
 
 
public class Factura {
    private int codigoFactura;
    private String numeroFactura;
    private LocalDateTime fechaEmision;
    private BigDecimal totalFactura;
    private Venta codVenta;
 
    public Factura() {
    }
    public Factura(int codigoFactura, String numeroFactura, LocalDateTime fechaEmision, BigDecimal totalFactura, Venta codVenta) {
        this.codigoFactura = codigoFactura;
        this.numeroFactura = numeroFactura;
        this.fechaEmision = fechaEmision;
        this.totalFactura = totalFactura;
        this.codVenta = codVenta;
    }
    public int getCodigoFactura() {
        return codigoFactura;
    }
 
    public void setCodigoFactura(int codigoFactura) {
        this.codigoFactura = codigoFactura;
    }
 
    public String getNumeroFactura() {
        return numeroFactura;
    }
 
    public void setNumeroFactura(String numeroFactura) {
        this.numeroFactura = numeroFactura;
    }
 
    public LocalDateTime getFechaEmision() {
        return fechaEmision;
    }
 
    public void setFechaEmision(LocalDateTime fechaEmision) {
        this.fechaEmision = fechaEmision;
    }
 
    public BigDecimal getTotalFactura() {
        return totalFactura;
    }
 
    public void setTotalFactura(BigDecimal totalFactura) {
        this.totalFactura = totalFactura;
    }
 
    public Venta getCodVenta() {
        return codVenta;
    }
 
    public void setCodVenta(Venta codVenta) {
        this.codVenta = codVenta;
    }
}