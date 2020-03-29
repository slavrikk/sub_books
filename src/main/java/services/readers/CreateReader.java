package services.readers;

import implementation.ReaderUserDAO;
import objects.ReaderUser;

import java.sql.SQLException;

public class CreateReader {

    public void createReader(String name,String surName,String birthday) {
    ReaderUser newuser = new ReaderUser();
    newuser.setName(name);
    newuser.setSurname(surName);
    newuser.setBirthday(birthday);
    ReaderUserDAO readerUser = new ReaderUserDAO();
        try {
            readerUser.create(newuser);
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Error under create");
        }
    }

}