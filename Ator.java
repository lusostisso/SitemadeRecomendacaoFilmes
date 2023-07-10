import java.util.Scanner;

public class Ator {

    static Scanner scanner = new Scanner(System.in);

    public static String [] atoresSelecionados(){
        String continua = "1";
        int cont = 0;

        String ator;
        String [] atoresSelecionados = new String[100]; 

        while (continua.equals("1")) {
            boolean atorJaAdd = false;

            do {
                System.out.println("-> Insira um ator");
                ator = scanner.nextLine();
            } while (ator.length()<1);

            for (int i = 0; i < cont; i++) {
                if (atoresSelecionados[i].equalsIgnoreCase(ator)) {
                    atorJaAdd = true;
                    break;
                }
            }

            if (!atorJaAdd) {
                atoresSelecionados [cont] = ator.toUpperCase();
                cont ++;
            } else {
                System.out.println("\n* Esse ator já foi selecionado. Por favor, escolha outro.\n");
            }

            System.out.println("\nExiste mais algum ator para selecionar?");
            System.out.println("-> Digite 1 PARA CONTINUAR adicionando atores, ou qualquer outra tecla para encerrar");
            continua = scanner.nextLine();
            System.out.println();
        }
        return Uteis.copiarArray(atoresSelecionados, cont);
    }
}
