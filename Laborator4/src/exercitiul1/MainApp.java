
package exercitiul1;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MainApp
{
    public static void main(String[] args) throws IOException, ClassNotFoundException
    {
        List<Echipament> echipamente = citesteEchipamente();

        Scanner tastatura = new Scanner(System.in);
        int optiune;

        do
        {
            System.out.println("\n===== MENIU ELECTRONICE =====");
            System.out.println("1. Afisarea tuturor echipamentelor");
            System.out.println("2. Afisarea imprimantelor");
            System.out.println("3. Afisarea copiatoarelor");
            System.out.println("4. Afisarea sistemelor de calcul");
            System.out.println("5. Modificarea starii unui echipament");
            System.out.println("6. Modificarea modului de tiparire");
            System.out.println("7. Modificarea formatului copiatorului");
            System.out.println("8. Instalarea sistemului de operare");
            System.out.println("9. Afisarea echipamentelor vandute");
            System.out.println("10. Serializarea echipamentelor");
            System.out.println("11. Deserializarea echipamentelor");
            System.out.println("0. Iesire");
            System.out.print("Alege optiunea: ");

            optiune = Integer.parseInt(tastatura.nextLine());

            switch (optiune)
            {
                case 1:
                    afisareToate(echipamente);
                    break;

                case 2:
                    afisareImprimante(echipamente);
                    break;

                case 3:
                    afisareCopiatoare(echipamente);
                    break;

                case 4:
                    afisareSisteme(echipamente);
                    break;

                case 5:
                    modificareStare(echipamente, tastatura);
                    break;

                case 6:
                    modificareModTiparire(echipamente, tastatura);
                    break;

                case 7:
                    modificareFormat(echipamente, tastatura);
                    break;

                case 8:
                    instalareSistemOperare(echipamente, tastatura);
                    break;

                case 9:
                    afisareVandute(echipamente);
                    break;

                case 10:
                    serializare(echipamente);
                    System.out.println("Lista a fost salvata in echip.bin.");
                    break;

                case 11:
                    echipamente = deserializare();
                    System.out.println("Lista a fost incarcata din echip.bin.");
                    break;

                case 0:
                    System.out.println("Program incheiat.");
                    break;

                default:
                    System.out.println("Optiune invalida.");
            }

        } while (optiune != 0);

        tastatura.close();
    }

    // Citirea echipamentelor din fisier
    public static List<Echipament> citesteEchipamente() throws FileNotFoundException
    {
        List<Echipament> echipamente = new ArrayList<>();

        Scanner scanner = new Scanner(new File("electronice.txt"));

        while (scanner.hasNextLine())
        {
            String linie = scanner.nextLine();

            if (linie.isBlank())
            {
                continue;
            }

            String[] date = linie.split(";");

            switch (date[0])
            {
                case "IMPRIMANTA":
                    echipamente.add(new Imprimanta(
                            date[1],
                            Integer.parseInt(date[2]),
                            Double.parseDouble(date[3]),
                            date[4],
                            Stare.valueOf(date[5]),
                            Integer.parseInt(date[6]),
                            Integer.parseInt(date[7]),
                            Integer.parseInt(date[8]),
                            ModTiparire.valueOf(date[9])
                    ));
                    break;

                case "COPIATOR":
                    echipamente.add(new Copiator(
                            date[1],
                            Integer.parseInt(date[2]),
                            Double.parseDouble(date[3]),
                            date[4],
                            Stare.valueOf(date[5]),
                            Integer.parseInt(date[6]),
                            Format.valueOf(date[7])
                    ));
                    break;

                case "SISTEM":
                    echipamente.add(new SistemeCalcul(
                            date[1],
                            Integer.parseInt(date[2]),
                            Double.parseDouble(date[3]),
                            date[4],
                            Stare.valueOf(date[5]),
                            date[6],
                            Double.parseDouble(date[7]),
                            Integer.parseInt(date[8]),
                            SistemOperare.valueOf(date[9])
                    ));
                    break;
            }
        }

        scanner.close();

        return echipamente;
    }

    // 1. Afisarea tuturor echipamentelor
    public static void afisareToate(List<Echipament> echipamente)
    {
        for (int i = 0; i < echipamente.size(); i++)
        {
            System.out.println(echipamente.get(i));
        }
    }

    // 2. Afisarea imprimantelor
    public static void afisareImprimante(List<Echipament> echipamente)
    {
        for (int i = 0; i < echipamente.size(); i++)
        {
            if (echipamente.get(i) instanceof Imprimanta)
            {
                System.out.println(echipamente.get(i));
            }
        }
    }

    // 3. Afisarea copiatoarelor
    public static void afisareCopiatoare(List<Echipament> echipamente)
    {
        for (int i = 0; i < echipamente.size(); i++)
        {
            if (echipamente.get(i) instanceof Copiator)
            {
                System.out.println(echipamente.get(i));
            }
        }
    }

    // 4. Afisarea sistemelor de calcul
    public static void afisareSisteme(List<Echipament> echipamente)
    {
        for (int i = 0; i < echipamente.size(); i++)
        {
            if (echipamente.get(i) instanceof SistemeCalcul)
            {
                System.out.println(echipamente.get(i));
            }
        }
    }

    // Cautarea unui echipament dupa numarul de inventar
    public static Echipament cautaEchipament(List<Echipament> echipamente, int nrInv)
    {
        for (int i = 0; i < echipamente.size(); i++)
        {
            if (echipamente.get(i).getNr_inv() == nrInv)
            {
                return echipamente.get(i);
            }
        }

        return null;
    }

    // 5. Modificarea starii unui echipament
    public static void modificareStare(List<Echipament> echipamente, Scanner tastatura)
    {
        System.out.print("Introdu numarul de inventar: ");
        int nrInv = Integer.parseInt(tastatura.nextLine());

        Echipament e = cautaEchipament(echipamente, nrInv);

        if (e == null)
        {
            System.out.println("Echipamentul nu a fost gasit.");
            return;
        }

        System.out.println("Stari disponibile:");

        for (int i = 0; i < Stare.values().length; i++)
        {
            System.out.println(Stare.values()[i]);
        }

        System.out.print("Introdu noua stare: ");
        String stareNoua = tastatura.nextLine().toUpperCase();

        try
        {
            e.setStare(Stare.valueOf(stareNoua));
            System.out.println("Starea a fost modificata.");
        }
        catch (IllegalArgumentException ex)
        {
            System.out.println("Stare invalida.");
        }
    }

    // 6. Modificarea modului de tiparire
    public static void modificareModTiparire(List<Echipament> echipamente, Scanner tastatura)
    {
        System.out.print("Introdu numarul de inventar al imprimantei: ");
        int nrInv = Integer.parseInt(tastatura.nextLine());

        Echipament e = cautaEchipament(echipamente, nrInv);

        if (e instanceof Imprimanta)
        {
            Imprimanta imprimanta = (Imprimanta) e;

            System.out.println("Moduri disponibile:");

            for (int i = 0; i < ModTiparire.values().length; i++)
            {
                System.out.println(ModTiparire.values()[i]);
            }

            System.out.print("Introdu noul mod de tiparire: ");
            String modNou = tastatura.nextLine().toUpperCase();

            try
            {
                imprimanta.setMod(ModTiparire.valueOf(modNou));
                System.out.println("Modul de tiparire a fost modificat.");
            }
            catch (IllegalArgumentException ex)
            {
                System.out.println("Mod de tiparire invalid.");
            }
        }
        else
        {
            System.out.println("Imprimanta nu a fost gasita.");
        }
    }

    // 7. Modificarea formatului copiatorului
    public static void modificareFormat(List<Echipament> echipamente, Scanner tastatura)
    {
        System.out.print("Introdu numarul de inventar al copiatorului: ");
        int nrInv = Integer.parseInt(tastatura.nextLine());

        Echipament e = cautaEchipament(echipamente, nrInv);

        if (e instanceof Copiator)
        {
            Copiator copiator = (Copiator) e;

            System.out.println("Formate disponibile:");

            for (int i = 0; i < Format.values().length; i++)
            {
                System.out.println(Format.values()[i]);
            }

            System.out.print("Introdu noul format: ");
            String formatNou = tastatura.nextLine().toUpperCase();

            try
            {
                copiator.setFormat(Format.valueOf(formatNou));
                System.out.println("Formatul a fost modificat.");
            }
            catch (IllegalArgumentException ex)
            {
                System.out.println("Format invalid.");
            }
        }
        else
        {
            System.out.println("Copiatorul nu a fost gasit.");
        }
    }

    // 8. Instalarea sistemului de operare
    public static void instalareSistemOperare(List<Echipament> echipamente, Scanner tastatura)
    {
        System.out.print("Introdu numarul de inventar al sistemului: ");
        int nrInv = Integer.parseInt(tastatura.nextLine());

        Echipament e = cautaEchipament(echipamente, nrInv);

        if (e instanceof SistemeCalcul)
        {
            SistemeCalcul sistem = (SistemeCalcul) e;

            System.out.println("Sisteme de operare disponibile:");

            for (int i = 0; i < SistemOperare.values().length; i++)
            {
                System.out.println(SistemOperare.values()[i]);
            }

            System.out.print("Introdu sistemul de operare: ");
            String soNou = tastatura.nextLine().toUpperCase();

            try
            {
                sistem.setSistemOperare(SistemOperare.valueOf(soNou));
                System.out.println("Sistemul de operare a fost instalat.");
            }
            catch (IllegalArgumentException ex)
            {
                System.out.println("Sistem de operare invalid.");
            }
        }
        else
        {
            System.out.println("Sistemul de calcul nu a fost gasit.");
        }
    }

    // 9. Afisarea echipamentelor vandute
    public static void afisareVandute(List<Echipament> echipamente)
    {
        for (int i = 0; i < echipamente.size(); i++)
        {
            if (echipamente.get(i).getStare() == Stare.VANDUT)
            {
                System.out.println(echipamente.get(i));
            }
        }
    }

    // 10. Serializarea listei
    public static void serializare(List<Echipament> echipamente) throws IOException
    {
        ObjectOutputStream out = new ObjectOutputStream(
                new FileOutputStream("echip.bin")
        );

        out.writeObject(echipamente);
        out.close();
    }

    // 11. Deserializarea listei
    @SuppressWarnings("unchecked")
    public static List<Echipament> deserializare() throws IOException, ClassNotFoundException
    {
        ObjectInputStream in = new ObjectInputStream(
                new FileInputStream("echip.bin")
        );

        List<Echipament> echipamente =
                (List<Echipament>) in.readObject();

        in.close();

        return echipamente;
    }
}
