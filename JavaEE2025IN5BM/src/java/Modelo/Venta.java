
package Modelo;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


public class Venta {
    private int codigoVenta ;
    private LocalDateTime  fecha;
    private BigDecimal total;
    private Cliente cliente;
    private Empleado empleado;
    
    
    public Venta() {
    }

    public Venta(LocalDateTime  fecha, BigDecimal total, int codigoCliente, int codigoEmpleado) {
        this.codigoVenta = codigoVenta;
        this.fecha = fecha;
        this.total = total;
    }

    
    
    public int getCodigoVenta() {
        return codigoVenta;
    }

    public void setCodigoVenta(int codigoVenta) {
        this.codigoVenta = codigoVenta;
    }

    public LocalDateTime  getFecha() {
        return fecha;
    }

    public void setFecha(LocalDateTime  fecha) {
        this.fecha = fecha;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Empleado getEmpleado() {
        return empleado;
    }

    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }

    @Override
    public String toString() {
        return "Venta{" + "codigoVenta=" + codigoVenta + ", fecha=" + fecha + ", total=" + total + ", cliente=" + cliente + ", empleado=" + empleado + '}';
    }

   
    
}


