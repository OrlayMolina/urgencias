package co.edu.uniquindio.estructura.datos.sala.urgencias.models;

import co.edu.uniquindio.estructura.datos.sala.urgencias.enumms.Riesgo;

public class Diagnostico {

    private String nombreDX;
    private Riesgo riesgo;

    public Diagnostico(){

    }
    public Diagnostico(String nombreDX, Riesgo riesgo) {
        this.nombreDX = nombreDX;
        this.riesgo = riesgo;
    }

    public String getNombreDX() {
        return nombreDX;
    }

    public void setNombreDX(String nombreDX) {
        this.nombreDX = nombreDX;
    }

    public Riesgo getRiesgo() {
        return riesgo;
    }

    public void setRiesgo(Riesgo riesgo) {
        this.riesgo = riesgo;
    }

    @Override
    public String toString() {
        return nombreDX + " - RIESGO " + riesgo;
    }
}
