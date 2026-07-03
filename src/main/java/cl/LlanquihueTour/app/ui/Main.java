package cl.LlanquihueTour.app.ui;

import cl.LlanquihueTour.app.data.GestorDatos;
import cl.LlanquihueTour.app.data.GestorServicios;
import cl.LlanquihueTour.app.model.CentrosPanoramicos;
import cl.LlanquihueTour.app.model.RutaGastronomica;
import cl.LlanquihueTour.app.model.ServicioTuristico;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static Scanner scanner;


    static void main(String[] args) {
        scanner = new Scanner(System.in);
        GestorServicios gestor1 = new GestorServicios();


        ArrayList<CentrosPanoramicos> lista = new ArrayList<>();

        GestorDatos gestor = new GestorDatos();

        gestor.leer_archivo(lista);
        mostrarMenu(lista, gestor1);
        scanner.close();

    }

    public static void mostrarMenu(ArrayList<CentrosPanoramicos> lista, GestorServicios gestor1) {
        boolean salir = false;
        while (!salir) {
            System.out.println("Menu Principal");
            System.out.println("1. Agregar Panorama");
            System.out.println("2. Eliminar Panorama");
            System.out.println("3. Buscar Panorama");
            System.out.println("4. Mostrar Todo los Panoramas");
            System.out.println("5. Mostrar Todo Los Servicios Turisticos");
            System.out.println("6. Salir");

            System.out.println("Selecione una Opción:");
            String opcion = scanner.nextLine();
            switch (opcion) {
                case "1":
                    agregarPanorama(lista);
                    break;
                case "2":
                    eliminarPanorama(lista);
                    break;
                case "3":
                    buscarPanorama(lista);
                    break;
                case "4":
                    mostrarPanoramas(lista);
                    break;
                case "5":
                    mostrarServiciosTuristicos(gestor1.obtenerServicios());
                case "6":
                    salir = true;
                    break;
                default:
                    System.out.println("Opcion no valida");
                    break;
            }
        }

    }

    public static CentrosPanoramicos agregarPanorama(ArrayList<CentrosPanoramicos> Agregarlista) {
        System.out.println("Ingrese Nuevo Panorama");
        System.out.println("Nombre Panorama:");
        String nombre = scanner.nextLine();
        System.out.println("Tipo De Panorama:");
        String tipo = scanner.nextLine();
        System.out.println("Ubicacion De Panorama:");
        String ubicacion = scanner.nextLine();
        System.out.println("Precio Estimado Del Panorama:");
        int precioEstimado = scanner.nextInt();
        scanner.nextLine();

        CentrosPanoramicos nuevoPanorama = new CentrosPanoramicos(nombre, tipo, ubicacion, precioEstimado);
        Agregarlista.add(nuevoPanorama);
        GestorDatos.GuardarPanorama(nuevoPanorama);
        return nuevoPanorama;
    }

    public static void eliminarPanorama(ArrayList<CentrosPanoramicos> EleminarLista) {
        System.out.println("Ingrese el nombre para eleminar el panorama:");
        String eliminar = scanner.nextLine();

        CentrosPanoramicos eliminado = GestorDatos.eLiminarPanorama(EleminarLista, eliminar);

        if (eliminado != null) {
            System.out.println(eliminado.getNombre() + "fue eliminado con éxito");
        } else {
            System.out.println("No se ha encontrado ningun panorama con ese nombre.");
        }
    }

    public static void buscarPanorama(ArrayList<CentrosPanoramicos> listaBuscar) {
        System.out.println("Ingrese El Nombre Del Panorama:");
        String buscar = scanner.nextLine();

        CentrosPanoramicos encontrado = GestorDatos.buscarPanoramaPorNombre(listaBuscar, buscar);

        if (encontrado != null) {
            System.out.println("Panorama Encontrado:");

            System.out.println(encontrado);
        } else {
            System.out.println("No se ha encontrado ningun panorama con ese nombre" + buscar);
        }
    }
    public static void mostrarPanoramas(ArrayList<CentrosPanoramicos> listaBuscar){

        if (!listaBuscar.isEmpty()){
            System.out.println("Mostrando Todo los Panoramas");

            for (CentrosPanoramicos panorama : listaBuscar){
                System.out.println(panorama);
            }
        }else {
            System.out.println("No se ha agregado ningun panorama");
        }
    }
    public static void mostrarServiciosTuristicos(List<ServicioTuristico> obtenerServicios){
        if (obtenerServicios == null || obtenerServicios.isEmpty()) {
            System.out.println("No Hay Servicios Turisticos registrados.");
            return;
        }
        for (ServicioTuristico servicio : obtenerServicios) {
            servicio.mostrarInformacion();
        }
    }
}
