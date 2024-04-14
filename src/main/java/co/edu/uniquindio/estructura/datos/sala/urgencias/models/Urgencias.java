package co.edu.uniquindio.estructura.datos.sala.urgencias.models;

import java.util.ArrayList;
import java.util.List;

public class Urgencias {

    private List<Enfermera> enfermerasLista = new ArrayList<>();
    private List<Paciente> pacientesLista = new ArrayList<>();

    private List<Diagnostico> diagnosticos = new ArrayList<>();

    public Urgencias(){

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
