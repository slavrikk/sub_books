package services.readers;

import implementation.ReaderUserDAO;

import java.sql.SQLException;

public class DeleteReader {
    public void deleteReader(String id) throws SQLException {
        ReaderUserDAO response = new ReaderUserDAO();
        response.delete(id);
       if(response.isCheck_delete_response()){
           System.out.println("The Reader has been deleted");
       }
       else{
           System.out.println("This Reader does not exist or has been deleted early");
       }
    }
}
