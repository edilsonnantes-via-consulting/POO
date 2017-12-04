public class Menu
{
    public static void main(String args[])
    {
        Modalidade mod[] = new Modalidade[Utilitario.TOTAL_MODALIDADES];
        Titulo usuario[] = new Titulo[Utilitario.TOTAL_TITULOS];
        Socio soc[] = new Socio[Utilitario.TOTAL_SOCIOS];
        Endereco end[] = new Endereco[Utilitario.TOTAL_ENDERECOS];
        
        while(true)
        {
            int opcao = 0; //Variavel que armazena a opção escolhida pelo usuário
            
            System.out.printf("\n\n\t\t _____________ Menu Principal ____________\n");
            System.out.printf("\t\t|\t                                  |\n");
            System.out.printf("\t\t|\t<1> Cadastrar Modalidade          |\n");
            System.out.printf("\t\t|\t<2> Novo Socio                    |\n");
            System.out.printf("\t\t|\t<3> Matricular Socio              |\n");
            System.out.printf("\t\t|\t<4> Desmatricular Socio           |\n");
            System.out.printf("\t\t|\t<5> Pagar Mensalidade             |\n");
            System.out.printf("\t\t|\t<6> Imprimir                      |\n");
            System.out.printf("\t\t|\t<7> Sair                          |\n");
            System.out.printf("\t\t|_________________________________________|\n\n");

            opcao = Leitura.lerInt("Qual a opcao escolhida??\n");

            switch(opcao)
            {
                case 1:
                    cadastrarModalidade(mod);
                    break;
    
                case 2:
                    cadastrarTitulo(soc,usuario, end);
                    break;
    
                case 3:
                    matricular(soc,mod);
                    break;
    
                case 4:
                    desmatricular(soc);
                    break;
    
                case 5:
                    pagarMensalidade(usuario);
                    break;
    
                case 6:
                    imprimirSocio(soc);
                    break;

                default:
                    System.exit(0);
            }
         }
    }
   
    public static void cadastrarModalidade(Modalidade mod[]){
        if(Utilitario.MODALIDADE_ID < Utilitario.TOTAL_MODALIDADES){
            mod[Utilitario.MODALIDADE_ID - 1] = Modalidade.criar();
            System.out.printf("Cadastro efetuado com sucesso!!");
        }else{
            System.out.printf("\nNumero maximo de modalidades cadastradas..\n"); 
        }
    }

    public static void cadastrarTitulo(Socio soc[],Titulo usuario[], Endereco end[]){
        if(Utilitario.TITULO_ID < Utilitario.TOTAL_TITULOS){
            usuario[Utilitario.TITULO_ID - 1] = Titulo.criar(end);
            soc[Utilitario.SOCIO_ID -2 ] = usuario[Utilitario.TITULO_ID-2].getTitular();
            
            System.out.printf("Cadastro efetuado com sucesso!!");
        }else{
            System.out.printf("\nNumero maximo de socios cadastrados..\n");
        }
    }

    public static void matricular(Socio soc[], Modalidade mod[]){
        Socio soc_matricula = Socio.pesquisarSocio(Leitura.lerInt("Digite ID da matricula: "), soc);

        if(soc_matricula!=null){

            if(soc_matricula.matricular(Leitura.lerInt("Digite ID da modalidade: "), mod)){
                System.out.println("Matricula efetuada com sucesso!!");
            }
        }
    }

    public static void desmatricular(Socio soc[]){
        Socio soc_pesquisa = Socio.pesquisarSocio(Leitura.lerInt("Digite ID do socio: "), soc);
        if(soc_pesquisa == null){
            System.out.printf("ID de socio invalido..\n");
        }else{
            if(soc_pesquisa.desmatricular(Leitura.lerInt("Qual ID voce quer desmatricular?? \n"))){
                System.out.println("Desmatricula efetuada");
            }else{
                System.out.println("ID de matricula invalido");
            }
        }
            
    }

    public static void pagarMensalidade(Titulo usuario[]){
        if(Utilitario.TITULO_ID != 1)
        {
            Titulo tit_pesquisa = Titulo.pesquisarTitulo(Leitura.lerInt("Qual ID do socio: "), usuario);
            if(tit_pesquisa == null)
                System.out.printf("ID invalida..\n");
            else
            {
                if(tit_pesquisa.pagarMensalidade(Leitura.lerInt("Digite o mes: ")))
                    System.out.printf("Pagamento realizado com sucesso..");

                else
                    System.out.printf("Erro no Pagamento..");
            }
        }

        else
            System.out.printf("Impossivel pagar..");
    }

    public static void imprimirSocio(Socio soc[]){
        try{
            for(int i=0; i<soc.length; i++){
                if(soc[i]!=null)
                    System.out.println(soc[i]);
                else
                    break;
            }
        }catch(Exception erro){
            System.out.println("Nao foi possivel imprimir!!");
        }
        
    }
}