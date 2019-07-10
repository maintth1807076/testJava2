package sample.model;

import sample.entity.Member;

import java.sql.*;

public class MemberModel {
    private static Connection connection;
    private static final String DATABASE_NAME = "netcafe";
    private static final String DATABASE_USER = "root";
    private static final String DATABASE_PASSWORD = "";

    public static Connection getConnection() throws SQLException {
        if (connection == null || connection.isClosed()) {
            connection = DriverManager.getConnection("jdbc:mysql://localhost/"
                    + DATABASE_NAME + "?user="
                    + DATABASE_USER + "&password="
                    + DATABASE_PASSWORD);
        }
        return connection;
    }
    public boolean create(Member member) {
        try {
            String sqlCommand = "insert into members (username, password, fullName, avatar, remainTime, status) values (?,?,?,?,?,?)";
            PreparedStatement preparedStatement = MemberModel.getConnection().prepareStatement(sqlCommand);
            preparedStatement.setString(1, member.getUsername());
            preparedStatement.setString(2, member.getPassword());
            preparedStatement.setString(3, member.getFullName());
            preparedStatement.setString(4, member.getAvatar());
            preparedStatement.setLong(5, member.getRemainTime());
            preparedStatement.setInt(6, member.getStatus());
            preparedStatement.execute();
            return true;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return false;
    }
    public Member read(String account, String password) {
        try {
            String sqlCommand = "select * from accounts where account = ? and password = ?";
            PreparedStatement preparedStatement = MemberModel.getConnection().prepareStatement(sqlCommand);
            preparedStatement.setString(1, account);
            preparedStatement.setString(2, password);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                String rsAccount = resultSet.getString(1);
                String rsPassword = resultSet.getString(2);
                double rsBalance = resultSet.getDouble(3);
                int rsStatus = resultSet.getInt(4);
                Member member = new Member();

                return member;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }

}
