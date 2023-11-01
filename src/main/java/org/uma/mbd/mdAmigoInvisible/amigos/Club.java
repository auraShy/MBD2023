package org.uma.mbd.mdAmigoInvisible.amigos;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

public class Club{
    protected List<Persona> socios;

    public Club(){
        socios = new ArrayList<>();
    }

    public void lee(String fEntrada, String delim) throws IOException{
        Path fichero = Path.of(fEntrada);
        for (String linea : Files.readAllLines(fichero)){
            try {
                leeSocios(linea,delim);
            }catch (InputMismatchException e) {
                System.err.println("Error en dato numérico en " + linea);
            } catch (NoSuchElementException e) {
                System.err.println("Error, faltan datos en " + linea);
            }
        }
    }

    private void leeSocios(String linea, String delim){
        Scanner sc = new Scanner(linea);
        sc.useDelimiter(delim);
        while (sc.hasNext()){
            crearSociosDesdeString(sc.next());
        }
    }

    protected void crearSociosDesdeString(String nombre){
        socios.addLast(new Persona(nombre));
    }

    protected void hacerAmigos(){
        List<Integer> posAmigos = new ArrayList<>(socios.size());
        for (int i=0; i<socios.size();i++){
            posAmigos.add(i);
        }
        while (hayCoincidencias(posAmigos))
            Collections.shuffle(posAmigos);

        for (int i=0; i<socios.size();i++){
            socios.get(i).setAmigo(socios.get(posAmigos.get(i)));
        }
    }

    private static boolean hayCoincidencias(List<Integer> posAmigos){
        for(int pos : posAmigos){
            if (pos == posAmigos.get(pos))
                return true;
        }
        return false;
    }

    public void presentaAmigos(String fSalida) throws FileNotFoundException {
        try(PrintWriter pw = new PrintWriter(fSalida)){
            presentaAmigos(pw);
        }
    }

    public void presentaAmigos(PrintWriter pw){
        List<Persona> amigosOrdenados = new ArrayList<>();
        amigosOrdenados.addAll(socios);
        Comparator<Persona> cNatural = Comparator.naturalOrder();
        Collections.sort(amigosOrdenados,cNatural);
        for (Persona line : amigosOrdenados){
            pw.println(line.toString());
        }
    }
}
