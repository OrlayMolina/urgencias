package co.edu.uniquindio.estructura.datos.sala.urgencias.models;

import co.edu.uniquindio.estructura.datos.sala.urgencias.enumms.Genero;
import co.edu.uniquindio.estructura.datos.sala.urgencias.enumms.Opcion;
import co.edu.uniquindio.estructura.datos.sala.urgencias.enumms.Riesgo;

import java.util.Comparator;

public class Paciente extends Persona  {

    private int edad;
    private Genero genero;
    private Opcion discapacidad;
    private Opcion embarazada;
    private String temperatura;
    private String tensionArtificial;
    private String frecuenciaRespiratoria;
    private String frecuenciaCardiaca;
    private String SPO2;
    private Diagnostico diagnotico;

    public Paciente(String nombres, String apellidos, String cedula, int edad, Genero genero, Opcion discapacidad, Opcion embarazada, String temperatura, String tensionArtificial, String frecuenciaRespiratoria, String frecuenciaCardiaca, String SPO2, Diagnostico diagnotico) {
        super(nombres, apellidos, cedula);
        this.edad = edad;
        this.genero = genero;
        this.discapacidad = discapacidad;
        this.embarazada = embarazada;
        this.temperatura = temperatura;
        this.tensionArtificial = tensionArtificial;
        this.frecuenciaRespiratoria = frecuenciaRespiratoria;
        this.frecuenciaCardiaca = frecuenciaCardiaca;
        this.SPO2 = SPO2;
        this.diagnotico = diagnotico;
    }
    public Paciente(){

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

    public Diagnostico getDiagnotico() {
        return diagnotico;
    }

    public void setDiagnotico(Diagnostico diagnotico) {
        this.diagnotico = diagnotico;
    }

    public int determinarPrioridad() {
        int prioridad = 0;

        if (discapacidad != null && discapacidad.equals(Opcion.SI)) {
            prioridad = 2;
        } else if (!diagnotico.getRiesgo().equals(Riesgo.ALTO) && !diagnotico.getRiesgo().equals(Riesgo.MODERADO) && (edad > 60 || edad < 14)) {
            prioridad = 2;
        }

        if (embarazada != null && embarazada.equals(Opcion.SI)) {
            prioridad = 2;
        }
        return prioridad;
    }


}
