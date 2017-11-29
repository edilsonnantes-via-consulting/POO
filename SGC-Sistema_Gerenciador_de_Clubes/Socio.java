import java.util.Calendar;

public class Socio{
	private int socioId;
	private String cpf;
	private String nome;
	private Endereco endereco;
	private Calendar dataNasc;
	private Matricula matriculas[];
	
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

	public static Socio criar(){
		String nome;
		String cpf;
		Calendar dataNasc;
		Endereco endereco;

		nome=Leitura.lerString("Digite nome: ");
		cpf=Leitura.lerString("Digite CPF: ");
		dataNasc=Leitura.lerData("Digite data: ");
		endereco = Endereco.criar();
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

//metodo de matricula
	/*public boolean matricular(int modalidadeId, Modalidades[] modalidade){
		
	}*/
	public static Socio pesquisar(int id, Socio socs[]){
	    int i;
		for (i = Utilitario.SOCIO_ID; i <= socs.length; i++){
		    if(id == socs[i].getSocioId()){
				break;
		    }
	    }
		if(id == socs[i].getSocioId()){
			return socs[i];
		}
		else{
			return null;
		}

	}
}