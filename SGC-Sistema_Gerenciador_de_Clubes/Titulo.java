/**
 * @(#)Titulo.java
 *
 *
 * @author 
 * @version 1.00 2017/11/23
 */


public class Titulo {

    private int tituloid;
    private Socio titular;
    private Mensalidade mensalidades[];
    
    
    public void getTituloid(){
    	return this.tituloid;
    }
    
    public void getTitular(){
    	return this.titular;
    }
    
    public void getMensalidades(){
    	return this.mensalidades;
    }
    
    public Titulo criar(Endereco enderecos[]){
    	this.tituloid = Utilitario.TITULO_ID++;
    	int tipo;
    	System.out.printf("1- Indivual\n2- Familiar");
    	
    }
    
    public Titulo pesquisar(int id, Titulo titulos[]){
    	for(int i = 0; i <= titulos.lentgh; i++){
    		if(id == titulos[i].getTituloid()){
    			return titulos[i];
    		}
    		else{
    			return NULL;
    		}
    	}
    }
}