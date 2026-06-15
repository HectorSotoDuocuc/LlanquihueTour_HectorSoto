package cl.LlanquihueTour.app.data;
import cl.LlanquihueTour.app.model.CentrosPanoramicos;

import java.io.*;
import java.util.*;

public class GestorDatos {
    private static final String PANORAMAS_FILE = "resources/Panoramas.txt";

    public GestorDatos() {crearDirectorio();}

    public void  crearDirectorio(){
        File dir = new File(PANORAMAS_FILE);
        if (!dir.exists()) {
            dir.mkdirs();
        }
    }

    public static void leer_archivo(ArrayList<CentrosPanoramicos> listaPanoramas) {
        try {
            BufferedReader leer = new BufferedReader( new FileReader("resources/Panoramas.txt"));
            String linea = "";
            while ((linea = leer.readLine()) != null){
                String[] bloques = linea.split(";");
                String nombre = bloques[0];
                String tipo = bloques[1];
                String ubicacion = bloques[2];
                Double precioEstimado = Double.parseDouble(bloques[3]);

                CentrosPanoramicos NuevosPanoramas = new CentrosPanoramicos(nombre,tipo,ubicacion,precioEstimado);

                listaPanoramas.add(NuevosPanoramas);

            }
            leer.close();

        }catch(IOException e) {
            System.out.println("Error al leer el archivo " + e.getMessage());
        }
    }
}
