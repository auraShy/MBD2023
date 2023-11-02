package org.uma.mbd.mdIndicePalabrasV1.indices;

import java.util.*;
import java.util.stream.Collectors;

public class IndiceLineas extends Indice{
    private Map<String, Set<Integer>> palabras;

    public IndiceLineas(){
        super();
        palabras = new TreeMap<>();
    }

    @Override
    public void agregarLinea(String texto) {
        super.agregarLinea(texto);
        palabras.clear();
    }
    @Override
    public void resolver(String delimitadores, Collection<String> noSignificativas) {
        Set<String> pNoSigni = noSignificativas.stream()
                .map(p -> p.toLowerCase())
                .collect(Collectors.toSet());
        for(int nLine = 0; nLine<texto.size(); nLine++){
            Scanner sc = new Scanner(texto.get(nLine));
            sc.useDelimiter(delimitadores);
            while (sc.hasNext()){
                String word = sc.next().toLowerCase();
                if (!pNoSigni.contains(word)){
                    // el metodo devuelve el TreeSet por lo que:
                    // se puede añadir el numero directamente
                   palabras.computeIfAbsent(word,key -> new TreeSet<>()).add(nLine+1);
                }
            }
        }
    }

    @Override
    public void presentarIndiceConsola() {
        for (String key : palabras.keySet()) {
            System.out.printf("%-30s", key);
            for (int linea : palabras.get(key)) {
                System.out.printf("%d.", linea);
            }
            System.out.println();
        }
    }
}
