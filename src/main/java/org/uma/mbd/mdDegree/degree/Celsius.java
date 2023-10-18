package org.uma.mbd.mdDegree.degree;

public record Celsius (double degrees) implements Degree{

    @Override
    public boolean isfrozen() {
        return degrees<0;
    }

    @Override
    public Degree toFarenheit() {
        return new Farenheit((degrees*1.8+32));
    }
}
