public class Modalidade{
    private int modalidadeId;
    private String nome;
    private float valor;
    private int frequencia;
	
	//metodo construtor
	public Modalidade(String nome, float valor, int frequencia){
		this.modalidadeId = Utilitario.MODALIDADE_ID++;
		this.nome = nome;
		this.valor = valor;
		this.frequencia = frequencia;
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
	
	//modalidadeId não pode ser modificado, por isso não possui set. Ele é definido no criar.
	public void setNome(String nome){
		this.nome=nome;
	}

	public void setValor(float valor){
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

	//Método para criar uma nova modalidade
	public static Modalidade criar(){
		String nome = Leitura.lerString("Digite o nome da modalidade: ");
		float valor = Leitura.lerFloat("Digite o valor da modalidade: ");
		int frequencia = Leitura.lerInt("Digite a frequencia semanal: ");
		return new Modalidade(nome, valor, frequencia);
	}
	
	//Método para pesquisar uma modalidade a partir do ID
	public static Modalidade pesquisar(int id, Modalidade modalidades[]){
	    int i;
		for (i = 0; i < modalidades.length; i++){
		    if(id == modalidades[i].getId()){
				break;
		    }
	    }
		if(id == modalidades[i].getId()){
			return modalidades[i+1];
		}
		else{
			return null;
		}
	}
}
