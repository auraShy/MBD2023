package org.uma.mbd.mdUrna;

import org.uma.mbd.mdUrna.urna.Urna;

public class MainUrna {
    public static void main(String[] args) {
        int b1 = Integer.parseInt(args[0]);
        int b2 = Integer.parseInt(args[1]);

        if (b1 == 0 && b2 == 0)
            throw new IllegalArgumentException("No se puede realizar el experimento si no hay bolas en la urna");
        Urna u1 = new Urna(b1,b2);
        Urna.ColorBola colorUltimaBola = null;

        while (u1.totalBolas() > 1){

            Urna.ColorBola colorDeBola1 = u1.extraerBola();
            Urna.ColorBola colorDeBola2= u1.extraerBola();
            if(colorDeBola1 == colorDeBola2)
                u1.ponerBlanca();
            else
                u1.ponerNegra();
            if (u1.totalBolas() == 1)
                colorUltimaBola = u1.extraerBola();
        }
        System.out.println("El color de la ultima bola de la urna es " + colorUltimaBola);

    }
}
