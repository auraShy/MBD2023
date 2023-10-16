package org.uma.mbd.mdCoche.coches;

public class Coche {
    private String nombre;
    private double precio;
    static private double PIVA = 0.16;

    public Coche(String name, double price){
        nombre = name;
        precio = price;
    }

    public static void setPiva(double iva){
        PIVA = iva;
    }

    public double precioTotal(){
        return precio + precio*PIVA;
    }

    @Override
    public String toString(){
        return nombre + " -> " + this.precioTotal();
    }
}
