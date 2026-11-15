package exercitiul2;

public class Vers
{
    private String text;

    public Vers(String text)
    {
        this.text = text;
    }

    public String getText()
    {
        return text;
    }

    public int getNrCuvinte()
    {
        String[] cuvinte = text.split(" ");

        return cuvinte.length;
    }

    public int getNrVocale()
    {
        int nrVocale = 0;

        for (int i = 0; i < text.length(); i++)
        {
            char litera = text.charAt(i);

            if (litera == 'a' || litera == 'e' || litera == 'i' || litera == 'o' || litera == 'u')
            {
                nrVocale++;
            }
        }
        return nrVocale;
    }

    public boolean seTerminaCu(String grupare)
    {
        return text.endsWith(grupare);
    }

    public String getVersMajuscule()
    {
        return text.toUpperCase();
    }
}
