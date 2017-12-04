public class Familiar extends Titulo{
    private Socio dependentes[];


    public Familiar(Socio titular, Mensalidade mensalidades[], Socio dependentes[]){
        super(titular, mensalidades);
        this.dependentes = new Socio[dependentes.length];
        for(int i=0; i< dependentes.length; i++){
            this.dependentes[i]=dependentes[i];
        }
    }

    public static Familiar criar(Socio titular, Endereco enderecos[], Mensalidade mensalidades[]){
        int x = Leitura.lerInt("Numero de dependentes: ");
        Socio dependentes[] = new Socio[x];
		for (int i = 0; i < x; i++){
			dependentes[i] = Socio.criar(enderecos);
		}
		return new Familiar(titular, mensalidades, dependentes);
    }


}
