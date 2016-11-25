package com.guy;

/**
 * Created by aphis on 25-Nov-16.
 */
import java.sql.Connection;
import java.sql.SQLException;
import com.guy.OracleConnUtils;

public class ConnectionUtils {

    public static Connection getConnection() throws SQLException,
            ClassNotFoundException {

        // Using Oracle
        // You may be replaced by other Database.
        return OracleConnUtils.getOracleConnection();
    }

    //
    // Test Connection ...
    //
    public static void main(String[] args) throws SQLException,
            ClassNotFoundException {

        System.out.println("Get connection ... ");

        // Get a Connection object
        Connection conn = ConnectionUtils.getConnection();

        System.out.println("Get connection " + conn);

        System.out.println("Done!");
    }
}