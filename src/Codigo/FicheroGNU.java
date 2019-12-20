package Codigo;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class FicheroGNU {
    
    public void Comandos() throws IOException{
        FileWriter comandos = new FileWriter(".\\conjunto.plt");
        comandos.write("set key top left vertical inside\n");
        comandos.write("set xlabel \"coordenada x\"\n");
        comandos.write("set ylabel \"coordenada y\"\n");
        comandos.write("plot \"datos.dat\" t \"CONJUNTO\"\n");
        comandos.write("replot \"sol.dat\" w lp\n");
        comandos.close();
    }
    
    public void Conjunto(ArrayList<Puntos> vector) throws IOException{
        FileWriter datosGNU = new FileWriter(".\\datos.dat");
        for(int i=0;i<vector.size();i++){
            datosGNU.write(vector.get(i).getx()+" "+vector.get(i).gety()+"\n");
        }
        datosGNU.close();
    }
    
    public void Solucion(ArrayList<Puntos> vectorSol) throws IOException{
        FileWriter solucion = new FileWriter(".\\sol.dat");

        for(int i=0;i<vectorSol.size();i++){
            solucion.write(vectorSol.get(i).getx()+" "+vectorSol.get(i).gety()+"\n");
        }
        solucion.write(vectorSol.get(0).getx()+" "+vectorSol.get(0).gety()+"\n");
       
        solucion.close();
    }
    
    
     public void ComandosArbol() throws IOException{
        FileWriter comandos = new FileWriter(".\\conjunto.plt");
        comandos.write("set key top left vertical inside\n");
        comandos.write("set xlabel \"coordenada x\"\n");
        comandos.write("set ylabel \"coordenada y\"\n");
        comandos.write("plot \"arbol.dat\" w lp\n");
        comandos.close();
    }
     
    public void arbol(ArrayList<ArrayList<Puntos>> camino) throws IOException{
        FileWriter arbol = new FileWriter(".\\arbol.dat");

        for(int i=0;i<camino.size();i++){
            arbol.write(camino.get(i).get(0).getx()+" "+camino.get(i).get(0).gety()+ "\n");
            arbol.write(camino.get(i).get(1).getx()+" "+camino.get(i).get(1).gety()+ "\n");
            arbol.write("\n");
            arbol.write("\n");
        }
        
        arbol.close();
    }
}
