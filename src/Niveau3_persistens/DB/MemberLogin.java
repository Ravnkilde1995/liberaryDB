package Niveau3_persistens.DB;

import java.util.Scanner;

import static Niveau3_persistens.DB.AuthorMapper.searchForAuthor;
import static Niveau3_persistens.DB.LoanMapper.loanBook;

public class MemberLogin {

    public static void memberLogin(Scanner input) {

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
                    System.out.println("\n"  + "Going back a step");
                    break;

            }
        }
    }
}
