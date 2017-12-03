public class Individual extends Titulo{
    public Individual(Socio titular, Mensalidade mensalidades[]){
        super(titular,mensalidades);
    }

    public static Titulo criar(Socio titular, Mensalidade mensalidades[]){
        return new Inividual(titular,mensalidades);
    }
}