package org.uma.mbd.mdTestL.tests;

import java.util.Objects;

public record Test(String alumno, int aciertos, int errores) {
    @Override
    public boolean equals(Object obj){
        return (obj instanceof Test test)
                && test.alumno.equalsIgnoreCase(alumno);
                //&& aciertos == test.aciertos
                //&& errores == test.errores();
    }

    public int hashCode(){
        return Objects.hash(alumno.toLowerCase());
    }

    public double calificacion(double valAc, double valErr){
        return aciertos*valAc + errores*valErr;
    }
}
