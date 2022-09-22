package Niveau3_persistens.Language;

import Niveau3_persistens.DB.Admin;

import java.util.Scanner;

import static Niveau3_persistens.DB.AuthorMapper.searchForAuthor;
import static Niveau3_persistens.DB.LoanMapper.loanBook;
import static Niveau3_persistens.DB.LoginMapper.*;

public class Engelsk extends Dialog {
    Scanner input = new Scanner(System.in);
    @Override
    public String hi() {
        return "Hello and welcome !";
    }

    @Override
    public String changeLanguage() {
        return "do you want to change language ?";
    }

    @Override
    public String selectLanguage() {
        return "select DK/ENG/DEU or menu";
    }

    @Override
    public void loginMenu() {
        int answer = 1;

        while (answer != 0) {
            System.out.print("\n" + "Login menu" + "\n" + "\n");
            System.out.println("Select your options");
            System.out.println("-------------------------\n");
            System.out.println("Press '1' to login as user ");
            System.out.println("Press '2' to login as admin ");
            System.out.println("Press '3' to create a new user ");
            System.out.println("Press '0' to shut down ");


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
            System.out.print("Welcome to member menu" + "\n" + "\n");
            System.out.println("Select your options");
            System.out.println("-------------------------\n");
            System.out.println("Press '1' to loan book ");
            System.out.println("Press '2' to return a book ");
            System.out.println("Press '3' to search for an author ");
            System.out.println("Press '0' to go back ");


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
                    System.out.println("\n" + "Going back a step");
                    break;

            }
        }
    }

}
