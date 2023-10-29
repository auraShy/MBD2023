package org.uma.mbd.mdBusV2.buses;

import java.util.Objects;

public class Bus implements Comparable<Bus>{
    private int codBus;
    private int codLinea;
    private String matricula;

    public Bus(int codBus, String matricula){
        // Expecion en tamaños de los parametros?
        this.codBus = codBus;
        this.matricula = matricula;
    }

    public void setCodLinea(int codLinea){
        this.codLinea = codLinea;
    }

    public int getCodBus() {
        return codBus;
    }

    public int getCodLinea() {
        return codLinea;
    }

    public String getMatricula() {
        return matricula;
    }

    @Override
    public boolean equals(Object o) {
        return (o instanceof Bus b)
                && (codBus == b.codBus)
                && (b.matricula.equalsIgnoreCase(matricula));
    }

    @Override
    public int hashCode(){
        return Objects.hash(codBus,matricula.toLowerCase());
    }

    @Override
    public String toString(){
        return "Bus(" + codBus + "," + matricula + "," + codLinea + ")";
    }

    @Override
    public int compareTo(Bus bus){
        int resultado = matricula.compareTo(bus.matricula);
        // 0 = ambas matriculas iguales.
        // <0 = argumento es lexiograficamente mayor que la variable
        // >0 = argumento es lexiograficamente menor que la variable
        if (resultado == 0)
            resultado = Integer.compare(codBus,bus.codBus);
        return resultado;
    }
}
