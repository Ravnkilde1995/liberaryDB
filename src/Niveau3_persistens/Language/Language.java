package Niveau3_persistens.Language;


import Niveau2_logic.TerminalInput;

import java.util.Scanner;

import static Niveau3_persistens.DB.LoginMapper.loginMenu;

public class Language {
    public static void selectLanguage() {

        Scanner scanner = new Scanner(System.in);

        String ans = "";

        Dialog dialog = new Engelsk();

        while (true) {
            System.out.println(dialog.hi());

            if (TerminalInput.getString(dialog.changeLanguage()).equalsIgnoreCase("y")) {
                System.out.println(dialog.selectLanguage());
                ans = scanner.nextLine();

                switch (ans) {
                    case "dk":
                        dialog = new Dansk();
                        break;

                    case "eng":
                        dialog = new Engelsk();
                        break;

                    case "deu":
                        dialog = new Tysk();
                        break;

                    case "menu":
                        loginMenu();
                        break;

                    default:
                        dialog = new Engelsk();

                }
            }

        }
    }
}


