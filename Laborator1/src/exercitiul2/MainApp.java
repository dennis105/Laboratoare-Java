package exercitiul2;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.Scanner;

public class MainApp
{
    public static void main(String[] args) throws FileNotFoundException
    {
        Scanner scanner = new Scanner(new File("in.txt"));

        int sum = 0;
        int min = 0;
        int max = 0;
        int nr = 0;

        while (scanner.hasNextInt())
        {
            int x = scanner.nextInt();

            if (nr == 0)
            {
                min = x;
                max = x;
            }

            nr++;
            sum += x;

            if (x < min)
                min = x;

            if (x > max)
                max = x;
        }

        if (nr > 0)
        {
            double media = (double) sum / nr;
            System.out.println("Suma: " + sum);
            System.out.println("Media: " + media);
            System.out.println("Valoarea minima: " + min);
            System.out.println("Valoarea maxima: " + max);

            PrintStream flux_out = new PrintStream("out.txt");
            flux_out.println("Suma: " + sum);
            flux_out.println("Media: " + media);
            flux_out.println("Valoarea minima: " + min);
            flux_out.println("Valoarea maxima: " + max);
            flux_out.close();
        }
        else
        {
            System.out.println("Fisierul este gol!");
        }

        scanner.close();
    }
}
