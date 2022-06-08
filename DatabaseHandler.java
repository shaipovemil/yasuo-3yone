package com.example.demoex;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;


public class DatabaseHandler extends Configs {
    Connection dbConnection;

    public Connection getDbConnection()
            throws ClassCastException, SQLException, ClassNotFoundException {
        String connectionString = "jdbc:mysql://" + dbHost + ":"
                + dbPort + "/" + dbName;

        Class.forName("com.mysql.cj.jdbc.Driver");
        dbConnection = DriverManager.getConnection(connectionString, dbUser, dbPass);

        return dbConnection;

    }

    public void sighUpUser(User user) {
        String insert = "INSERT INTO " + Const.USER_TABLE + "(" +
                 Const.USERS_NAME + "," + Const.USERS_GENDER + "," + Const.USERS_BIRTHDAY + "," +
                Const.USERS_EMAIL + ","  + Const.USERS_PHONE + "," + Const.USERS_PASSWORD + ")" +
                "VALUES(?,?,?,?,?,?)";
        try {

            PreparedStatement prSt = getDbConnection().prepareStatement(insert);

            prSt.setString(1, user.getName());
            prSt.setString(2, user.getGender());
            prSt.setString(3, user.getBirthday());
            prSt.setString(4, user.getEmail());
            prSt.setString(5, user.getPhone());
            prSt.setString(6, user.getPassword());

            prSt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
}

    public ResultSet getUser(User user) {
        ResultSet resSet = null;

        String select = "SELECT * FROM " + Const.USER_TABLE + " WHERE " +
                Const.USERS_PHONE + "=? AND " + Const.USERS_PASSWORD + "=?";

        try {

            PreparedStatement prSt = getDbConnection().prepareStatement(select);
            prSt.setString(1, user.getPhone());
            prSt.setString(2, user.getPassword());

            resSet = prSt.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        return resSet;
    }

}

