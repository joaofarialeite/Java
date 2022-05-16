import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Utilizador implements Comparable<Utilizador> {

    private String email;
    private String password;
    private String nome;
    private String genero;
    private double altura;
    private double peso;
    private LocalDate datadenascimento;
    private String desportofavorito;
    private Map<String, Atividade> atividades; // falta completar o toString
    // Set<Atividades> atividades , PROF

    public Utilizador(String email, String password, String nome, String genero, double altura, double peso,
            LocalDate datadenascimento, String desportofavorito, Map<String, Atividade> atividades) {
        this.email = email;
        this.password = password;
        this.nome = nome;
        this.genero = genero;
        this.altura = altura;
        this.peso = peso;
        // this.datadenascimento = datadenascimento;
        this.setDatadenascimento(datadenascimento);
        this.desportofavorito = desportofavorito;
        this.setAtividades(atividades);
    }

    public Utilizador(Utilizador uUtilizador) {
        this.email = uUtilizador.getEmail();
        this.password = uUtilizador.getPassword();
        this.nome = uUtilizador.getPassword();
        this.genero = uUtilizador.getGenero();
        this.altura = uUtilizador.getAltura();
        this.peso = uUtilizador.getPeso();
        this.datadenascimento = uUtilizador.getDatadenascimento();
        this.desportofavorito = uUtilizador.getDesportofavorito();
        this.atividades = uUtilizador.getAtividades();
    }

    // nunca utilizar a null
    public Utilizador() {
        this.email = "";
        this.password = "";
        this.nome = "";
        this.genero = "";
        this.altura = 0;
        this.peso = 0;
        this.datadenascimento = LocalDate.now();
        this.desportofavorito = "";
        this.atividades = new HashMap<>();
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public void setDatadenascimento(LocalDate datadenascimento) {
        this.datadenascimento = datadenascimento;
    }

    public void setDesportofavorito(String desportofavorito) {
        this.desportofavorito = desportofavorito;
    }

    // visto que atividades é uma classe abstrata como fasso clone ?

    public void setAtividades(Map<String, Atividade> atividades) {
        this.atividades = new HashMap<>();

        for (Map.Entry<String, Atividade> m : atividades.entrySet()) {

            this.atividades.put(m.getKey(), m.getValue().clone());
        }

        /* for (Atividade a : m.getValue()) */
        /*
         * this.atividades = atividades.entrySet().stream()
         * .collect(Collectors.toMap(entry -> entry.getKey(), entry ->
         * entry.getValue().clone()));
         */
    }

    public Map<String, Atividade> getAtividades() {
        this.atividades = new HashMap<>();

        for (Map.Entry<String, Atividade> a : atividades.entrySet()) {
            this.atividades.put(a.getKey(), a.getValue().clone());
        }

        return this.atividades;
        /*
         * return this.atividades.entrySet().stream()
         * .collect(Collectors.toMap(entry -> entry.getKey(), entry ->
         * entry.getValue().clone()));
         */
    }

    public String getEmail() {
        return this.email;
    }

    public String getPassword() {
        return this.password;
    }

    public String getNome() {
        return this.nome;
    }

    public String getGenero() {
        return this.genero;
    }

    public double getAltura() {
        return this.altura;
    }

    public double getPeso() {
        return this.peso;
    }

    public LocalDate getDatadenascimento() {
        return this.datadenascimento;
    }

    public String getDesportofavorito() {
        return this.desportofavorito;
    }

    public Utilizador clone() {
        return new Utilizador(this);
    }

    public boolean equals(Object object) {
        if (this == object)
            return true;

        if (object == null || this.getClass() != object.getClass())
            return false;

        Utilizador u = (Utilizador) object;

        return (this.email.equals(u.getEmail())
                && this.password.equals(u.getPassword())
                && this.nome.equals(u.getNome())
                && this.genero.equals(u.getGenero())
                && this.altura == u.getAltura()
                && this.peso == u.getPeso()
                && this.datadenascimento.equals(u.getDatadenascimento())
                && this.desportofavorito.equals(u.getDesportofavorito()));
    }

    // FUNCOES

    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return "\n" + this.email +
                " " + this.password +
                " " + this.nome +
                " " + this.genero +
                " " + this.altura +
                " " + this.peso +
                " " + this.datadenascimento +
                " " + this.desportofavorito +
                " " + this.atividades;
    }

    public int getIdade() {
        LocalDate now = LocalDate.now();
        int anodenascimento = this.datadenascimento.getYear();
        int anoagora = now.getYear();
        int result = anoagora - anodenascimento;
        return result;
    }

    public int totalCalorias() {

        int r = 0;

        for (Map.Entry<String, Atividade> m : this.atividades.entrySet()) {
            Atividade a = m.getValue();
            r = a.calorias();
        }
        return r;
    }

    /**
     * 
     * @param actividade
     * @return atividades de um certo tipo
     */

    public int quantos(String actividade) {

        int total = 0;

        for (Map.Entry<String, Atividade> m : this.atividades.entrySet()) {

            if (m.getValue().getClass().getName().equals(actividade)) {
                total++;
            }
        }
        return total;
    }

    @Override
    public int compareTo(Utilizador o) {
        return Double.compare(this.getIdade(), o.getIdade());
    }

}
