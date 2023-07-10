public class Uteis {

    /*Classe construída para armazenar algumas funções
    e métodos que utilizamos várias vezes no código.*/

    public static boolean ehDigito (String string) {

        if (string.length() == 0) {
            return false; 
        }

        //Utilizamos comparação por meio da tabela ASCII.
        for (int i=0; i<string.length(); i++){
            char c = string.charAt(i);
                if ((c<'0' || c > '9')){
                    return false;
                }
        }
        return true;
    }

    public static String[] copiarArray(String[] original, int tamanho) {

        //Fizemos nossa própria função estilo Arrays.copyOf().
        String[] copia = new String[tamanho];

        for (int i = 0; i < tamanho; i++) {
            copia[i] = original[i];
        }
        return copia;
    }


    public static double transformarEmDouble (String string) {
        double opcao = -1;
        if(Uteis.ehDigito(string)){
            opcao = Double.parseDouble(string);
        }
        return opcao;
    }

    public static int transformarEmInt (String string) {
        int opcao = -1;
        if(Uteis.ehDigito(string)){
            opcao = Integer.parseInt(string);
        }
        return opcao;
    }

    public static void exibirLinhaSeparadora () {
        System.out.println("\n========================================\n");
    }

    public static String mostrarVetor(String[] vetor) {
        String resultado = "";

        for (int i = 0; i < vetor.length; i++){
            if (i < vetor.length - 1) {
                resultado = resultado.concat(vetor[i] + ",");
            } else {
                resultado = resultado.concat(vetor[i]);
            }
        }
        return resultado;
    }

    public static void exibirListaOrdenada(String [] lista) {
        for (int i = 0; i < lista.length; i++){
            System.out.println((i + 1) + ". " + lista[i]);
        }
    }

    public static void listarUmVetorFilmes(Filme[] listaFilmes) {
        for (int i = 0; i < listaFilmes.length; i++) {
            System.out.println(listaFilmes[i]);
        }
    }

    public static void exibirMovies(){
        System.out.println("                       _           \r\n" + //
                "  _ __ ___   _____   _(_) ___  ___ \r\n" + //
                " | '_ ` _ \\ / _ \\ \\ / / |/ _ \\/ __|\r\n" + //
                " | | | | | | (_) \\ V /| |  __/\\__ \\\r\n" + //
                " |_| |_| |_|\\___/ \\_/ |_|\\___||___/\n");
    }

    public static void exibirEstrela(){
        System.out.println("        .\r\n" + //
                "       ,O,\r\n" + //
                "      ,OOO,\r\n" + //
                "'oooooOOOOOooooo'\r\n" + //
                "  `OOOOOOOOOOO`\r\n" + //
                "    `OOOOOOO`\r\n" + //
                "    OOOO'OOOO\r\n" + //
                "   OOO'   'OOO\r\n" + //
                "  O'         'O\n");
    }

    public static void exibirTelevisao(){
        System.out.println("     _______________\r\n" + //
                "    |,----------.  |\\\r\n" + //
                "    ||           |=| |\r\n" + //
                "    ||          || | |\r\n" + //
                "    ||       . _o| | | __\r\n" + //
                "    |`-----------' |/ /~/\r\n" + //
                "     ~~~~~~~~~~~~~~~ / /\r\n" + //
                "                     ~~");
    }

    public static void exibirCoracao(){
        System.out.println("     ******       ******\r\n" + //
                "   **********   **********\r\n" + //
                " ************* *************\r\n" + //
                "*****************************\r\n" + //
                "*****************************\r\n" + //
                "*****************************\r\n" + //
                " ***************************\r\n" + //
                "   ***********************\r\n" + //
                "     *******************\r\n" + //
                "       ***************\r\n" + //
                "         ***********\r\n" + //
                "           *******\r\n" + //
                "             ***\n");
    }
}
