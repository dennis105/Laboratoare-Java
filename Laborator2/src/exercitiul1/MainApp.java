package exercitiul1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.io.FileNotFoundException;
import java.io.File;

public class MainApp
{
    public static void main(String[] args) throws FileNotFoundException
    {
        Scanner scannerFisier = new Scanner(new File("judete_in.txt"));

        ArrayList<String> lista = new ArrayList<>();

        while (scannerFisier.hasNextLine())
        {
            lista.add(scannerFisier.nextLine());
        }

        scannerFisier.close();

        String[] judete = lista.toArray(new String[0]);

        System.out.println("Tabloul initial: ");
        System.out.println(Arrays.toString(judete));

        Arrays.sort(judete);

        System.out.println("Tabloul sortat: ");
        System.out.println(Arrays.toString(judete));

        Scanner scanner = new Scanner(System.in);

        System.out.print("Introduceti judetul cautat: ");
        String cautat = scanner.nextLine();

        int pozitie = Arrays.binarySearch(judete, cautat);

        if (pozitie >= 0)
        {
            System.out.println("Judetul a fost gasit pe pozitia: " + (pozitie +1));
        }
        else
        {
            System.out.println("Judetul nu a fost gasit!");
        }

        scanner.close();
    }
}
