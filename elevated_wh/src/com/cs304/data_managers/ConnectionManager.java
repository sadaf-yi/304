package com.cs304.data_managers;

import java.sql.*;

/**
 * Created by tyh0 on 2016-11-20.
 */
public class ConnectionManager {

    private String USERNAME = "ora_c1h0b";
    private String PASSWORD = "a46452158";
    private Connection connection;
    private Statement statement;

    public ConnectionManager() { } ;

    public void connectToDb() {
        try {
            DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
            connection = DriverManager.getConnection(
                    "jdbc:oracle:thin:@localhost:1522:ug", USERNAME, PASSWORD
            );
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Message: " + e.getMessage());
            System.exit(-1);
        }
    }

    public void endConnection() {
        try {
            statement.close();
            connection.close();
            statement = null;
            connection = null;
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Message: " + e.getMessage());
            System.exit(-1);
        }
    }

    public String[][] submitQuery(String qstring) throws SQLException {
        statement = null;
        int numCols, numRows = 0;
        ResultSet rset = null;
        String[][] data = new String[1][1];
        try {
            statement = connection.createStatement(
                    ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            rset = statement.executeQuery(qstring);
            ResultSetMetaData rsmd = rset.getMetaData();
            numCols = rsmd.getColumnCount();
            if (!rset.isBeforeFirst()) {
                System.out.println("No Data Collected");
            }
            if (rset.last()) {
                numRows = rset.getRow();
                rset.beforeFirst();
            }
            data = new String[numCols][numRows+1];

            for (int i = 1; i <= numCols; i++) {
                String columnName = rsmd.getColumnName(i);
                data[i-1][0] = columnName;
            }
            for (int j = 1; j <= numRows; j++) {
                rset.next();
                for (int i = 0; i < numCols; i++) {
                    data[i][j] = rset.getString(i+1);
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Message: " + e.getMessage());
        } finally {
            rset.close();
            this.endConnection();
        }
        return data;
    }

    public int executeStatement(String cmd){
        Statement s = null;
        int rowCount = -1;
        try {
            s = connection.createStatement();
            rowCount = s.executeUpdate(cmd);
            s.close();
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Message: " + e.getMessage());
        } finally {
            this.endConnection();
        }
        return rowCount;
    }

}
