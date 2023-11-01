package org.uma.mbd.mdAmigoInvisible.amigos;

import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class ClubPareja extends Club{

    private Set<Pareja> parejas;

    public ClubPareja(){
        super();
        parejas = new HashSet<>();
    }

    @Override
    protected void crearSociosDesdeString(String nombre) {
        try (Scanner sc = new Scanner(nombre);){
            sc.useDelimiter("-");
            String parejaUno = sc.next();
            super.crearSociosDesdeString(parejaUno);
            if(sc.hasNext()){
                String parejaDos = sc.next();
                super.crearSociosDesdeString(parejaDos);
                Pareja pareja = new Pareja(super.socios.get(super.socios.size()-2),super.socios.get(super.socios.size()-1));
                parejas.add(pareja);
            }
        }
    }

    @Override
    protected void hacerAmigos() {
        super.hacerAmigos();
        for(Persona p : socios){
            Pareja pareja = new Pareja(p,p.getAmigo());
            if (parejas.contains(pareja))
                super.hacerAmigos();
        }
    }

}
