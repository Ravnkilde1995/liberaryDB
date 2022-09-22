package Niveau3_persistens.DB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AuthorMapper {

    public static void printAuthorList() {
        List<String> authorList = new ArrayList<>();

        String sql = "select * from author ";

        try (Connection con = DBConnection.createConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {


            ResultSet resultSet = ps.executeQuery();

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String navn = resultSet.getString("first_name");
                String efternavn = resultSet.getString("last_name");



                authorList.add(id + " : First name: " + navn + ", last name: " + efternavn);

            }
        } catch (SQLException e) {

            e.printStackTrace();
        }
        for (String s : authorList) {

            System.out.println(s);

        }
    }


    public static void searchForAuthor (Scanner input){

        System.out.println("Søg på forfatter");
        String searchForAAuthor = input.next();

        String sql = "SELECT * FROM author WHERE first_name LIKE " + "'%" + searchForAAuthor + "%'";

        try {
            PreparedStatement preparedStatement = DBConnection.createConnection().prepareStatement(sql);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                String firstname = rs.getString("first_name");
                String lastname = rs.getString("last_name");

                String author = firstname + " " + lastname;
                System.out.println(author + "hej");

            }

        } catch (SQLException e) {
            e.printStackTrace();

        }
    }
}
