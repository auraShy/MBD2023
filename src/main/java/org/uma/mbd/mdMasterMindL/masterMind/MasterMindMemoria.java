package org.uma.mbd.mdMasterMindL.masterMind;

import java.util.ArrayList;
import java.util.List;

public class MasterMindMemoria extends MasterMind {

    private List<Movimiento> movimientos = new ArrayList<>();
    public MasterMindMemoria(){
        super();
    }
    public MasterMindMemoria(int tamano){
        super(tamano);
    }

    @Override
    public Movimiento intento(String cifras) {
        Movimiento nuevoMov = super.intento(cifras);
        if (movimientos.contains(nuevoMov))
            throw new MasterMindException("Este movimiento ya se ha realizado");
        movimientos.addLast(nuevoMov);
        return nuevoMov;
    }

    public List<Movimiento> Movimientos() {
        return movimientos;
    }
}
