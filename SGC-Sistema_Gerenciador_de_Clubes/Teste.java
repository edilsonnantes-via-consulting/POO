import java.util.Calendar;

public class Teste{
    public static void main(String[] args){
         System.out.println("Teste:");
         Mensalidade m = new Mensalidade(Leitura.lerFloat("Digite valor: "));
         Endereco[] ends = new Endereco[Utilitario.ENDERECO_ID+1];
		 Modalidade[] mod = new Modalidade[Utilitario.MODALIDADE_ID+1];
		 ends[Utilitario.ENDERECO_ID] = Endereco.criar();
		 Socio soc = Socio.criar(ends);
		 mod[Utilitario.MODALIDADE_ID] = Modalidade.criar();
		 boolean a = soc.matricular(1, mod);
		 if(a){
			 System.out.println(soc.getMatriculas().toString());
		 }
		 
    }
}