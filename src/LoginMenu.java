import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class LoginMenu {

    static String username;
    static int answer;
    static String currentUser;


    public static void loginMenu(Scanner input) {

        answer = 1;

        while (answer != 0) {
            System.out.print(" Login menu" + "\n" + "\n");
            System.out.println("Select your options");
            System.out.println("-------------------------\n");
            System.out.println("Press '1' to login as user ");
            System.out.println("Press '2' to create a new user ");
            System.out.println("Press '3' to login as admin ");
            System.out.println("Press '0' to shut down ");


            answer = input.nextInt();

            switch (answer) {
                case 1:
                    login(input);
                    break;

                case 2:
                    create(input);
                    break;

                case 3:
                    Admin.loginAdmin(input);
                    break;

                case 0:
                    System.out.println("Shutting down");
                    break;

            }
        }
    }

    static void login(Scanner input) {

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
                //myPageMenu(input);
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

        DBInput dbInput = new DBInput();
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