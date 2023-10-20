package org.uma.mbd.mdGenetico;

import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Random r = new Random();
        System.out.println(r.nextInt(2));
        int [] num = {0,1,1,1,1,0,0,1};
        int cont1 = 0;
        int cont0 = 0;

        for(int i : num){
            if(i == 0)
                cont0 ++;
            else
                cont1 ++;
        }
        System.out.println(cont0);
        System.out.println(cont1);
    }
}
