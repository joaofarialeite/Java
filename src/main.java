import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

public class main {

        public static void main(String[] args) {

                Atividade corrida1 = new Corrida("A1", "descricao", LocalDate.of(2019, 8, 20), 2.5, 1.1, 5, "percurso");
                Atividade corrida2 = new Corrida("A2", "descricao", LocalDate.of(2019, 8, 20), 2.5, 1.1, 5, "percurso");
                Atividade corrida3 = new Corrida("A3", "descricao", LocalDate.of(2019, 8, 20), 2.5, 1.1, 5, "percurso");
                Atividade corrida4 = new Corrida("A3", "descricao", LocalDate.of(2019, 8, 20), 2.5, 1.1, 5, "percurso");
                Atividade canoagem1 = new Canoagem("B1", "descricao", LocalDate.of(2019, 8, 20), 3.0, "Maritima",
                                "Norte", 1.1,
                                10, 5);
                Atividade abdominais1 = new Abdominais("C1", "descricao", LocalDate.of(2019, 8, 20), 5.0, "DUROS", 5);
                Map<String, Atividade> a1 = new HashMap<>();
                a1.put("B1", canoagem1);
                a1.put("C1", abdominais1);

                Map<String, Atividade> a2 = new HashMap<>();
                a2.put("A1", corrida1);
                a2.put("A2", corrida2);

                Map<String, Atividade> a3 = new HashMap<>();
                a3.put("A1", corrida1);
                a3.put("A2", corrida2);
                a3.put("A3", corrida3);

                Map<String, Atividade> a4 = new HashMap<>();
                a4.put("A1", corrida1);
                a4.put("A2", corrida2);
                a4.put("A3", corrida3);
                a4.put("A4", corrida4);
                a4.put("C1", abdominais1);

                Utilizador n1 = new Utilizador("email1", "password", "nome1", "genero1", 1.98, 60,
                                LocalDate.of(2000, 8, 1),
                                "desportofavorito", a1);

                Utilizador n2 = new Utilizador("email2", "password", "nome2", "genero2", 1.98, 60,
                                LocalDate.of(2000, 8, 1),
                                "desportofavorito", a2);

                Utilizador n4 = new Utilizador("email4", "password", "nome4", "genero4", 1.98, 60,
                                LocalDate.of(2000, 8, 1),
                                "desportofavorito", a4);

                Utilizador n3 = new Utilizador("email3", "password", "nome3", "genero3", 1.98, 60,
                                LocalDate.of(2000, 8, 1),
                                "desportofavorito", a3);

                Utilizador n20 = new Utilizador("email3", "password", "nome3", "genero3", 1.98, 60,
                                LocalDate.of(2000, 8, 1),
                                "desportofavorito", a3);

                List<Utilizador> list = new ArrayList<>();
                list.add(n1);
                list.add(n2);
                list.add(n3);
                list.add(n4);

                FitnessList f1 = new FitnessList(list);

                // como usar o ? extends ?

                // System.out.println(n4.quantos("Abdominais"));
                // System.out.println(f1.quantos("Corrida", "email4"));
                // System.out.println(n1.toString());
                // f1.getUtilizador("email1");
                // Utilizador testar = new Utilizador();
                /*
                 * Utilizador testar = f1.getUtilizador("email1");
                 * System.out.println(testar.toString())
                 */;

                /*
                 * System.out.println(n1.toString());
                 * f1.adiciona("email1", abdominais1);
                 * System.out.println(f1.quantos("Abdominais", "email4"));
                 * 
                 * System.out.println(n1.toString());
                 */

                /*
                 * ArrayList<Atividade> list1 = new ArrayList<>();
                 * list1 = f1.getAllActividades();
                 */

                // Set<Atividade> seteste = new TreeSet<>();
                // seteste.add(corrida1);
                // f1.adiciona("email2", seteste);

                // System.out.println(f1.tempoTotalUtilizador("email4"));

                /*
                 * Atividade testar1 = f1.actividadeMaisExigente();
                 * System.out.println(testar1.getDuracao());
                 */

                Set<Utilizador> testar2 = new TreeSet<>();
                testar2 = f1.ordenarUtilizadores();
                System.out.println(testar2.contains(n20));

        }
}
