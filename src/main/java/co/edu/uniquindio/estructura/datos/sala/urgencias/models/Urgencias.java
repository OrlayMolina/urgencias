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
    public static String usuarioLogueado;

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
                usuarioLogueado = usuario;
                usuarioExiste = true;
                break;
            }
        }
        return usuarioExiste;
    }

    public boolean verificarPacienteExistente(String documento) throws PacienteException {
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

    public boolean actualizarPaciente(Paciente paciente) throws PacienteException {
        if(pacienteExiste(paciente.getDocumento())){
            for (Paciente paciente1 : getPacientesLista()) {
                if(paciente1.getDocumento().equalsIgnoreCase(paciente.getDocumento())){
                    paciente1.setNombres(paciente.getNombres());
                    paciente1.setEdad(paciente.getEdad());
                    paciente1.setGenero(paciente.getGenero());
                    paciente1.setEmbarazada(paciente.getEmbarazada());
                    paciente1.setTemperatura(paciente.getTemperatura());
                    paciente1.setTensionArterial(paciente.getTensionArterial());
                    paciente1.setFrecuenciaRespiratoria(paciente.getFrecuenciaRespiratoria());
                    paciente1.setFrecuenciaCardiaca(paciente.getFrecuenciaCardiaca());
                    paciente1.setDiagnostico(paciente.getDiagnostico());
                    break;
                }
            }
            return true;
        }else{
            throw new PacienteException("El paciente con documento: "+paciente.getDocumento()+" no existe");
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

    public PriorityQueue<Paciente> getPacientesPrioridadAlta() {
        return pacientesPrioridadAlta;
    }

    public void setPacientesPrioridadAlta(PriorityQueue<Paciente> pacientesPrioridadAlta) {
        this.pacientesPrioridadAlta = pacientesPrioridadAlta;
    }

    public PriorityQueue<Paciente> getPacientesPrioridadMedia() {
        return pacientesPrioridadMedia;
    }

    public void setPacientesPrioridadMedia(PriorityQueue<Paciente> pacientesPrioridadMedia) {
        this.pacientesPrioridadMedia = pacientesPrioridadMedia;
    }

    public PriorityQueue<Paciente> getPacientesPrioridadBaja() {
        return pacientesPrioridadBaja;
    }

    public void setPacientesPrioridadBaja(PriorityQueue<Paciente> pacientesPrioridadBaja) {
        this.pacientesPrioridadBaja = pacientesPrioridadBaja;
    }

    public String getUsuarioLogueado() {
        return usuarioLogueado;
    }

    public void setUsuarioLogueado(String usuarioLogueado) {
        Urgencias.usuarioLogueado = usuarioLogueado;
    }
}
