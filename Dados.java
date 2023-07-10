public class Dados {

    //Pré cadastramos alguns filmes utilizando essa classe.

    final int TAMANHO_MAXIMO_SISTEMA = 1000;
    private Filme [] listaFilmes = new Filme [TAMANHO_MAXIMO_SISTEMA];

    Filme asCronicasDeNarnia = new Filme("AS CRÔNICAS DE NÁRNIA", "AVENTURA", 150.0, new String[]{"FREDDIE", "MARI"}, 5, "MICHAEL");
    Filme coachCarter = new Filme ("COACH CARTER", "DRAMA", 136.0, new String[]{"SAMUEL", "ROB", "FREDDIE"}, 5, "THOMAS");
    Filme ponteParaTerabitia = new Filme ("PONTE PARA TERABITIA", "AVENTURA", 96.0, new String[]{"SERGIO", "FREDDIE", "ROB"}, 4, "FERNANDO");
    Filme marleyeEu = new Filme("MARLEY & EU", "DRAMA", 115.0, new String[]{"MARI", "JENNIFER", "ERIC"}, 5, "DAVID");
    Filme oLabirintoDoFauno = new Filme("O LABIRINTO DO FAUNO", "ANIMAÇÃO", 118.0, new String[]{"IVANA", "SERGIO", "HELENA"}, 4, "ADAM");
    Filme aOrigem = new Filme("A ORIGEM", "FICÇÃO", 148.0, new String[]{"LEONARDO", "ROB", "ELLIOT"}, 5, "CHRIS");
    Filme oClubeDaLuta = new Filme("CLUBE DA LUTA", "DRAMA", 139.0, new String[]{"BRAD", "EDWARD", "HELENA"}, 5, "DAVID");
    Filme aViagemDeChihiro = new Filme("A VIAGEM DE CHIHIRO", "ANIMAÇÃO", 125.0, new String[]{"JOHN", "BRAD", "MARI"}, 5, "THOMAS");
    Filme cidadeDeDeus = new Filme("CIDADE DE DEUS", "DRAMA", 130.0, new String[]{"JOHN", "LEANDRO", "JENNIFER"}, 5, "FERNANDO");
    Filme PulpFicition = new Filme("PULP FICTION: TEMPO DE VIOLÊNCIA", "AÇÃO", 154.0, new String[]{"JOHN", "SAMUEL", "ROB"}, 5, "CHRIS");
    Filme oSenhorDosAneis = new Filme("O SENHOR DOS ANÉIS: A SOCIEDADE DO ANEL", "FANTASIA", 178.0, new String[]{"FREDDIE", "IAN", "ERIC"}, 5, "ADAM");
    Filme theSilentChild = new Filme("THE SILENT CHILD", "DRAMA", 20.0, new String[]{"RACHEL", "EDWARD", "LEANDRO"}, 4, "CHRIS");
    Filme laJetee = new Filme("LA JETÉE", "FICÇÃO", 28.0, new String[]{"DAVID", "FREDDIE", "JEAN"}, 5, "CHRIS");
    Filme theLunchDate = new Filme("THE LUNCH DATE", "COMÉDIA", 12.0, new String[]{"JOHN", "HELENA"}, 3, "ADAM");
    Filme balance = new Filme("BALANCE", "ANIMAÇÃO", 7.0, new String[]{"RACHEL", "BRAD"}, 4, "TARANTINO");
    Filme whiplash = new Filme("WHIPLASH", "DRAMA", 47.0, new String[]{"SAMUEL", "MELISSA"}, 5, "FERNANDO");
    Filme bigNight = new Filme("BIG NIGHT", "COMÉDIA", 58.0, new String[]{"EDWARD", "TONY", "ISABELLA"}, 4, "ADAM");
    Filme ratatouille = new Filme("RATATOUILLE", "ANIMAÇÃO", 52.0, new String[]{"DAVID", "FREDDIE", "ROB"}, 5, "MICHAEL");

    private final Filme [] listaFilmesBase = {asCronicasDeNarnia, coachCarter, ponteParaTerabitia, marleyeEu, oLabirintoDoFauno,aOrigem,  oClubeDaLuta,aViagemDeChihiro, cidadeDeDeus, PulpFicition, oSenhorDosAneis, theSilentChild, laJetee, theLunchDate, balance, whiplash, bigNight, ratatouille};
    public final int tamListaBase = listaFilmesBase.length;
    private int indiceFilme = tamListaBase;

    public void alimentarListaFilmes () {
        for (int i=0; i<tamListaBase; i++){
            listaFilmes[i] = listaFilmesBase[i];
        }
    }

    public Filme[] getListaFilmes() {
        return listaFilmes;
    }

    public void setListaFilmes(Filme filme) {
        this.listaFilmes[indiceFilme] = filme;
        indiceFilme++;
    }

    public int getTamListaBase() {
        return tamListaBase;
    }

    public int getIndiceFilme() {
        return indiceFilme;
    }

    public int getSomaPontuacaoFilmes (){
        int somaPontuacao = 0;
        for (int i = 0; i<indiceFilme; i++){
            somaPontuacao += listaFilmes[i].getPontuacaoEmEstrelas();
        }
        return somaPontuacao;
    }

    public double [] getDuracaoFilmes () {
        double [] duracaoFilmes = new double[indiceFilme];
        for (int i = 0; i<indiceFilme; i++){
            duracaoFilmes [i] = listaFilmes[i].getDuracaoMinutos();
        }
        return duracaoFilmes;
    }

    // Métodos

    public void listarFilmes() {

        /*Criado para não listar posições nulas*/

        Filme[] novoArraySemNulos = new Filme[indiceFilme];
        for (int i = 0; i < indiceFilme; i++) {
            novoArraySemNulos[i] = listaFilmes[i];
        }
        Uteis.listarUmVetorFilmes(novoArraySemNulos);
    }
}
