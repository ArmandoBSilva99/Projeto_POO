
public class GPS
{
    private double x;
    private double y;
    
    public GPS(){ 
     this.x = 0;
     this.y = 0;
    }
    public GPS (double x,double y){ 
     this.x = x;
     this.y = y;
    }
    public GPS(GPS g){ 
     this.x = getX();
     this.y = getY();
    }
    public double getX(){ 
     return this.x;
    }
    public double getY(){ 
     return this.y;
    }
    public void setX(double x){ 
     this.x = x ;
    }
    public void setY(double y){ 
     this.y = y ;
    }
    public String toString(){
       StringBuilder sb = new StringBuilder();
       sb.append ("Coordenadas: ").append(this.x).append(",").append(this.y);
       return sb.toString();
    }
    public boolean equals(Object o){ 
     if (o == this) return true;
     if (o == null || o.getClass() != this.getClass()) return false;
     
     GPS g = (GPS) o;
     return (this.x == g.getX())&&(this.y == g.getY());
          
    }
    public GPS clone(){ 
     return new GPS (this);
    }
} 