import java.io.Serializable;
import java.time.LocalDate;

//Serializable serve para ler e escrever binarios
public class Canoagem extends Atividade implements FazMetros, Serializable { // posso implementar mais do que uma
                                                                             // interface

    private String embarcacao;
    private String direcaodovento;
    private double velocidadedovento;
    private double distancia;
    private double nvoltas;
    private int pontos;

    public Canoagem(String id, String descricao, LocalDate dataderealizacao, double duracao, String embarcacao,
            String direcaodovento, double velocidadedovento, double distancia,
            double nvoltas) {
        super(id, descricao, dataderealizacao, duracao);
        this.embarcacao = embarcacao;
        this.direcaodovento = direcaodovento;
        this.velocidadedovento = velocidadedovento;
        this.distancia = distancia;
        this.nvoltas = nvoltas;
    }

    public Canoagem(Canoagem uCanoagem) {
        super(uCanoagem);
        this.embarcacao = uCanoagem.embarcacao;
        this.direcaodovento = uCanoagem.direcaodovento;
        this.velocidadedovento = uCanoagem.velocidadedovento;
        this.distancia = uCanoagem.distancia;
        this.nvoltas = uCanoagem.nvoltas;
    }

    public Canoagem() {
        super();
        this.embarcacao = "";
        this.direcaodovento = "";
        this.distancia = 0;
        this.nvoltas = 0;
    }

    public void setEmbarcacao(String embarcacao) {
        this.embarcacao = embarcacao;
    }

    public void setDirecaodovento(String direcaodovento) {
        this.direcaodovento = direcaodovento;
    }

    public void setVelocidadedovento(double velocidadedovento) {
        this.velocidadedovento = velocidadedovento;
    }

    public void setDistancia(double distancia) {
        this.distancia = distancia;
    }

    public void setNvoltas(double nvoltas) {
        this.nvoltas = nvoltas;
    }

    public String getEmbarcacao() {
        return this.embarcacao;
    }

    public String getDirecaodovento() {
        return this.direcaodovento;
    }

    public double getVelocidadedovento() {
        return this.velocidadedovento;
    }

    public double getDistancia() {
        return this.distancia;
    }

    public double getNvoltas() {
        return this.nvoltas;
    }

    @Override
    public int calorias() {
        // TODO Auto-generated method stub
        double result = (double) (this.getDistancia() * this.getVelocidadedovento() * super.getDuracao()
                * (super.getIdade() / 4));
        return (int) result;

    }

    @Override
    public Canoagem clone() {
        // TODO Auto-generated method stub

        return new Canoagem(this);
    }

    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return "\n" + super.getId()
                + "\n" + this.embarcacao
                + " " + this.direcaodovento
                + " " + this.velocidadedovento
                + " " + this.distancia + " "
                + this.nvoltas;
    }

    @Override
    public boolean equals(Object object) {
        // TODO Auto-generated method stub
        if (this == object)
            return true;

        if (object == null || (this.getClass() != object.getClass()))
            return false;

        Canoagem c = (Canoagem) object;

        return (this.embarcacao.equals(c.getEmbarcacao())
                && (this.direcaodovento.equals(c.getDirecaodovento()))
                && (this.velocidadedovento == c.getVelocidadedovento())
                && (this.distancia == c.getDistancia())
                && (this.nvoltas == c.getNvoltas()));
    }

    @Override
    public void setPointsPerMeter(int points) {
        // TODO Auto-generated method stub
        this.pontos = points;
    }

    @Override
    public int getPointsPerMeter() {
        // TODO Auto-generated method stub
        return this.pontos;

    }

    @Override
    public double computePoints() {
        // TODO Auto-generated method stub

        return this.pontos * this.distancia;
    }

}
