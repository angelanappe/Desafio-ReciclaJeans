package cl.praxis.model;

import java.util.ArrayList;
import java.util.Scanner;

public class Menu {
    public static void main(String[] args) {
        ProductoServicio productoServicio = new ProductoServicio(new ArrayList<>());
        ArchivoServicio archivoServicio = new ArchivoServicio(productoServicio);
        Scanner sc = new Scanner(System.in);

        Menu menu = new Menu(productoServicio, archivoServicio, sc);
        menu.mostrarMenu();
    }

    private ProductoServicio productoServicio;
    private ArchivoServicio archivoServicio;
    private Scanner sc;

    public Menu() {
    }

    public Menu(ProductoServicio productoServicio, ArchivoServicio archivoServicio, Scanner sc) {
        this.productoServicio = productoServicio;
        this.archivoServicio = archivoServicio;
        this.sc = sc;
    }

    public void mostrarMenu() {
        int opcion;
        do {
            System.out.println("1. Listar Productos");
            System.out.println("2. Editar Datos");
            System.out.println("3. Importar Datos");
            System.out.println("4. Salir");
            System.out.print("Ingrese una opción: ");
            opcion = sc.nextInt();

            switch (opcion) {
                case 1:
                    listarProductos();
                    break;
                case 2:
                    editarDatos();
                    break;
                case 3:
                    importarDatos();
                    break;
                case 4:
                    System.out.println("Abandonando el sistema de clientes...");
                    System.out.println("Acaba de salir del sistema");
                    break;
                default:
                    System.out.println("La opción no es válida.");
            }
        } while (opcion != 4);
    }

    private void listarProductos() {
        productoServicio.listarProductos();
    }

    private void editarDatos() {
        System.out.println("Editar Producto");
        System.out.println("Ingrese el código del producto: ");
        sc.nextLine();
        String codigo = sc.nextLine();
        Producto producto = null;
        for (Producto p : productoServicio.getListaProductos()) {
            if (p.getCodigo().equals(codigo)) {
                producto = p;
                break;
            }
        }

        if (producto != null) {
            System.out.println("1.-El nombre del articulo actual es: " + producto.getArticulo());
            System.out.println("2.-El código del producto: " + producto.getCodigo());
            System.out.println("3.-El color del producto: " + producto.getColor());
            System.out.println("4.-La descripción del producto: " + producto.getDescripcion());
            System.out.println("5.-La marca del producto: " + producto.getMarca());
            System.out.println("6.-El precio del producto: " + producto.getPrecio());
            System.out.println("7.-La talla del producto: " + producto.getTalla());
            System.out.print("Ingrese la opción a editar de los datos del producto: ");
            int opcion = sc.nextInt();
            sc.nextLine();
            System.out.print("Ingrese el nuevo valor: ");
            String nuevoValor = sc.nextLine();
            productoServicio.editarProductos(codigo, opcion, nuevoValor);
        } else {
            System.out.println("Producto no encontrado.");
        }
    }

    private void importarDatos() {
        System.out.println("Cargar datos");
        System.out.println("Ingresa la ruta del archivo que quieres importar: ");
        sc.nextLine();
        String ruta = sc.nextLine();
        archivoServicio.cargarDatos(ruta);
    }
}
