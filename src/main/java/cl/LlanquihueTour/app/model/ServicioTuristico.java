package cl.LlanquihueTour.app.model;

public class ServicioTuristico implements Registable{
    protected String nombre;
    protected double duracionHoras;

    public ServicioTuristico(String nombre, double duracionHoras) {
        this.nombre = nombre;
        this.duracionHoras = duracionHoras;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getDuracionHoras() {
        return duracionHoras;
    }

    public void setDuracionHoras(double duracionHoras) {
        this.duracionHoras = duracionHoras;
    }

    public void mostrarInformacion() {
        System.out.println(nombre
        + " -Duracion: " + duracionHoras + " Horas");
    }

    @Override
    public void mostrarResumen() {

    }
}
