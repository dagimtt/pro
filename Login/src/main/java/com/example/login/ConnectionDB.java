package com.example.login;

import javafx.scene.control.Alert;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionDB {

    private static final String URL = "jdbc:oracle:thin:@localhost:1521:xe";
    private static final String DRIVER = "oracle.jdbc.driver.OracleDriver";
    private static final String USERNAME = "GU2";
    private static final String PASSWORD = "1111";
    Connection connection = null;

   // Alert alert = new Alert(Alert.AlertType.INFORMATION);


    public Connection conMethod() {
        try {
            Class.forName(DRIVER);
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
/*
            if (connection != null)
                alert.setContentText("Connected successfuly");
            else
                alert.setContentText("Not Connected ");
*/
        } catch (Exception e) {
        }
      //  alert.showAndWait();

        return connection;
    }

    public Connection conMethod2() {
        try {
            Class.forName(DRIVER);
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        return connection;
    }

}
