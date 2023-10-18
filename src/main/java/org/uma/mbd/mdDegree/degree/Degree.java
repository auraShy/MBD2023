package org.uma.mbd.mdDegree.degree;

public sealed interface Degree permits Celsius, Farenheit {
    boolean isfrozen();
    default Degree toCelsius(){
        return this;
    }
    default Degree toFarenheit(){
        return this;
    }

    static Degree farenhait(double degree){
        return new Farenheit(degree);
    }

    static Degree celsius(double degree){
        return new Celsius(degree);
    }
}
