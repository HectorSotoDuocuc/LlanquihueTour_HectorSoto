package cl.LlanquihueTour.app.model;

public class Guia extends Persona implements Registable{
    private int idTrabajador;
    private String tipoDeGuia;

    public Guia(String rut,String nombre, int edad,int idTrabajador, String tipoDeGuia) {
        super(rut,nombre,edad);
        this.idTrabajador = idTrabajador;
        this.tipoDeGuia = tipoDeGuia;
    }

    public int getIdTrabajador() {
        return idTrabajador;
    }

    public void setIdTrabajador(int idTrabajador) {
        this.idTrabajador = idTrabajador;
    }

    public String getTipoDeGuia() {
        return tipoDeGuia;
    }

    public void setTipoDeGuia(String tipoDeGuia) {
        this.tipoDeGuia = tipoDeGuia;
    }

    public void mostrarResumen(){
        System.out.println("Nombre De La Persona:" + nombre + ", Edad Del Guia:" + edad + ", Id Del Trabajador:" + idTrabajador +
                ", Tipo de Guia:" + tipoDeGuia);
    }

    @Override
    public void mostrarDatos() {

    }
}
