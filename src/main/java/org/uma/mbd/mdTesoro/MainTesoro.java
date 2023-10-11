package org.uma.mbd.mdTesoro;

import org.uma.mbd.mdRectas.rectas.Punto;
import org.uma.mbd.mdTesoro.tesoro.Tesoro;

public class MainTesoro {
    public static void main(String[] args) {
        double a1 = Double.parseDouble(args[0]);
        double a2 = Double.parseDouble(args[1]);
        double a3 = Double.parseDouble(args[2]);
        double a4 = Double.parseDouble(args[3]);
        double a5 = Double.parseDouble(args[4]);
        double a6 = Double.parseDouble(args[5]);

        Punto palmAmar = new Punto(a1, a2);
        Punto palmAzul = new Punto(a3, a4);
        Punto palmRosa = new Punto(a5, a6);

        Tesoro tes = new Tesoro(palmAmar, palmAzul, palmRosa);

        Punto estacaAmarilla = tes.getEstacaAmararilla();
        Punto estacaAzul = tes.getEstacaAzul();
        Punto tesoro = tes.getTesoro();

        System.out.println(estacaAmarilla);
        System.out.println(estacaAzul);
        System.out.println(tesoro);
    }
}