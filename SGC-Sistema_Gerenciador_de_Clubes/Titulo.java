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



    public Titulo(Socio titular, Mensalidade mensalidades[]){
        this.tituloid = Utilitario.TITULO_ID++;
        this.titular = titular;
        this.mensalidades = mensalidades;
    }


    public int getTituloid(){
    	return this.tituloid;
    }

    public Socio getTitular(){
    	return this.titular;
    }

    public Mensalidade[] getMensal(){
		return mensalidades;
	}

    public static Titulo criar(Endereco enderecos[]){
    	this.tituloid = Utilitario.TITULO_ID++;
    	int tipo = Leitura.lerInt("\nTipo: 1 - Individual / 2 - Familia");
    	String r = Leitura.lerString("Ja possui cadastro?");
    	Socio titular;
    	if(r == "sim"){
            int i = Leitura.lerInt("Digite seu id: ");
            titular = Socio.pesquisar(i, socios);
    	}
    	else{
            titular = Socio.criar();
    	}
    	if(tipo == 2){
                Familiar.criar();
    	}


    }

    public static Titulo pesquisar(int id, Titulo titulos[]){
    	for(int i = 0; i <= titulos.lentgh; i++){
    		if(id == titulos[i].getTituloid()){
    			break;
    		}
    	}
		if(id == titulos[i].getTituloid()){
    			return titulos[i];
    		}
    		else{
    			return null;
    		}
    }
}
