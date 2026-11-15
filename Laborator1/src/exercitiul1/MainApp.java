package exercitiul1;

import java.util.Scanner;

public class MainApp
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);

        System.out.print("L = ");
        int L = scanner.nextInt();

        System.out.print("l = ");
        int l = scanner.nextInt();

        System.out.println("Perimetrul dreptunghiului este: " + 2 * (L + l));
        System.out.println("Aria dreptunghiului este: " + L * l);

        scanner.close();
    }
}
