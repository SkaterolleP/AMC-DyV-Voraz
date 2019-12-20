package Codigo;

import static java.lang.Float.MAX_VALUE;
import java.util.ArrayList;
import java.util.Scanner;

public class Prim {

    public void CaminoPrim(ArrayList<Puntos> vector, ArrayList<ArrayList<Puntos>> camino) {
        ArrayList<Puntos> restantes = vector;
        ArrayList<Puntos> visitados = new ArrayList<>();
        Scanner teclado = new Scanner(System.in);
        System.out.println("Por que punto empezar?");
        int inicial = teclado.nextInt();
        visitados.add(restantes.get(inicial));
        restantes.remove(inicial);
        PrimRec(restantes, visitados, camino);
    }

    private void PrimRec(ArrayList<Puntos> restantes, ArrayList<Puntos> visitados, ArrayList<ArrayList<Puntos>> camino) {
        if (!restantes.isEmpty()) {
            ArrayList<Puntos> arista = new ArrayList<>();
            float tam = MAX_VALUE;
            int index = 0, jdex = 0;
            for (int i = 0; i < visitados.size(); i++) {
                for (int j = 0; j < restantes.size(); j++) {
                    float d = distancia(visitados.get(i), restantes.get(j));
                    if (d < tam) {
                        tam = d;
                        index = i;
                        jdex = j;
                    }
                }
            }
        }
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
