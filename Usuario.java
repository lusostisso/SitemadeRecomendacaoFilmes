public class Usuario {

    private final String nome;
    private String [] generosPreferidos;
    private String [] atoresPreferidos;
    private String [] diretoresPreferidos;
    private String duracaoPreferida;

    public Usuario(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public String[] getGenerosPreferidos() {
        return generosPreferidos;
    }

    public void setGenerosPreferidos(String[] generosPreferidos) {
        this.generosPreferidos = generosPreferidos;
    }

    public String[] getAtoresPreferidos() {
        return atoresPreferidos;
    }

    public void setAtoresPreferidos(String[] atoresPreferidos) {
        this.atoresPreferidos = atoresPreferidos;
    }

    public String[] getDiretoresPreferidos() {
        return diretoresPreferidos;
    }

    public void setDiretoresPreferidos(String[] diretoresPreferidos) {
        this.diretoresPreferidos = diretoresPreferidos;
    }

    public String getDuracaoPreferida() {
        return duracaoPreferida;
    }

    public void setDuracaoPreferida(String duracaoPreferida) {
        this.duracaoPreferida = duracaoPreferida;
    }

    public String toString() {
        return "===== Usuario ====="+
                " \nNome: "+ nome +
                " \nGeneros Preferidos: "+ Uteis.mostrarVetor(generosPreferidos) +
                " \nAtores Preferidos: " + Uteis.mostrarVetor(atoresPreferidos) +
                " \nDiretores Preferidos: " + Uteis.mostrarVetor(diretoresPreferidos) +
                " \nDuracao Preferida: " + duracaoPreferida +
                "\n===================\n";
    }
}
