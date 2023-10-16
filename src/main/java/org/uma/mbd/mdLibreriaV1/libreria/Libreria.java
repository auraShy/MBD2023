package org.uma.mbd.mdLibreriaV1.libreria;

import java.util.Arrays;

public class Libreria {

    private Libro [] libros;

    private int numLibros;

    private static final int TAM_DEFECTO = 16;

    public Libreria(int tamLibreria){
        libros = new Libro[tamLibreria];
        numLibros = 0;
    }

    public Libreria(){
        this(Libreria.TAM_DEFECTO);
        // this(TAM_DEFECTO);
    }

    public void addLibro(String autor, String titulo, double precioBase){
        Libro libro = new Libro(autor, titulo, precioBase);
        addLibro(libro);
    }

    private void addLibro(Libro libro) {
        int pos = posicionLibro(libro.getAutor(), libro.getTitulo());
        if (pos < 0) {
            // El libro no esta
            aseguraQueCabe();
            libros[numLibros] = libro;
            numLibros++;
        } else {
            // El libro esta
            libros[pos] = libro;
        }
    }

    private int posicionLibro(String autor, String titulo){
        int pos = 0;
        while(pos<numLibros && !(autor.equals(libros[pos].getAutor()) && (titulo.equals(libros[pos].getTitulo()))))
            pos++;
        return (pos == numLibros) ? -1 : pos;
    }

    private void aseguraQueCabe(){
        if (numLibros == libros.length){
            libros = Arrays.copyOf(libros, libros.length*2);
        }
    }

    public void remLibro(String autor, String titulo){
        int pos = posicionLibro(autor, titulo);
        if(pos >= 0)
        {
            for (int i = pos; i < numLibros - 1; i++)
                libros[i] = libros[i+1];
            numLibros--;
            libros[numLibros] = null;
        }
    }

    public double getPrecioBase(String autor, String titulo){
        int pos = posicionLibro(autor, titulo);
        return pos >= 0 ? libros[pos].getPrecioBase() : 0;
    }

    public double getPrecioFinal(String autor, String titulo){
        int pos = posicionLibro(autor, titulo);
        return pos >= 0 ? libros[pos].getPrecioFinal() : 0;
    }

    @Override
    public String toString(){
        String salida = "[";
        for (int i = 0; i < numLibros; i++){
            salida += libros[i];
            if (i < numLibros-1)
                salida += " ,";
        }
        salida += "]";
        return salida;
    }
}