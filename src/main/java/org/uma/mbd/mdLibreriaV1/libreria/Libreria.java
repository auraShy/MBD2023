package org.uma.mbd.mdLibreriaV1.libreria;

public class Libreria {
    private Libro [] libros;
    private int numLibros;
    private static final int TAM_DEFECTO = 16;

    public Libreria(){
        this(Libreria.TAM_DEFECTO);
    }

    public Libreria(int tam){
        libros = new Libro[tam];
        numLibros = 0; // no es necesario, las variables enteras se inicializan por defecto a 0
    }

    public void addLibro(String autor, String titulo, double precioBase){
        Libro libro = new Libro(autor,titulo,precioBase);

    }

    /*private void addLibro(Libro libro){
        //pos = posicionLibro(libro.getAutor(),libro.getTitulo(),libro.getPrecioBase());
        //if (pos=0){
            // el libro no esta
        }
        else{
            // el libro ya está
        }
    }*/
}
