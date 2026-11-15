package exercitiul3;

import java.util.Scanner;

public class MainApp
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);

        System.out.print("n = ");
        int n = scanner.nextInt();

        int nrDiv = 0;

        System.out.print("Divizorii lui " + n + " sunt: ");
        for (int i = 1; i <= n; i++)
        {
            if (n % i == 0)
            {
                System.out.print(i + " ");
                nrDiv++;
            }
        }

        if (nrDiv == 2)
        {
            System.out.println("\nNumarul este prim.");
        }
        else
        {
            System.out.println("\nNumarul nu este prim.");
        }

        scanner.close();
    }
}
