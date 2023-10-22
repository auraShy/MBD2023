package org.uma.mbd.mdMasterMindL;

import org.uma.mbd.mdMasterMindL.masterMind.MasterMind;

public class Main {
    public static void main(String[] args) {
        String combi = "";
        StringBuilder cb = new StringBuilder(3);
        int i = 1;
        while (i<=3){
            int cifra =2;
            cb.append(cifra);
            i++;
        }

        combi = cb.toString();

        System.out.println("combi: " + combi + " Hashcode: " + combi.hashCode());
        System.out.println("cb: " + cb + " Hashcode: " + cb.hashCode());

        MasterMind m1 = new MasterMind(3);


    }
}
