package services.readers;

import implementation.ReaderUserDAO;

public class DeleteReader {
    public void deleteReader(String id){
        ReaderUserDAO response = new ReaderUserDAO();
        response.delete(id);
       if(response.check_delete_response){
           System.out.println("The Reader has been deleted");
       }
       else{
           System.out.println("This Reader does not exist or has been deleted early");
       }
    }
}
