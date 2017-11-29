public class Familiar extends Titulo{
    private Socio dependentes[];


    public Familiar(){

    }

    public static void criar(){
        int i = Leitura.lerInt("Numero de dependentes: ");
        for(int x = 0; x < i; x++){
            String r = Leitura.lerString("O dependente ja possui cadastro?");
            if(r == 'sim'){
                int i = Leitura.lerInt("Digite seu id: ");
                Socio titular = Socio.pesquisar(i, socios);
            }
            else{
                tituluar = Socio.criar();
            }
        }
    }


}
