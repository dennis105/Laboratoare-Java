package exercitiul5;

import java.util.Random;

public class MainApp
{
    public static void main(String[] args)
    {
        Random random = new Random();

        int a = random.nextInt(21);

        System.out.println("a = " + a);

        int f1 = 0;
        int f2 = 1;
        int f3;
        boolean found = false;

        while (f1 <= a)
        {
            if (f1 == a)
            {
                found = true;
            }

            f3 = f1 + f2;
            f1 = f2;
            f2 = f3;
        }

        if (found)
        {
            System.out.println("Numarul apartine sirului Fibonacci.");
        }
        else
        {
         System.out.println("Numarul nu apartine sirului lui Fibonacci.");
        }
    }
}
