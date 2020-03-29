package interfaces;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public interface ConnectionDAO {

    Connection setConnection(String user, String password, String url);
    void connectionClose(Connection connection, PreparedStatement statement, ResultSet res) ;
    void connectionClose(Connection connection, PreparedStatement statement);

}
