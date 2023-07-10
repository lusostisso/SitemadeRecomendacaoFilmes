public class Filme {

    private String titulo;
    private String genero;
    private double duracaoMinutos;
    private String [] atoresPrincipais;
    private int pontuacaoEmEstrelas; // 0 a 5
    private String diretor;

    public Filme(String titulo, String genero, double duracaoMinutos, String[] atoresPrincipais, int pontuacaoEmEstrelas, String diretor) {
        setDuracaoMinutos(duracaoMinutos);
        setGenero(genero);
        setTitulo(titulo);
        setAtoresPrincipais(atoresPrincipais);
        setPontuacaoEmEstrelas(pontuacaoEmEstrelas);
        setDiretor(diretor);
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public double getDuracaoMinutos() {
        return duracaoMinutos;
    }

    public void setDuracaoMinutos(double duracaoMinutos) {
        this.duracaoMinutos = duracaoMinutos;
    }

    public String[] getAtoresPrincipais() {
        return atoresPrincipais;
    }

    public void setAtoresPrincipais(String[] atoresPrincipais) {
        this.atoresPrincipais = atoresPrincipais;
    }

    public int getPontuacaoEmEstrelas() {
        return pontuacaoEmEstrelas;
    }

    public void setPontuacaoEmEstrelas(int pontuacaoEmEstrelas) {

        if (pontuacaoEmEstrelas >= 0 && pontuacaoEmEstrelas <= 5){
            this.pontuacaoEmEstrelas = pontuacaoEmEstrelas;
        }
        else {
            this.pontuacaoEmEstrelas = -1;
        }
    }

    public String getDiretor() {
        return diretor;
    }

    public void setDiretor(String diretor) {
        this.diretor = diretor;
    }

    public String toString() {
        return "===== Filme ====="+
                " \nTitulo: "+ titulo +
                " \nGenero: "+ genero +
                " \nDuração (min): " + duracaoMinutos +
                " \nAtores Principais: " + Uteis.mostrarVetor(atoresPrincipais) +
                " \nPontuação: " + pontuacaoEmEstrelas +
                " \nDiretor: " + diretor +
                "\n===================\n";
    }
}
