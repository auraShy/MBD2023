package org.uma.mbd.mdPartidos.partidos;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public class Proporcional implements CriterioSeleccion{
    @Override
    public Map<Partido, Integer> ejecuta(List<Partido> partidos, int numEsc) {
        Set<Token> tokens = creaTokens(partidos,numEsc);
        tokens = Token.seleccioneTokens(tokens,numEsc);
        return Token.generaResultados(tokens);
    }

    private static Set<Token> creaTokens(List<Partido> partidos, int numEsc){
        Set<Token> tokens = new TreeSet<>();
        int votosTotales = partidos.stream()
                .mapToInt(Partido::getVotos)
                .sum();
        double vpe = (double) votosTotales/numEsc;
        partidos.forEach(partido -> {
            for(int i=0; i<numEsc; i++){
                tokens.add(new Token(partido, (double)partido.getVotos()-i*vpe));
            }
        });
        return tokens;
    }
}
