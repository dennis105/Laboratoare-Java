package exercitiul1;

public class Punct
{
    public double x;
    public double y;

    public Punct(double x, double y)
    {
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString()
    {
        return "(" + x + ", " + y + ")";
    }
}
