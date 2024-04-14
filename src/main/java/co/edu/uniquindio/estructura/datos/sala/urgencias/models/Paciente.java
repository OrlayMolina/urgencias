package co.edu.uniquindio.estructura.datos.sala.urgencias.models;

import co.edu.uniquindio.estructura.datos.sala.urgencias.enumms.Genero;
import co.edu.uniquindio.estructura.datos.sala.urgencias.enumms.Opcion;
import co.edu.uniquindio.estructura.datos.sala.urgencias.enumms.Riesgo;

public class Paciente extends Persona{

    private String foto;
    private int edad;
    private Genero genero;
    private Opcion discapacidad;
    private Opcion embarazada;
    private String temperatura;
    private String tensionArterial;
    private String frecuenciaRespiratoria;
    private String frecuenciaCardiaca;
    private Diagnostico diagnostico;

    public Paciente(){

    }

    public Paciente(String nombres, String apellidos, String documento, String foto,
                    int edad, Genero genero, Opcion discapacidad, Opcion embarazada,
                    String temperatura, String tensionArterial, String frecuenciaRespiratoria,
                    String frecuenciaCardiaca, Diagnostico diagnostico) {
        super(nombres, apellidos, documento);
        this.foto = foto;
        this.edad = edad;
        this.genero = genero;
        this.discapacidad = discapacidad;
        this.embarazada = embarazada;
        this.temperatura = temperatura;
        this.tensionArterial = tensionArterial;
        this.frecuenciaRespiratoria = frecuenciaRespiratoria;
        this.frecuenciaCardiaca = frecuenciaCardiaca;
        this.diagnostico = diagnostico;
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

    public String getTensionArterial() {
        return tensionArterial;
    }

    public void setTensionArterial(String tensionArtificial) {
        this.tensionArterial = tensionArtificial;
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

    public Diagnostico getDiagnostico() {
        return diagnostico;
    }

    public void setDiagnostico(Diagnostico diagnostico) {
        this.diagnostico = diagnostico;
    }

    public int determinarPrioridad() {
        int prioridad = 0;

        if (diagnostico.getRiesgo().equals(Riesgo.ALTO)) {
            prioridad = 3;
        } else if (diagnostico.getRiesgo().equals(Riesgo.MODERADO)) {
            prioridad = 2;
        } else if (diagnostico.getRiesgo().equals(Riesgo.BAJO)) {
            prioridad = 1;
        }
        return prioridad;
    }
}
