package cl.LlanquihueTour.app.model;

public class Provedor extends Persona implements Registable{
    private String nombreDelProducto;
    private String tipoDeProvedor;

    public Provedor(String rut, String nombre, int edad, String nombreDelProducto, String tipoDeProvedor) {
        super(rut, nombre, edad);
        this.nombreDelProducto = nombreDelProducto;
        this.tipoDeProvedor = tipoDeProvedor;
    }

    public String getNombreDelProducto() {
        return nombreDelProducto;
    }

    public void setNombreDelProducto(String nombreDelProducto) {
        this.nombreDelProducto = nombreDelProducto;
    }

    public String getTipoDeProvedor() {
        return tipoDeProvedor;
    }

    public void setTipoDeProvedor(String tipoDeProvedor) {
        this.tipoDeProvedor = tipoDeProvedor;
    }

    @Override
    public void mostrarDatos() {

    }

    @Override
    public void mostrarResumen() {
        System.out.println("Nombre Del Provedor:" + nombre + ", Edad: " + edad + ", Nombre Del Producto:" + nombreDelProducto +
                ", Tipo De Provedor:" + tipoDeProvedor);
    }
}
