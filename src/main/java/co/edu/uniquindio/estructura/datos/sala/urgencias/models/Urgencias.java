package co.edu.uniquindio.estructura.datos.sala.urgencias.models;

import co.edu.uniquindio.estructura.datos.sala.urgencias.enumms.Riesgo;

import java.util.*;
import java.util.stream.Collectors;

public class Urgencias {
    PriorityQueue<Paciente> colaDePrioridad;
    private List<Enfermera> enfermerasLista = new ArrayList<>();
    private List<Paciente> pacientesLista = new ArrayList<>();

    private List<Diagnostico> diagnosticos = new ArrayList<>();

    public Urgencias() {
        // Creamos la cola de prioridad con un comparador personalizado
        colaDePrioridad = new PriorityQueue<>(new Comparator<Paciente>() {
            @Override
            public int compare(Paciente p1, Paciente p2) {
                int prioridadP1 = p1.determinarPrioridad();
                int prioridadP2 = p2.determinarPrioridad();
                if (prioridadP1 != prioridadP2) {
                    // Si las prioridades son diferentes, retornar la diferencia
                    return Integer.compare(prioridadP1, prioridadP2);
                } else {
                    // Si las prioridades son iguales, comparar por riesgo del diagnóstico
                    int riesgoComparison = p1.getDiagnotico().getRiesgo().compareTo(p2.getDiagnotico().getRiesgo());
                    if (riesgoComparison != 0) {
                        return riesgoComparison;
                    } else {
                        // Si el riesgo es el mismo, comparar por edad
                        int edadComparison = Integer.compare(p1.getEdad(), p2.getEdad());
                        if (edadComparison != 0) {
                            return edadComparison;
                        } else {
                            // Si la edad es la misma, comparar por orden lexicográfico de nombres
                            return p1.getNombres().compareTo(p2.getNombres());
                        }
                    }
                }
            }
        });
    }

    public void agregarPaciente(Paciente paciente) {
        paciente.determinarPrioridad();
        colaDePrioridad.offer(paciente); // Agregar paciente a la cola
    }

    public void distribuirPacientes(Queue<Paciente> alto, Queue<Paciente> moderado, Queue<Paciente> bajo, Queue<Paciente> prioritario, Queue<Paciente> consultaExterna) {
        while (!estaVacia()) {
            Paciente paciente = atenderSiguientePaciente();
            switch (paciente.getDiagnotico().getRiesgo()) {
                case ALTO:
                    alto.offer(paciente);
                    break;
                case MODERADO:
                    moderado.offer(paciente);
                    break;
                case BAJO:
                    bajo.offer(paciente);
                    break;
                case PRIORITARIA:
                    prioritario.offer(paciente);
                    break;
                case CONSULTA_EXTERNA:
                    consultaExterna.offer(paciente);
                    break;
            }
        }
    }

    public void atenderPacientes(Queue<Paciente> pacientes) {
        while (!pacientes.isEmpty()) {
            Paciente pacienteAtendido = pacientes.poll();
            System.out.println("Atendiendo a: " + pacienteAtendido.getNombres() + " " + pacienteAtendido.getApellidos() + " - Diagnóstico: " + pacienteAtendido.getDiagnotico().getNombreDX() + " - Riesgo: " + pacienteAtendido.getDiagnotico().getRiesgo());
        }
    }


    public Paciente atenderSiguientePaciente() {
        Paciente pacienteAtendido = colaDePrioridad.poll(); // Atender al siguiente paciente en la cola

        if (pacienteAtendido != null && pacienteAtendido.determinarPrioridad() == 2) {
            // Si el paciente tiene prioridad media debido a discapacidad, volver a agregarlo a la cola con prioridad media
            colaDePrioridad.offer(pacienteAtendido);
            pacienteAtendido = colaDePrioridad.poll(); // Obtener el siguiente paciente con prioridad media o alta
        }

        return pacienteAtendido;
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
    public boolean estaVacia() {
        return colaDePrioridad.isEmpty();
    }

}
