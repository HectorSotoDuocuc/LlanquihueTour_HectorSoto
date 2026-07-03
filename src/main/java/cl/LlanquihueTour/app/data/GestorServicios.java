package cl.LlanquihueTour.app.data;

import cl.LlanquihueTour.app.model.ExcursionCultural;
import cl.LlanquihueTour.app.model.PaseoLacustre;
import cl.LlanquihueTour.app.model.RutaGastronomica;
import cl.LlanquihueTour.app.model.ServicioTuristico;

import java.util.ArrayList;
import java.util.List;

public class GestorServicios {
    private List<ServicioTuristico> servicios;

    public GestorServicios() {
        servicios = new ArrayList<>();
        cargarServicios();
    }

    private void cargarServicios() {
        servicios.add(new RutaGastronomica("las Vegas", 8, 4));
        servicios.add(new RutaGastronomica("El Frances", 4, 2));
        servicios.add(new ExcursionCultural("Excursion LLanquihue", 1, "Mueso Llanquihue"));
        servicios.add(new ExcursionCultural("Excursion Torres Paine", 12, "Torres Del Paine"));
        servicios.add(new PaseoLacustre("Paseo Glaciar Antiguo", 4, "Barco Pesquero"));
    }

    public List <ServicioTuristico> obtenerServicios(){
        return servicios;
    }
}
