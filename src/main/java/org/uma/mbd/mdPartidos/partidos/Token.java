package org.uma.mbd.mdPartidos.partidos;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Token implements Comparable<Token>{
    private Partido partido;
    private double ratio;

    public Token(Partido partido, double ratio){
        this.partido = partido;
        this.ratio = ratio;
    }

    public double getRatio(){ return ratio; }

    public Partido getPartido() {
        return partido;
    }

    public int compareTo(Token t) {
        int resultado = Double.compare(t.ratio, ratio);
        if (resultado == 0)
            resultado = t.partido.getNombre().compareTo(partido.getNombre());
        return resultado;
    }

    public static Set<Token> seleccioneTokens(Set<Token> tks, int numEsc){
        return tks.stream()
                .sorted()
                .limit(numEsc) //limit(N) method returns first N elements in the encounter order of the Stream.
                .collect(Collectors.toSet());
    }

    public static Map<Partido,Integer> generaResultados(Set<Token> tks){
        Map<Partido,Integer> resultado = new HashMap<>();
        for(Token tk : tks){
             int nEsc = (int) tks.stream()
                    .filter(token -> token.partido.getNombre().equals(tk.partido.getNombre()))
                     .count();
            resultado.putIfAbsent(tk.partido,nEsc);
        }
        return resultado;
    }
}
