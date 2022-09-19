import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Date;
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
            System.out.println("Press '1' to login ");
            System.out.println("Press '2' to create a new user ");

            answer = input.nextInt();

            switch (answer) {
                case 1:
                    login(input);
                    break;

                case 2:
                    create(input);
                    break;
            }
        }
    }

    static void login(Scanner input) {

        boolean loggedIn = false;

        while(!loggedIn) {
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

    static boolean validateLogin(Scanner input, Member member, String passwordInput){

        if(member != null){

            if(member.getPassword().equals(passwordInput)){
                username = Member.getUser_name();
                answer = 0;
                //myPageMenu(input);
                return true;

            }else{
                System.out.println("\n"+"Wrong user name or password");

            }

        } else {
            System.out.println("\n"+"Wrong user name or password");

        }
        System.out.println();
        return false;

    }

    public static void create(Scanner input) {

        System.out.println("Creating new user: "+"\n");

        System.out.println("insert first name: ");
        String firstname = input.next();

        System.out.println("insert last name: ");
        String lastname = input.next();

        //System.out.println("insert todaysdate: ");
        Date joinedDate =input.nextInt();

        System.out.println("type 1 for active or 0 for inactive: ");
        int activeStatus = input.nextInt();


        System.out.println("insert username: ");
        String userName = input.next();

        System.out.println("insert password: ");
        String password = input.next();



        Member user = new Member(firstname, lastname, joinedDate, activeStatus, userName, password);

        System.out.println("\n You have succesfully created a user. Continue to login \n");

        DBInput dbInput = new DBInput();
        dbInput.create(user);
    }


    static Member getMemberByUsername(String username) {

        try {
            String sql = "SELECT * FROM members WHERE username = ?";
            PreparedStatement statement = DBConnection.connection.prepareStatement(sql);
            statement.setString(1, username);

            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                int id = resultSet.getInt("userid");
                String firstName = resultSet.getString("first_name");
                String lastName = resultSet.getString("last_name");
                Date joinedDate = resultSet.getDate("joined_date");
                int activeStatus = resultSet.getInt("active_status_id");
                String user_name = resultSet.getString("user_name");
                String password = resultSet.getString("password");

                Member user = new Member(firstName, lastName, joinedDate, activeStatus, user_name, password);
                return user;

            }

        } catch (Exception exception) {
            exception.printStackTrace();
        }

        return null;

    }

}