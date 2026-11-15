package exercitiul4;

import java.time.LocalDate;
import java.time.Period;
import java.time.DateTimeException;

public class Persoana
{
    private String nume;
    private String cnp;

    public Persoana(String nume, String cnp)
    {
        this.nume = nume;
        this.cnp = cnp;
    }

    public String getNume()
    {
        return nume;
    }

    public void setNume(String nume)
    {
        this.nume = nume;
    }

    public String getCnp()
    {
        return cnp;
    }

    public void setCnp(String cnp)
    {
        this.cnp = cnp;
    }

    public int getVarsta()
    {
        if (!cnpValid())
        {
            return -1;
        }
        
        int an = Integer.parseInt(cnp.substring(1,3));
        int luna = Integer.parseInt(cnp.substring(3,5));
        int zi = Integer.parseInt(cnp.substring(5,7));

        int primaCifra = Integer.parseInt(cnp.substring(0, 1));

        if (primaCifra == 1 || primaCifra == 2)
        {
            an += 1900;
        }
        else if (primaCifra == 5 || primaCifra == 6)
        {
            an += 2000;
        }

        LocalDate dataNasterii = LocalDate.of(an, luna, zi);
        LocalDate dataCurenta = LocalDate.now();

        Period diferenta = Period.between(dataNasterii, dataCurenta);

        return diferenta.getYears();
    }

    public boolean cnpValid()
    {
        if (cnp.length() != 13)
        {
            return false;
        }

        for (int i = 0; i < 13; i++)
        {
            if (!Character.isDigit(cnp.charAt(i)))
            {
                return false;
            }
        }

        if (cnp.charAt(0) != '1' && cnp.charAt(0) != '2' && cnp.charAt(0) != '5' && cnp.charAt(0) != '6')
        {
            return false;
        }

        int an = Integer.parseInt(cnp.substring(1, 3));
        int luna = Integer.parseInt(cnp.substring(3, 5));
        int zi = Integer.parseInt(cnp.substring(5, 7));

        if (cnp.charAt(0) == '1' || cnp.charAt(0) == '2')
        {
            an += 1900;
        }
        else
        {
            an += 2000;
        }

        LocalDate dataNasterii;

        try
        {
            dataNasterii = LocalDate.of(an, luna, zi);
        }
        catch (DateTimeException e)
        {
            return false;
        }

        if (dataNasterii.isAfter(LocalDate.now()))
        {
            return false;
        }

        String control = "279146358279";
        int suma = 0;

        for (int i = 0; i < 12; i++)
        {
            suma = suma + (Character.getNumericValue(cnp.charAt(i)) * Character.getNumericValue(control.charAt(i)));
        }

        int cifraControl = suma % 11;

        if (cifraControl == 10)
        {
            cifraControl = 1;
        }

        if (cifraControl != Character.getNumericValue(cnp.charAt(12)))
        {
            return false;
        }

        return true;
    }
}
