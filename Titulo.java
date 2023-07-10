import java.util.Scanner;

public class Titulo {

    static Scanner scanner = new Scanner(System.in);

    public static String definirTituloFilme () {
        String titulo;

        do {
            System.out.println("Qual o título do filme?");
            titulo = scanner.nextLine();
        } while (titulo.length() < 1);
        
        return titulo.toUpperCase();
    }
}
