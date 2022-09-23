package Niveau3_persistens.Language;

import Niveau3_persistens.DB.Admin;

import java.util.Scanner;

import static Niveau3_persistens.DB.AuthorMapper.searchForAuthor;
import static Niveau3_persistens.DB.LoanMapper.loanBook;
import static Niveau3_persistens.DB.LoginMapper.create;
import static Niveau3_persistens.DB.LoginMapper.login;

public class Tysk extends Dialog {
    Scanner input = new Scanner(System.in);
    @Override
    public String hi() {
        return "Hallo und herzlich willkommen" + " jaa oder nein";
    }

    @Override
    public String changeLanguage() {
        return "Möchten Sie die Sprache ändern, um die Sprache zu ändern";
    }

    @Override
    public String selectLanguage() {
        return "Eintreten DK/ENG/DEU";
    }

    @Override
    public void loginMenu() {
        int answer = 1;

        while (answer != 0) {
            System.out.print("\n" + "Anmeldemenü" + "\n" + "\n");
            System.out.println("Wählen Sie Ihre Optionen aus");
            System.out.println("-------------------------\n");
            System.out.println("Drücken Sie '1', um sich als Benutzer anzumelden ");
            System.out.println("Drücken Sie '2', um sich als Administrator anzumelden ");
            System.out.println("Drücken Sie '3', um einen neuen Benutzer zu erstellen ");
            System.out.println("Drücken Sie '0', um zurückzugehen ");


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
                    System.out.println("\n" + "zurück gehen");
                    break;

            }
        }
    }

    @Override
    public void memberLogin() {
        int answer = 1;

        while (answer != 0) {
            System.out.print("Willkommen im Mitgliedermenü" + "\n" + "\n");
            System.out.println("Wählen Sie Ihre Optionen aus");
            System.out.println("-------------------------\n");
            System.out.println("Drücken Sie die '1', um das Buch auszuleihen ");
            System.out.println("Drücken Sie '2', um ein Buch zurückzugeben ");
            System.out.println("Drücken Sie '3', um nach einem Autor zu suchen ");
            System.out.println("Drücken Sie '0', um zurückzugehen");


            answer = input.nextInt();

            switch (answer) {
                case 1:
                    loanBook();
                    break;

                case 2:
                    System.out.println("demnächst");
                    break;

                case 3:
                    searchForAuthor(input);
                    break;

                case 0:
                    System.out.println("\n" + "Gehe einen Schritt zurück");
                    break;

            }
        }

    }

}