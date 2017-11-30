import java.util.Calendar;

public class Socio{
	private int socioId;
	private String cpf;
	private String nome;
	private Endereco endereco;
	private Calendar dataNasc;
	private Matricula[] matriculas;
	
	//Método construtor
	public Socio(String nome, String cpf, Calendar dataNasc, Endereco endereco){
		this.socioId=Utilitario.SOCIO_ID++;
		this.nome=nome;
		this.cpf=cpf;
		this.endereco=endereco;
		this.dataNasc=dataNasc;
	}
	
	//Método toString
	public String toString(){
		String aux ="";
		aux += "Nome: " + this.nome;
		return aux;
	}

	public static Socio criar(Endereco ends[]){
		String nome;
		String cpf;
		Calendar dataNasc;
		Endereco endereco;
		System.out.println("\nDados de Socio: \n");
		nome=Leitura.lerString("Digite nome: ");
		cpf=Leitura.lerString("Digite CPF: ");
		dataNasc=Leitura.lerData("Digite data: ");
		int r = Leitura.lerInt("Já possui endereço cadastrado?(1 - Sim/2 - Nao): ");
		if(r == 1){
			int x = Leitura.lerInt("Digite o ID do endereço: ");
			endereco = Endereco.pesquisar(x, ends);
		}
		else{
			endereco = Endereco.criar();
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
		Modalidade mod = Modalidade.pesquisar(modalidadeId, modalidade);
		Matricula[] matricula = new Matricula[Utilitario.MATRICULA_ID + 1];
		this.matriculas[Utilitario.MATRICULA_ID] = matricula[Utilitario.MATRICULA_ID]; 
		return true;
	}
	
	public boolean desmatricular(int matriculaId){
		Matricula mat = Matricula.pesquisar(matriculaId,matriculas);
		Calendar dataFim = Calendar.getInstance();
		mat.setDataFim(dataFim);
		return true;
	}
	
	
	public static Socio pesquisar(int id, Socio socs[]){
	    int i;
		for (i = 0; i < socs.length; i++){
		    if(id == socs[i+1].getSocioId()){
				break;
		    }
	    }
		if(id == socs[i+1].getSocioId()){
			return socs[i+1];
		}
		else{
			return null;
		}

	}
}