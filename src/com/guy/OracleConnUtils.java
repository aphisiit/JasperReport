package com.guy;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by aphis on 25-Nov-16.
 */
public class OracleConnUtils {
    public static Connection getOracleConnection()
        throws ClassNotFoundException, SQLException{
        String hostName = "localhost";
        String sid = "xe";
        String userName = "system";
        String password = "b5604937";

        return getOracleConnection(hostName,sid,userName,password);
    }
    public static Connection getOracleConnection(String hostName,String sid,
        String userName,String password) throws ClassNotFoundException,SQLException{

        Class.forName("oracle.jdbc.driver.OracleDriver");

        String connectionURL = "jdbc:oracle:thin:@" + hostName + ":1521:" + sid;

        Connection conn = DriverManager.getConnection(connectionURL, userName,
                password);

        return conn;
    }
}
