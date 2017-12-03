import java.util.Calendar;

public class Socio{
	private int socioId;
	private String cpf;
	private String nome;
	private Endereco endereco;
	private Calendar dataNasc;
	private Matricula[] matriculas;
	private int qtd_matriculas; //Controlador de quantidde de matriculas efetuadas

	//Método construtor
	public Socio(String nome, String cpf, Calendar dataNasc, Endereco endereco){
		this.socioId=Utilitario.SOCIO_ID++;
		this.nome=nome;
		this.cpf=cpf;
		this.endereco=endereco;
		this.dataNasc=dataNasc;
		this.matriculas = new Matricula[Utilitario.TOTAL_MATRICULAS];
		this.qtd_matriculas= 0;
		
	}
	
	//Método toString
	public String toString(){
		String aux ="";
		aux += "Nome: " + this.nome;
		return aux;
	}

	//Método para auxiliar a criar socio
	public static Socio criar(Endereco ends[]){
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

		Socio socios = new Socio(nome,cpf,dataNasc,endereco);
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

	public void setEndereco(Endereco endereco){
		this.endereco=endereco;
	}

	public void setDataNasc(Calendar dataNasc){
		this.dataNasc=dataNasc;
	}
	
	
	//gets
	public int getSocioId(){
		return this.socioId;
	}
	
	public String getNome(){
		return this.nome;
	}

	public String getCPF(){
		return this.cpf;
	}

	public Endereco getEndereco(){
		return this.endereco;
	}

	public Calendar getDataNasc(){
		return this.dataNasc;
	}
	
	public Matricula[] getMatriculas(){
		return matriculas;
	}

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
	
	public boolean desmatricular(int matriculaId){
		Matricula mat; //Onde vai ficar a matricula case seja encontrado

		if(this.qtd_matriculas == 0){
			System.out.println("Socio nao possui matricula!!");
		}else{
			mat = Matricula.pesquisar(matriculaId,this.matriculas);
			if(mat==null){
				System.out.println("Nao foi encontrado matricula");
			}else{
				mat.setDataFim();
				return true;
			}
		}
		return false;
	}
	
	
	public static Socio pesquisarSocio(int id, Socio[] soc){
		int i=0;
		
		try{
			for(i = 0; i < soc.length; i++){
				if(id == soc[i].getSocioId()){
					return soc[i];
				}
			}
		}catch(NullPointerException erroNenhumElemento){
			System.out.println("Nao ha socio cadastrado");
		}catch(Exception erro){
			System.out.println("Ocorreu um erro inesperado");
		}
		
		return null;
	}
}