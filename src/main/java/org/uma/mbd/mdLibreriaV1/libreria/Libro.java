package org.uma.mbd.mdLibreriaV1.libreria;

public class Libro {
    private String autor;
    private String titulo;
    private double precioBase;
    private static double IVA;

    public Libro(String aut, String tit, double precio){
        autor = aut;
        titulo = tit;
        precioBase = precio;

    }

    public String getAutor() {
        return autor;
    }

    public String getTitulo() {
        return titulo;
    }

    public double getPrecioBase() {
        return precioBase;
    }

    public double getPrecioFinal(){
        return precioBase + precioBase*Libro.IVA/100;
    }

    public static double getIVA() {
        return IVA;
    }

    public static void setIVA(double iva) {
        Libro.IVA = iva;
    }

    @Override
    public String toString(){
        return "(" + autor + "; " + titulo + "; " + precioBase + "; " + Libro.IVA + "%; " + this.getPrecioFinal() + ")";
    }
}
