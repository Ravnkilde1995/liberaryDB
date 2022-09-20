package Niveau3_persistens;

import Niveau2_logic.TerminalInput;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DBInput {


    static void update() {
        printBookList();

        String sql = "update  book set title=?  Where id = ?";



        try (Connection con = DBConnection.createConnection();
             PreparedStatement ps = con.prepareStatement(sql);) {

            String bookName = TerminalInput.getString("angiv ny titel");

            ps.setString(1, bookName);


            // det er det her jeg søger på.
            ps.setInt(2, TerminalInput.getInt("Skriv bogens id"));


            int res = ps.executeUpdate();

            if (res > 0) {

                System.out.println("Bogen med navnet " + "\"" + bookName + "\"" + " er nu blevet opdateret");
            } else {

                System.out.println("bogen med navnet " + "\"" + bookName + "\"" + " findes ikke i listen");
            }


        } catch (Exception e) {
            e.printStackTrace();
        }

        printBookList();
    }

    static void printBookList() {
        List<String> bookList = new ArrayList<>();

        String sql = "select * from book ";

        try (Connection con = DBConnection.createConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {


            ResultSet resultSet = ps.executeQuery();

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String navn = resultSet.getString("title");
                int category_id = resultSet.getInt("category_id");
                String date = resultSet.getString("publication_date");
                int copy = resultSet.getInt("copies_owned");

                bookList.add(id + " : Titel: " + navn + ", kategori_id: " + category_id + ", udgivelses dato: " + date + ", bøger på lager: " + copy);

            }
        } catch (SQLException e) {

            e.printStackTrace();
        }
        for (String s : bookList) {

            System.out.println(s);

        }
    }

    static void insert() {
        String sql = "INSERT INTO book(title, category_id, publication_date, copies_owned) VALUES (?, ?, ?, ?)";

        try (Connection con = DBConnection.createConnection();

             PreparedStatement ps = con.prepareStatement(sql);
        ) {

            ps.setString(1, TerminalInput.getString("Skriv titlen på bogen"));
            ps.setInt(2, TerminalInput.getInt("Skriv tallet på den katogri som bogen tilhører"));
            ps.setString(3, TerminalInput.getString("Skriv udgivelses datoen på bogen"));
            ps.setString(4, TerminalInput.getString("Hvor mange kopier findes der på lageret"));

            ps.executeUpdate();


            System.out.println("inserted details ");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static void delete() {
        printBookList();

        String sql = "delete from book where title = ?";

        try (Connection con = DBConnection.createConnection();
             PreparedStatement ps = con.prepareStatement(sql);) {

            String bookName = TerminalInput.getString("Skriv navnet på bogen der skal slettes ");

            ps.setString(1, bookName);


            int res = ps.executeUpdate();

            if (res > 0) {

                System.out.println("Bogen med navnet " + "\"" + bookName + "\"" + " er nu blevet slettet");
            } else {

                System.out.println("Bogen med navnet " + "\"" + bookName + "\"" + " fandtes ikke i listen");

            }


        } catch (Exception e) {
            e.printStackTrace();
        }

        printBookList();
    }


    public void create(Member member) {

        try {
            String sql = "INSERT INTO member(first_name, last_name, user_name, password) VALUES(?, ?, ?, ?)";

            PreparedStatement preparedStatement = DBConnection.createConnection().prepareStatement(sql);
            preparedStatement.setString(1, member.getFirstName());
            preparedStatement.setString(2, member.getLastName());
            preparedStatement.setString(3, member.getUser_name());
            preparedStatement.setString(4, member.getPassword());
            preparedStatement.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();

        }
    }
}

