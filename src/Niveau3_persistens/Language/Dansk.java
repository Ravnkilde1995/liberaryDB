package Niveau3_persistens.Language;

import Niveau3_persistens.DB.Admin;

import java.util.Scanner;

import static Niveau3_persistens.DB.AuthorMapper.searchForAuthor;
import static Niveau3_persistens.DB.LoanMapper.loanBook;
import static Niveau3_persistens.DB.LoginMapper.*;

public class Dansk extends Dialog {

    Scanner input = new Scanner(System.in);
    @Override
    public String hi() {
        return "Hej og velkommen !";
    }

    @Override
    public String changeLanguage() {
        return "vil du skifte sprog? ";
    }

    @Override
    public String selectLanguage() {
        return "angiv DK/ENG/DEU eller menu";
    }

    @Override
    public void loginMenu() {
        int answer = 1;

        while (answer != 0) {
            System.out.print("\n" + "Login menu" + "\n" + "\n");
            System.out.println("fortag dit valg");
            System.out.println("-------------------------\n");
            System.out.println("Tryk '1' for at logge på som medlem ");
            System.out.println("Tryk '2' for at logge på som admin ");
            System.out.println("Tryk '3' for at oprette dig som medlem ");
            System.out.println("Tryk '0' for at afslutte ");


            answer = input.nextInt();

            switch (answer) {
                case 1:
                    login(input);
                    break;

                case 2:
                    Admin.loginAdmin(input);
                    break;

                case 3:
                    create(input);
                    break;

                case 0:
                    System.out.println("\n" + "Shutting down");
                    break;

            }
        }
    }

    @Override
    public void memberLogin() {
        int answer = 1;

        while (answer != 0) {
            System.out.print("Velkommen til medlems menuen" + "\n" + "\n");
            System.out.println("fortag dit valg");
            System.out.println("-------------------------\n");
            System.out.println("Tryk '1' for at låne bog ");
            System.out.println("Tryk '2' for at aflevere bog ");
            System.out.println("Tryk '3' for at søge på forfatter ");
            System.out.println("Tryk '0' for at afslutte ");


            answer = input.nextInt();

            switch (answer) {
                case 1:
                    loanBook();
                    break;

                case 2:
                    System.out.println("kommer snart");
                    break;

                case 3:
                    searchForAuthor(input);
                    break;

                case 0:
                    System.out.println("\n" + "afslutter");
                    break;

            }
        }
    }


}
