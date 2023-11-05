package org.uma.mbd.mdIndicePalabrasV1.indices;

import java.util.*;
import java.util.stream.Collectors;

public class IndicePosicionesEnLineas extends Indice {
    private Map<String, Map<Integer, Set<Integer>>> palabras;

    public IndicePosicionesEnLineas(){
        super();
        palabras = new TreeMap<>();
    }

    @Override
    public void agregarLinea(String texto) {
        super.agregarLinea(texto);
    }

    @Override
    public void resolver(String delimitadores, Collection<String> noSignificativas) {
        Set<String> pNoSigni = noSignificativas.stream()
                .map(p -> p.toLowerCase())
                .collect(Collectors.toSet());
        for (int nLine = 0; nLine < texto.size(); nLine++) {
            Scanner sc = new Scanner(texto.get(nLine));
            sc.useDelimiter(delimitadores);
            int palabraPos = 1;
            while (sc.hasNext()) {
                String word = sc.next().toLowerCase();
                if (!pNoSigni.contains(word)) {
                    Map<Integer, Set<Integer>> lineaPlusPos = palabras.computeIfAbsent(word, key -> new TreeMap<>());
                    lineaPlusPos.computeIfAbsent(nLine+1, key-> new TreeSet<Integer>()).add(palabraPos);
                }
                palabraPos ++;
            }
        }
    }
    @Override
    public void presentarIndiceConsola() {
        for (String key : palabras.keySet()) {
            System.out.println(key);
            for (int line : palabras.get(key).keySet()) {
                System.out.printf("%15d     ", line);
                for (int pos :  palabras.get(key).get(line)) {
                    System.out.printf("%d.", pos);
                }
                System.out.println();
            }
        }
    }
}


