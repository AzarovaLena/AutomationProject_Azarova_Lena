package mysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class DBConnector {
    private static Connection connection;

    public Connection getConnection() {
        try {
            if (connection == null) {
                connection =  DriverManager.getConnection("jdbc:mysql://db4free.net/testqa07?user=testqa07&password=testqa07");
            }
            return connection;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public Statement getStatement() {
        try {
            return getConnection().createStatement();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}

