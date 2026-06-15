package cl.LlanquihueTour.app.model;

import java.util.ArrayList;

public class CentrosPanoramicos {

    private String nombre;

    private String tipo;

    private String ubicacion;

    private Double precioEstimado;

    private ArrayList<CentrosPanoramicos> listaPanoramas;


    public CentrosPanoramicos(String nombre, String tipo, String ubicacion, double precioEstimado) {
        this.nombre = nombre;
        this.tipo = tipo;
        this.ubicacion = ubicacion;
        this.precioEstimado = precioEstimado;
        this.listaPanoramas = new ArrayList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public Double getPrecioEstimado() {
        return precioEstimado;
    }

    public void setPrecioEstimado(Double precioEstimado) {
        this.precioEstimado = precioEstimado;
    }

    public ArrayList<CentrosPanoramicos> getListaParonamas() {
        return listaPanoramas;
    }

    public void setListaParonamas(ArrayList<CentrosPanoramicos> listaParonamas){
        this.listaPanoramas = listaParonamas;
    }

    public void agregarPanorama(CentrosPanoramicos centrosPanoramicos) {listaPanoramas.add(centrosPanoramicos);}

    public void eliminarPanorama(CentrosPanoramicos centrosPanoramicos){
        listaPanoramas.removeIf(cp -> cp.getNombre().equals(centrosPanoramicos.getNombre()));
    }

    public CentrosPanoramicos buscarPanorama(String nombre){
        return listaPanoramas.stream()
                .filter(cp -> cp.getNombre().equals(nombre))
                .findFirst()
                .orElse(null);
    }

    @Override
    public String toString() {
        return "CentrosParonamicos:" +
                "nombre:'" + nombre + '\'' +
                ", tipo:'" + tipo + '\'' +
                ", ubicacion:'" + ubicacion + '\'' +
                ", precioEstimado:" + precioEstimado;
    }
}
