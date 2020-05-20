package services.readers;

import implementation.ReaderUserDAO;

import java.sql.SQLException;


public class ObtainAllReaders {

    public void obtainAllReaders() throws SQLException {
        ReaderUserDAO response = null;
        try {
            response = new ReaderUserDAO();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println(response.selectALL().toString());

    }

}
