package Libreria;

public class Libro {
    String titulo;
    Double precio;
    String autor;
    public Libro(String titulo,Double precio, String autor){
this.titulo = titulo;
this.precio = precio;
this.autor = autor;
    }
    public String obtenerLibro() {
        return String.format("Titulo: %s, precio: %f, autor: %s", 
                titulo,autor);
    }
}
