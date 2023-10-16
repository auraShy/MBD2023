package org.uma.mbd.mdUrna;

import org.uma.mbd.mdUrna.urna.Urna;

public class MainUrna {
    public static void main(String[] args) {
        int b1 = Integer.parseInt(args[0]);
        int b2 = Integer.parseInt(args[1]);

        Urna u1 = new Urna(b1,b2);
        Urna.ColorBola colorUltimaBola = null;

        while (u1.totalBolas() > 1){

            Urna.ColorBola colorDeBola1 = u1.extraerBola();
            System.out.println("La primera bola sacada es: " + colorDeBola1);
            Urna.ColorBola colorDeBola2 = u1.extraerBola();
            System.out.println("La segunda bola sacada es: " + colorDeBola2);
            if(colorDeBola1 == colorDeBola2) {
                u1.ponerBlanca();
                System.out.println("Como las bolas sacadas son del mismo color, se mete una bola Blanca");
            }
            else {
                u1.ponerNegra();
                System.out.println("Como las bolas sacadas son de diferente color, se mete una bola Negra");
            }
        }
        System.out.println("El color de la ultima bola de la urna es " + u1.extraerBola());

    }
}
