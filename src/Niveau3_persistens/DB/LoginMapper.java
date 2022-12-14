package Niveau3_persistens.DB;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

import static Niveau3_persistens.DB.MemberLogin.memberLogin;

public class LoginMapper {
    static Scanner input = new Scanner(System.in);

    static String username;
    static int answer;
    static String currentUser;


    public static void login(Scanner input) {

        boolean loggedIn = false;

        while (!loggedIn) {
            System.out.println("LOG IN");
            System.out.print("Username: ");
            String usernameInput = input.next();
            currentUser = usernameInput;
            System.out.print("Password: ");
            String passwordInput = input.next();
            System.out.println("\n");

            Member user = getMemberByUsername(usernameInput);

            loggedIn = validateLogin(input, user, passwordInput);
        }
    }

    static boolean validateLogin(Scanner input, Member member, String passwordInput) {

        if (member != null) {

            if (member.getPassword().equals(passwordInput)) {
                username = Member.getUser_name();
                answer = 0;
                memberLogin(input);
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

    public static void create(Scanner input) {

        System.out.println("Creating new user: " + "\n");

        System.out.println("insert first name: ");
        String firstname = input.next();

        System.out.println("insert last name: ");
        String lastname = input.next();


        System.out.println("insert username: ");
        String userName = input.next();

        System.out.println("insert password: ");
        String password = input.next();


        Member user = new Member(firstname, lastname, userName, password);

        System.out.println("\n You have succesfully created a user. Continue to login \n");

        MemberMapper dbInput = new MemberMapper();
        dbInput.create(user);
    }


    static Member getMemberByUsername(String username) {

        try {
            String sql = "SELECT * FROM member WHERE user_name = ?";
            PreparedStatement statement = DBConnection.createConnection().prepareStatement(sql);
            statement.setString(1, username);

            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                int id = resultSet.getInt("id");
                String firstName = resultSet.getString("first_name");
                String lastName = resultSet.getString("last_name");
                String user_name = resultSet.getString("user_name");
                String password = resultSet.getString("password");

                Member user = new Member(firstName, lastName, user_name, password);
                return user;

            }

        } catch (Exception exception) {
            exception.printStackTrace();
        }

        return null;

    }
}