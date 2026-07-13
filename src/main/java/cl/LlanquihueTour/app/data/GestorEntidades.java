package cl.LlanquihueTour.app.data;

import cl.LlanquihueTour.app.model.Guia;
import cl.LlanquihueTour.app.model.Provedor;
import cl.LlanquihueTour.app.model.Registable;
import cl.LlanquihueTour.app.model.RutaGastronomica;

import java.util.ArrayList;
import java.util.List;

public class GestorEntidades {
    List<Registable> entidades = new ArrayList<>();







    public void CargarEntidades() {
        entidades.add(new RutaGastronomica("A las Papas Fritas", 8,4));
        entidades.add(new Guia("15030213-4", "Fabian", 42,1503,"Explorador Turisticos"));
        entidades.add(new Provedor("2019382-2", "Camilo", 28, "Cervilletas y Higiene", "Productos"));



        for (Registable r : entidades) {
            r.mostrarResumen();

            if (r instanceof  RutaGastronomica rG) {
                System.out.println("-> Nombre: " + rG.getNombre() + "Numero De Paradas: " + rG.getNumeroDeParadas());
            }else if (r instanceof  Guia g) {
                System.out.println("-> Id Trabajador: " + g.getIdTrabajador() + "Tipo De Guia: " + g.getTipoDeGuia());
            }
        }
    }
}
