package com.cs304.data_managers;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by tyh0 on 2016-11-20.
 */
public class ConnectionManager {

    private String USERNAME = "ora_v1d0b";
    private String PASSWORD = "a55982145";
    private Connection connection;
    private Statement statement;

    public ConnectionManager() { } ;

    public void connectToDb() {
        try {
            DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
            connection = DriverManager.getConnection(
                    "jdbc:oracle:thin:@localhost:1522:ug", USERNAME, PASSWORD
            );
            // connection.setAutoCommit(false);
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Message: " + e.getMessage());
            System.exit(-1);
        }
    }

    public void endConnection() {
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Message: " + e.getMessage());
            System.exit(-1);
        }
    }

    public ResultSet submitQuery(String qstring) {
        Statement s = null;
        ResultSet results = null;
        try {
            s = connection.createStatement();
            results = s.executeQuery(qstring);

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Message: " + e.getMessage());
        }
        return results;
    }

    public int executeStatement(String cmd){
        Statement s = null;
        int rowCount = -1;
        try {
            s = connection.createStatement();
            rowCount = s.executeUpdate(cmd);
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Message: " + e.getMessage());
        }
        return rowCount;
    }

}
