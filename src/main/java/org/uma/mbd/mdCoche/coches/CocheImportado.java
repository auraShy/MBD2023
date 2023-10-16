package org.uma.mbd.mdCoche.coches;

public class CocheImportado extends Coche{
    private double homologacion;
    public CocheImportado(String name, double price, double homolog){
        super(name,price);
        homologacion = homolog;
    }

    @Override
    public double precioTotal(){
        return super.precioTotal() + homologacion;
    }
}
