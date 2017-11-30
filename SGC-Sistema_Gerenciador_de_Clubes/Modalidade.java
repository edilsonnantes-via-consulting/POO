public class Modalidade{
    private int modalidadeId;
    private String nome;
    private float valor;
    private int frequencia;
	
	
	public int getId(){
		return modalidadeId;
	}
	
	public String getNome(){
		return nome;
	}
	
	public float getValor(){
		return valor;
	}
	
	public int getFrequencia(){
		return frequencia;
	}
	
	public Modalidade(String nome, float valor, int frequencia){
		this.modalidadeId = Utilitario.MODALIDADE_ID++;
		this.nome = nome;
		this.valor = valor;
		this.frequencia = frequencia;
	}
	
	
	public static Modalidade criar(){
		String nome = Leitura.lerString("Digite o nome da modalidade: ");
		float valor = Leitura.lerFloat("Digite o valor da modalidade: ");
		int frequencia = Leitura.lerInt("Digite a frequencia semanal: ");
		Modalidade modalidade = new Modalidade(nome, valor, frequencia);
		return modalidade;
	}
	
	
	public static Modalidade pesquisar(int id, Modalidade modalidades[]){
	    int i;
		for (i = 0; i < modalidades.length; i++){
		    if(id == modalidades[i+1].getId()){
				break;
		    }
	    }
		if(id == modalidades[i+1].getId()){
			return modalidades[i+1];
		}
		else{
			return null;
		}

	}
	
	public String toString(){
		String aux = "";
		aux += "Nome: " + this.nome;
		aux += "\nValor: " + this.valor;
		aux += "\nFrequencia: " + this.frequencia;
		return aux;
	}
}
