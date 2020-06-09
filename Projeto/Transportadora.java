import java.util.*;
public class Transportadora
{
    
   //Variaveis 
   private String codEmpresa;
   private String nomeE;
   private GPS gpsE;
   private String nif;
   private double raioE;
   private double precokm;
   private String pwT;
   private List<Encomenda> encomendasConcluidas;
   private int classificacao;
   
   //Instancias
   public Transportadora(){
    this.codEmpresa= "n/a";
    this.nomeE = "n/a";
    this.gpsE = new GPS();
    this.nif = "n/a";
    this.raioE=0.0;
    this.precokm = 0.0;
    this.pwT = "0000";
    this.encomendasConcluidas = new ArrayList<Encomenda>();
    this.classificacao = 0;
    }
    
   public Transportadora(String codigo,String nome,GPS gps,String nif,double raio,double precokm, String pw, List<Encomenda> enc,int classi){ 
    this.codEmpresa= codigo;
    this.nomeE = nome;
    this.gpsE = gps.clone();
    this.nif = nif;
    this.raioE= raio;
    this.precokm = precokm;
    this.pwT = pw;
    this.encomendasConcluidas = enc;
    this.classificacao = classi;
    }
    
   public Transportadora(Transportadora t){
    this.codEmpresa= t.getCodEmpresa();
    this.nomeE = t.getNomeE();
    this.gpsE = t.getGPSE();
    this.nif = t.getNif();
    this.precokm = t.getPrecoKm();
    this.raioE = t.getRaioE();
    this.pwT = t.getPwT();
    this.encomendasConcluidas = t.getEncomendasConcluidas();
    this.classificacao = t.getClassificacao();
    }
    
   //Getters
   public String getCodEmpresa(){ 
    return this.codEmpresa;
    }
    
   public String getNomeE(){ 
    return this.nomeE;
    }
    
   public GPS getGPSE(){ 
    return this.gpsE.clone();
    }
    
   public String getNif(){ 
    return this.nif;
    }
    
   public double getPrecoKm(){
    return this.precokm;
    }
    
   public double getRaioE(){ 
    return this.raioE;
    }
    
   public String getPwT(){
       return this.pwT;
    } 
    
   public List<Encomenda> getEncomendasConcluidas(){
       List<Encomenda> res = new ArrayList<>();
       for(Encomenda e: this.encomendasConcluidas)
            res.add(e.clone());
       return res;     
    }   
   
   public int getClassificacao(){ 
    return this.classificacao;
    }
   //Setters 
   public void setCodEmpresa(String codigo){ 
    this.codEmpresa = codigo;
    }
    
   public void setNomeE(String nome){ 
    this.nomeE = nome;
    }
    
   public void setGPSE(GPS gps){ 
    this.gpsE = gps.clone();
    }
    
   public void setNif(String nif){ 
    this.nif = nif;
    }
    
   public void setPrecoKm(Double preco){ 
    this.precokm = preco;
    }
    
   public void setRaioE(Double raio){ 
    this.raioE = raio ;
    }
    
   public void setPwT(String pw){
       this.pwT = pw;
    }   
    
   public void setEncomendasConcluidas(List<Encomenda> enc){
       this.encomendasConcluidas = new ArrayList<>();
       for(Encomenda e: enc)
            this.encomendasConcluidas.add(e);     
    }   
   
   public void setClassificacao(int classi){ 
     this.classificacao = classi;
    }
   //toString 
   public String toString(){
       StringBuilder sb = new StringBuilder();
       sb.append("Codigo: ").append(this.codEmpresa).append("\n").
       append("Nome: ").append(this.nomeE).append("\n").
       append("Local: ").append(this.gpsE).append("\n").
       append("Nif: ").append(this.nif).append("\n").
       append("Preço(p/km): ").append(this.precokm).append("\n").
       append("Raio: ").append(this.raioE).append("\n").
       append("Classificação: ").append(this.classificacao).append("\n");
       return sb.toString();
       //Nao mostra password
    }   
    
   //Boolean 
   public boolean equals (Object o){ 
       if (o == this) return true;
      if (o == null || o.getClass() != this.getClass()) return false;
      Transportadora t = (Transportadora) o;
      return this.codEmpresa.equals(t.getCodEmpresa())&&
             this.nomeE.equals(t.getNomeE())&&
             this.gpsE.equals(t.getGPSE())&&
             this.raioE == t.getRaioE() &&
             this.nif.equals(t.getNif()) &&
             this.precokm == t.getPrecoKm() &&
             this.pwT.equals(t.getPwT())&&
             this.classificacao == t.getClassificacao();
    } 
    
   //Clone 
   public Transportadora clone (){ 
    return new Transportadora(this);
    }
    
   public void adicionaEncConcluida(Encomenda e){
       this.encomendasConcluidas.add(e);
    }
    
   public void registacusto(Encomenda e,Double custo){ 
       e.setCustoTransporte(custo);
   }
    
   public double faturado(){
       double fat = 0; 
       for(Encomenda e: this.encomendasConcluidas) {
           fat += e.getCustoTransporte();
        }
       return fat; 
    }  
    
   public String toStringCSV(){
       StringBuilder sb = new StringBuilder();
       sb.append(this.codEmpresa).append(",")
         .append(this.nomeE).append(",")
         .append(this.gpsE.getX()).append(",")
         .append(this.gpsE.getY()).append(",")
         .append(this.nif).append(",")
         .append(this.raioE).append(",")
         .append(this.precokm).append(",")
         .append(this.encomendasConcluidas).append(",")
         .append(this.classificacao).append(",")
         .append(this.pwT);
       return sb.toString();  
   }     
}