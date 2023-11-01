package org.uma.mbd.mdAmigoInvisible.amigos;

import java.util.Objects;

record Pareja(Persona uno, Persona otro){

    @Override
    public boolean equals(Object obj) {
        return (obj instanceof Pareja pareja)
                && (uno.equals(pareja.uno) && otro.equals(pareja.otro)
                || (uno.equals(pareja.otro) && otro.equals(pareja.uno)));
    }

    @Override
    public int hashCode() {
        return Objects.hash(uno.getNombre().toLowerCase(), otro.getNombre().toLowerCase());
    }
}

