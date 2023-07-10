import java.util.Scanner;

public class Tela {
    
    static Scanner scanner = new Scanner(System.in);

    public static void bemVindo (){

        String opcaoTexto;
        int opcao = -1; 

        System.out.println("Seja Bem Vindo ao Sistema de Recomendação\n");
        Uteis.exibirMovies();

        Dados data = new Dados();
        Usuario user = new Usuario(nome());
        Sistema sistema = new Sistema(data, user);

        data.alimentarListaFilmes();

        do {
            exibirMenu();
            opcaoTexto = scanner.nextLine();

            if (Uteis.ehDigito(opcaoTexto)){
                opcao = Integer.parseInt(opcaoTexto);
                /*Usamos opcaoTexto para evitar que o programa "quebre"
                caso o usuário digite algo não numérico. Dessa forma,
                se for um número transformamos para int.*/
            }

            switch (opcao) {
                case 1:
                    sistema.configurarPreferenciasUsuario();
                    break;
                case 2:
                    sistema.listarFilmesNaLista();
                    break;
                case 3:
                    sistema.incluirNovoFilmeNaLista();
                    break;
                case 4:
                    sistema.recomendarFilmes();
                    break;
                case 5:
                    sistema.mostrarEstatisticas();
                    break;
                case 6:
                    sistema.exibirPerfilUsuario();
                    break;
                case 0:
                    sistema.sairDoSistema();
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
                    break;
            }
        } while (opcao != 0);
    }

    public static void exibirMenu() {
        System.out.println("\n===== MENU =====");
        System.out.println("1. Cadastre suas preferências");
        System.out.println("2. Acesse o banco de filmes");
        System.out.println("3. Cadastre um novo filme");
        System.out.println("4. Recomendações de Filmes");
        System.out.println("5. Visualizar Estatisticas");
        System.out.println("6. Exibir perfil");
        System.out.println("0. Sair do Sistema");
        System.out.print("Escolha uma opção: \n");
    
    }

    private static String nome (){
        String nome;
        System.out.println("Insira o seu nome para que possamos te conhecer melhor");

        do {
            nome = scanner.nextLine();
        } while (nome.length()<1);

        return nome.toUpperCase();
    }


}
