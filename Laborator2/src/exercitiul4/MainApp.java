package exercitiul4;

import java.util.Scanner;

public class MainApp
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Introdu numarul de persoane: ");
        int n = scanner.nextInt();

        scanner.nextLine();

        Persoana[] persoane = new Persoana[n];

        for (int i = 0; i < n; i++)
        {
            System.out.print("Nume: ");
            String nume = scanner.nextLine();

            System.out.print("CNP: ");
            String cnp = scanner.nextLine();

            persoane[i] = new Persoana(nume, cnp);

            while (!persoane[i].cnpValid())
            {
                System.out.print("CNP Invalid! Introduceti din nou: ");
                cnp = scanner.nextLine();

                persoane[i] = new Persoana(nume, cnp);
            }
        }

        for (int i = 0; i < n; i++)
        {
            System.out.println(
                    persoane[i].getNume() + ", " +
                    persoane[i].getCnp() + ", " +
                    persoane[i].getVarsta()
            );
        }
    }
}
