import java.time.LocalDate;

public class Corrida extends Atividade implements FazMetros {

    private double distancia;
    private double altimetria;
    private String percurso;
    private int pontos;

    public Corrida(String id, String descricao, LocalDate dataderealizacao, double duracao,
            double distancia, double altimetria, String percurso) {
        super(id, descricao, dataderealizacao, duracao);
        this.distancia = distancia;
        this.altimetria = altimetria;
        this.percurso = percurso;
    }

    public Corrida(Corrida uCorrida) {
        super(uCorrida);
        this.distancia = uCorrida.distancia;
        this.altimetria = uCorrida.altimetria;
        this.percurso = uCorrida.percurso;
    }

    public Corrida() {
        super();
        this.distancia = 0;
        this.altimetria = 0;
        this.percurso = "";
    }

    public void setDistancia(double distancia) {
        this.distancia = distancia;
    }

    public void setAltimetria(double altimetria) {
        this.altimetria = altimetria;
    }

    public void setPercurso(String percurso) {
        this.percurso = percurso;
    }

    public double getDistancia() {
        return this.distancia;
    }

    public double getAltimetria() {
        return this.altimetria;
    }

    public String getPercurso() {
        return this.percurso;
    }

    @Override
    public int calorias() {
        // TODO Auto-generated method stub
        double resultado = (double) (this.distancia * super.getPeso() * super.getDuracao() * (super.getIdade() / 5))
                + 50;
        return (int) resultado;
    }

    @Override
    public Corrida clone() {
        // TODO Auto-generated method stub
        return new Corrida(this);
    }

    @Override
    public boolean equals(Object object) {
        // TODO Auto-generated method stub
        if (this == object)
            return true;

        if (this.getClass() == object.getClass() && object != null)
            return true;

        Corrida c = (Corrida) object;

        return (this.distancia == c.getDistancia())
                && (this.altimetria == c.getAltimetria())
                && (this.percurso.equals(c.getPercurso()));
    }

    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return "\n" + super.getId() +
                "\n" + this.distancia +
                " " + this.altimetria +
                " " + this.percurso;
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
