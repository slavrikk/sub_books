package services.readers;

import implementation.ReaderUserDAO;


public class ObtainAllReaders {

    public void obtainAllReaders(){
        ReaderUserDAO response = new ReaderUserDAO();
        System.out.println(response.selectALL().toString());

    }

}
