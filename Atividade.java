import java.time.LocalDate;

public abstract class Atividade extends Utilizador {

    private String id;
    private String descricao;
    private LocalDate dataderealizacao;
    private Utilizador user; // implementar
    private double duracao;

    public Atividade(String id, String descricao, LocalDate dataderealizacao, double duracao) {
        // super(email, password, nome, genero, altura, peso, datadenascimento,
        // desportofavorito, atividades);
        this.id = id;
        this.descricao = descricao;
        this.dataderealizacao = dataderealizacao;
        this.duracao = duracao;
    }

    public Atividade() {
        this.id = "";
        this.descricao = "";
        this.dataderealizacao = null;
        this.duracao = 0;
    }

    public Atividade(Atividade uAtividade) {
        this.id = uAtividade.id;
        this.descricao = uAtividade.descricao;
        this.dataderealizacao = uAtividade.dataderealizacao;
        this.duracao = uAtividade.duracao;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setDescricacao(String descricao) {
        this.descricao = descricao;
    }

    public void setDataderealizacao(LocalDate dataderealizacao) {
        this.dataderealizacao = dataderealizacao;
    }

    public void setDuracao(double duracao) {
        this.duracao = duracao;
    }

    public String getId() {
        return this.id;
    }

    public String getDescricao() {
        return this.descricao;
    }

    public LocalDate getDataderealizacao() {
        return this.dataderealizacao;
    }

    public double getDuracao() {
        return this.duracao;
    }

    // Abstratos nao tem clones nem e possivel fazer clones
    /*
     * public Atividade clone() {
     * return new Atividade(this);
     * }
     */

    // Abstratos tambem nao tem equals,

    // Override

    public abstract Atividade clone();

    public abstract boolean equals(Object object);

    public abstract String toString();

    public abstract int calorias(); // vai aparecer em todas as subclasses
}
