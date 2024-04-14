package co.edu.uniquindio.estructura.datos.sala.urgencias.models;

import co.edu.uniquindio.estructura.datos.sala.urgencias.enumms.Genero;
import co.edu.uniquindio.estructura.datos.sala.urgencias.enumms.Opcion;
import co.edu.uniquindio.estructura.datos.sala.urgencias.utils.UrgenciasUtils;

public class PacientePriority {

    public static void main(String[] args) {
        Urgencias urgencias = UrgenciasUtils.inicializarDatos();

        // Crear pacientes
        Paciente paciente1 = new Paciente("Juan", "Pérez", "123456", 35, Genero.MASCULINO, null, null, "36.5", "120/80", "18", "70", "98%", urgencias.getDiagnosticos().get(0));
        Paciente paciente2 = new Paciente("María", "López", "789012", 25, Genero.FEMENINO, Opcion.SI, null, "37.0", "130/90", "20", "75", "95%", urgencias.getDiagnosticos().get(2));
        Paciente paciente3 = new Paciente("Pedro", "García", "345678", 70, Genero.MASCULINO, Opcion.SI, null, "36.0", "110/70", "15", "65", "92%", urgencias.getDiagnosticos().get(3));
        Paciente paciente4 = new Paciente("Ana", "Martínez", "901234", 45, Genero.FEMENINO, null, null, "36.8", "125/85", "16", "68", "96%", urgencias.getDiagnosticos().get(1));
        Paciente paciente5 = new Paciente("Carlos", "Gómez", "567890", 20, Genero.MASCULINO, null, null, "36.9", "122/78", "19", "72", "97%", urgencias.getDiagnosticos().get(4));
        Paciente paciente6 = new Paciente("Laura", "Hernández", "234567", 50, Genero.FEMENINO, null, null, "36.7", "128/82", "17", "71", "99%", urgencias.getDiagnosticos().get(5));
        Paciente paciente7 = new Paciente("David", "Ramírez", "678901", 60, Genero.MASCULINO, null, null, "37.1", "135/95", "21", "78", "93%", urgencias.getDiagnosticos().get(3));
        Paciente paciente8 = new Paciente("Sofía", "Díaz", "345678", 15, Genero.FEMENINO, null, Opcion.SI, "36.2", "115/75", "14", "63", "90%", urgencias.getDiagnosticos().get(4));
        Paciente paciente9 = new Paciente("Mateo", "Pérez", "987654", 22, Genero.MASCULINO, null, null, "37.2", "140/100", "22", "80", "94%", urgencias.getDiagnosticos().get(1));
        Paciente paciente10 = new Paciente("Camila", "González", "456789", 30, Genero.FEMENINO, null, null, "36.6", "130/85", "19", "74", "98%", urgencias.getDiagnosticos().get(0));

        // Agregar pacientes a la cola de prioridad
        urgencias.agregarPaciente(paciente1);
        urgencias.agregarPaciente(paciente2);
        urgencias.agregarPaciente(paciente3);
        urgencias.agregarPaciente(paciente4);
        urgencias.agregarPaciente(paciente5);
        urgencias.agregarPaciente(paciente6);
        urgencias.agregarPaciente(paciente7);
        urgencias.agregarPaciente(paciente8);
        urgencias.agregarPaciente(paciente9);
        urgencias.agregarPaciente(paciente10);

        // Atender pacientes y mostrar información
        int pacientesAtendidos = 0;
        while (pacientesAtendidos < 10) {
            Paciente pacienteAtendido = urgencias.atenderSiguientePaciente();
            pacientesAtendidos++;
        }
    }
}



