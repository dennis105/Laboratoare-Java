
package exercitiul2;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MainApp
{
    public static void main(String[] args) throws FileNotFoundException
    {
        List<Produs> produse = new ArrayList<>();

        Scanner scanner = new Scanner(new File("produse.csv"));

        while (scanner.hasNextLine())
        {
            String linie = scanner.nextLine();

            String[] date = linie.split(",");

            String denumire = date[0].trim();
            double pret = Double.parseDouble(date[1].trim());
            int cantitate = Integer.parseInt(date[2].trim());
            LocalDate dataExpirarii = LocalDate.parse(date[3].trim());

            Produs p = new Produs(denumire, pret, cantitate, dataExpirarii);

            produse.add(p);
        }

        scanner.close();

        Scanner tastatura = new Scanner(System.in);

        int optiune;

        do
        {
            System.out.println("\n===== MENIU PRODUSE =====");
            System.out.println("1. Afisarea tuturor produselor");
            System.out.println("2. Afisarea produselor expirate");
            System.out.println("3. Vanzarea unui produs");
            System.out.println("4. Afisarea produselor cu pret minim");
            System.out.println("5. Salvarea produselor cu stoc sub o limita");
            System.out.println("0. Iesire");
            System.out.print("Alege optiunea: ");

            optiune = tastatura.nextInt();
            tastatura.nextLine();

            switch (optiune)
            {
                case 1:
                    System.out.println("\nLista produselor:");

                    for (Produs p : produse)
                    {
                        System.out.println(p);
                    }
                    break;

                case 2:
                    System.out.println("\nProduse expirate:");

                    boolean existaExpirate = false;

                    for (Produs p : produse)
                    {
                        if (p.getDataExpirarii().isBefore(LocalDate.now()))
                        {
                            System.out.println(p);
                            existaExpirate = true;
                        }
                    }

                    if (!existaExpirate)
                    {
                        System.out.println("Nu exista produse expirate.");
                    }
                    break;

                case 3:
                    System.out.print("Introdu denumirea produsului: ");
                    String nume = tastatura.nextLine();

                    System.out.print("Introdu cantitatea dorita: ");
                    int cantitateVanduta = tastatura.nextInt();

                    boolean gasit = false;

                    for (int i = 0; i < produse.size(); i++)
                    {
                        Produs p = produse.get(i);

                        if (p.getDenumire().equalsIgnoreCase(nume))
                        {
                            gasit = true;

                            if (cantitateVanduta <= 0)
                            {
                                System.out.println("Cantitate invalida.");
                            }
                            else if (p.getCantitate() >= cantitateVanduta)
                            {
                                double suma = p.getPret() * cantitateVanduta;

                                p.setCantitate(p.getCantitate() - cantitateVanduta);

                                Produs.adaugaIncasari(suma);

                                System.out.println("Vanzare realizata!");
                                System.out.println("Valoare vanzare: " + suma);

                                if (p.getCantitate() == 0)
                                {
                                    produse.remove(i);
                                    System.out.println("Produsul a fost eliminat din lista.");
                                }

                                System.out.println("Incasari totale: " + Produs.getIncasari());
                            }
                            else
                            {
                                System.out.println("Stoc insuficient!");
                            }

                            break;
                        }
                    }

                    if (!gasit)
                    {
                        System.out.println("Produsul nu a fost gasit.");
                    }

                    tastatura.nextLine();
                    break;

                case 4:
                    if (produse.isEmpty())
                    {
                        System.out.println("Nu exista produse.");
                        break;
                    }

                    double pretMinim = produse.get(0).getPret();

                    for (Produs p : produse)
                    {
                        if (p.getPret() < pretMinim)
                        {
                            pretMinim = p.getPret();
                        }
                    }

                    System.out.println("\nProduse cu pret minim:");

                    for (Produs p : produse)
                    {
                        if (p.getPret() == pretMinim)
                        {
                            System.out.println(p);
                        }
                    }
                    break;

                case 5:
                    System.out.print("Introdu limita cantitatii: ");
                    int limita = tastatura.nextInt();

                    PrintWriter writer = new PrintWriter("produse_stoc_redus.txt");

                    for (Produs p : produse)
                    {
                        if (p.getCantitate() < limita)
                        {
                            writer.println(p);
                        }
                    }

                    writer.close();

                    System.out.println("Produsele au fost salvate in produse_stoc_redus.txt");
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
}
