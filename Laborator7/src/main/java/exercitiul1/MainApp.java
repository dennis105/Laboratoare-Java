package exercitiul1;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

public class MainApp
{
    public static void main(String[] args)
    {
        try
        {
            ObjectMapper mapper = new ObjectMapper();

            Map<Integer, Carte> carti = mapper.readValue(
                    new File("src/main/resources/carti.json"),
                    new TypeReference<HashMap<Integer, Carte>>() {}
            );

            // 1.Să se afișeze colecția
            carti.forEach((id, carte) ->
                    System.out.println(id + " -> " + carte));

            // 2.Să se șteargă o carte din colecția Map
            carti.remove(2);

            System.out.println("\nDupa stergere: ");
            carti.forEach((id, carte) ->
                    System.out.println(id + " -> " + carte));

            // 3.Să se adauge o carte la colecția Map
            carti.putIfAbsent(7,
                    new Carte("Sapiens", "Yuval Noah Harari", 2011));

            System.out.println("\nDupa adaugare: ");
            carti.forEach((id, carte) ->
                    System.out.println(id + " ->  " + carte));

            // 4.Sa se salveze în fișierul JSON modificările făcute asupra colecției
            mapper.writerWithDefaultPrettyPrinter().writeValue(
                    new File("src/main/resources/carti.json"), carti);

            // 5.Să se creeze o colecție Set<Carte> care extrage din colecția Map cărțile autorului Yuval Noah Harari
            System.out.println("\nCarti scrise de Yuval Noah Harari: ");

            Set<Carte> cartiHarari = carti.values().stream()
                    .filter(c -> c.autorul().equals("Yuval Noah Harari"))
                    .collect(Collectors.toSet());

            cartiHarari.forEach(System.out::println);

            // 6.Să se afișeze ordonat după titlul cărți elementele din colecția Set
            System.out.println("\nCarti ordonate dupa titlu:");

            cartiHarari.stream()
                    .sorted((c1, c2) -> c1.titlul().compareTo(c2.titlul()))
                    .forEach(System.out::println);

            // 7.Să se afișeze datele celei mai vechi cărți din colecția Set
            System.out.println("\nCea mai veche carte:");

            Optional<Carte> carteVeche = cartiHarari.stream()
                    .min((c1, c2) -> Integer.compare(c1.anul(), c2.anul()));

            if (carteVeche.isPresent())
            {
                System.out.println(carteVeche.get());
            }
            else
            {
                System.out.println("Nu exista carti.");
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}
