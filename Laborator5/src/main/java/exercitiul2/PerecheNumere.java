package exercitiul2;

public class PerecheNumere
{
    private int a;
    private int b;

    public PerecheNumere()
    {
    }

    public PerecheNumere(int a, int b)
    {
        this.a = a;
        this.b = b;
    }

    public int getA()
    {
        return a;
    }

    public void setA(int a)
    {
        this.a = a;
    }

    public int getB()
    {
        return b;
    }

    public void setB(int b)
    {
        this.b = b;
    }

    @Override
    public String toString()
    {
        return "(" + a + ", " + b + ")";
    }

    // Verifica daca numerele sunt consecutive in sirul Fibonacci
    public boolean suntConsecutiveFibonacci()
    {
        if (a < 0 || b < 0)
        {
            return false;
        }

        long x = 0;
        long y = 1;

        while (x <= a)
        {
            if (x == a && y == b)
            {
                return true;
            }

            long aux = x + y;
            x = y;
            y = aux;
        }

        return false;
    }

    // Calculeaza cel mai mare divizor comun
    private int cmmd(int x, int y)
    {
        while (y != 0)
        {
            int aux = y;
            y = x % y;
            x = aux;
        }

        return Math.abs(x);
    }

    // Calculeaza cel mai mic multiplu comun
    public long cmmmc()
    {
        if (a == 0 || b == 0)
        {
            return 0;
        }

        return Math.abs((long) a / cmmd(a, b) * b);
    }

    // Calculeaza suma cifrelor unui numar
    private int sumaCifrelor(int n)
    {
        long numar = Math.abs((long) n);
        int suma = 0;

        while (numar > 0)
        {
            suma += numar % 10;
            numar = numar / 10;
        }

        return suma;
    }

    // Verifica daca numerele au aceeasi suma a cifrelor
    public boolean auAceeasiSumaCifrelor()
    {
        return sumaCifrelor(a) == sumaCifrelor(b);
    }

    // Numara cifrele pare ale unui numar
    private int numaraCifrePare(int n)
    {
        long numar = Math.abs((long) n);
        int contor = 0;

        while (numar > 0)
        {
            int cifra = (int) (numar % 10);

            if (cifra % 2 == 0)
            {
                contor++;
            }

            numar = numar / 10;
        }

        return contor;
    }

    // Verifica daca numerele au acelasi numar de cifre pare
    public boolean auAcelasiNumarCifrePare()
    {
        return numaraCifrePare(a) == numaraCifrePare(b);
    }
}
