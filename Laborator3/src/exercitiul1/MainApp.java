
package exercitiul1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MainApp
{
    public static void main(String[] args) throws FileNotFoundException
    {
        List<Parabola> parabole = new ArrayList<>();

        Scanner scanner = new Scanner(new File("in.txt"));

        while (scanner.hasNextInt())
        {
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            int c = scanner.nextInt();

            Parabola p = new Parabola(a, b, c);
            parabole.add(p);
        }

        scanner.close();

        System.out.println("Lista de parabole:");

        for (Parabola p : parabole)
        {
            System.out.println(p);
            System.out.println("Varf: " + p.getVarf());
            System.out.println();
        }

        if (parabole.size() >= 2)
        {
            Parabola p1 = parabole.get(0);
            Parabola p2 = parabole.get(1);

            Punct m1 = p1.mijloc(p2);
            double d1 = p1.distanta(p2);

            System.out.println("Metode de instanta:");
            System.out.println("Mijloc: " + m1);
            System.out.println("Distanta: " + d1);

            Punct m2 = Parabola.mijloc(p1, p2);
            double d2 = Parabola.distanta(p1, p2);

            System.out.println("\nMetode statice:");
            System.out.println("Mijloc: " + m2);
            System.out.println("Distanta: " + d2);
        }
    }
}
