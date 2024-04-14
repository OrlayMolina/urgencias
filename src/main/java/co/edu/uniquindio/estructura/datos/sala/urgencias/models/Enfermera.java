package co.edu.uniquindio.estructura.datos.sala.urgencias.models;

public class Enfermera extends Persona{

    private String nombreUsuario;
    private String contrasenia;

    public Enfermera() {
    }
    public Enfermera(String nombreUsuario, String contrasenia) {
        this.nombreUsuario = nombreUsuario;
        this.contrasenia = contrasenia;
    }

    public Enfermera(String nombres, String apellidos, String cedula, String nombreUsuario, String contrasenia) {
        super(nombres, apellidos, cedula);
        this.nombreUsuario = nombreUsuario;
        this.contrasenia = contrasenia;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }
}
