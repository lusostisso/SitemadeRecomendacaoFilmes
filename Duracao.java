import java.util.Scanner;

public class Duracao {

    private static String [] duracaoFavorita = {"CURTOS","INTERMEDIÁRIOS", "LONGA-METRAGEM", "ÉPICOS"};
    static Scanner scanner = new Scanner(System.in);

    public static String selecaoDuracaoFavorita() {
        int opcao;
        String opcaoTexto; 

        Uteis.exibirListaOrdenada(duracaoFavorita);

        do {
            System.out.println("\n-> Qual das durações de filmes é a sua predileta? Digite o numero de sua opcao");

            opcaoTexto = scanner.nextLine();
            opcao = Uteis.transformarEmInt(opcaoTexto);
            /*Usamos opcaoTexto para evitar que o programa "quebre"
            caso o usuário digite algo não numérico. Dessa forma,
            se for um número transformamos para int.*/

        } while (opcao<1 || opcao>duracaoFavorita.length);

        return duracaoFavorita[opcao-1];
    }

    public static double definirDuracaoFilme () {
        String textoDuracaoFilme;
        double duracaoFilme;

        do {
            System.out.println("Qual é a duração do filme em minutos?");
            textoDuracaoFilme = scanner.nextLine();
            duracaoFilme = Uteis.transformarEmDouble(textoDuracaoFilme);
        } while (duracaoFilme<0);

        Uteis.exibirLinhaSeparadora();
        return duracaoFilme;
    }

    private static void atualizarContagemDuracaoConceito(double duracao, int [] vetQntDuracaoFilmes) {
        if (duracao < 40){
            if (duracao>0){
                vetQntDuracaoFilmes[0] = vetQntDuracaoFilmes[0]+1;
            }
            else{
                System.out.println("BUG");
            }
        }
        else if (duracao >= 40 && duracao<60){
            vetQntDuracaoFilmes[1] = vetQntDuracaoFilmes[1]+1;
        }
        else if (duracao >= 60 && duracao<130){
            vetQntDuracaoFilmes[2] = vetQntDuracaoFilmes[2]+1;
        }
        else {
            vetQntDuracaoFilmes[3] = vetQntDuracaoFilmes[3]+1;
        }
    }

    public static String obterConceitoDeDuracao(double duracao){

        if (duracao < 40){
            return duracaoFavorita[0];
        }
        else if (duracao >= 40 && duracao < 60){
            return duracaoFavorita[1];
        }
        else if (duracao >= 60 && duracao < 130){
            return duracaoFavorita[2];
        }
        else {
            return duracaoFavorita[3];
        }
    }

    public static void exibirPorcentagemDuracao(double duracao[]){

        int [] vetQntDuracaoFilmes = {0,0,0,0};
        final double PORCENTAGEM = 100.0;

        for (int i = 0; i<duracao.length; i++){
            atualizarContagemDuracaoConceito(duracao[i], vetQntDuracaoFilmes);
        }

        for (int i = 0; i<duracaoFavorita.length; i++){
            System.out.printf("\nPorcentagem de filmes %s: %.2f %% \n", duracaoFavorita [i], ((vetQntDuracaoFilmes[i]*PORCENTAGEM)/duracao.length));
        }
    }
}
