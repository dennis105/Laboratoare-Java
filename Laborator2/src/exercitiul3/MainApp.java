package exercitiul3;

import java.util.Scanner;

public class MainApp
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Introduceti textul: ");
        String textInitial = scanner.nextLine();

        StringBuilder text = new StringBuilder(textInitial);

        System.out.print("Introduceti textul de inserat: ");
        String textInserat = scanner.nextLine();

        System.out.print("De la ce pozitie doriti sa inserati? ");
        int pozInserare = scanner.nextInt();

        scanner.nextLine();

        text.insert(pozInserare, textInserat);

        System.out.println(text);

        System.out.print("De la ce pozitie doriti sa stergeti? ");
        int pozStergere = scanner.nextInt();

        System.out.print("Cate caractere doriti sa stergeti? ");
        int nrCaractere = scanner.nextInt();

        text.delete(pozStergere, pozStergere + nrCaractere);

        System.out.println(text);
    }
}
