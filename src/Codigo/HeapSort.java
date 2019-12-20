package Codigo;

import java.util.ArrayList;

public class HeapSort {

    public static void ordenaMonticulos(ArrayList<Puntos> vector) {
        final int N = vector.size();
        Puntos p;
        for (int nodo = N / 2; nodo >= 0; nodo--) {
            haceMonticulo(vector, nodo, N - 1);
        }
        for (int nodo = N - 1; nodo >= 0; nodo--) {
            p = vector.get(0);
            vector.set(0, vector.get(nodo));
            vector.set(nodo, p);
            haceMonticulo(vector, 0, nodo - 1);
        }
    }

    public static void haceMonticulo(ArrayList<Puntos> vector, int nodo, int fin) {
        int izq = 2 * nodo + 1;
        int der = izq + 1;
        int may;
        Puntos p;
        if (izq > fin) {
            return;
        }
        if (der > fin) {
            may = izq;
        } else {
            may = vector.get(izq).getx() > vector.get(der).getx() ? izq : der;
        }
        if (vector.get(nodo).getx() < vector.get(may).getx()) {
            p = vector.get(nodo);
            vector.set(nodo, vector.get(may));
            vector.set(may, p);
            haceMonticulo(vector, may, fin);
        }
    }
}
