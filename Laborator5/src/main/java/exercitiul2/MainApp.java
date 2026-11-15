package exercitiul2;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

public class MainApp
{
    public static void scriere(List<PerecheNumere> lista)
    {
        try
        {
            ObjectMapper mapper = new ObjectMapper();
            File file = new File("src/main/resources/perechi.json");

            mapper.writeValue(file, lista);
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    public static List<PerecheNumere> citire()
    {
        try
        {
            File file = new File("src/main/resources/perechi.json");
            ObjectMapper mapper = new ObjectMapper();

            List<PerecheNumere> lista = mapper.readValue(
                    file,
                    new TypeReference<List<PerecheNumere>>() {}
            );

            return lista;
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }

        return null;
    }

    public static void main(String[] args)
    {
        List<PerecheNumere> perechi = citire();

        if (perechi == null)
        {
            perechi = new ArrayList<>();
        }

        System.out.println("Perechile citite din JSON:");

        for (int i = 0; i < perechi.size(); i++)
        {
            System.out.println(perechi.get(i));
        }

        System.out.println("\nVerificarea perechilor:");

        for (int i = 0; i < perechi.size(); i++)
        {
            PerecheNumere p = perechi.get(i);

            System.out.println("\nPerechea: " + p);
            System.out.println("Consecutive Fibonacci: " +
                    p.suntConsecutiveFibonacci());
            System.out.println("CMMMC: " + p.cmmmc());
            System.out.println("Aceeasi suma a cifrelor: " +
                    p.auAceeasiSumaCifrelor());
            System.out.println("Acelasi numar de cifre pare: " +
                    p.auAcelasiNumarCifrePare());
        }

        perechi.add(new PerecheNumere(8, 13));

        scriere(perechi);

        System.out.println("\nLista a fost salvata in JSON.");
    }
}
