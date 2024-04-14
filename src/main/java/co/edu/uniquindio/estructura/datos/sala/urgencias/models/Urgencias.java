package co.edu.uniquindio.estructura.datos.sala.urgencias.models;

import co.edu.uniquindio.estructura.datos.sala.urgencias.exceptions.PacienteException;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class Urgencias {

    private List<Enfermera> enfermerasLista = new ArrayList<>();
    private List<Paciente> pacientesLista = new ArrayList<>();
    private PriorityQueue<Paciente> pacientesPrioridadAlta;
    private PriorityQueue<Paciente> pacientesPrioridadMedia;
    private PriorityQueue<Paciente> pacientesPrioridadBaja;
    private List<Diagnostico> diagnosticos = new ArrayList<>();

    public Urgencias(){
        pacientesPrioridadAlta = new PriorityQueue<>(Comparator.comparingInt(Paciente::determinarPrioridad));
        pacientesPrioridadMedia = new PriorityQueue<>(Comparator.comparingInt(Paciente::determinarPrioridad));
        pacientesPrioridadBaja = new PriorityQueue<>(Comparator.comparingInt(Paciente::determinarPrioridad));
    }

    public boolean inicioSesion(String usuario, String password){
        boolean encontrado = usuarioExiste(usuario, password);
        return encontrado;
    }

    public boolean usuarioExiste(String usuario, String password){
        boolean usuarioExiste = false;
        for(Enfermera enfermera : getEnfermerasLista()){
            if(enfermera.getNombreUsuario().equalsIgnoreCase(usuario) &&
                    enfermera.getContrasenia().equalsIgnoreCase(password)){
                usuarioExiste = true;
                break;
            }
        }
        return usuarioExiste;
    }

    public boolean verificarProductoExistente(String documento) throws PacienteException {
        if(pacienteExiste(documento)){
            throw new PacienteException("El paciente con documento: "+documento+" ya existe");
        }else{
            return false;
        }
    }

    public boolean pacienteExiste(String documento) {
        boolean productoEncontrado = false;
        for (Paciente paciente : getPacientesLista()) {
            if(paciente.getDocumento().equalsIgnoreCase(documento)){
                productoEncontrado = true;
                break;
            }
        }
        return productoEncontrado;
    }

    public void agregarPaciente(Paciente paciente) {
        int prioridad = paciente.determinarPrioridad();
        switch (prioridad) {
            case 1:
                pacientesPrioridadBaja.offer(paciente);
                break;
            case 2:
                pacientesPrioridadMedia.offer(paciente);
                break;
            case 3:
                pacientesPrioridadAlta.offer(paciente);
                break;
            default:
                break;
        }
    }

    public List<Enfermera> getEnfermerasLista() {
        return enfermerasLista;
    }

    public void setEnfermerasLista(List<Enfermera> enfermerasLista) {
        this.enfermerasLista = enfermerasLista;
    }

    public List<Paciente> getPacientesLista() {
        return pacientesLista;
    }

    public void setPacientesLista(List<Paciente> pacientesLista) {
        this.pacientesLista = pacientesLista;
    }

    public List<Diagnostico> getDiagnosticos() {
        return diagnosticos;
    }

    public void setDiagnosticos(List<Diagnostico> diagnosticos) {
        this.diagnosticos = diagnosticos;
    }
}
