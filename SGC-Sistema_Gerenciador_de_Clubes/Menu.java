public class Menu
{
    public static void main(String args[])
    {
        while(true)
        {
            System.out.printf("\n\n\t\t _____________ Menu Principal ____________\n");
            System.out.printf("\t\t|\t                                  |\n");
            System.out.printf("\t\t|\t<1> Cadastrar Modalidade          |\n");
            System.out.printf("\t\t|\t<2> Novo Socio                    |\n");
            System.out.printf("\t\t|\t<3> Matricular Socio              |\n");
            System.out.printf("\t\t|\t<4> Desmatricular Socio           |\n");
    //        System.out.printf("                                | <4> |\n");
    //        System.out.printf("                                | <5> |\n");
            System.out.printf("\t\t|\t<5> Sair                          |\n");
            System.out.printf("\t\t|_________________________________________|\n\n");

            System.out.printf("Qual a opcao escolhida??\n");

            cases(Leitura.lerInt());

//            for (int i = 0; i < 50; ++i)
//                System.out.printf("\n");
        }
    }

    public static void cases(int opc)
    {
        Modalidade mod[] = new Modalidade[Utilitario.TOTAL_MODALIDADES];
        Titulo usuario[] = new Titulo[Utilitario.TOTAL_SOCIOS];
        Socio soc[] = new Socio[Utilitario.TOTAL_TITULOS];
        Endereco end[] = new Endereco[Utilitario.TOTAL_ENDERECOS];

        switch(opc)
        {
            case 1:
                if(Utilitario.MODALIDADE_ID < Utilitario.TOTAL_MODALIDADES)
                    mod[Utilitario.MODALIDADE_ID - 1] = Modalidade.criar();

                else
                    System.out.printf("\nNumero maximo de modalidades cadastradas..\n");

                break;

            case 2:
                if(Utilitario.TITULO_ID < Utilitario.TOTAL_TITULOS)
                {
                    end[Utilitario.ENDERECO_ID - 1] = Endereco.criar();
                    usuario[Utilitario.TITULO_ID - 1] = Titulo.criar(end);
                }

                else
                    System.out.printf("\nNumero maximo de socios cadastrados..\n");

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

            default:
                System.exit(0);
        }
    }
}
