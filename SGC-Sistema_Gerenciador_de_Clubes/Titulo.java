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

    public static void criar(Endereco enderecos[]){
    	this.tituloid = Utilitario.TITULO_ID++;
    	int tipo = Leitura.lerInt("\nTipo: 1 - Individual / 2 - Familia");
    	String r = Leitura.lerString("Ja possui cadastro?");
    	Socio titular;
    	if(r == 'sim'){
            int i = Leitura.lerInt("Digite seu id: ");
            titular = Socio.pesquisar(i, socios);
    	}
    	else{
            tituluar = Socio.criar();
    	}
    	if(tipo == 2){
                Familiar.criar();
    	}


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
