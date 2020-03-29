package services.readers;

import implementation.ReaderUserDAO;

public class DeleteReader {
    public void deleteReader(String id){
        ReaderUserDAO response = new ReaderUserDAO();
        response.delete(id);

    }
}
