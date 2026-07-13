package cl.LlanquihueTour.app.ui;

import cl.LlanquihueTour.app.data.GestorDatos;
import cl.LlanquihueTour.app.data.GestorServicios;
import cl.LlanquihueTour.app.model.CentrosPanoramicos;
import cl.LlanquihueTour.app.model.*;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main extends JFrame {
    private static Scanner scanner;
    private ArrayList<Registable> listaRegistros = new ArrayList<>();
    private JTextArea mostrarResultados;
    public Main(){
        super("Llanqihue Tour - Registro De Identidades");

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(950,400);
        setLocationRelativeTo(null);

        mostrarResultados = new JTextArea();
        mostrarResultados.setEditable(false);
        JScrollPane scrollResultados = new JScrollPane(mostrarResultados);
        scrollResultados.setBorder(BorderFactory.createTitledBorder("Registros Guardados"));

        JPanel panelPrincipal = new JPanel(new GridLayout(1, 2, 10, 10));
        JPanel panelSuperior = new JPanel();
        String[] opciones = {"Ruta Gastronomica","Guia","Provedor"};
        JComboBox<String> tipoDeIdentidad = new JComboBox<>(opciones);
        panelSuperior.add(tipoDeIdentidad);

        JPanel panelFormularios = new JPanel(new BorderLayout());


        tipoDeIdentidad.addActionListener(e -> {
            String seleccion = (String) tipoDeIdentidad.getSelectedItem();

            panelFormularios.removeAll();
            switch (seleccion) {
                case "Ruta Gastronomica":
                    panelFormularios.add(guardarRutaGastronomica(), BorderLayout.CENTER);
            break;
                case "Guia":
                    panelFormularios.add(guardarGuia(), BorderLayout.CENTER);
            break;
                case "Provedor":
                    panelFormularios.add(guardarProvedor(),BorderLayout.CENTER);
            break;
            }
            panelFormularios.revalidate();
            panelFormularios.repaint();});
        JPanel contenedorIzquierdo = new JPanel(new BorderLayout());
        contenedorIzquierdo.add(panelSuperior, BorderLayout.NORTH);
        contenedorIzquierdo.add(panelFormularios, BorderLayout.CENTER);

        panelPrincipal.add(contenedorIzquierdo);
        panelPrincipal.add(scrollResultados);
        super.add(panelPrincipal);

    }
    private JPanel guardarRutaGastronomica() {

        JTextField nombre = new JTextField();
        JTextField duracionHoras = new JTextField();
        JTextField numeroDeParadas = new JTextField();


        JPanel form = new JPanel(new GridLayout(0,2,10,10));
        form.setBorder(BorderFactory.createTitledBorder("Nueva Ruta Gastronomica"));
        form.add(new JLabel("nombre:")); form.add(nombre);
        form.add(new JLabel("duracionHoras:")); form.add(duracionHoras);
        form.add(new JLabel("NumeroDeParadas:")); form.add(numeroDeParadas);


        JButton  btnGuardar = new JButton("Guardar Ruta Gastronomica");
        btnGuardar.addActionListener(e -> {
            try{
                RutaGastronomica Ruta1 = new RutaGastronomica(
                        nombre.getText(),
                        Integer.parseInt(duracionHoras.getText()),Integer.parseInt(numeroDeParadas.getText())
                );

                listaRegistros.add(Ruta1);



                for (Registable r :listaRegistros) {
                    r.mostrarResumen();
                if (r instanceof RutaGastronomica rg) {

                    mostrarResultados.append("Ruta Gastronomica:" + rg.getNombre() +
                                             " | Duracion Horas" + rg.getDuracionHoras() +
                                             " | Numero De Paradas Gastronomicas:" + rg.getNumeroDeParadas() + "\n");
                }
                }
            }catch (NumberFormatException ex){
                JOptionPane.showMessageDialog(this, "Por Favor Ingrese los datos correctamente,","Error", JOptionPane.ERROR_MESSAGE);
            }});
        form.add(new JLabel(""));
        form.add(btnGuardar);
        return form;

    }
    private JPanel guardarGuia() {

        JTextField rut = new JTextField();
        JTextField nombre = new JTextField();
        JTextField edad = new JTextField();
        JTextField idTrabajador = new JTextField();
        JTextField tipoDeGuia = new JTextField();

        JPanel form = new JPanel(new GridLayout(0,2,10,10));
        form.setBorder(BorderFactory.createTitledBorder("Nuevo Guia"));
        form.add(new JLabel("Rut:")); form.add(rut);
        form.add(new JLabel("nombre:")); form.add(nombre);
        form.add(new JLabel("edad:")); form.add(edad);
        form.add(new JLabel("idTrabajador:")); form.add(idTrabajador);
        form.add(new JLabel("tipoDeGuia:")); form.add(tipoDeGuia);

        JButton btnGuardar = new JButton("Guardar Guia");
        btnGuardar.addActionListener(e -> {
            try {
                Guia guia1 = new Guia(
                        rut.getText(),nombre.getText(),Integer.parseInt(edad.getText()), Integer.parseInt(idTrabajador.getText()),tipoDeGuia.getText()
                );
                listaRegistros.add(guia1);
                for (Registable r :listaRegistros) {
                    r.mostrarResumen();
                    if (r instanceof Guia ga) {
                        mostrarResultados.append("Rut:" + ga.getRut() + " | Nombre:" + ga.getNombre() +
                                " | edad:"  + ga.getEdad() + " | Id Del Trabajador:" + ga.getIdTrabajador() +
                                " | Tipo De Guia:" + ga.getTipoDeGuia() + "\n");
                    }
                }
            }catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Por Favor Ingrese los datos correctamente,","Error", JOptionPane.ERROR_MESSAGE);
            }
        });
        form.add(new JLabel(""));
        form.add(btnGuardar);
        return form;
    }
    private JPanel guardarProvedor() {
        JTextField rut = new JTextField();
        JTextField nombre = new JTextField();
        JTextField edad = new JTextField();
        JTextField nombreDelProducto = new JTextField();
        JTextField tipoDeProvedor = new JTextField();

        JPanel form = new JPanel(new GridLayout(0,2,10,10));
        form.setBorder(BorderFactory.createTitledBorder("Nuevo Provedor"));
        form.add(new JLabel("Rut:")); form.add(rut);
        form.add(new JLabel("Nombre:")); form.add(nombre);
        form.add(new JLabel("Edad:")); form.add(edad);
        form.add(new JLabel("Nombre Del Producto:")); form.add(nombreDelProducto);
        form.add(new JLabel("Tipo de Provedor:")); form.add(tipoDeProvedor);

        JButton btnGuardar = new JButton("Guardar Guia");
        btnGuardar.addActionListener(e -> {
            try {
                Provedor provedor1 = new Provedor(
                        rut.getText(),nombre.getText(),Integer.parseInt(edad.getText()), nombreDelProducto.getText() ,tipoDeProvedor.getText());
                listaRegistros.add(provedor1);
                for (Registable r :listaRegistros) {
                    r.mostrarResumen();
                    if (r instanceof Provedor pv) {
                        mostrarResultados.append("Rut:" + pv.getRut() + " | Nombre:" + pv.getNombre() +
                                " | edad:"  + pv.getEdad() + " | Nombre Del Producto:" + pv.getNombreDelProducto() +
                                " | Tipo De Provedor:" + pv.getTipoDeProvedor() + "\n");
                    }
                }
            }catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Por Favor Ingrese los datos correctamente,","Error", JOptionPane.ERROR_MESSAGE);
            }
        });
        form.add(new JLabel(""));
        form.add(btnGuardar);
        return form;
    }

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
            System.out.println("6. Modo Interfaz");
            System.out.println("7. Salir");

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
                    break;
                case "6":
                    SwingUtilities.invokeLater(() ->  {
                        new Main().setVisible(true);
                    });
                    case "7":
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
