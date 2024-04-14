package co.edu.uniquindio.estructura.datos.sala.urgencias.models;

public abstract class Persona {

    private String nombres;
    private String apellidos;
    private String documento;

    public Persona(){

    }

    public Persona(String nombres, String apellidos, String documento) {
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.documento = documento;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    @Override
    public String toString() {
        return "Persona{" +
                "nombre='" + documento + '\'' +
                ", apellido='" + nombres + '\'' +
                ", cedula='" + apellidos + '\'' +
                '}';
    }
}
