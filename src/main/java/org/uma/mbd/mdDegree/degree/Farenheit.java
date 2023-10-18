package org.uma.mbd.mdDegree.degree;

public record Farenheit (double degrees) implements Degree {
    @Override
    public boolean isfrozen() {

        return degrees < 32;
    }

    @Override
    public Degree toCelsius() {
        return new Celsius((degrees - 32) / 1.8);
    }
}
