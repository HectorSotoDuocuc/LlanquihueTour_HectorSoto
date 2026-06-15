package cl.LlanquihueTour.app.ui;

import cl.LlanquihueTour.app.data.GestorDatos;
import cl.LlanquihueTour.app.model.CentrosPanoramicos;

import java.util.ArrayList;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    static void main(String[] args) {

        ArrayList<CentrosPanoramicos> lista = new ArrayList<>();

        GestorDatos gestor = new GestorDatos();

        gestor.leer_archivo(lista);

        System.out.println("Listado de Panoramas");

        for (CentrosPanoramicos cp : lista) {
            System.out.println(cp);
        }
        System.out.println("Filtrados Por Tipo");
        String TipoBuscar= "Restaurante";
        for (CentrosPanoramicos cp : lista){
            if (cp.getTipo().equals(TipoBuscar)){
                System.out.println(cp);
            }
        }
    }
}
