package co.edu.uniquindio.estructura.datos.sala.urgencias.models;

import co.edu.uniquindio.estructura.datos.sala.urgencias.enumms.Riesgo;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
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
        colaDePrioridad.offer(paciente); // Agregar paciente a la cola
    }

    public Paciente atenderSiguientePaciente() {
        Paciente pacienteAtendido = null;

        // Buscar y atender a pacientes con riesgo ALTO primero
        while (!colaDePrioridad.isEmpty()) {
            Paciente paciente = colaDePrioridad.poll(); // Obtener el siguiente paciente en la cola
            if (paciente.getDiagnotico().getRiesgo() == Riesgo.ALTO) {
                pacienteAtendido = paciente;
                break; // Salir del bucle al encontrar un paciente de alto riesgo
            }
            // Si el paciente no es de alto riesgo, agregarlo nuevamente a la cola
            colaDePrioridad.offer(paciente);
        }

        // Si no se encontraron pacientes de alto riesgo, buscar pacientes con otros tipos de riesgo
        if (pacienteAtendido == null) {
            while (!colaDePrioridad.isEmpty()) {
                Paciente paciente = colaDePrioridad.poll(); // Obtener el siguiente paciente en la cola
                if (paciente.getDiagnotico().getRiesgo() != Riesgo.ALTO) {
                    pacienteAtendido = paciente;
                    break; // Salir del bucle al encontrar un paciente con otro tipo de riesgo
                }
                // Si el paciente es de alto riesgo, agregarlo nuevamente a la cola
                colaDePrioridad.offer(paciente);
            }
        }

        // Mostrar información del paciente atendido
        if (pacienteAtendido != null) {
            System.out.println("Atendiendo a: " + pacienteAtendido.getNombres() + " " + pacienteAtendido.getApellidos() + " - Diagnóstico: " + pacienteAtendido.getDiagnotico().getNombreDX() + " - Riesgo: " + pacienteAtendido.getDiagnotico().getRiesgo());
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

}
