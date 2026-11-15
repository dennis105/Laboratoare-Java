package exercitiul1;

public class Imprimanta extends Echipament
{
    private int ppm;
    private int dpi;
    private int p_car;
    private ModTiparire mod;

    public Imprimanta(String denumire, int nr_inv, double pret, String zona_mag, Stare stare, int ppm, int dpi, int p_car, ModTiparire mod)
    {
        super(denumire, nr_inv, pret, zona_mag, stare);
        this.ppm = ppm;
        this.dpi = dpi;
        this.p_car = p_car;
        this.mod = mod;
    }

    public int getPpm()
    {
        return ppm;
    }

    public void setPpm(int ppm)
    {
        this.ppm = ppm;
    }

    public int getDpi()
    {
        return dpi;
    }

    public void setDpi(int dpi)
    {
        this.dpi = dpi;
    }

    public int getP_car()
    {
        return p_car;
    }

    public void setP_car(int p_car)
    {
        this.p_car = p_car;
    }

    public ModTiparire getMod()
    {
        return mod;
    }

    public void setMod(ModTiparire mod)
    {
        this.mod = mod;
    }

    @Override
    public String toString()
    {
        return super.toString() +
                ", Imprimanta{" +
                "ppm=" + ppm +
                ", dpi=" + dpi +
                ", p_car=" + p_car +
                ", mod=" + mod +
                '}';
    }
}
