package Codigo;

public class Puntos {
    private float id;
    private float x;
    private float y;

    Puntos(float id, float x, float y) {
        this.id = id;
        this.x = x;
        this.y = y;
    }
    
    Puntos(Puntos p){
        this.id = p.getid();
        this.x = p.getx();
        this.y = p.gety();
    }
    
    public float getid(){   return id;  }
    public float getx(){    return x;   }
    public float gety(){    return y;   }
    public void setid(int id){  this.id=id; }
    public void setx(float x){  this.x=x;   }
    public void sety(float y){  this.y=y;   }
}
