public class Familiar extends Titulo{
    private Socio dependentes[];


    public Familiar(Socio titular, Mensalidade mensalidades[], Socio dependentes[]){
        super(titular, mensalidades);
		this.dependentes = dependentes;

    }

    public static Familiar criar(Socio titular, Endereco enderecos[], Mensalidade mensalidades[]){
        int i = Leitura.lerInt("Numero de dependentes: ");
        Socio dependentes[] = new Socio[i];
		for (int x = 0; x < i; x++){
			dependentes[x] = Socio.criar(enderecos);
		}
		return new Familiar(titular, mensalidades, dependentes);
        
    }


}
