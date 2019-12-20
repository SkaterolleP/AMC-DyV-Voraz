package Codigo;

import static java.lang.Float.MAX_VALUE;
import java.util.ArrayList;

public class Perimetros {

    private float perimetroMin = MAX_VALUE;
    private int soli, solj, solk;

    public float CalculaPerimetro(ArrayList<Puntos> vector, int i, int j, int k) {
        float l1, l2, l3;
        float perimetro;
        float xP1 = vector.get(i).getx(), xP2 = vector.get(j).getx(), xP3 = vector.get(k).getx();
        float yP1 = vector.get(i).gety(), yP2 = vector.get(j).gety(), yP3 = vector.get(k).gety();
        float cateto1;
        float cateto2;
        //Calculo L1
        cateto1 = (xP1 - xP2);
        cateto2 = (yP1 - yP2);
        l1 = (float) Math.sqrt(cateto1 * cateto1 + cateto2 * cateto2);
        //Calculo L2
        cateto1 = (xP1 - xP3);
        cateto2 = (yP1 - yP3);
        l2 = (float) Math.sqrt(cateto1 * cateto1 + cateto2 * cateto2);
        //Calculo L3
        cateto1 = (xP3 - xP2);
        cateto2 = (yP3 - yP2);
        l3 = (float) Math.sqrt(cateto1 * cateto1 + cateto2 * cateto2);
        //Saco el perimetro
        perimetro = l1 + l2 + l3;
        return perimetro;
    }

    public void Busqueda(ArrayList<Puntos> vector, ArrayList<Puntos> vectorsol) {
        float perimetroAct;
        for (int i = 0; i < vector.size(); i++) {
            for (int j = i + 1; j < vector.size(); j++) {
                for (int k = j + 1; k < vector.size(); k++) {
                    perimetroAct = CalculaPerimetro(vector, i, j, k);
                    CompararMinimo(vector, vectorsol, perimetroAct, i, j, k);
                }
            }
        }
        System.out.println("Perimetro:"+perimetroMin);
    }

    public void CompararMinimo(ArrayList<Puntos> vector, ArrayList<Puntos> vectorsol, float perimetroAct, int i, int j, int k) {
        if (perimetroAct < perimetroMin) {
            perimetroMin = perimetroAct;
            soli = i;
            solj = j;
            solk = k;
            vectorsol.clear();
            vectorsol.add(vector.get(i));
            vectorsol.add(vector.get(j));
            vectorsol.add(vector.get(k));
        }
    }

    public void BusquedaParam(ArrayList<Puntos> vector, ArrayList<Puntos> vectorsol, int ini, int fin) {
        if (((fin + 1) - ini) >= 3) {
            float perimetroAct;
            for (int i = ini; i < fin + 1; i++) {
                for (int j = i + 1; j < fin + 1; j++) {
                    for (int k = j + 1; k < fin + 1; k++) {
                        perimetroAct = CalculaPerimetro(vector, i, j, k);
                        CompararMinimo(vector, vectorsol, perimetroAct, i, j, k);
                    }
                }
            }
        }
    }

    public int geti() {
        return soli;
    }

    public int getj() {
        return solj;
    }

    public int getk() {
        return solk;
    }
}
