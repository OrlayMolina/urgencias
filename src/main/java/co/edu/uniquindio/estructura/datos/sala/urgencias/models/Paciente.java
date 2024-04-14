package co.edu.uniquindio.estructura.datos.sala.urgencias.models;

import co.edu.uniquindio.estructura.datos.sala.urgencias.enumms.Genero;
import co.edu.uniquindio.estructura.datos.sala.urgencias.enumms.Opcion;

public class Paciente extends Persona{

    private int edad;
    private Genero genero;
    private Opcion discapacidad;
    private Opcion embarazada;
    private String temperatura;
    private String tensionArtificial;
    private String frecuenciaRespiratoria;
    private String frecuenciaCardiaca;
    private String SPO2;
}
