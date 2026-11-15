package exercitiul4;

import java.util.Random;

public class MainApp
{
    public static void main(String[] args)
    {
        Random random = new Random();

        int a = random.nextInt(31);
        int b = random.nextInt(31);

        System.out.println("a = " + a);
        System.out.println("b = " + b);

        while (b != 0)
        {
            int r = a % b;
            a = b;
            b = r;
        }

        System.out.println("CMMDC: " + a);
    }
}
