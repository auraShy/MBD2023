package org.uma.mbd.mdIndicePalabrasV1.indices;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Scanner;

abstract public class Indice {
    protected List<String> texto;

    public Indice(){
        texto = new ArrayList<>();
    }

    public void agregarLinea (String texto){
        try(Scanner sc = new Scanner(texto);){
            sc.useDelimiter("/n");
            while (sc.hasNext())
                this.texto.addLast(sc.next());
        }
    }

    public void resolver(String delimitadores, Collection<String> noSignificativas){
    }

    public void presentarIndiceConsola(){}
}
