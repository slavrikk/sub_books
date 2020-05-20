package implementation;

import interfaces.ConnectionDAO;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;

public class ConnectionDAOtoDB implements ConnectionDAO {
    private Connection connection;
    public Connection setConnection(String user, String password, String url) throws SQLException {
        connection = DriverManager.getConnection(url+"?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", user, password);
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
