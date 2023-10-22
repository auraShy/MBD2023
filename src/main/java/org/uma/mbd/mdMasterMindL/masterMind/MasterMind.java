package org.uma.mbd.mdMasterMindL.masterMind;

import java.util.Random;

public class MasterMind {

    protected String combinacionSecreta = "";

    private Random alea = new Random();

    static public final int TAMANO_POR_DEFECTO = 4;

    public MasterMind(int tamano){
        if (tamano < 1 || tamano > 10)
            throw new MasterMindException("Tamano no valido");
        generaCombinacionSecreta(tamano);
    }
    public MasterMind(){
        this(TAMANO_POR_DEFECTO);
    }

    private void generaCombinacionSecreta(int tamano){
        StringBuilder cb = new StringBuilder();
        while (cb.length() < tamano){
            int cifra = alea.nextInt(10);
            String cifraS = Integer.toString(cifra);
            if(cb.indexOf(cifraS) == -1){
                cb.append(cifra);
            }
        }
        combinacionSecreta = cb.toString();
    }
    public int getLongitud(){
        return combinacionSecreta.length();
    }

    private boolean validaCombinacion(String cifras){
        boolean tam = (cifras.length() == getLongitud());
        boolean numerico = cifras.matches("^(?!.*(\\d).*\\1)\\d{0,9}$");

        return (tam&&numerico);
    }

    public Movimiento intento(String cifras) {
        int colocadas = 0;
        int descolocadas = 0;
        if (validaCombinacion(cifras) == false)
            throw new MasterMindException("La secuencia de cifras no es valida");

        for (int i = 0; i < cifras.length(); i++) {
            if (combinacionSecreta.indexOf(cifras.charAt(i)) == i) {
                colocadas++;
            } else if (combinacionSecreta.indexOf(cifras.charAt(i)) != -1) {
                descolocadas++;
            }
        }

        return new Movimiento(cifras, colocadas, descolocadas);

    }

    public String getSecreto() { return combinacionSecreta; }

}
