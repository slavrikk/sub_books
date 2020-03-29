package services.readers;

import implementation.ReaderUserDAO;
import objects.ReaderUser;

public class ObtainTheReaderByName {

    public void obtainUserByName(String name, String surname){
        ReaderUser readerUser;
        ReaderUserDAO reader = new ReaderUserDAO();
        readerUser=reader.readByName(name,surname);
        if(readerUser.getId()==0){
            System.out.println("Reader not found ");
        }
        else{
            System.out.println(readerUser.toString());
        }

    }

}
