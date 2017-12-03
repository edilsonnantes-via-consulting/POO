public class Menu
{
    public static void main(String args[])
    {
        while(true)
        {
            Modalidade mod[] = new Modalidade[Utilitario.TOTAL_MODALIDADES];
            Titulo usuario[] = new Titulo[Utilitario.TOTAL_SOCIOS];
            Socio soc[] = new Socio[Utilitario.TOTAL_TITULOS];
            Endereco end[] = new Endereco[Utilitario.TOTAL_ENDERECOS];
            int opcao = 0; //Variavel que armazena a opção escolhida pelo usuário
    
            System.out.printf("\n\n\t\t _____________ Menu Principal ____________\n");
            System.out.printf("\t\t|\t                                  |\n");
            System.out.printf("\t\t|\t<1> Cadastrar Modalidade          |\n");
            System.out.printf("\t\t|\t<2> Novo Socio                    |\n");
            System.out.printf("\t\t|\t<3> Matricular Socio              |\n");
            System.out.printf("\t\t|\t<4> Desmatricular Socio           |\n");
            System.out.printf("\t\t|\t<5> Pagar Mensalidade             |\n");
            System.out.printf("\t\t|\t<6> Sair                          |\n");
            System.out.printf("\t\t|_________________________________________|\n\n");

            opcao = Leitura.lerInt("Qual a opcao escolhida??\n");

            switch(opcao)
            {
                case 1:
                    cadastrarModalidade(mod);
                    break;
    
                case 2:
                    cadastrarTitulo(usuario, end);
                    break;
    
                case 3:
                    System.out.printf("Qual ID voce quer matricular??\n");
                    int auxId = Leitura.lerInt();
    
                    System.out.printf("Qual a ID da modalidade??\n");
                    int auxMod = Leitura.lerInt();
    
                    if(Socio.pesquisar(auxId, soc) == null || Modalidade.pesquisar(auxMod, mod) == null)
                        soc[auxId].matricular(mod[auxMod].getId(), mod);
    
                    else
                        System.out.printf("\nInvalido..\n");
    
                    break;
    
                case 4:
                    Socio soc_pesquisa = Socio.pesquisar(Leitura.lerInt("Qual ID do socio: "), soc);
                    if(soc_pesquisa == null)
                        System.out.printf("ID invalida..\n");
                    else
                        soc_pesquisa.desmatricular(Leitura.lerInt("Qual ID voce quer desmatricular?? \n"));
                    
                    break;
    
                case 5:
                    if(Utilitario.TITULO_ID != 1)
                    {
                        Titulo tit_pesquisa = Titulo.pesquisar(Leitura.lerInt("Qual ID do socio: "), usuario);
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

    public static void cadastrarTitulo(Titulo usuario[], Endereco end[]){
        if(Utilitario.TITULO_ID < Utilitario.TOTAL_TITULOS){
            usuario[Utilitario.TITULO_ID - 1] = Titulo.criar(end);
            System.out.printf("Cadastro efetuado com sucesso!!");
        }else{
            System.out.printf("\nNumero maximo de socios cadastrados..\n");
        }
    }
}