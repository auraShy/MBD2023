package org.uma.mbd.mdJarras.jarras;

public class Mesa {

    private Jarra jA;
    private Jarra jB;

    public Mesa(int capInicialA,int capInicialB){

        jA = new Jarra(capInicialA);
        jB = new Jarra(capInicialB);

    }

    public void llenaA(){
        jA.llena();
    }

    public void llenaB(){
        jB.llena();
    }

    public void vaciaA(){
        jA.vacia();
    }

    public void vaciaB(){
        jB.vacia();
    }

    public void vuelcaASobreB(){
        jB.llenaDesde(jA);
    }

    public void vuelcaBSobreA(){
        jA.llenaDesde(jB);
    }

    public int getContenidoA(){
        return jA.getContenido();
    }

    public int getContenidoB(){
        return jB.getContenido();
    }

    public int getContenido(){
        return jA.getContenido() + jB.getContenido();
    }

    @Override
    public String toString(){
        return "Jarra A->"+ jA + "; Jarra B->"+ jB;
    }
}
