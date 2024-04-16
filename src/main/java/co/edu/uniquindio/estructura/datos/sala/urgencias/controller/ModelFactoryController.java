package co.edu.uniquindio.estructura.datos.sala.urgencias.controller;

import co.edu.uniquindio.estructura.datos.sala.urgencias.exceptions.PacienteException;
import co.edu.uniquindio.estructura.datos.sala.urgencias.models.Diagnostico;
import co.edu.uniquindio.estructura.datos.sala.urgencias.models.Paciente;
import co.edu.uniquindio.estructura.datos.sala.urgencias.models.Urgencias;
import co.edu.uniquindio.estructura.datos.sala.urgencias.utils.Persistencia;
import co.edu.uniquindio.estructura.datos.sala.urgencias.utils.UrgenciasUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class ModelFactoryController {

    Urgencias urgencias;
    String mensaje;
    int nivel;
    String accion;


    //------------------------------  Singleton ------------------------------------------------
    // Clase estatica oculta. Tan solo se instanciara el singleton una vez
    private static class SingletonHolder {
        private final static ModelFactoryController eINSTANCE = new ModelFactoryController();
    }

    // Método para obtener la instancia de nuestra clase
    public static ModelFactoryController getInstance() {
        return SingletonHolder.eINSTANCE;
    }
    public ModelFactoryController() {

        cargarResourceXML();

        if(urgencias == null){
            cargarDatosBase();
            guardarResourceXML();
        }
    }

    public void registrarAccionesSistema(String mensaje, int nivel, String accion){
        this.mensaje=mensaje;
        this.nivel=nivel;
        this.accion=accion;

        Persistencia.guardaRegistroLog(mensaje, nivel, accion);
    }

    public Urgencias getUrgencias() {
        return urgencias;
    }

    public boolean inicioSesion(String usuario, String password) {
        return getUrgencias().inicioSesion(usuario, password);
    }

    public boolean agregarPaciente(Paciente paciente) {
        try{
            if(!getUrgencias().verificarPacienteExistente(paciente.getDocumento())) {
                getUrgencias().agregarPaciente(paciente);
                guardarResourceXML();

            }
            return true;
        }catch (PacienteException e){
            e.getMessage();
            return false;
        }
    }

    public boolean actualizarPaciente(Paciente paciente) {
        try{
            if(getUrgencias().pacienteExiste(paciente.getDocumento())) {
                getUrgencias().actualizarPaciente(paciente);
                guardarResourceXML();
            }
            return true;
        }catch (PacienteException e){
            e.getMessage();
            return false;
        }
    }

    public List<Paciente> obtenerPacientesBajaPrioridad() {
        PriorityQueue<Paciente> colaPrioridad = getUrgencias().getPacientesPrioridadBaja();
        return new ArrayList<>(colaPrioridad);
    }

    public List<Paciente> obtenerPacientesPrioridadModerada() {
        PriorityQueue<Paciente> colaPrioridad = getUrgencias().getPacientesPrioridadMedia();
        return new ArrayList<>(colaPrioridad);
    }

    public List<Paciente> obtenerPacientesAltaPrioridad() {
        PriorityQueue<Paciente> colaPrioridad = getUrgencias().getPacientesPrioridadAlta();
        return new ArrayList<>(colaPrioridad);
    }

    public List<Diagnostico> obtenerDiagnosticos() {
        return  getUrgencias().getDiagnosticos();
    }

    private void cargarDatosBase() {
        urgencias = UrgenciasUtils.inicializarDatos();
    }

    private void guardarResourceXML() {
        Persistencia.guardarRecursoSubastaXML(urgencias);
    }

    private void cargarResourceXML() {
        urgencias = Persistencia.cargarRecursoUrgenciasXML();
    }
}
