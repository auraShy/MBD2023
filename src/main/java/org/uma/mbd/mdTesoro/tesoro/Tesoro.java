package org.uma.mbd.mdTesoro.tesoro;

import org.uma.mbd.mdRectas.rectas.Punto;
import org.uma.mbd.mdRectas.rectas.Recta;
import org.uma.mbd.mdRectas.rectas.Vector;

public class Tesoro {
    private Punto palmeraAmarilla, palmeraAzul, palmeraRosa;
    private Punto estacaAmarilla, estacaAzul;
    private Punto tesoro;

    public Tesoro(Punto palmAmar, Punto palmAzul, Punto palmRosa){
        palmeraAmarilla = palmAmar;
        palmeraAzul = palmAzul;
        palmeraRosa = palmRosa;
    }

    private void calculaPosiciones(){
        Vector v1 = new Vector(palmeraRosa,palmeraAmarilla);
        Vector v2 = new Vector(palmeraRosa,palmeraAzul);
        // perpendicular que pasa por palmera amarilla
        Vector v1perpe = v1.ortogonal();
        // perpendicular que pasa por palmera azul
        Vector v2perpe = v2.ortogonal().ortogonal().ortogonal();
        // Posiciones de las estacas
        estacaAmarilla = v1perpe.extremoDesde(palmeraAmarilla);
        estacaAzul = v2perpe.extremoDesde(palmeraAzul);
        // Poscion del tesoro
        tesoro = new Punto((estacaAmarilla.getX()+estacaAzul.getX())/2,(estacaAmarilla.getY()+estacaAzul.getY())/2);

    }
    public void  setPalmeraAmarilla(Punto p){
        palmeraAmarilla = p;
        calculaPosiciones();
    }
    public void setPalmeraAzul(Punto p){
        palmeraAzul = p;
        calculaPosiciones();
    }

    public void setPalmeraRosa(Punto p){
        palmeraRosa = p;
        calculaPosiciones();
    }

    public Punto getEstacaAmararilla() {
        calculaPosiciones();
        return estacaAmarilla;
    }

    public Punto getEstacaAzul(){
        calculaPosiciones();
        return estacaAzul;
    }

    public Punto getTesoro(){
        calculaPosiciones();
        return tesoro;
    }
}
