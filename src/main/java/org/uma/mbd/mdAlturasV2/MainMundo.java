package org.uma.mbd.mdAlturasV2;

import org.uma.mbd.mdAlturasV2.alturas.EnContinente;
import org.uma.mbd.mdAlturasV2.alturas.MenoresQue;
import org.uma.mbd.mdAlturasV2.alturas.Mundo;
import org.uma.mbd.mdAlturasV2.alturas.Pais;

import java.io.IOException;
import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

public class MainMundo {
    public static void main(String args[]) throws IOException {
        Mundo paises = new Mundo();
        paises.leePaises("recursos/mdAlturas/alturas.txt");

        Comparator<Pais> ordenAlt = Comparator.comparingDouble(Pais::altura);
        Set<Pais> paisesOrdenAlt = new TreeSet<>(ordenAlt);
        paisesOrdenAlt.addAll(paises.getPaises());
        //paisesOrdenAlt.forEach(System.out::println);

        Comparator<Pais> ordenPaisAlf = Comparator.comparing(Pais::nombre);
        Set<Pais> paisesOrdenAlf = new TreeSet<>(ordenPaisAlf);
        paisesOrdenAlf.addAll(paises.getPaises());
        //paisesOrdenAlf.forEach(System.out::println);

        Comparator<Pais> ordenContinente = Comparator.comparing(Pais::continente);
        Comparator<Pais> ordenContAlf = ordenContinente.thenComparing(ordenPaisAlf);
        Set<Pais> paisesContAlf = new TreeSet<>(ordenContAlf);
        paisesContAlf.addAll(paises.getPaises());
        //paisesContAlf.forEach(System.out::println);

        Comparator<Pais> ordenContAlfRev = ordenContinente.thenComparing(ordenPaisAlf.reversed());
        Set<Pais> paisesContAlfRev = new TreeSet<>(ordenContAlfRev);
        paisesContAlfRev.addAll(paises.getPaises());
        //paisesContAlfRev.forEach(System.out::println);

        Comparator<Pais> ordenContNat = ordenContinente.thenComparing(Comparator.naturalOrder());
        Set<Pais> paisesContNat = new TreeSet<>(ordenContNat);
        paisesContNat.addAll(paises.getPaises());
        paisesContNat.forEach(System.out::println);




    }
}
