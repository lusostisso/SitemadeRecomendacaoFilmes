import java.util.Scanner;

public class Genero {

    private static final String[] generos = {"AVENTURA", "COMÉDIA", "AÇÃO", "TERROR", "DRAMA", "FICÇÃO", "ANIMAÇÃO"};
    private final static int numeroGeneros = generos.length;
    static Scanner scanner = new Scanner(System.in);


    public static String[] selecaoGeneroFavorito() {
        int opcao;
        String opcaoTexto;

        String continua = "1";
        int cont = 0;

        Uteis.exibirListaOrdenada(generos);
        System.out.println("Nos conte quais seus gêneros prediletos");

        String[] generosPreferidos = new String[numeroGeneros];

        while (continua.equals("1") && cont < numeroGeneros) {

            do {
                System.out.println("-> Qual gênero é o selecionado? Digite o número da opção:");

                opcaoTexto = scanner.nextLine();
                opcao = Uteis.transformarEmInt(opcaoTexto);
                /*Usamos opcaoTexto para evitar que o programa "quebre"
                caso o usuário digite algo não numérico. Dessa forma,
                se for um número transformamos para int.*/

            } while (opcao < 1 || opcao > generos.length);

            String generoSelecionado = generos[opcao - 1];
            boolean generoJaAdd = false;

            for (int i = 0; i < cont; i++) {
                if (generosPreferidos[i].equals(generoSelecionado)) {
                    generoJaAdd = true;
                    break;
                }
            }

            if (!generoJaAdd) {
                generosPreferidos[cont] = generoSelecionado;
                cont++;
            } else {
                System.out.println("\n* Esse gênero já foi selecionado. Por favor, escolha outro.\n");
            }

            if (cont < numeroGeneros) {
                System.out.println("\nExiste mais algum gênero para colocar em seus prediletos?");
                System.out.println("-> Digite 1 PARA CONTINUAR adicionando gêneros, ou qualquer outra tecla para encerrar os gêneros prediletos");
                continua = scanner.nextLine();
            }
        }
        return Uteis.copiarArray(generosPreferidos, cont);
    }

    public static String definirGeneroFilme () {
        int opcao;
        String opcaoTexto;

        Uteis.exibirLinhaSeparadora();
        Uteis.exibirListaOrdenada(generos);

        do {
            System.out.println("Qual gênero do filme? Digite o número da opção:");

            opcaoTexto = scanner.nextLine();
            opcao = Uteis.transformarEmInt(opcaoTexto);
            /*Usamos opcaoTexto para evitar que o programa "quebre"
            caso o usuário digite algo não numérico. Dessa forma,
            se for um número transformamos para int.*/

        } while (opcao < 1 || opcao > generos.length);
        
        Uteis.exibirLinhaSeparadora();
        return generos[opcao - 1];
    }
}
