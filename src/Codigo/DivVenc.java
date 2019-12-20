package Codigo;

import java.util.ArrayList;

public class DivVenc {
    
    DivVenc(ArrayList<Puntos> vector) {
    }

    public ArrayList<Puntos> triangulo(ArrayList<Puntos> vector) {
        int i = 0;
        int j = vector.size() - 1;
        ArrayList<Puntos> t = triangulorecursivo(vector, i, j);
        float perm = CalcularPerimetro(t);
        System.out.println("Perimetro:"+perm);
        return t;
    }

    private ArrayList<Puntos> triangulorecursivo(ArrayList<Puntos> vector, int i, int j) {
        ArrayList<Puntos> sol = new ArrayList<>();
        float perm;
        perm = 0;
        if ((j - i) < 5) {
            Perimetros ex = new Perimetros();
            ex.BusquedaParam(vector, sol, i, j);
        } else {
            ArrayList<Puntos> soli = new ArrayList<>();
            ArrayList<Puntos> sold = new ArrayList<>();
            ArrayList<Puntos> solm = new ArrayList<>();
            Perimetros ex = new Perimetros();
            int medio = (i + j) / 2;
            
            soli = triangulorecursivo(vector, i, medio);
            sold = triangulorecursivo(vector, medio + 1, j);
            sol = menor(soli, sold);
            perm = CalcularPerimetro(sol);
            perm = perm / 2;
            int ini = medio, fin = medio;
            while ((perm > (vector.get(medio).getx() - vector.get(ini).getx())) && ini > 0) {
                ini--;
            }
            while (perm > (vector.get(fin).getx() - vector.get(medio).getx()) && (fin < vector.size() && fin < j)) {
                fin++;
            }
            ex.BusquedaParam(vector, solm, ini, fin);
            if (CalcularPerimetro(solm) < CalcularPerimetro(sol)) {
                sol = solm;
            }
        }
        return sol;
    }

    private ArrayList<Puntos> menor(ArrayList<Puntos> soli, ArrayList<Puntos> sold) {
        if (CalcularPerimetro(soli) < CalcularPerimetro(sold)) {
            return soli;
        } else {
            return sold;
        }
    }

    public float CalcularPerimetro(ArrayList<Puntos> vector) {
        float l1, l2, l3;
        float perimetro;
        float xP1 = vector.get(0).getx(), xP2 = vector.get(1).getx(), xP3 = vector.get(2).getx();
        float yP1 = vector.get(0).gety(), yP2 = vector.get(1).gety(), yP3 = vector.get(2).gety();
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
}
