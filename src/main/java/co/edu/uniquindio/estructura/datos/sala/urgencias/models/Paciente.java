package co.edu.uniquindio.estructura.datos.sala.urgencias.models;

import co.edu.uniquindio.estructura.datos.sala.urgencias.enumms.Genero;
import co.edu.uniquindio.estructura.datos.sala.urgencias.enumms.Opcion;

public class Paciente extends Persona{

    private String foto;
    private int edad;
    private Genero genero;
    private Opcion discapacidad;
    private Opcion embarazada;
    private String temperatura;
    private String tensionArtificial;
    private String frecuenciaRespiratoria;
    private String frecuenciaCardiaca;
    private String SPO2;
    private Diagnostico diagnostico;

    public Paciente(){

    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public Genero getGenero() {
        return genero;
    }

    public void setGenero(Genero genero) {
        this.genero = genero;
    }

    public Opcion getDiscapacidad() {
        return discapacidad;
    }

    public void setDiscapacidad(Opcion discapacidad) {
        this.discapacidad = discapacidad;
    }

    public Opcion getEmbarazada() {
        return embarazada;
    }

    public void setEmbarazada(Opcion embarazada) {
        this.embarazada = embarazada;
    }

    public String getTemperatura() {
        return temperatura;
    }

    public void setTemperatura(String temperatura) {
        this.temperatura = temperatura;
    }

    public String getTensionArtificial() {
        return tensionArtificial;
    }

    public void setTensionArtificial(String tensionArtificial) {
        this.tensionArtificial = tensionArtificial;
    }

    public String getFrecuenciaRespiratoria() {
        return frecuenciaRespiratoria;
    }

    public void setFrecuenciaRespiratoria(String frecuenciaRespiratoria) {
        this.frecuenciaRespiratoria = frecuenciaRespiratoria;
    }

    public String getFrecuenciaCardiaca() {
        return frecuenciaCardiaca;
    }

    public void setFrecuenciaCardiaca(String frecuenciaCardiaca) {
        this.frecuenciaCardiaca = frecuenciaCardiaca;
    }

    public String getSPO2() {
        return SPO2;
    }

    public void setSPO2(String SPO2) {
        this.SPO2 = SPO2;
    }

    public Diagnostico getDiagnostico() {
        return diagnostico;
    }

    public void setDiagnostico(Diagnostico diagnostico) {
        this.diagnostico = diagnostico;
    }
}
