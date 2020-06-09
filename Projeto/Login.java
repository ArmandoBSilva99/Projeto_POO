import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.util.ArrayList;
public class Login  
{   
    //Armazena cada Utilizador, Voluntario, Transportadora e Loja na sua lista respetiva
    private Map<String, Utilizador> AllUtilizadores;
    private Map<String, Voluntario> AllVoluntarios;
    private Map<String, Transportadora> AllTransportadoras;
    private Map<String, Loja> AllLojas;
    
    public Login(){
        this.AllUtilizadores = new HashMap<>();
        this.AllVoluntarios = new HashMap<>();
        this.AllTransportadoras = new HashMap<>();
        this.AllLojas = new HashMap<>();
    }
    
    public Login(Map<String,Utilizador> u, Map<String,Voluntario> v, Map<String, Transportadora> t, Map<String, Loja> l){
        setAllUtilizadores(u);
        setAllVoluntarios(v);
        setAllTransportadoras(t);
        setAllLojas(l);
    }
    
    public Login(Login lo){
        this.AllUtilizadores = lo.getAllUtilizadores();
        this.AllVoluntarios = lo.getAllVoluntarios();
        this.AllTransportadoras = lo.getAllTransportadoras();
        this.AllLojas = lo.getAllLojas();
    }    
    
    //Getters
    
    public Map<String, Utilizador> getAllUtilizadores(){
        Map<String, Utilizador> u = new HashMap<>();
        for(Map.Entry<String, Utilizador> e : this.AllUtilizadores.entrySet()){
            u.put(e.getKey(), e.getValue().clone());
        }
        return u;
    }
    
    public Map<String, Voluntario> getAllVoluntarios(){
        Map<String, Voluntario> v = new HashMap<>();
        for(Map.Entry<String, Voluntario> e : this.AllVoluntarios.entrySet()){
            v.put(e.getKey(), e.getValue().clone());
        }
        return v;
    }   
    
    public Map<String, Transportadora> getAllTransportadoras(){
        Map<String, Transportadora> t = new HashMap<>();
        for(Map.Entry<String, Transportadora> e : this.AllTransportadoras.entrySet()){
            t.put(e.getKey(), e.getValue().clone());
        }
        return t;
    }   
    
    public Map<String, Loja> getAllLojas(){
        Map<String, Loja> l = new HashMap<>();
        for(Map.Entry<String, Loja> e : this.AllLojas.entrySet()){
            l.put(e.getKey(), e.getValue().clone());
        }
        return l;
    }
    
    //Setters
    
    public void setAllUtilizadores(Map<String, Utilizador> u){
        this.AllUtilizadores = new HashMap<>();
        for(Map.Entry<String, Utilizador> e: u.entrySet()){
            this.AllUtilizadores.put(e.getKey(), e.getValue().clone());
        }
    } 
    
    public void setAllVoluntarios(Map<String, Voluntario> v){
        this.AllVoluntarios = new HashMap<>();
        for(Map.Entry<String, Voluntario> e: v.entrySet()){
            this.AllVoluntarios.put(e.getKey(), e.getValue().clone());
        }
    } 
    
    public void setAllTransportadoras(Map<String, Transportadora> t){
        this.AllTransportadoras = new HashMap<String, Transportadora>();
        for(Map.Entry<String, Transportadora> e: t.entrySet()){
            this.AllTransportadoras.put(e.getKey(), e.getValue().clone());
        }
    } 
    
    public void setAllLojas(Map<String, Loja> l){
        this.AllLojas = new HashMap<String, Loja>();
        for(Map.Entry<String, Loja> e: l.entrySet()){
            this.AllLojas.put(e.getKey(), e.getValue().clone());
        }
    } 
    
    //toString
    
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("Utilizadores registados: ").append(this.AllUtilizadores).append("\n").
           append("Voluntarios registados: ").append(this.AllVoluntarios).append("\n").
           append("Transportadoras registadas: ").append(this.AllTransportadoras).append("\n").
           append("Lojas registadas: ").append(this.AllLojas).append("\n");
        return sb.toString();
    }   
    
    public Login clone(){
        return new Login(this);
    }    
    
    //Registar um utilizador, um voluntário, uma empresa transportadora e uma loja
    
    public void registarUtilizador(String codU, String nomeU, GPS gpsU, String pwU) throws JaRegistadoException{
        Utilizador u = new Utilizador(codU, nomeU, gpsU, pwU);
        if (AllUtilizadores.containsKey(u.getCodUtilizador())) throw new JaRegistadoException("Este utilizador ja foi registado! : " + u.getCodUtilizador());
        else AllUtilizadores.put(codU,u.clone());
    }    
    
    public void registarVoluntario(String codV, String nomeV, GPS gpsV, double raioV, String pwV) throws JaRegistadoException{
        Voluntario v = new Voluntario(codV, nomeV, gpsV, raioV, pwV, 0);
        if (AllVoluntarios.containsKey(v.getCodVoluntario())) throw new JaRegistadoException("Este Voluntario ja foi registado! : " + v.getCodVoluntario());
        else AllVoluntarios.put(codV, v.clone());
    }
    
    public void registarTrasportadora(String CodEmpresaT, String NomeT, GPS gpsT, String NifT, double RaioT, double precokmT, String pwT) throws JaRegistadoException{
        Transportadora t = new Transportadora(CodEmpresaT, NomeT, gpsT, NifT, RaioT, precokmT, pwT,new ArrayList<Encomenda>(),0);
        if (AllTransportadoras.containsKey(t.getCodEmpresa())) throw new JaRegistadoException("Esta Transportadora ja foi registada! : " + t.getCodEmpresa());
        else AllTransportadoras.put(CodEmpresaT, t.clone());
    }    
    
    public void registarLoja(String CodLoja, String NomeL, GPS gpsL, String pwL, Map<Utilizador, Encomenda> enc) throws JaRegistadoException{
        Loja l = new Loja(CodLoja, NomeL, gpsL, pwL, enc);
        if (AllLojas.containsKey(l.getCodLoja())) throw new JaRegistadoException("Esta Loja ja foi registada! : " + l.getCodLoja());
        else AllLojas.put(CodLoja,l.clone());
    }   
    
    
    //Validar o acesso à aplicação utilizando as credenciais (Codigo e password)
    
    public boolean validaUtilizador(String CodU, String pass){
        return AllUtilizadores.containsKey(CodU) && AllUtilizadores.get(CodU).getPwU().equals(pass);
    }    
    
    public boolean validaVoluntario(String CodV, String pass){
        return AllVoluntarios.containsKey(CodV) && AllVoluntarios.get(CodV).getPwV().equals(pass);
    }  
    
    public boolean validaTransportadora(String CodT, String pass){
        return AllTransportadoras.containsKey(CodT) && AllTransportadoras.get(CodT).getPwT().equals(pass);
    }    
    
    public boolean validaLoja(String CodL, String pass){
        return AllLojas.containsKey(CodL) && AllLojas.get(CodL).getPwL().equals(pass);
    }    
}
