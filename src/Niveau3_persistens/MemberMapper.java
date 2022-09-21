package Niveau3_persistens;

import java.sql.*;

public class MemberMapper {


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

