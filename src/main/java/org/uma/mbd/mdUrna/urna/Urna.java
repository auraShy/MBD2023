package org.uma.mbd.mdUrna.urna;

import java.util.NoSuchElementException;
import java.util.Random;

public class Urna {
    private  int negras, blancas;
    private static Random alea  = new Random();

    public Urna(int nblancas, int nnegras){
        if (nblancas<0 || nnegras<0)
            throw new IllegalArgumentException("El numero de bolas no puede ser inferior a 0");
        negras = nnegras;
        blancas = nblancas;
    }

    static public enum ColorBola{Negra,Blanca}

    public int totalBolas(){
        return negras + blancas;
    }

    public ColorBola extraerBola(){
        ColorBola BolaSacada = null;
        if (this.totalBolas() == 0)
            throw new NoSuchElementException("No hay bolas en la urna");
        if(alea.nextInt(this.totalBolas()) < blancas){
            BolaSacada = ColorBola.Blanca;
            blancas --;
        }
        else {
            BolaSacada = ColorBola.Negra;
            negras--;
        }

        return BolaSacada;
    }

    public void ponerBlanca(){
        blancas ++;
    }

    public void ponerNegra(){
        negras ++;
    }

    @Override
    public String toString(){
        return "Urna( Bolas Blancas: " + blancas + "; Bolas Negras: " + negras + ")";
    }
}
