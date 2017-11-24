import java.util.Calendar;

public class Teste{
    public static void main(String[] args){
         System.out.println("Teste:");
         Mensalidade m = new Mensalidade(Leitura.lerFloat("Digite valor: "));
         
         System.out.println(m);
    }
}