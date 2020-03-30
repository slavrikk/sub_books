package services.readers;

import implementation.ReaderUserDAO;
import objects.ReaderUser;

import java.sql.SQLException;

public class UpdateReaderSurnameById {

    public void updateReaderSurname(String id,String surname){
        ReaderUser reader = new ReaderUser();
        reader.setSurname(surname);
        reader.setId(Integer.parseInt(id));
        ReaderUserDAO request = new ReaderUserDAO();
        try {
            request.update(reader);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}