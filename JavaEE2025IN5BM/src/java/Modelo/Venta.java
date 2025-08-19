
package Modelo;

import java.math.BigDecimal;
import java.time.LocalDateTime;





public class Venta {

    private int codigoVenta ;

    private LocalDateTime  fecha;
    private BigDecimal total;

    private Cliente codCliente;

    private Empleado codEmpleado;
    
    
    public Venta() {
    }

    public Venta(int codigoVenta, LocalDateTime fecha, BigDecimal total, Cliente codCliente, Empleado codEmpleado) {
        this.codigoVenta = codigoVenta;
        this.fecha = fecha;
        this.total = total;
        this.codCliente = codCliente;
        this.codEmpleado = codEmpleado;
    }

    public int getCodigoVenta() {
        return codigoVenta;
    }

    public void setCodigoVenta(int codigoVenta) {
        this.codigoVenta = codigoVenta;
    }

    public LocalDateTime getFecha() {
        return fecha;
    }

    public void setFecha(LocalDateTime fecha) {
        this.fecha = fecha;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    public Cliente getCodCliente() {
        return codCliente;
    }

    public void setCodCliente(Cliente codCliente) {
        this.codCliente = codCliente;
    }

    public Empleado getCodEmpleado() {
        return codEmpleado;
    }

    public void setCodEmpleado(Empleado codEmpleado) {
        this.codEmpleado = codEmpleado;
    }



   
    
}
