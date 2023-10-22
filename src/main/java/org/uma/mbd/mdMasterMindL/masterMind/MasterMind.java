package org.uma.mbd.mdMasterMindL.masterMind;

import java.util.Random;

public class MasterMind {

    protected String combinacionSecreta = "";

    private Random alea = new Random();

    static public final int TAMANO_POR_DEFECTO = 4;

    public MasterMind(int tamano){
        if (tamano < 1 || tamano > 10)
            throw new MasterMindException("Tamano no valido");
        combinacionSecreta = generaCombinacionSecreta(tamano);
    }
    public MasterMind(){
        this(TAMANO_POR_DEFECTO);
    }

    private String generaCombinacionSecreta(int tamano){
        StringBuilder cb = new StringBuilder(combinacionSecreta.length());
        while (combinacionSecreta.length() < tamano){
            int cifra = alea.nextInt(0,10);
            cb.append(cifra);
        }
        return cb.toString();
    }
    public int getLongitud(){
        return combinacionSecreta.length();
    }

    private boolean validaCombinacion(String cifras){
        boolean tam = (cifras.length() == getLongitud());
        boolean numerico = cifras.matches("^(?!.*(\\d).*\\1)\\d{0,10}$");

        return (tam&&numerico);
    }

    //public Movimiento intento(String cifras){
      //  if (validaCombinacion(cifras)){

        //}
    //}



}
