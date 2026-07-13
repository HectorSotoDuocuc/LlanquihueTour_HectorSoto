package cl.LlanquihueTour.app.model;

public class ExcursionCultural extends ServicioTuristico implements Registable{
    private String lugarHistorico;

    public ExcursionCultural(String nombre, double duracionHoras, String lugarHistorico) {
        super(nombre, duracionHoras);
        this.lugarHistorico = lugarHistorico;
    }

    public String getLugarHistorico() {
        return lugarHistorico;
    }

    public void setLugarHistorico(String lugarHistorico) {
        this.lugarHistorico = lugarHistorico;
    }

    @Override
    public void mostrarResumen() {
        super.mostrarResumen();
        System.out.println("Tipo: Excursion - " + "LugarHistorico: " + lugarHistorico);
    }
}
