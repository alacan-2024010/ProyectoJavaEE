
package Modelo;


public class Cliente {
    private int codigoCliente;

    private String nombreCliente;

    private String apellidoCliente;

    private String emailCliente;

    private String contrasenia;
    private String imagen;

    public Cliente() {
    }

    public Cliente( String nombreCliente, String apellidoCliente, String emailCliente, String contrasenia, String imagen) {
        this.nombreCliente = nombreCliente;
        this.apellidoCliente = apellidoCliente;
        this.emailCliente = emailCliente;
        this.contrasenia = contrasenia;
        this.imagen=imagen;
    }

    public int getCodigoCliente() {
        return codigoCliente;
    }

    public void setCodigoCliente(int codigoCliente) {
        this.codigoCliente = codigoCliente;
    }

    public String getNombreCliente() {
        return nombreCliente;
    }

    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }

    public String getApellidoCliente() {
        return apellidoCliente;
    }

    public void setApellidoCliente(String apellidoCliente) {
        this.apellidoCliente = apellidoCliente;
    }

    public String getEmailCliente() {
        return emailCliente;
    }

    public void setEmailCliente(String emailCliente) {
        this.emailCliente = emailCliente;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }

    public String getImagen() {
        if (imagen == null || imagen.isEmpty()) {
        return "../Images/usuarioPredeterminado.png";
        }
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    @Override
    public String toString() {
        return "Cliente{" + "codigoCliente=" + codigoCliente + ", nombreCliente=" + nombreCliente + ", apellidoCliente=" + apellidoCliente + ", emailCliente=" + emailCliente + ", contrasenia=" + contrasenia + ", imagen=" + getImagen() + '}';
    }
}