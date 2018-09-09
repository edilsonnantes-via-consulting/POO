package Classes;

import java.util.Calendar;

public class Cliente{
	private String cpf;
	private String nome;
	private int enderecoId;
	//private Calendar dataNasc;

	//Método construtor
        public Cliente(){}
        
	public Cliente(String nome, String cpf, int enderecoId){
		this.nome=nome;
		this.cpf=cpf;
		this.enderecoId=enderecoId;
	//	this.dataNasc=dataNasc;
	}
	
	/*//Método toString
	public String toString(){
		String aux ="";
		aux += "\nSocio ID.......: " + this.socioId;
		aux += "\nNome...........: " + this.nome;
		aux += "\nCPF............: " + this.cpf;
		//aux += "\nEndereco ID....: " + this.endereco.getEnderecoId();
		aux += "\nDt. Nascimento.: " + this.dataNasc.get(Calendar.DAY_OF_MONTH);
		aux += "/" + this.dataNasc.get(Calendar.MONTH);
		aux += "/" + this.dataNasc.get(Calendar.YEAR);
		return aux;
	}

	//Método para auxiliar a criar socio
	public static Cliente criar(Endereco ends[]){
		String nome;
		String cpf;
		Calendar dataNasc;
		Endereco endereco = null;
		System.out.printf("\nDADOS DE SOCIO \n");
		nome=Leitura.lerString("Digite nome: ");
		cpf=Leitura.lerString("Digite CPF: ");
		dataNasc=Leitura.lerData("Digite data (dd/mm/aaaa): ");
		int r = Leitura.lerInt("Ja possui endereco cadastrado?(1 - Sim/2 - Nao): ");
		
		if(r == 1){
			int id_pesquisa = Leitura.lerInt("Digite o ID do endereco: "); //ID que vai ser pesuisada se existe
			endereco = Endereco.pesquisar(id_pesquisa, ends);
		}

		//Se o enderco for Null, quer dizer que nao posui endereco cadastrado
		if(endereco==null){
			ends[Utilitario.ENDERECO_ID-1] = Endereco.criar();
			endereco = ends[Utilitario.ENDERECO_ID-1];
		}

		Cliente socios = new Cliente(nome,cpf,dataNasc,endereco);
		return socios;

	}
	
	//sets
	
	/*socioId não precisa de set, pois o Id é definido pelo metodo construtor*/
	
	public void setCPF(String cpf){
		this.cpf=cpf;
	}

	public void setNome(String nome){
		this.nome=nome;
	}

	public void setEnderecoId(int enderecoId){
		this.enderecoId=enderecoId;
	}

//	public void setDataNasc(Calendar dataNasc){
//		this.dataNasc=dataNasc;
//	}
	
	
	//gets
	
	public String getNome(){
		return this.nome;
	}

	public String getCPF(){
		return this.cpf;
	}

	public int getEnderecoId(){
		return this.enderecoId;
	}

//	public Calendar getDataNasc(){
//		return this.dataNasc;
//	}
/*
	//metodo de matricula
	public boolean matricular(int modalidadeId, Modalidade[] modalidade){
		Modalidade mod; //Auxiliar na pesquisa da modalidade
		boolean deuCerto=false; //Vai retornar se foi feito a matricula
		
		if(this.qtd_matriculas == Utilitario.TOTAL_MATRICULAS){
			System.out.println("Numero limite de matriculas alcançado!!");
		}else{
			mod = Modalidade.pesquisar(modalidadeId, modalidade);
			if(mod==null){
				System.out.println("Modalidade nao cadastrada!!"); 
			}else{
				this.matriculas[this.qtd_matriculas++] = new Matricula(mod);
				deuCerto=true;
			}
		}
		return deuCerto;
	}
*/
	
}