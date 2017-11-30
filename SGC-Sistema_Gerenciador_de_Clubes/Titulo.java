/**
 * @(#)Titulo.java
 *
 *
 * @author
 * @version 1.00 2017/11/23
 */


import java.util.Calendar;
 
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
    	int tipo = Leitura.lerInt("\nTipo: 1 - Individual / 2 - Familiar: \n");
    	int meses = Leitura.lerInt("Quantos meses deseja contratar? \n");
		Mensalidade[] mensalidades = new Mensalidade[meses];
		Socio titular = Socio.criar(enderecos);
		if (tipo == 2){
			return Familiar.criar(titular, enderecos, mensalidades);
		}
		return new Titulo(titular,mensalidades);
    }

    public static Titulo pesquisar(int id, Titulo titulos[]){
    	int i;
		for(i = 0; i <= titulos.length; i++){
    		if(id == titulos[i+1].getTituloid()){
    			break;
    		}
    	}
		if(id == titulos[i+1].getTituloid()){
    			return titulos[i+1];
    		}
    		else{
    			return null;
    		}
	}

	public Mensalidade calcularMensalidade(Socio soci[]){
		Socio s_pagar = Socio.pesquisar(Leitura.lerInt("Digite uma ID: "), soci);
		Matricula mt[] = s_pagar.getMatriculas();
		float soma = 0;
		for (int a = 0; a < mt.length; a++){
			Modalidade md = mt[a].getModalidade();
			soma += md.getValor();
		}
		float valor = Utilitario.custoBasico + soma;
		return new Mensalidade(valor);
	}
	
	public boolean pagarMensalidade(int mes){
    	if(mes>0 && mes<13){ 
				this.mensalidades[mes].setDataPagamento();
				return true;
        }else{
				System.out.printf("Data invalida");
		}
		return false;
 	}
}
