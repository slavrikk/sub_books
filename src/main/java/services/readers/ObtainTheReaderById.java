package services.readers;

import implementation.ReaderUserDAO;
import objects.ReaderUser;

import java.sql.SQLException;

public class ObtainTheReaderById {

    public void obtainReader(String id) {
        ReaderUserDAO newreader = new ReaderUserDAO();
        ReaderUser reader = null;
        try {
            reader = newreader.read(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        if(reader.getName()==null){
            System.out.println("This Reader does not exist");
        }
        else{
            System.out.println(reader.toString());
        }

    }
}
