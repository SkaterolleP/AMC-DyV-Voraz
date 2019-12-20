package Codigo;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Lector {

    private String nomFich;

    Lector(String nomFich) {
        this.nomFich = nomFich;
    }

    public void leeFichero(ArrayList<Puntos> vector) {
        try {
            String cadena = null;
            Puntos p;
            char aux;
            float x = 0, y = 0, idpunto = 0;
            try {
                FileReader f = new FileReader(nomFich);
                BufferedReader b = new BufferedReader(f);
                cadena = b.readLine();
                System.out.println(cadena);
                while (!cadena.equals("NODE_COORD_SECTION")) {
                    cadena = b.readLine();
                }
                int i = 0;
                while ((cadena = b.readLine()) != null && !cadena.equals("EOF")) {
                    cadena = cadena.trim();
                    String[] lectura = cadena.split(" ");
                    x = Float.valueOf(lectura[1]);
                    y = Float.valueOf(lectura[2]);
                    p = new Puntos(i, x, y);
                    vector.add(p);
                    i++;
                }
                b.close();
            } catch (FileNotFoundException ex) {
                Logger.getLogger(Lector.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (IOException ex) {
            Logger.getLogger(Lector.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
