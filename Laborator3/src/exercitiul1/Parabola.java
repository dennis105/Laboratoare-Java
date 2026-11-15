package exercitiul1;

public class Parabola
{
    private int a;
    private int b;
    private int c;

    public Parabola(int a, int b, int c)
    {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public Punct getVarf()
    {
        double x = -b / (2.0 * a);
        double y = (4.0 * a * c - b * b) / (4.0 * a);

        return new Punct(x, y);
    }

    public Punct mijloc(Parabola p)
    {
        Punct v1 = this.getVarf();
        Punct v2 = p.getVarf();

        double x = (v1.x + v2.x) / 2;
        double y = (v1.y + v2.y) / 2;

        return new Punct(x, y);
    }

    public static Punct mijloc(Parabola p1, Parabola p2)
    {
        Punct v1 = p1.getVarf();
        Punct v2 = p2.getVarf();

        double x = (v1.x + v2.x) / 2;
        double y = (v1.y + v2.y) / 2;

        return new Punct(x, y);
    }

    public double distanta(Parabola p)
    {
        Punct v1 = this.getVarf();
        Punct v2 = p.getVarf();

        return Math.hypot(v2.x - v1.x, v2.y - v1.y);
    }

    public static double distanta(Parabola p1, Parabola p2)
    {
        Punct v1 = p1.getVarf();
        Punct v2 = p2.getVarf();

        return Math.hypot(v2.x - v1.x, v2.y - v1.y);
    }

    @Override
    public String toString()
    {
        return "f(x) = " + a + "x^2 + " + b + "x + " + c;
    }
}
