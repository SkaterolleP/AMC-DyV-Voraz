/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Codigo;

import static java.lang.Float.MAX_VALUE;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author usuario
 */
public class Kruscal {

    static int INFINITO = 0xFFFF;
    private double[][] matrizdistancia;
    private int numv;
    private ArrayList<Puntos> nodos = new ArrayList();
    private boolean[] vis;

    private void matrizdistancia(ArrayList<Puntos> vectorin, ArrayList<Puntos> vectorout) {

        matrizdistancia = new double[vectorin.size()][vectorout.size()];
        for (int i = 0; i < vectorin.size(); i++) {
            for (int j = 0; j < vectorout.size(); j++) {
                if (i != j) {
                    double dist = distancia(vectorin.get(i), vectorout.get(j));
                    matrizdistancia[i][j] = dist;
                } else {
                    matrizdistancia[i][j] = -1;
                }
                //System.out.println("Matriz "+matrizdistancia[i][j]);
            }
        }
    }

    public void CaminoKrus(ArrayList<Puntos> vector, ArrayList<ArrayList<Puntos>> camino) {
        numv = vector.size();
        nodos = vector;
        vis = new boolean[numv];
        for (int i = 0; i < numv; i++) {
            vis[i] = false;
        }
        //matrizdistancia();
        recorrer(camino);
    }

    public void recorrer(ArrayList<ArrayList<Puntos>> camino) {
        double minimo = MAX_VALUE, minimo_costo = 0;

        int ne = 0, a = 0, b = 0;
        ArrayList<Puntos> visitados = new ArrayList<>();
        visitados.add(nodos.get(0));
        nodos.remove(0);
        //System.out.println("Arbol de recubrimiento minimo(Algoritmo de Kruskal) :");
        //System.out.println(ne + " < " + numv);

        while (!nodos.isEmpty()) {
            matrizdistancia(visitados, nodos);
            minimo = MAX_VALUE;
            ArrayList<Puntos> arista = new ArrayList<>();
            for (int i = 0; i < visitados.size(); i++) {
                for (int j = 0; j < nodos.size(); j++) {
                    if (matrizdistancia[i][j] < minimo && matrizdistancia[i][j] != -1 && matrizdistancia[i][j] != MAX_VALUE) {
                        minimo = matrizdistancia[i][j];
                        a = i;
                        b = j;
                    }
                }
            }
            //nueva arista del camino
            arista.add(visitados.get(a));
            arista.add(nodos.get(b));

            visitados.add(nodos.get(b));
            nodos.remove(b);

            //añadimos los caminos
            camino.add(arista);
            //System.out.println(nodos.get(a).getid() + "---" + nodos.get(b).getid() + "  ( " + minimo + " )");
            minimo_costo = minimo_costo + minimo;
            ne++;
            //System.out.println(ne);

        }
        /*
        for (int i = 0; i < numv; i++) {
            minimo = MAX_VALUE;
            ArrayList<Puntos> arista = new ArrayList<>();
            for (int j = 0; j < numv; j++) {
                if (matrizdistancia[i][j] < minimo && matrizdistancia[i][j] != -1 && matrizdistancia[i][j] != MAX_VALUE) {
                    minimo = matrizdistancia[i][j];
                    a = i;
                    b = j;
                }
            }
            
        }
         */
        //System.out.println(ne);
        System.out.println("");
        System.out.println("Costo minimo = " + minimo_costo);
    }

    private float distancia(Puntos p1, Puntos p2) {
        float xP1 = p1.getx(), xP2 = p2.getx();
        float yP1 = p1.gety(), yP2 = p2.gety();
        float cateto1 = (xP1 - xP2);
        float cateto2 = (yP1 - yP2);
        float dist = (float) Math.sqrt(cateto1 * cateto1 + cateto2 * cateto2);
        return dist;
    }
}
