import java.util.*;
import java.util.ArrayList;

public class Encomenda
{
    //Variaveis
    
    private String codEncomenda;
    private String codUtilizador;
    private String codLoja;
    private double peso;
    private ArrayList<LinhaEncomenda> linha;
    private int classificacao;
    private double custoTransporte;
    private int tempo;
    
    //Instancias
    public Encomenda(){
        this.codEncomenda = "n/a";
        this.codUtilizador = "n/a";
        this.codLoja = "n/a";
        this.peso = 0.0;
        this.linha = new ArrayList<LinhaEncomenda>();
        this.classificacao = 0;
        this.custoTransporte = 0.0;
        this.tempo = 0;
    }    
    
    public Encomenda(String codenc, String codutil, String codloja, Double pes, ArrayList<LinhaEncomenda> le, int classi, double custo,int tempo){
        this.codEncomenda = codenc;
        this.codUtilizador = codutil;
        this.codLoja = codloja;
        this.peso = pes;
        setLinha(le);
        this.classificacao = classi;
        this.custoTransporte = custo;
        this.tempo = tempo;
    }    
    
    public Encomenda (Encomenda e){
        this.codEncomenda = e.getCodEncomenda();
        this.codUtilizador = e.getCodUtilizador();
        this.codLoja = e.getCodLoja();
        this.peso = e.getPeso();
        this.linha = e.getLinha();
        this.classificacao = e.getClassificacao();
        this.custoTransporte = e.getCustoTransporte();
        this.tempo = e.getTempo();
    }  
    
    //Getters
    
    public String getCodEncomenda(){
        return this.codEncomenda;    
    } 
    
    public String getCodUtilizador(){
        return this.codUtilizador;    
    } 
    
    public String getCodLoja(){
        return this.codEncomenda;    
    } 
    
    public Double getPeso(){
        return this.peso;
    } 
    
    public ArrayList<LinhaEncomenda> getLinha(){
        ArrayList<LinhaEncomenda> novo = new ArrayList<LinhaEncomenda>();
        for (LinhaEncomenda l: this.linha){
            novo.add(l.clone());
        }  
        return novo;
    }
    
    public Integer getClassificacao(){ 
        return this.classificacao;
        }
        
    public Double getCustoTransporte(){
        return this.custoTransporte;
    }   
    
    public int getTempo(){ 
     return this.tempo;
    }
    //Setters
    
    public void setCodEncomenda(String codenco){
        this.codEncomenda = codenco;    
    } 
    
    public void setCodUtilizador(String util){
        this.codUtilizador = util;
    }    
    
    public void setCodLoja(String codl){
        this.codLoja = codl;
    }    
    
    public void setPeso(Double peso){
        this.peso = peso;
    } 
    
    public void setLinha(ArrayList<LinhaEncomenda> le){
        linha.clear();
        for(LinhaEncomenda l: le){
            this.linha.add(l.clone());
        }    
    }
    
    public void setClassificacao(int classi){ 
        this.classificacao = classi;
        }
    
    public void setCustoTransporte(double custo){
        this.custoTransporte = custo;
    }
    
    public void setTempo(int tempo){
      this.tempo = tempo;
    }
    //toString
    
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("Codigo Encomenda: ").append(this.codEncomenda).append("\n").
           append("Codigo Utilizador: ").append(this.codUtilizador).append("\n").
           append("Codigo Loja: ").append(this.codLoja).append("\n").
           append("Peso: ").append(this.peso).append("\n").
           append("Linha Encomendada: ").append(this.linha.toString()).append("\n").
           append("Classificaçao: ").append(this.classificacao).append("\n");
           
        return sb.toString();    
    }    
    
    //Equals
    
    public boolean equals (Object o){ 
      if (o == this) return true;
      if (o == null || o.getClass() != this.getClass()) return false;
      Encomenda e = (Encomenda) o;
      return this.codEncomenda.equals(e.getCodEncomenda())&&
             this.codUtilizador.equals(e.getCodUtilizador())&&
             this.codLoja.equals(e.getCodLoja())&&
             (this.peso == e.getPeso()) &&
             this.linha.equals(e.getLinha()) &&
             (this.classificacao == e.getClassificacao()) &&
             this.custoTransporte == e.getCustoTransporte()&&
             this.tempo == e.getTempo();
    } 
    
    //Clone
    
    public Encomenda clone(){
        return new Encomenda(this);
    }   
    
    public double custo(Loja l, Utilizador u, Transportadora t){
        int x = 0;
        double distLoja = Math.sqrt(Math.pow(t.getGPSE().getX() + l.getGPSL().getX(), 2) - Math.pow(t.getGPSE().getY() + l.getGPSL().getY(), 2));
        double distLojaCasa = Math.sqrt(Math.pow(l.getGPSL().getX() + u.getGPS().getX(), 2) - Math.pow(l.getGPSL().getY() + u.getGPS().getY(), 2));
        for (LinhaEncomenda a: this.linha) {
            x += a.getValorUnitario();
        }    
        double custo = x + this.getPeso() + (distLoja * t.getPrecoKm()) + (distLojaCasa * t.getPrecoKm());
        return custo;
    }
    
    //toStringCSV
    
    public String toStringCSV(){
       StringBuilder sb = new StringBuilder();
       sb.append(this.codEncomenda).append(",")
         .append(this.codUtilizador).append(",")
         .append(this.codLoja).append(",")
         .append(this.peso).append(",")
         .append(this.linha).append(",")
         .append(this.classificacao);
       return sb.toString();  
   }    
}
