package interfaces;

import java.sql.Connection;

public interface ConnectionDAO {

    Connection setConnection(String user, String password, String url);

}
