package org.uma.mbd.mdTren;

import org.uma.mbd.mdTren.tren.Tren;
import org.uma.mbd.mdTren.tren.Vagon;

public class MainTren {
    public static void main(String[] args) {
        Vagon vag1 = new Vagon(20);
        System.out.println(vag1);
        System.out.println("Toneladas de carbon que no se han podido cargar: " + vag1.carga(21));
        System.out.println(vag1);
        System.out.println("Toneladas de carbon que no se han podido descargar del vagon: " + vag1.descarga(30));
        System.out.println(vag1);

        Tren tren1 = new Tren(4,10);
        System.out.println(tren1);
        tren1.carga(65);
        System.out.println(tren1);
        tren1.gasta(35);
        System.out.println(tren1);
        tren1.optimiza();
        System.out.println(tren1);
        tren1.carga(10);
        System.out.println(tren1);
    }
}
