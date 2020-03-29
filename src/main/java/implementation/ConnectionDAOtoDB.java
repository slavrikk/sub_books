package implementation;

import interfaces.ConnectionDAO;

import java.sql.*;

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

    public void connectionClose(Connection connection, PreparedStatement statement, ResultSet res)  {
        try {
            res.close();
            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void connectionClose(Connection connection, PreparedStatement statement)  {
        try {
            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
