package cl.praxis.model;

import java.util.ArrayList;

//3) Generar una clase ProductoServicio que contendrá una ArrayList llamada
//listaProductos, con su respectivo getters y setters. Además, esta clase debe contar
//con el siguiente método y su respectiva aplicación: listarProductos y editarProductos.

public class ProductoServicio {
    private ArrayList<Producto> listaProductos;

    public ProductoServicio() {
    }

    public ProductoServicio(ArrayList<Producto> listaProductos) {
        this.listaProductos = listaProductos;
    }

    public ArrayList<Producto> getListaProductos() {
        return listaProductos;
    }

    public void setListaProductos(ArrayList<Producto> listaProductos) {
        this.listaProductos = listaProductos;
    }

    public void editarProductos(String codigo, int opcion, String nuevoValor) {
        for (Producto producto : listaProductos) {
            if (producto.getCodigo().equals(codigo)) {
                switch (opcion){
                    case 1:
                        producto.setArticulo(nuevoValor);
                        break;
                    case 2:
                        producto.setCodigo(nuevoValor);
                        break;
                    case 3:
                        producto.setColor(nuevoValor);
                        break;
                    case 4:
                        producto.setDescripcion(nuevoValor);
                        break;
                    case 5:
                        producto.setMarca(nuevoValor);
                        break;
                    case 6:
                        producto.setPrecio(nuevoValor);
                        break;
                    case 7:
                        producto.setTalla(nuevoValor);
                        break;
                }
            }
        }
    }

    public void listarProductos(){
        for (Producto producto : listaProductos){
            System.out.println(producto);
        }
    }

    public void agregarProducto(Producto producto) {
        listaProductos.add(producto);
    }
}
