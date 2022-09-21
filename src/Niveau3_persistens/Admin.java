package Niveau3_persistens;

import Niveau2_logic.TerminalInput;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class Admin {

    static String userName;
    static int answer;
    static String currentUser;
    String password;

    public Admin(String username, String password) {
        this.userName = username;
        this.password = password;
    }

    private static void adminMenu() {
        String svar;

        while (true) {

            svar = TerminalInput.getString("Hvad ønsker du? opret/print/slet/update");

            switch (svar) {

                case "opret":
                    AdminMapper.insert();
                    break;

                case "print":
                    AdminMapper.printBookList();
                    break;

                case "slet":
                    AdminMapper.delete();
                    break;

                case "update":
                    AdminMapper.update();
                    break;

                default:
                    System.out.println("indput findes ikke. Prøv igen");


            }
        }
    }

    public String getUsername() {
        return userName;
    }

    public String getPassword() {
        return password;
    }


    static void loginAdmin(Scanner input) {

        boolean loggedIn = false;

        while (!loggedIn) {
            System.out.println("LOG IN");
            System.out.print("Username: ");
            String usernameInput = input.next();
            currentUser = usernameInput;
            System.out.print("Password: ");
            String passwordInput = input.next();
            System.out.println("\n");

            Admin admin = getAdminByUsername(usernameInput);

            loggedIn = validateLogin(admin, passwordInput);
        }
    }

    static boolean validateLogin(Admin admin, String passwordInput) {

        if (admin != null) {

            if (admin.getPassword().equals(passwordInput)) {
                userName = admin.getUsername();
                answer = 0;
                adminMenu();
                return true;

            } else {
                System.out.println("\n" + "Wrong user name or password");

            }

        } else {
            System.out.println("\n" + "Wrong user name or password");

        }
        System.out.println();
        return false;

    }

    static Admin getAdminByUsername(String username) {

        try {
            String sql = "SELECT * FROM admin WHERE username = ?";
            PreparedStatement statement = DBConnection.createConnection().prepareStatement(sql);
            statement.setString(1, username);

            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                int id = resultSet.getInt("idadmin");
                String user_name = resultSet.getString("username");
                String password = resultSet.getString("password");

                Admin admin = new Admin(username, password);
                return admin;

            }

        } catch (Exception exception) {
            exception.printStackTrace();
        }

        return null;

    }
}
