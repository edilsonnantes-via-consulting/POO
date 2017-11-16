public class Endereco{
	private int enderecoId;
	private String rua;
	private int numero;
	private String cep;
	private String cidade;
	private String estado;

	//construtor
	public Endereco(){

	}


	public Endereco criar(){
		this.enderecoId = Utilitario.ENDERECO_ID++;
		System.out.printf("Rua: ");

	}


	public String toString(){
		String aux = "";
		aux += "Rua: " + this.rua;
		aux += ", " + this.numero;
		aux += ", " + this.cidade;
		aux += ", " + this.estado;

		return aux;
	}

	//metodos gets e sets
	public void setRua(String rua){
		this.rua = rua;
	}
	public String getRua(){
		return this.rua;
	}

	public void setCEP(String cep){
		this.cep = cep;
	}

	public String getCEP(){
		return this.cep;
	}

	public void setCidade(String cidade){
		this.cidade = cidade;
	}
	public String getCidade(){
		return this.cidade;
	}

	public void setEstado(String estado){
		this.estado = estado;
	}
	public String getEstado(){
		return this.estado;
	}

	public int getId(){
        return this.enderecoId;
	}


	//Pesquisar
	public Endereco pesquisar(int id, Endereco enderecos[]){
	    for (int i = 0; i <= enderecos.length; i++){
            if(id == Endereco.getId){
                return enderecos[i];
            }
            else{
                return NULL;
            }
	    }

	}
}
