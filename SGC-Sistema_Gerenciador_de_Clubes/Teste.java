import java.util.Calendar;

public class Teste{
    public static void main(String[] args){
         System.out.printf("Teste:");
         Mensalidade m = new Mensalidade(Leitura.lerData(), Leitura.lerFloat());

         System.out.println(m);
    }
}