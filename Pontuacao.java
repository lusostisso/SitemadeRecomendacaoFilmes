import java.util.Scanner;

public class Pontuacao {

    static Scanner scanner = new Scanner(System.in);

    public static int definirPontuacaoFilme () {
        String estrelaTexto;
        int estrela;

        System.out.println("Classifique o filme que você adicionou! (De 0 a 5 estrelas)");
        System.out.println("☆☆☆☆☆");

        do {
            System.out.println("-> Insira o número de estrelas que você deseja classificar");

            estrelaTexto = scanner.nextLine();
            estrela = Uteis.transformarEmInt(estrelaTexto);
            /*Usamos estrelaTexto para evitar que o programa "quebre"
            caso o usuário digite algo não numérico. Dessa forma,
            se for um número transformamos para int.*/

        } while (estrela < 0 || estrela > 5);
        
        Uteis.exibirLinhaSeparadora();
        return estrela;
    }
}
