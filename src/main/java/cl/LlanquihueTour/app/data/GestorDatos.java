package cl.LlanquihueTour.app.data;
import cl.LlanquihueTour.app.model.CentrosPanoramicos;

import java.io.*;
import java.util.*;

public class GestorDatos {
    private static final String PANORAMAS_FILE = "resources/Panoramas.txt";
    private static CentrosPanoramicos[] lista;

    public GestorDatos() {crearDirectorio();}

    public void  crearDirectorio(){
        File dir = new File(PANORAMAS_FILE);
        if (!dir.exists()) {
            dir.mkdirs();
        }
    }

    public static void GuardarPanorama(CentrosPanoramicos centrosPanoramicos){
     try (BufferedWriter bw = new BufferedWriter(new FileWriter(PANORAMAS_FILE,true))){
         bw.write(centrosPanoramicos.toString());
         bw.newLine();
     }catch (IOException e){
         System.out.println("Ocurrio un error al guardar el panorama" + e.getMessage());
     }
    }

    public static void leer_archivo(ArrayList<CentrosPanoramicos> listaPanoramas) {
        try {
            BufferedReader leer = new BufferedReader(new FileReader("resources/Panoramas.txt"));
            String linea = "";
            while ((linea = leer.readLine()) != null) {
                String[] bloques = linea.split(";");
                String nombre = bloques[0].trim();
                String tipo = bloques[1].trim();
                String ubicacion = bloques[2].trim();
                int precioEstimado = Integer.parseInt(bloques[3].trim());

                CentrosPanoramicos NuevosPanoramas = new CentrosPanoramicos(nombre, tipo, ubicacion, precioEstimado);

                listaPanoramas.add(NuevosPanoramas);

            }
            leer.close();
        }catch (FileNotFoundException e){
            System.out.println("Error no se encuentre el archivo" + e.getMessage());

        }catch(IOException e) {
            System.out.println("Error al leer el archivo " + e.getMessage());
        }
    }
    public static CentrosPanoramicos eLiminarPanorama(ArrayList<CentrosPanoramicos> lista, String nombreBuscar){
        CentrosPanoramicos encontrado = null;

        for (CentrosPanoramicos p : lista) {
            if (p.getNombre().trim().equalsIgnoreCase(nombreBuscar)) {
                encontrado = p;
                break;
            }
        }
        if (encontrado !=null) {
            lista.remove(encontrado);

            try (BufferedWriter bw = new BufferedWriter(new FileWriter(PANORAMAS_FILE, false))){
                for (CentrosPanoramicos p : lista){
                    bw.write(p.toString());
                    bw.newLine();
                }
            }catch (IOException e) {
                System.out.println("Error al actualizar el archivo tras ser eliminado:" + e.getMessage());
            }
        }
        return encontrado;
    }
    public static CentrosPanoramicos buscarPanoramaPorNombre(ArrayList<CentrosPanoramicos> lista, String nombreBuscar){
        for (CentrosPanoramicos p: lista) {
            if (p.getNombre().trim().equalsIgnoreCase(nombreBuscar.trim())) {
                return p;
            }
        }
        return null;
    }
}
