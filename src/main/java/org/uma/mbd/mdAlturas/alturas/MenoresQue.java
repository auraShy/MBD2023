package org.uma.mbd.mdAlturas.alturas;

public class MenoresQue implements Seleccion{
    private double alturaMax;

    public MenoresQue(double alturaMax){
        this.alturaMax = alturaMax;
    }

    @Override
    public boolean test(Pais pais) {
        return pais.altura() < this.alturaMax;
    }

    @Override
    public String toString(){
        return "Paises con la altura media inferior a " + alturaMax + ": ";
    }
}
