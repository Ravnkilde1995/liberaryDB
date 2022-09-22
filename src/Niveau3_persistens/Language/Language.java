package Niveau3_persistens.Language;


import Niveau2_logic.TerminalInput;

import java.util.Scanner;

public class Language {
    public static void selectLanguage() {

        Scanner scanner = new Scanner(System.in);

        String ans = "";

        Dialog dialog = new Engelsk();

        while (true) {
            System.out.println(dialog.hi());

            if (TerminalInput.getString(dialog.changeLanguage()).equalsIgnoreCase("yes")) {
                System.out.println(dialog.selectLanguage());
                ans = scanner.next();
                System.out.println(ans);

                switch (ans) {
                    case "dk":
                        dialog = new Dansk();
                        Dansk dansk = new Dansk();
                        dansk.loginMenu();
                        break;

                    case "eng":
                        dialog = new Engelsk();
                        Engelsk engelsk = new Engelsk();
                        engelsk.loginMenu();
                        break;

                    case "deu":
                        dialog = new Tysk();
                        Tysk tysk = new Tysk();
                        tysk.loginMenu();
                        break;

                }
            }

            else{
                Engelsk engelsk1 = new Engelsk();
                engelsk1.loginMenu();
            }

        }
    }
}



