package org.uma.mbd.mdOptional;

import java.util.Optional;

public class MainOwnUtilOptional {
    public static void main(String[] args) {
        java.util.Optional<String> os = java.util.Optional.of("Hola");
        prueba(os);
        java.util.Optional<Integer> is = java.util.Optional.of(45);
        prueba(is);
        java.util.Optional<String> os2 = java.util.Optional.empty();
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


