package Classes;

public class Endereco{
	private int enderecoId;
	private String rua;
	private int numero;
	private String cep;
	private String cidade;
	private String estado;

	//construtor
        
        
	public Endereco(String rua, int numero, String cep, String cidade, String estado){
	    this.rua  = rua;
	    this.numero = numero;
	    this.cep = cep;
	    this.cidade = cidade;
	    this.estado = estado;
	}
        
    Endereco() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

	public String toString(){
		String aux = "";
		aux += "ID " + this.enderecoId;
		aux += "-" + this.rua;
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

	public void setNumero(int numero){
		this.numero = numero;
	}
	public int getNumero(){
		return this.numero;
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

	public int getEnderecoId(){
        return this.enderecoId;
	}


	//Pesquisar
	public static Endereco pesquisar(int id, Endereco enderecos[]){
		int i;
		
		try{
			for (i = 0; i < enderecos.length; i++){
				if(id == enderecos[i].getEnderecoId()){
					return enderecos[i];
				}
			}
		}catch(NullPointerException erroNenhumElemento){
			System.out.println("Nao ha nenhum endereco cadastrado!!");
		}catch(Exception erro){
			System.out.println("Ocorreu um erro inesperado!!");
		}

		System.out.println("Endereco nao encontrado!!");
		return null;
	}
}
