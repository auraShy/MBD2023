package org.uma.mbd.mdTesoro.tesoro;

import org.uma.mbd.mdRectas.rectas.Punto;
import org.uma.mbd.mdRectas.rectas.Recta;

public class Tesoro {
    private Punto palmeraAmarilla, palmeraAzul, palmeraRosa;
    private Punto estacaAmar, estacaAzul;
    private Punto tesoro;

    public Tesoro(Punto palmAmar, Punto palmAzul, Punto palmRosa){
        palmeraAmarilla = palmAmar;
        palmeraAzul = palmAzul;
        palmeraRosa = palmRosa;
    }

    private void calculaPosiciones(){
        Recta r1 = new Recta(palmeraRosa,palmeraAmarilla);
        Recta r2 = new Recta(palmeraRosa,palmeraAzul);
        //numero de pasos desde palmera rosa a palmera amarilla
        double npasos1 = palmeraRosa.distancia(palmeraAmarilla);
        //numero de pasos desde palmera rosa a palmera azul
        double npasos2 = palmeraRosa.distancia(palmeraAzul);
        // perpendicular que pasa por palmera amarilla
        Recta r1perpe = r1.perpendicularPor(palmeraAmarilla);
        // perpendicular que pasa por palmera azul
        Recta r2perpe = r2.perpendicularPor(palmeraAzul);

    }
}
