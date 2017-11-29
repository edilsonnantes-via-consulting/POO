import java.util.Calendar;

public class Teste{
    public static void main(String[] args){
         System.out.println("Teste:");
         Mensalidade m = new Mensalidade(Leitura.lerFloat("Digite valor: "));
         Socio soc = Socio.criar();
         
		 System.out.println(m);
		 System.out.printf(soc.toString());
		 System.out.println(soc.getSocioId());
		 int i;
		 i = Leitura.lerInt("Digite umn ID: ");
		 int x = 100;
		 Endereco[] ends = new Endereco[x];
		 ends[Utilitario.ENDERECO_ID] = soc.getEndereco();
		 Endereco ed = Endereco.pesquisar(i, ends);
		 System.out.println(ed);
    }
}