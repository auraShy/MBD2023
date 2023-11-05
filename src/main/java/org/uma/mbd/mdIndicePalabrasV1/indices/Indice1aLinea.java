package org.uma.mbd.mdIndicePalabrasV1.indices;

import java.util.*;
import java.util.stream.Collectors;

public class Indice1aLinea extends Indice{
    private Map<String,Integer> palabras;

    public Indice1aLinea(){
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
                    palabras.putIfAbsent(word, nLine+1);
                }
            }
        }
    }

    /*@Override
    public void presentarIndiceConsola() {
        Iterator it = palabras.entrySet().iterator();
        while (it.hasNext()) {
           Map.Entry e = (Map.Entry)it.next();
            System.out.println(e.getKey() + " " + e.getValue());
        }
    }*/

    @Override
    public void presentarIndiceConsola() {
        for (String key : palabras.keySet()) {
            // %-30s un ancho de 30 caracteres y alineada a la izquierda:
            System.out.printf("%-30s%d\n",key,palabras.get(key));
        }
    }
}
