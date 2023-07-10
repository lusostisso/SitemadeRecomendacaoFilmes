import java.util.*;

public class Sistema {
    /*Classe mais importante do projeto, pois nela realizamos a maioria das funcionalidades.*/

    private boolean configurouPerfil = false;
    private final Dados dados;
    private final Usuario usuario;


    public Sistema(Dados dados, Usuario usuario) {
        this.dados = dados;
        this.usuario = usuario;
    }

    //Organizado na ordem do menu:

    //1) Cadastro de preferências:

    public void configurarPreferenciasUsuario () {
        configurouPerfil = true;

        Uteis.exibirLinhaSeparadora();
        System.out.println("Vamos Configurar Suas Preferencias " + (this.usuario.getNome()) + "!\n");
        Uteis.exibirTelevisao();
        Uteis.exibirLinhaSeparadora();

        this.usuario.setGenerosPreferidos(Genero.selecaoGeneroFavorito());
        System.out.println("\nGÊNEROS PREFERIDOS CADASTRADOS COM SUCESSO!: " + Arrays.toString(this.usuario.getGenerosPreferidos())+"\n");
        Uteis.exibirLinhaSeparadora();

        this.usuario.setDuracaoPreferida(Duracao.selecaoDuracaoFavorita());
        System.out.println("DURAÇÃO PREFERIDA CADASTRADA COM SUCESSO!: " + (this.usuario.getDuracaoPreferida()));
        Uteis.exibirLinhaSeparadora();

        this.usuario.setAtoresPreferidos(Ator.atoresSelecionados());
        System.out.println("ATORES PREFERIDOS CADASTRADOS COM SUCESSO!: " + Arrays.toString(this.usuario.getAtoresPreferidos()));
        Uteis.exibirLinhaSeparadora();

        this.usuario.setDiretoresPreferidos(Diretor.diretoresFavoritos());
        System.out.println("DIRETORES PREFERIDOS CADASTRADOS COM SUCESSO!: " + Arrays.toString((this.usuario.getDiretoresPreferidos())));
        Uteis.exibirLinhaSeparadora();
    }

    //2) Acesso ao banco de filmes:

    public void listarFilmesNaLista () {
        int qntFilmes = this.dados.getIndiceFilme();

        Uteis.exibirLinhaSeparadora();
        System.out.println("Confira os filmes cadastrados em nosso sistema:\n");
        Uteis.exibirMovies();

        this.dados.listarFilmes();

        Uteis.exibirEstrela();
        System.out.printf("A classificação média dos %d filmes do banco de dados é %.2f estrelas \n", qntFilmes, pontuacaoMediaFilmes(qntFilmes));
        Uteis.exibirLinhaSeparadora();
    }

    //3) Cadastro de novos filmes:

    public void incluirNovoFilmeNaLista (){

        if (this.dados.getIndiceFilme() >= (this.dados.TAMANHO_MAXIMO_SISTEMA-1)){
            System.out.println("Capacidade máxima do sistema atingida, não é possível cadastrar mais filmes");
        }
        else {
            this.dados.setListaFilmes(criarFilme());
        }
    }

    public Filme criarFilme (){

        Uteis.exibirLinhaSeparadora();
        System.out.println("Vamos cadastrar um novo filme " + (this.usuario.getNome()) + "!\n");
        Uteis.exibirTelevisao();
        Uteis.exibirLinhaSeparadora();

        String titulo = Titulo.definirTituloFilme();
        String genero = Genero.definirGeneroFilme();
        double duracao = Duracao.definirDuracaoFilme();
        System.out.println("Informe os atores principais do filme");
        String [] atores = Ator.atoresSelecionados();
        Uteis.exibirLinhaSeparadora();
        String diretor = Diretor.definirDiretorFilme();
        int pontuacao = Pontuacao.definirPontuacaoFilme();

        System.out.println("PARABÉNS! FILME CADASTRADO COM SUCESSO.");
        return new Filme(titulo, genero, duracao, atores, pontuacao, diretor);
    }

    //4) Realizar recomendações de Filmes:

    private int [] obterPontuacoesDeMatchTodosFilmes(){

        Filme [] listaFilmes = this.dados.getListaFilmes();

        //Recupera preferências do usuário:
        String [] generosPreferidos = usuario.getGenerosPreferidos();
        String [] atoresPreferidos = usuario.getAtoresPreferidos();
        String [] diretoresPreferidos = usuario.getDiretoresPreferidos();
        String duracaoPreferida = usuario.getDuracaoPreferida();

        //Cria um vetor armazenando os pontos de preferencias de match cada filme:
        int [] pontosDeMatch = new int [dados.getIndiceFilme()];

        for (int i = 0; i <this.dados.getIndiceFilme(); i++){
            Filme filme = listaFilmes[i];

            String generoFilme = filme.getGenero();
            String[] atoresFilme = filme.getAtoresPrincipais();
            String diretorFilme = filme.getDiretor();
            double duracaoFilme = filme.getDuracaoMinutos();
            String duracaoFilmeEmTexto = Duracao.obterConceitoDeDuracao(duracaoFilme);

            for (String generoPreferido : generosPreferidos) { 
                if (generoPreferido.equalsIgnoreCase(generoFilme)) {
                    pontosDeMatch[i]++; //genero coincidir vale 1 ponto
                }
            }

            for (String atorPreferido : atoresPreferidos) { 
                for (String ator : atoresFilme) {
                    if (atorPreferido.equalsIgnoreCase(ator)) {
                        pontosDeMatch[i]+=2; //ator coincidir vale 2 pontos
                    }
                }
            }

            for (String diretorPreferido : diretoresPreferidos) { 
                if (diretorPreferido.equalsIgnoreCase(diretorFilme)) {
                    pontosDeMatch[i]+=2; //diretor coincidir vale 2 pontos
                }
            }

            if(duracaoPreferida.equalsIgnoreCase(duracaoFilmeEmTexto)){
                pontosDeMatch[i]++; //duracao coincidir vale 1 ponto
            }
        }
        return pontosDeMatch;
    }

    /* Método responsável pela exibição */

    public void recomendarFilmes() {

        if (configurouPerfil) {
            
            Filme [] listaTodosFilmes = this.dados.getListaFilmes();
            int[] pontuacoesDeMatchTodosFilmes = obterPontuacoesDeMatchTodosFilmes();
            int pontuacaoMaxima = pontuacaoMaxima(); // Depende da quantidade de dados que o usuário inseriu.

            int NUMERO_DE_FILMES_RECOMENDADOS = 10;
            Filme [] listaFilmesRecomendados = new Filme[NUMERO_DE_FILMES_RECOMENDADOS];
            int [] pontuacoesDeMatchDosFilmesRecomendados = new int[NUMERO_DE_FILMES_RECOMENDADOS];

            Uteis.exibirLinhaSeparadora();
            System.out.println("--------IT'S A MATCH!--------\n");
            Uteis.exibirCoracao();
            System.out.println("CONFIRA 10 RECOMENDAÇÕES BASEADAS NO SEU PERFIL!\n");

            for (int j=0; j<listaFilmesRecomendados.length; j++){

                int indiceMaior = obterIndiceMaiorPontuacao(pontuacoesDeMatchTodosFilmes);

                listaFilmesRecomendados [j] = listaTodosFilmes[indiceMaior];
                pontuacoesDeMatchDosFilmesRecomendados [j] = pontuacoesDeMatchTodosFilmes [indiceMaior];
                pontuacoesDeMatchTodosFilmes [indiceMaior] = 0;
            }

            for (int i = 0; i<listaFilmesRecomendados.length; i++) {

                System.out.printf((i+1) + ".\nEste filme deu match de %.2f%% com você! \n",
                calculaPorcentagemMatch(pontuacoesDeMatchDosFilmesRecomendados[i], pontuacaoMaxima));

                System.out.println(listaFilmesRecomendados [i]);
            }

        } else {
            Uteis.exibirLinhaSeparadora();
            System.out.println(usuario.getNome() + ", parece que você não configurou suas preferências. Digite 1 para configurar!");
            Uteis.exibirLinhaSeparadora();
        }
    }

    /* Funções utilizadas pelo Método responsável pela exibição dos Filmes Recomendados */

    private int pontuacaoMaxima () {
        return ((usuario.getAtoresPreferidos().length)*2) +
        ((usuario.getDiretoresPreferidos().length)*2) + (1) /*+1 pois a duração favorita inserida é somente uma.*/ + 
        (usuario.getGenerosPreferidos().length);
    }

    private int obterIndiceMaiorPontuacao(int[] pontuacoesDeMatchTodosFilmes) {

        int indiceMaiorPontuacao = 0;
        int maiorPontuacao = 0;

        Filme [] filmes = this.dados.getListaFilmes();

        for (int i = 0; i < pontuacoesDeMatchTodosFilmes.length; i++) {

            if ((pontuacoesDeMatchTodosFilmes[i] > maiorPontuacao) ||
                ((filmes[i].getPontuacaoEmEstrelas() > filmes[indiceMaiorPontuacao].getPontuacaoEmEstrelas()) &&
                pontuacoesDeMatchTodosFilmes[i] == maiorPontuacao)) {

                /*Critério de desempate que usamos: se os dois filmes tiverem a mesma
                pontuação o filme com mais estrelas é exibido primeiro.*/

                maiorPontuacao = pontuacoesDeMatchTodosFilmes[i];
                indiceMaiorPontuacao = i;
            }
        }
        return indiceMaiorPontuacao;
    }

    private double calculaPorcentagemMatch (double pontuacao, double pontuacaoMaxima) {
        return 100*(pontuacao/pontuacaoMaxima);
    }

    //5) Visualização de Estatisticas:

    public void mostrarEstatisticas () {

        int qntFilmes = this.dados.getIndiceFilme();

        Uteis.exibirLinhaSeparadora();
        System.out.println("EXIBINDO ESTATÍSTICAS: \n");

        System.out.println("-> Quantidade de filmes cadastrados " + qntFilmes+"\n");
        Uteis.exibirEstrela();

        System.out.printf("-> A classificação média dos %d filmes do banco de dados é %.2f estrelas \n", qntFilmes, pontuacaoMediaFilmes(qntFilmes));

        Duracao.exibirPorcentagemDuracao(this.dados.getDuracaoFilmes());
        Uteis.exibirLinhaSeparadora();
    }

    /* Funções utilizadas pelo Método responsável pela exibição das Estatisticas */
    
    public double pontuacaoMediaFilmes (int qntFilmes) {
        return (double) dados.getSomaPontuacaoFilmes()/qntFilmes;
    }

    //6) Exibir perfil do usuário:

    public void exibirPerfilUsuario (){

        if (configurouPerfil){
            Uteis.exibirLinhaSeparadora();
            System.out.println("ESTE É O SEU PERFIL: \n");
            System.out.println(usuario);
            Uteis.exibirLinhaSeparadora();
        }
        else {
            Uteis.exibirLinhaSeparadora();
            System.out.println(usuario.getNome() + ", parece que você não configurou suas preferencias, digite 1 para configurar!");
            Uteis.exibirLinhaSeparadora();
        }
    }

    //0) Sair do sistema:

    public void sairDoSistema () {
        System.out.println("Agradecemos sua visita, até mais!");
    }

}
