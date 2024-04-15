package co.edu.uniquindio.estructura.datos.sala.urgencias.utils;

import co.edu.uniquindio.estructura.datos.sala.urgencias.models.Urgencias;

public class Persistencia {

    public static final String RUTA_ARCHIVO_LOG = "src/main/resources/co/edu/uniquindio/estructura/datos/sala/urgencias/log/Log.txt";
    public static final String RUTA_ARCHIVO_MODELO_URGENCIAS_XML = "src/main/resources/co/edu/uniquindio/estructura/datos/sala/urgencias/modelo.xml";

    public static void guardaRegistroLog(String mensajeLog, int nivel, String accion) {
        ArchivoUtil.guardarRegistroLog(mensajeLog, nivel, accion, RUTA_ARCHIVO_LOG);
    }
    public static Urgencias cargarRecursoSubastaXML() {

        Urgencias urgencias = null;

        try {
            urgencias = (Urgencias) ArchivoUtil.cargarRecursoSerializadoXML(RUTA_ARCHIVO_MODELO_URGENCIAS_XML);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return urgencias;

    }


    public static void guardarRecursoSubastaXML(Urgencias urgencias) {

        try {
            ArchivoUtil.salvarRecursoSerializadoXML(RUTA_ARCHIVO_MODELO_URGENCIAS_XML, urgencias);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
