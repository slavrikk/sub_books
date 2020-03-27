package implementation;

import interfaces.ConnectionDAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionDAOtoDB implements ConnectionDAO {

    private Connection connection;

    public Connection setConnection(String user, String password, String url) {
        try{
            connection = DriverManager.getConnection(url+"?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", user, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }
}
