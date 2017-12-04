/**
 * @(#)Titulo.java
 *
 *
 * @author
 * @version 1.00 2017/11/23
 */


import java.util.Calendar;
 
 public class Titulo {

    private int tituloId;
    private Socio titular;
    private Mensalidade mensalidades[];


	//metodo construtor
    public Titulo(Socio titular, Mensalidade mensalidades[]){
        this.tituloId = Utilitario.TITULO_ID++;
        this.titular = titular;
        this.mensalidades = mensalidades;
	}
	
	//metodo toString
	public String toString(){
		String aux ="";
		aux += "\nTitulo ID......: " + this.tituloId;
		return aux + titular.toString();
	}


    public int getTituloId(){
    	return this.tituloId;
    }

    public Socio getTitular(){
    	return this.titular;
    }

    public Mensalidade[] getMensalidade(){
		return mensalidades;
	}

    public static Titulo criar(Endereco enderecos[]){
		Socio titular = Socio.criar(enderecos);
		Mensalidade[] mensalidades = new Mensalidade[12];

		int tipo = Leitura.lerInt("\nTipo: 1 - Individual / 2 - Familiar: ");
		switch(tipo){
			case 1:
				return new Individual(titular, mensalidades);
			case 2:
				return Familiar.criar(titular,enderecos,mensalidades);
			default:
				System.out.println("Opcao Invalida");
		}

		return null;
    }

    public static Titulo pesquisarTitulo(int id, Titulo[] titulo){
		int i=0;
		
		try{
			for(i = 0; i < titulo.length; i++){
				if(id == titulo[i].getTituloId()){
					return titulo[i];
				}
			}
		}catch(NullPointerException erroNenhumElemento){
			System.out.println("Nao ha socio cadastrado");
		}catch(Exception erro){
			System.out.println("Ocorreu um erro inesperado");
		}
		
		return null;
	}

	public Mensalidade calcularMensalidade(Socio soci[]){
		Socio s_pagar = Socio.pesquisarSocio(Leitura.lerInt("Digite uma ID: "), soci);
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
				this.mensalidades[mes-1].setDataPagamento();
				return true;
        }else{
				System.out.printf("Data invalida");
		}
		return false;
 	}
}
