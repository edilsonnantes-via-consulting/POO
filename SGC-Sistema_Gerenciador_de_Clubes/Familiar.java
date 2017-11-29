public class Familiar extends Titulo{
    private Socio dependentes[];


    public Familiar(Socio dependentes[]){
        
		this.dependentes = dependentes;

    }

    public Familiar criar(){
        int i = Leitura.lerInt("Numero de dependentes: ");
        Socio dependentes[];
        for(int x = 0; x < i; x++){
            String r = Leitura.lerString("O dependente ja possui cadastro?");
            if(r == "sim"){
                int a = Leitura.lerInt("Digite seu id: ");
                dependentes[x] = Socio.pesquisar(i, socios);
            }
            else{
                dependentes[x] = Socio.criar();
            }
        }
        Familiar familiares = new Familiar(dependentes);
    }


}
