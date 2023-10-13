package org.uma.mbd.mdUrna;

import org.uma.mbd.mdUrna.urna.Urna;

public class MainUrna {
    public static void main(String[] args) {
        Urna u1 = new Urna(5,6);
        u1.extraerBola();
        u1.extraerBola();
        u1.extraerBola();
        u1.extraerBola();
        u1.ponerBlanca();
        u1.ponerNegra();
        System.out.println(u1);
    }
}
