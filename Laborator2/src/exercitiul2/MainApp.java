package exercitiul2;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class MainApp
{
    public static void main(String[] args) throws FileNotFoundException
    {
        Scanner scannerFisier = new Scanner(new File("cantec_in.txt"));

        ArrayList<Vers> versuri = new ArrayList<>();

        while (scannerFisier.hasNextLine())
        {
            String linie = scannerFisier.nextLine();
            versuri.add(new Vers(linie));
        }

        scannerFisier.close();

        Vers[] tablouVersuri = versuri.toArray(new Vers[0]);

        PrintWriter writer = new PrintWriter("cantec_out.txt");

        String grupare = "zi";

        for (int i = 0; i < tablouVersuri.length; i++)
        {
            String linie = tablouVersuri[i].getText();

            double numar = Math.random();

            if (numar < 0.1)
            {
                linie = tablouVersuri[i].getVersMajuscule();
            }

            if (tablouVersuri[i].seTerminaCu(grupare))
            {
                linie = linie + "*";
            }

            writer.println(
                    linie +
                    " | Cuvinte: " + tablouVersuri[i].getNrCuvinte() +
                    " | Vocale: " + tablouVersuri[i].getNrVocale()
            );
        }

        writer.close();
    }
}
