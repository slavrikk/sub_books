package services;

import implementation.ReaderUserDAO;
import objects.ReaderUser;

public class ObtainTheReaderById {

    public void obtainReader(String id){
        ReaderUserDAO newreader = new ReaderUserDAO();
        ReaderUser reader = newreader.read(id);
        if(reader.getName()==null){
            System.out.println("This Reader does not exist");
        }
        else{
            System.out.println(reader.toString());
        }

    }
}
