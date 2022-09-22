package Niveau3_persistens.DB;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

import static Niveau3_persistens.DB.AdminMapper.printBookList;

public class LoanMapper {


    public static void loanBook() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Type in your memberid");
        int member_id = scanner.nextInt();
        printBookList();
        System.out.println("Type in the id of the book you want to loan");
        int book_id = scanner.nextInt();

        // skal indsættes en låner dato
        // skal indsættes en returnerings dato
        insertIntoLoan(member_id, book_id);
    }


    public static void insertIntoLoan(int member_id, int book_id) {

        try {
            String sql = "INSERT INTO loan (book_id, member_id) VALUES (?,?) ";

            PreparedStatement preparedStatement = DBConnection.createConnection().prepareStatement(sql);
            preparedStatement.setInt(1, book_id);
            preparedStatement.setInt(2, member_id);
            preparedStatement.executeUpdate();

        } catch (SQLException exception) {
            exception.printStackTrace();

        }
    }


    public static void updateLoaner(int member_id, int book_id) {

        try {
            String sql = "UPDATE loan Set book_id = ? WHERE member_id = ?";

            PreparedStatement preparedStatement = DBConnection.createConnection().prepareStatement(sql);
            preparedStatement.setInt(1, book_id);
            preparedStatement.setInt(2, member_id);
            preparedStatement.executeUpdate();

        } catch (SQLException exception) {
            exception.printStackTrace();

        }
    }

}
