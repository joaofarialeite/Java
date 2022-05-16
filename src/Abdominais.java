import java.time.LocalDate;

public class Abdominais extends Atividade {

    private String tipo;
    private int repeticioes;

    public Abdominais(String id, String descricao, LocalDate dataderealizacao, double duracao, String tipo,
            int repeticioes) {
        super(id, descricao, dataderealizacao, duracao);
        this.tipo = tipo;
        this.repeticioes = repeticioes;
    }

    public Abdominais(Abdominais uAbdominais) {
        super(uAbdominais);
        this.tipo = uAbdominais.tipo;
        this.repeticioes = uAbdominais.repeticioes;
    }

    public Abdominais() {
        super();
        this.tipo = "";
        this.repeticioes = 0;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public void setRepeticoes(int repeticioes) {
        this.repeticioes = repeticioes;
    }

    public String getTipo() {
        return this.tipo;
    }

    public int getRepeticoes() {
        return this.repeticioes;
    }

    @Override
    public int calorias() {
        // TODO Auto-generated method stub
        double result = super.getDuracao() * this.getRepeticoes()
                * 3 / 5;

        return (int) result;
    }

    @Override
    public Abdominais clone() {
        // TODO Auto-generated method stub
        return new Abdominais(this);
    }

    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return "\n" + super.getId() + "\n" + this.tipo + "\n" + this.repeticioes;
    }

    @Override
    public boolean equals(Object object) {
        // TODO Auto-generated method stub

        if (this == object)
            return true;

        if (object == null || this.getClass() != object.getClass())
            return false;

        Abdominais a = (Abdominais) object;

        return (this.tipo.equals(a.getTipo()) && this.repeticioes == a.getRepeticoes());
    }

}
