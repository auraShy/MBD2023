package org.uma.mbd.mdTestL.tests;

import java.util.*;

public class TestAsignatura {
    private String nombreAsignatura;
    private double valorAciertos;
    private double valorErrores;
    private List<Test> examenes;
    private final static double APROBADO = 5.0;

    public TestAsignatura(String nAsignatura, double valAc, double valErr, List<String> lista){
        examenes = new ArrayList<>();
        nombreAsignatura = nAsignatura;
        if(valAc <= 0 || valErr > 0 )
            throw new IllegalArgumentException("Valoracion de aciertos debe ser positviva y de errores negativa");
        valorAciertos = valAc;
        valorErrores = valErr;
        extraerDatos(lista);


    }

    public TestAsignatura(String nombreAsignatura, List<String> lista){
       this(nombreAsignatura,1,0,lista);
    }


    private void extraerDatos(List<String> lista) {
        for (String datosAlumno : lista) {
            try (Scanner sc = new Scanner(datosAlumno)) {
                sc.useDelimiter("[:+]");
                String alumno = sc.next();
                int aciertos = sc.nextInt();
                int errores = sc.nextInt();
                examenes.addLast(new Test(alumno, aciertos, errores));
            } catch (InputMismatchException e) {
                System.err.println("Faltan datos en " + datosAlumno);
            } catch (NoSuchElementException e) {
                System.err.println("Numero erroneo en " + datosAlumno);
            }
        }
    }

    public double notaMedia(){
        double suma = 0;
        for(Test test : examenes)
            suma+= test.calificacion(valorAciertos,valorErrores);
        //return suma/ examenes.size();
        // con stream
        return examenes.stream().mapToDouble(t -> t.calificacion(valorAciertos,valorErrores))
                .average()
                .getAsDouble();
    }

    public int aprobados(){
        return (int)examenes.stream().filter(t -> t.calificacion(valorAciertos,valorErrores) >= APROBADO)
                .count();
    }

    public String getNombreAsignatura() {
        return nombreAsignatura;
    }
}


