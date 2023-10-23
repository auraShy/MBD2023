package org.uma.mbd.mdBusV1L.buses;

import java.util.Objects;

public class Bus {
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

    public boolean equals(Object o) {
        return (o instanceof Bus b)
                && (codBus == b.codBus)
                && (codLinea == b.codLinea)
                && (b.matricula.equalsIgnoreCase(matricula));
    }

    public int hashCode(){
        return Objects.hash(codBus,codLinea,matricula.toLowerCase());
    }

    @Override
    public String toString(){
        return "Bus(" + codBus + "," + matricula + "," + codLinea + ")";
    }
}
