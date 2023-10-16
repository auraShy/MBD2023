package org.uma.mbd.mdLibreriaV2L.libreria;

import java.util.Arrays;

public class LibreriaOferta extends Libreria {
    private double descuento;
    private String [] autoresEnOferta;

    public LibreriaOferta(double d, String [] aeo){
        // si no pones nada se llama al super sin argumentos
        descuento = d;
        autoresEnOferta = aeo;
    }

    public void setOferta(double d, String [] aeo){
        descuento = d;
        autoresEnOferta = aeo;
    }

    public double getDescuento(){
        return descuento;
    }

    public String[] getOferta(){
        return autoresEnOferta;
    }


    public void addLibro(String autor, String titulo, double precioBase){
        boolean aeo = esAutorEnOferta(autor);
        Libro libro = null;
        if(aeo)
            libro = new LibroEnOferta(autor,titulo,precioBase,descuento);

        else
            libro = new Libro(autor,titulo,precioBase);

        addLibro(libro);
    }

    private boolean esAutorEnOferta(String autor){
        int pos = 0;
        while (pos < autoresEnOferta.length && !autoresEnOferta[pos].equalsIgnoreCase(autor))
            pos ++;
        return  pos < autoresEnOferta.length; // si pos es menor que lenght sq lo he encontrado y devuelve true
    }

    @Override
    public String toString() {
        return descuento + "%" + Arrays.toString(autoresEnOferta) + super.toString();
    }
}
