package org.uma.mbd.mdAmigoInvisible.amigos;

import java.util.*;

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
    protected void hacerAmigos(){
        List<Integer> posAmigos = new ArrayList<>(socios.size());
        for (int i=0; i<socios.size();i++){
            posAmigos.add(i);
        }
        while (hayCoincidencias(posAmigos) || hayParejas(posAmigos))
            Collections.shuffle(posAmigos);

        for (int i=0; i<socios.size();i++){
            socios.get(i).setAmigo(socios.get(posAmigos.get(i)));
        }
    }

    private static boolean hayCoincidencias(List<Integer> posAmigos){
        for(int pos : posAmigos){
            if (pos == posAmigos.get(pos))
                return true;
        }
        return false;
    }

    private boolean hayParejas(List<Integer> posAmigos){
        for(int i = 0; i< posAmigos.size(); i++){
            if(parejas.contains(new Pareja( socios.get(i), socios.get(posAmigos.get(i))))){
                return true;
            }
        }
        return false;
    }

}
