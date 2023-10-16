package org.uma.mbd.mdCoche.coches;

public class CocheImportado extends Coche{
    private double homologacion;
    public CocheImportado(String name, double price, double homolo){
        super(name,price);
        homologacion = homolo;
    }

    @Override
    public double precioTotal(){
        return super.precioTotal() + homologacion;
    }
}
