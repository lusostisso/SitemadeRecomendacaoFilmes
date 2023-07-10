import java.util.Scanner;

public class Diretor {

    static Scanner scanner = new Scanner(System.in);

    public static String [] diretoresFavoritos(){

        System.out.println("Nos conte quais seus diretores prediletos");
        String continua = "1";
        int cont = 0;

        String diretor;
        String [] diretoresPreferidos = new String[100];

        while (continua.equals("1")) {
            boolean diretorJaAdd = false;

            do {
                System.out.println("-> Insira seu diretor predileto");
                diretor = scanner.nextLine();
            } while (diretor.length()<1);

            for (int i = 0; i < cont; i++) {
                if (diretoresPreferidos[i].equalsIgnoreCase(diretor)) {
                    diretorJaAdd = true;
                    break;
                }
            }

            if (!diretorJaAdd) {
                diretoresPreferidos [cont] = diretor.toUpperCase();
                cont ++;
            } else {
                System.out.println("\n* Esse diretor já foi selecionado. Por favor, escolha outro.\n");
            }

            System.out.println("\nExiste mais algum diretor para colocar em prediletos?");
            System.out.println("-> Digite 1 PARA CONTINUAR adicionando diretores, ou qualquer outra tecla para encerrar os diretores prediletos");
            continua = scanner.nextLine();
            System.out.println();
        }
        return Uteis.copiarArray(diretoresPreferidos, cont);
    }

    public static String definirDiretorFilme () {
            String diretor;

            do {
                System.out.println("Qual o diretor do filme?");
                diretor = scanner.nextLine();
            } while (diretor.length() < 1);
            
        Uteis.exibirLinhaSeparadora();
        return diretor;
    }
}

