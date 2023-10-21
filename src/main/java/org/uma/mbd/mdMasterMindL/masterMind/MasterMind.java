package org.uma.mbd.mdMasterMindL.masterMind;

import java.util.Random;

public class MasterMind {

    protected String combinacionSecreta;

    private Random alea = new Random();

    static public final int TAMANO_POR_DEFECTO = 4;

    public MasterMind(int tamano){
        if (tamano < 1 || tamano > 10){
            throw new MasterMindException("Tamano no valido");
        }


    }
    public int getLongitud(){
        return combinacionSecreta.length();
    }

    private boolean validaCombinacion(String cifras){
        boolean tam = (cifras.length() == getLongitud());
        boolean numerico = cifras.matches("^(?!.*(\\d).*\\1)\\d{0,9}$");

        return (tam&&numerico);
    }

    //public Movimiento intento(String cifras){
      //  if (validaCombinacion(cifras)){

        //}
    //}

    public MasterMind(){
        this(TAMANO_POR_DEFECTO);
    }

}
