package exercitiul1;

public class Copiator extends Echipament
{
    private int p_ton;
    private Format format;

    public Copiator(String denumire, int nr_inv, double pret, String zona_mag, Stare stare, int p_ton, Format format)
    {
        super(denumire, nr_inv, pret, zona_mag, stare);
        this.p_ton = p_ton;
        this.format = format;
    }

    public int getP_ton()
    {
        return p_ton;
    }

    public void setP_ton(int p_ton)
    {
        this.p_ton = p_ton;
    }

    public Format getFormat()
    {
        return format;
    }

    public void setFormat(Format format)
    {
        this.format = format;
    }

    @Override
    public String toString()
    {
        return super.toString() +
                ", Copiator{" +
                "p_ton=" + p_ton +
                ", format=" + format +
                '}';
    }
}
