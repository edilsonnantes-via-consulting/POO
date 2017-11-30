import java.util.Calendar;

public class Teste{
    public static void main(String[] args){
         System.out.println("Teste:");
         //Mensalidade m = new Mensalidade(Leitura.lerFloat("Digite valor: "));
         Endereco[] ends = new Endereco[1];
		 //Modalidade[] mod = new Modalidade[Utilitario.MODALIDADE_ID+1];
		 ends[0] = Endereco.criar();
		 //ends = new Endereco[2];
		 //ends[1] = Endereco.criar();
		 //Socio soc = Socio.criar(ends);
		 //Endereco e = Endereco.pesquisar(,ends);
		 //System.out.println(e);
		Titulo t = Titulo.criar(ends);
    }
}