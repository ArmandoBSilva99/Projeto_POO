
public class EncomendasAceites
{
  private String CodEncomenda;
  
  
  public EncomendasAceites(){
      this.CodEncomenda = new String();
  }
  
  public EncomendasAceites(String codigo){ 
    setCodEncomendas(codigo);
  }
  
  public EncomendasAceites(EncomendasAceites ea){ 
    this.CodEncomenda = ea.getCodEncomenda();
  }
    
  public String getCodEncomenda(){ 
    return this.CodEncomenda;
  }
  
  public void setCodEncomendas(String codigo){ 
    this.CodEncomenda = codigo;
  }
  
  public String toString(){
       StringBuilder sb = new StringBuilder();
       sb.append("Codigo: ").append(this.CodEncomenda).append("\n");
       return sb.toString();
  }
  
  public boolean equals (Object o){ 
       if (o == this) return true;
      if (o == null || o.getClass() != this.getClass()) return false;
      EncomendasAceites ea = (EncomendasAceites) o;
      return this.CodEncomenda.equals(ea.getCodEncomenda());
  }
  
  public EncomendasAceites clone(){ 
    return new EncomendasAceites(this);
  }
  
} 