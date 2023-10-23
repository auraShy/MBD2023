package org.uma.mbd.mdOptional;

import java.util.Optional;

public class Main {
    public static void main(String[] args) {
        Optional<String> os = Optional.of("Hola");
        prueba(os);
        Optional<Integer> is = Optional.of(45);
        prueba(is);
        Optional<String> os2 = Optional.empty();
        prueba(os2);


    }


    //metodo generico de optionals
    public static <T> void prueba(Optional<T> o){
        if(o.isPresent())
            System.out.println(o.get());
        else
            System.out.println("No hay nada");
    }
}
