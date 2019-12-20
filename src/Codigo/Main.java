package Codigo;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException, InterruptedException {
        ArrayList<Puntos> vector = new ArrayList<>();
        ArrayList<Puntos> vectorSol = new ArrayList<>();
        ArrayList<ArrayList<Puntos>> camino = new ArrayList<>();
        Random rand = new Random();
        rand.setSeed(System.currentTimeMillis());
        double tini, tfin;
        Lector mf;
        Perimetros ex;
        FicheroGNU fGNU;
        String opcion;
        int tama;
        Scanner teclado = new Scanner(System.in);
        System.out.println("Generar datos de manera aleatoria?: (y,n)");
        opcion = teclado.nextLine();
        if (opcion.equals("n")) {
            String fichero = ".\\d493.tsp";
            mf = new Lector(fichero);
            mf.leeFichero(vector);
        } else {
            System.out.println("Indique el tamano del vector: ");
            tama = teclado.nextInt();
            for (int i = 0; i < tama; i++) {
                Puntos paux = new Puntos(i, rand.nextFloat(), rand.nextFloat());
                vector.add(paux);
            }
        }
        int bus;
        System.out.println("Seleccione el metodo de busqueda: ");
        System.out.println("1.- Busqueda Exhaustiva.");
        System.out.println("2.- Divide y venceras");
        System.out.println("3.- Prim");
        bus = teclado.nextInt();
        switch (bus) {
            case 1:
                ex = new Perimetros();
                System.out.println("Comienza la busqueda exhaustiva: ");
                tini = System.currentTimeMillis();
                ex.Busqueda(vector, vectorSol);
                tfin = System.currentTimeMillis();
                System.out.println("Total: " + (tfin - tini));
                fGNU = new FicheroGNU();
                fGNU.Comandos();
                fGNU.Conjunto(vector);
                fGNU.Solucion(vectorSol);
                break;
            case 2:
                HeapSort heap = new HeapSort();
                vectorSol.clear();
                DivVenc dv = new DivVenc(vector);
                fGNU = new FicheroGNU();
                fGNU.Comandos();
                fGNU.Conjunto(vector);
                tini = System.currentTimeMillis();
                heap.ordenaMonticulos(vector);
                vectorSol = dv.triangulo(vector);
                tfin = System.currentTimeMillis();
                System.out.println("Total: " + (tfin - tini));
                fGNU.Solucion(vectorSol);
                break;
            case 3:
                Prim p = new Prim();
                p.CaminoPrim(vector, camino);
                fGNU = new FicheroGNU();
                fGNU.ComandosArbol();
                fGNU.arbol(camino);
                break;
            case 4:

        }
        System.out.println("llego");
        String[] command = new String[2];
        command[0] = "C:\\Program Files\\gnuplot\\bin\\wgnuplot";
        command[1] = ".\\conjunto.plt";
        Process p = Runtime.getRuntime().exec(command);
        p.waitFor();
        System.out.println("salio");
    }

}
