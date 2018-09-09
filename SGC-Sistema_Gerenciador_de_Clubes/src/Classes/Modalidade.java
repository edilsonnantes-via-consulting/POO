package Classes;

public class Modalidade{
    private int modalidadeId;
    private String nome;
    private int valor;
    private int frequencia;
	


//metodo construtor
public Modalidade(String nome, int valor, int frequencia){
		this.nome = nome;
		this.valor = valor;
		this.frequencia = frequencia;
}

public Modalidade() {
    this("Qualquer",1,1);
}



	//Método toString
	public String toString(){
		String aux = "";
		aux += "Nome: " + this.nome;
		aux += "\nValor: " + this.valor;
		aux += "\nFrequencia: " + this.frequencia;
		return aux;
	}

	//sets
	
	public void setId(int id){
            this.modalidadeId = id;
        }
	
	public void setNome(String nome){
		this.nome=nome;
	}

	public void setValor(int valor){
		this.valor=valor;
	}

	public void setFrequencia(int frequencia){
		this.frequencia=frequencia;
	}

	public int getId(){
		return this.modalidadeId;
	}
	
	//gets
	public String getNome(){
		return this.nome;
	}
	
	public float getValor(){
		return this.valor;
	}
	
	public int getFrequencia(){
		return this.frequencia;
	}
	
	//Método para pesquisar uma modalidade a partir do ID
	public static Modalidade pesquisar(int id, Modalidade modalidades[]){
		int i;
		try{
			for (i = 0; i < modalidades.length; i++){
				if(id == modalidades[i].getId()){
					return modalidades[i];
				}
			}
		}catch(NullPointerException erroNenhumElemento){
			System.out.println("Nao ha nenhuma modalidade cadastrada");
		}catch(Exception erro){
			System.out.println("Ocorreu um erro inesperado!");
		}
			return null;
	}
}
