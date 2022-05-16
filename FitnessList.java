import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

import javax.print.DocFlavor.STRING;

public class FitnessList {

    private List<Utilizador> utilizadores;

    public FitnessList(List<Utilizador> utilizadores) {
        this.setUtilizadores(utilizadores);
    }

    public void setUtilizadores(List<Utilizador> utilizadores) {
        this.utilizadores = new ArrayList<Utilizador>();
        // this.utilizadores.addAll(utilizadores);
        for (Utilizador u : utilizadores)
            this.utilizadores.add(u);
    }

    public List<Utilizador> getUtilizadores() {
        this.utilizadores = new ArrayList<>(utilizadores);
        for (Utilizador u : utilizadores)
            this.utilizadores.add(u);

        return this.utilizadores;
    }

    public void allutilizadores() {

        for (Utilizador u : this.utilizadores) {
            System.out.println(u.getNome());
        }

    }

    public boolean existeUtilizador(String email) {

        for (Utilizador u : this.utilizadores) {
            if (u.getEmail().equals(email)) {
                return true;
            }
        }

        return false;
    }

    public int quantos() {

        int total = 0;

        for (Utilizador u : this.utilizadores) {
            total++;
        }

        return total;
    }

    public int quantos(String actividade, String email) {

        int total = 0;
        String s = "";
        for (Utilizador u : this.utilizadores) {
            if (u.getEmail().equals(email)) {
                total = u.quantos(actividade);
            }
        }

        return total;
    }

    public Utilizador getUtilizador(String email) {
        Utilizador novo = new Utilizador();
        for (Utilizador u : this.utilizadores) {
            if (u.getEmail().equals(email))
                // System.out.println(u.toString());
                novo = u;
        }

        return novo;

    }

    /**
     * 
     * @param email
     * @param actividade
     * @return elimina tudo o que tinha la antes !!!!!!!!!!!!!!!!!!!!!!!WHY!
     */
    public void adiciona(String email, Atividade act) {

        for (Utilizador u : this.utilizadores) {
            Map<String, Atividade> m = u.getAtividades();
            if (u.getEmail().equals(email)) {
                u.getAtividades().put("NOVAAA", act);
            }
        }
    }

    /**
     * 
     * @return deveria devolver todas uma lista com todas as atividades dos
     *         utilizadores
     *         Contudo da erro ??????????? Devolve lista vazia []
     */
    public ArrayList<Atividade> getAllActividades() {
        ArrayList<Atividade> resultado = new ArrayList<>();

        for (Utilizador u : this.utilizadores) {
            for (Map.Entry<String, Atividade> m : u.getAtividades().entrySet()) {
                resultado.add(m.getValue());
            }
        }

        return resultado;
    }

    /**
     * 
     * @param email
     * @param activs
     *               Erro de tipos
     */
    public void adiciona(String email, Set<Atividade> activs) {

        for (Utilizador u : this.utilizadores) {
            if (u.getEmail().equals(email)) {
                for (Atividade a : activs) {
                    u.getAtividades().put("Nova", a);
                }
            }
        }
    }

    /**
     * 
     * @param email
     * @return
     *         Nao retorna o que devia retornar
     */
    public int tempoTotalUtilizador(String email) {

        int duracao = 0;
        int total = 0;

        for (Utilizador u : this.utilizadores) {
            if (u.getEmail().equals(email)) {
                for (Map.Entry<String, Atividade> m : u.getAtividades().entrySet()) {
                    duracao = (int) m.getValue().getDuracao();
                    total = total + duracao;
                }
            }
        }

        return total;
    }

    /**
     * 
     * @return
     *         Exception in thread "main" java.lang.NullPointerException: Cannot
     *         invoke "Atividade.getDuracao()" because "<local17>" is null
     *         at main.main(main.java:99)
     */

    public Atividade actividadeMaisExigente() {

        Atividade a = null;
        int teste = 0;

        for (Utilizador u : this.utilizadores) {
            for (Map.Entry<String, Atividade> m : u.getAtividades().entrySet()) {
                if (m.getValue().calorias() > teste) {
                    teste = m.getValue().calorias();
                    a = m.getValue();
                }
            }
        }

        return a;
    }

    /**
     * 
     * @return
     *         Exception in thread "main" java.lang.NullPointerException: Cannot
     *         invoke "Atividade.getDuracao()" because "<local17>" is null
     *         at main.main(main.java:99)
     */
    public Utilizador utilizadorMaisActivo() {
        Utilizador a = null;
        int teste = 0;

        for (Utilizador u : this.utilizadores) {
            for (Map.Entry<String, Atividade> m : u.getAtividades().entrySet()) {
                if (m.getValue().calorias() > teste) {
                    teste = m.getValue().calorias();
                    a = u;
                }
            }
        }

        return a;
    }

    public void actualizaDesportoFav() {

        int total = 0;
        for (Utilizador u : this.utilizadores) {
            for (Map.Entry<String, Atividade> m : u.getAtividades().entrySet()) {
                if (u.quantos(m.getValue().getClass().getName()) > total) {
                    total = u.quantos(m.getValue().getClass().getName());
                    u.setDesportofavorito(m.getValue().getClass().getName());
                }
            }
        }
    }

    public Set<Utilizador> ordenarUtilizadores() {
        ComparadorUtilizador comparadorUtilizador = new ComparadorUtilizador();
        TreeSet<Utilizador> res = new TreeSet<>(comparadorUtilizador);

        for (Utilizador u : this.utilizadores) {
            res.add(u);
        }

        return res;
    }

    public List<Utilizador> ordenarUtilizadoresList() {
        ComparadorUtilizador comparadorUtilizador = new ComparadorUtilizador();
        List<Utilizador> res = new ArrayList<>();

        res.addAll(this.utilizadores);
        Collections.sort(res, comparadorUtilizador);

        return res;
    }

}

/*
 * public static void main(String[] args) {
 * 
 * Atividade corrida1 = new Corrida("A1", "descricao", LocalDate.of(2019, 8,
 * 20), 2.5, 1.1, 5, "percurso");
 * Atividade corrida2 = new Corrida("A1", "descricao", LocalDate.of(2019, 8,
 * 20), 2.5, 1.1, 5, "percurso");
 * Map<String, Atividade> a = new HashMap<>();
 * a.put("Ola", corrida1);
 * 
 * Utilizador n1 = new Utilizador("email", "password", "nome", "genero", 1.98,
 * 60, LocalDate.of(2000, 8, 1),
 * "desportofavorito", a);
 * 
 * // como usar o ? extends ?
 * 
 * System.out.println(n1.totalCalorias());
 * }
 * 
 */