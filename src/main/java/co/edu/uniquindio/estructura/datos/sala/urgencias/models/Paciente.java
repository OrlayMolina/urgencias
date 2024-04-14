package co.edu.uniquindio.estructura.datos.sala.urgencias.models;

import co.edu.uniquindio.estructura.datos.sala.urgencias.enumms.Genero;
import co.edu.uniquindio.estructura.datos.sala.urgencias.enumms.Opcion;
import co.edu.uniquindio.estructura.datos.sala.urgencias.enumms.Riesgo;

import java.util.Comparator;

public class Paciente extends Persona implements Comparator<Paciente> {

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

        if (!this.diagnotico.getRiesgo().equals(Riesgo.ALTO) && !this.diagnotico.getRiesgo().equals(Riesgo.MODERADO) &&
                (this.edad > 60 || this.edad < 14)) {
            prioridad = 1;
        }

        if (this.embarazada != null && this.embarazada.equals(Opcion.SI) ||
                this.discapacidad != null && this.discapacidad.equals(Opcion.SI)) {
            prioridad = 1;
        }
        return prioridad;
    }

    @Override
    public int compare(Paciente p1, Paciente p2) {
        // Comparar por riesgo del diagnóstico
        int riesgoComparison = p1.getDiagnotico().getRiesgo().compareTo(p2.getDiagnotico().getRiesgo());
        if (riesgoComparison != 0) {
            return riesgoComparison;
        }

        // Si el riesgo es el mismo, comparar por edad
        int edadComparison = Integer.compare(p1.getEdad(), p2.getEdad());
        if (edadComparison != 0) {
            return edadComparison;
        }

        // Si la edad es la misma, verificar si alguno está embarazada o discapacitado
        if (p1.getEmbarazada() != null && p1.getEmbarazada().equals(Opcion.SI)) {
            return -1; // p1 tiene prioridad si está embarazada
        } else if (p2.getEmbarazada() != null && p2.getEmbarazada().equals(Opcion.SI)) {
            return 1; // p2 tiene prioridad si está embarazada
        } else if (p1.getDiscapacidad() != null && p1.getDiscapacidad().equals(Opcion.SI)) {
            return -1; // p1 tiene prioridad si está discapacitado
        } else if (p2.getDiscapacidad() != null && p2.getDiscapacidad().equals(Opcion.SI)) {
            return 1; // p2 tiene prioridad si está discapacitado
        }

        // Si todo lo demás es igual, comparar por orden lexicográfico de nombres
        return p1.getNombres().compareTo(p2.getNombres());
    }
}
