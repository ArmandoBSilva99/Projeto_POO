import java.util.*;

public class Loja
{
  private String codLoja;
  private String nomeL;
  private GPS gpsL;
  private String pwL;
  private Map<Utilizador, Encomenda> pedidosEncomendas;
  
  public Loja(){ 
    this.codLoja = "n/a";
    this.nomeL = "n/a";
    this.gpsL = new GPS();
    this.pwL = "0000";
    this.pedidosEncomendas = new HashMap<Utilizador, Encomenda>();
    }
  public Loja(String codigo,String nome,GPS gps, String pw, Map<Utilizador, Encomenda> pedEnc){
    this.codLoja = codigo;
    this.nomeL = nome;
    this.gpsL = gps.clone();
    this.pwL = pw;
    this.pedidosEncomendas = pedEnc;
    }
  public Loja(Loja l){ 
   this.codLoja = l.getCodLoja();
   this.nomeL = l.getNomeL();
   this.gpsL = l.getGPSL();
   this.pwL = l.getPwL();
   this.pedidosEncomendas = l.getPedidosEncomendas();
    }
  public String getCodLoja(){ 
   return this.codLoja;
    }
  public String getNomeL(){ 
   return this.nomeL;
    }
  public GPS getGPSL(){ 
    return this.gpsL.clone();
    }
  public String getPwL(){
    return this.pwL;
    }   
  public Map<Utilizador, Encomenda> getPedidosEncomendas(){
      Map<Utilizador, Encomenda> e = new HashMap<>();
      for(Map.Entry<Utilizador, Encomenda> entry : this.pedidosEncomendas.entrySet()){
          e.put(entry.getKey().clone(), entry.getValue().clone());
        }    
      return e;  
    }   
  public void setCodLoja(String codigo){ 
    this.codLoja = codigo;
    }
  public void setNomeL(String nome){ 
    this.nomeL = nome;
    }
  public void setGPSL(GPS gps){ 
    this.gpsL = gps.clone();
    }
  public void setPwL(String pw){
    this.pwL = pw;  
    }    
  public void setPedidosEncomendas(Map<Utilizador, Encomenda> pedEnc){
      this.pedidosEncomendas = new HashMap<>();
      for(Map.Entry<Utilizador, Encomenda> entry: pedEnc.entrySet()) {
         this.pedidosEncomendas.put(entry.getKey().clone(), entry.getValue().clone());
        }    
    }  
  public String toString(){
       StringBuilder sb = new StringBuilder();
       sb.append("Codigo: ").append(this.codLoja).append("\n").
       append("Nome: ").append(this.nomeL).append("\n").
       append("Local: ").append(this.gpsL).append("\n").
       append("Lista de Encomendas pedidas: ").append(this.pedidosEncomendas).append("\n");
       return sb.toString();
       //Nao mostra password
    } 
  public boolean equals (Object o){ 
       if (o == this) return true;
      if (o == null || o.getClass() != this.getClass()) return false;
      Loja l = (Loja) o;
      return this.codLoja.equals(l.getCodLoja())&&
             this.nomeL.equals(l.getNomeL())&&
             this.gpsL.equals(l.getGPSL()) &&
             this.pwL.equals(l.getPwL()) &&
             this.pedidosEncomendas.equals(l.getPedidosEncomendas());
    } 
  public Loja clone(){ 
    return new Loja (this);
    }
    
 
  //inserir informação de encomenda pronta a ser entregue, por parte das lojas;
    
  public String InfoEncomendaAceite(Encomenda e){
      return e.toString() + e.getCustoTransporte().toString();
   } 
    
   
  //toStringCSV
  
  public String toStringCSV(){
       StringBuilder sb = new StringBuilder();
       sb.append(this.codLoja).append(",")
         .append(this.nomeL).append(",")
         .append(this.gpsL.getX()).append(",")
         .append(this.gpsL.getY()).append(",")
         .append(this.pedidosEncomendas);
       return sb.toString();  
   }    
}