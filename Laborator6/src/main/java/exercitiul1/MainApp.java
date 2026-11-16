package exercitiul1;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import java.io.File;
import java.time.LocalDate;
import java.util.DoubleSummaryStatistics;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class MainApp
{
    public static void main(String[] args)
    {
        try
        {
            ObjectMapper mapper = new ObjectMapper();

            mapper.registerModule(new JavaTimeModule());
            mapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);

            List<Angajat> angajati = mapper.readValue(
                    new File("src/main/resources/angajati.json"),
                    new TypeReference<List<Angajat>>()
                    {
                    }
            );

            // 1.Afișarea listei de angajați folosind referințe la metode.
            angajati.forEach(System.out::println);

            // 2.Afișarea angajaților care au salariul peste 2500 RON
            System.out.println("\nAngajati cu salariul mai mare de 2500 RON: ");

            Predicate<Angajat> p = a -> a.getSalariul() > 2500;

            angajati.stream()
                    .filter(p)
                    .forEach(System.out::println);

            // 3.Crearea unei liste cu angajații din luna aprilie, a anului trecut, care au funcție de conducere
            System.out.println("\nAngajati din aprilie anul trecut cu functie de conducere: ");

            int anulTrecut = LocalDate.now().getYear() - 1;

            List<Angajat> angajatiAprilie = angajati.stream()
                    .filter(a -> a.getData_angajarii().getYear() == anulTrecut)
                    .filter(a -> a.getData_angajarii().getMonthValue() == 4)
                    .filter(a -> a.getPostul().contains("sef") ||
                            a.getPostul().contains("director"))
                    .collect(Collectors.toList());

            angajatiAprilie.forEach(System.out::println);

            //  4.Afișarea angajaților care nu au funcție de conducere, în ordine descrescătoare a salariilor
            System.out.println("\nAngajati care nu au functie de conducere, in ordine descrescatoare a salariilor: ");

            angajati.stream()
                    .filter(a -> !a.getPostul().contains("sef") &&
                            !a.getPostul().contains("director"))
                    .sorted((a1, a2) -> Float.compare(a2.getSalariul(), a1.getSalariul()))
                    .forEach(System.out::println);

            // 5.Extragerea din lista de angajați a unei liste de String-uri care conține numele angajaților scrise cu majuscule
            System.out.println("\nNumele angajatilor cu majuscule: ");

            List<String> numeMajuscule = angajati.stream()
                    .map(a -> a.getNumele().toUpperCase())
                    .collect(Collectors.toList());

            numeMajuscule.forEach(System.out::println);

            // 6.Afișarea salariilor mai mici de 3000 de RON
            System.out.println("\nSalariile mai mici de 3000 RON: ");

            angajati.stream()
                    .map(Angajat::getSalariul)
                    .filter(salariul -> salariul < 3000)
                    .forEach(System.out::println);

            // 7.Afișarea datelor primului angajat al firmei
            System.out.println("\nDatele primului angajat din firma: ");

            Optional<Angajat> primulAngajat = angajati.stream()
                    .min((a1, a2) -> a1.getData_angajarii().compareTo(a2.getData_angajarii()));

            if (primulAngajat.isPresent())
            {
                System.out.println(primulAngajat.get());
            }
            else
            {
                System.out.println(("Nu exista angajati. "));
            }

            // 8.Afișarea de statistici referitoare la salariul angajaților
            System.out.println("\nStatistici salarii: ");

            DoubleSummaryStatistics statistici = angajati.stream()
                    .collect(Collectors.summarizingDouble(Angajat::getSalariul));

            System.out.println("Salariu mediu: " + statistici.getAverage());
            System.out.println("Salariu minim: " + statistici.getMin());
            System.out.println("Salariu maxim: " + statistici.getMax());

            // 9.Afișarea unor mesaje care indică dacă printre angajați există cel puțin un “Ion”
            System.out.println("\nVerificare angajati cu numele Ion:");

            Optional<Angajat> ion = angajati.stream()
                    .filter(a -> a.getNumele().contains("Ion"))
                    .findAny();

            ion.ifPresentOrElse(
                    a -> System.out.println("Firma are cel putin un Ion angajat."),
                    () -> System.out.println("Firma nu are niciun Ion angajat.")
            );


            // 10.Afișarea numărului de persoane care s-au angajat în vara anului precedent
            System.out.println("\nNumarul angajatilor angajati vara anului trecut:");

            long numarAngajati = angajati.stream()
                    .filter(a -> a.getData_angajarii().getYear() == anulTrecut)
                    .filter(a -> a.getData_angajarii().getMonthValue() >= 6 &&
                            a.getData_angajarii().getMonthValue() <= 8)
                    .count();

            System.out.println(numarAngajati);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}
