
package Modelo;

public class Categoria {
    
    private int codigoCategoria;
    
    private String nombre;

    public Categoria() {
    }

    public Categoria(int codigoCategoria, String nombre) {
        this.codigoCategoria = codigoCategoria;
        this.nombre = nombre;
    }

    public int getCodigoCategoria() {
        return codigoCategoria;
    }

    public void setCodigoCategoria(int codigoCategoria) {
        this.codigoCategoria = codigoCategoria;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "Categoria{" + "codigoCategoria=" + codigoCategoria + ", nombre=" + nombre + '}';
    }
    
    
}
