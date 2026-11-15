package exercitiul1;

import java.io.Serializable;

public class Echipament implements Serializable
{
    private String denumire;
    private int nr_inv;
    private double pret;
    private String zona_mag;
    private Stare stare;

    public Echipament(String denumire, int nr_inv, double pret, String zona_mag, Stare stare)
    {
        this.denumire = denumire;
        this.nr_inv = nr_inv;
        this.pret = pret;
        this.zona_mag = zona_mag;
        this.stare = stare;
    }

    public String getDenumire()
    {
        return denumire;
    }

    public void setDenumire(String denumire)
    {
        this.denumire = denumire;
    }

    public int getNr_inv()
    {
        return nr_inv;
    }

    public void setNr_inv(int nr_inv)
    {
        this.nr_inv = nr_inv;
    }

    public double getPret()
    {
        return pret;
    }

    public void setPret(double pret)
    {
        this.pret = pret;
    }

    public String getZona_mag()
    {
        return zona_mag;
    }

    public void setZona_mag(String zona_mag)
    {
        this.zona_mag = zona_mag;
    }

    public Stare getStare()
    {
        return stare;
    }

    public void setStare(Stare stare)
    {
        this.stare = stare;
    }

    @Override
    public String toString()
    {
        return "Echipament{" +
                "denumire='" + denumire + '\'' +
                ", nr_inv=" + nr_inv +
                ", pret=" + pret +
                ", zona_mag='" + zona_mag + '\'' +
                ", stare=" + stare +
                '}';
    }
}
