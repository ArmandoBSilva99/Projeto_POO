import java.util.*;
public class Utilizador
{
   //Variaveis
   private String codUtilizador;
   private String nome;
   private GPS gps;
   private String pwU;
   
   //Instancias
   public Utilizador(){
    this.codUtilizador = "n/a";
    this.nome = "n/a";
    this.gps = new GPS();
    this.pwU = "0000";
   }
   
   public Utilizador(String codigo,String nome,GPS gp, String pw){
    this.codUtilizador = codigo;
    this.nome= nome;
    this.gps = gp.clone();
    this.pwU = pw;
    }
    
   public Utilizador(Utilizador u){
    this.codUtilizador = u.getCodUtilizador();
    this.nome = u.getNome();
    this.gps= u.getGPS();
    this.pwU = u.getPwU();
    }
    
   //Getters 
   public String getCodUtilizador(){
       return this.codUtilizador;
    }
    
   public String getNome(){
       return this.nome;
    }
    
   public GPS getGPS(){
       return this.gps.clone();
    }
    
   public String getPwU(){
       return this.pwU;
    }   
    
   //Setters 
   public void setCodUtilizador(String util){
       this.codUtilizador=util;
    }
    
   public void setNome(String nome){
       this.nome = nome;
    }
    
   public void setGPS(GPS gp){
       this.gps = gp.clone();
    } 
    
   public void setPwU(String pw){
       this.pwU = pw;
    }   
    
   //toString
   public String toString(){
       StringBuilder sb = new StringBuilder();
       sb.append("Codigo: ").append(this.codUtilizador).append("\n").
       append("Nome: ").append(this.nome).append("\n").
       append("Local: ").append(this.gps).append("\n");
       return sb.toString();
       //Nao mostra password
    } 
    
    //boolean
   public boolean equals (Object o){ 
      if (o == this) return true;
      if (o == null || o.getClass() != this.getClass()) return false;
      Utilizador u = (Utilizador) o;
      return this.codUtilizador.equals(u.getCodUtilizador())&&
             this.nome.equals(u.getNome())&&
             this.gps.equals(u.getGPS()) &&
             this.pwU.equals(u.getPwU());
    }
    
   //Clone 
   public Utilizador clone(){
    return new Utilizador(this);
    }
   
   //inserir pedidos de encomendas a uma loja, por parte de um utilizador
   
   public void pedeEncomenda(Encomenda e, Loja l){
          l.getPedidosEncomendas().put(this, e);
   }
    
    
   public boolean aceitaPreco(Encomenda e){
       return true;
   }    
   
   //inserir classificacao da encomenda
   public void classificaEncomenda(Encomenda e,int classificacao){ 
       e.setClassificacao(classificacao);
    } 
   
   //classificar um voluntario
   public void classificaVoluntario(Voluntario v,int classificacao){ 
    v.setClassificacao((v.getClassificacao() + classificacao )/2);
    }
   
   //classificar transportadora
   public void classificaTransportadora( Transportadora t , int classificacao){ 
    t.setClassificacao((t.getClassificacao() + classificacao )/2);
    }
   
   //toString SCSV
   
   public String toStringCSV(){
       StringBuilder sb = new StringBuilder();
       sb.append(this.codUtilizador).append(",")
         .append(this.nome).append(",")
         .append(this.gps.getX()).append(",")
         .append(this.gps.getY()).append(",")
         .append(this.pwU);
       return sb.toString();  
   }    
}