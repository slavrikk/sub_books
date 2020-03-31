package reader_tests;

import implementation.ReaderUserDAO;
import objects.ReaderUser;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.sql.SQLException;

public class TestReaders {

    @Test(priority = 1)
    void testCreateUser(){
        ReaderUser new_reader = new ReaderUser();
        new_reader.setName("Роман");
        new_reader.setSurname("Широков");
        new_reader.setBirthday("1981-07-06");
        new_reader.setId(5);
        ReaderUserDAO request = new ReaderUserDAO();
        try {
            request.create(new_reader);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        Assert.assertTrue(request.check_create_response);
    }

    @Test(priority = 2)
    void testObtainReaderById(){
        String actual_reader = "";
        ReaderUser expect_reader = new ReaderUser();
        expect_reader.setId(5);
        expect_reader.setName("Роман");
        expect_reader.setSurname("Широков");
        expect_reader.setBirthday("1981-07-06");
        String expecting_reader = expect_reader.toString();
        ReaderUserDAO resp = new ReaderUserDAO();
        try {
           actual_reader =  resp.read("5").toString();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        Assert.assertEquals(actual_reader, expecting_reader);
    }

    @Test(priority = 3)
    void testObtainReaderByName(){
        ReaderUser expect_reader = new ReaderUser();
        expect_reader.setName("Роман");
        expect_reader.setSurname("Широков");
        ReaderUserDAO resp = new ReaderUserDAO();
        ReaderUser actual_reader = resp.readByName("Роман", "Широков");
        Assert.assertEquals(actual_reader.getSurname(), expect_reader.getSurname());
    }



    @Test(priority = 4)
    void testUpdateReaderSurname(){
        ReaderUser new_reader = new ReaderUser();
        new_reader.setId(5);
        new_reader.setSurname("Васильев");
        ReaderUserDAO request = new ReaderUserDAO();
        try {
            request.update(new_reader);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        Assert.assertTrue(request.check_update_response);
    }

    @Test(priority = 5)
    void testDeleteReaderById(){
        String id = "5";
        ReaderUserDAO request = new ReaderUserDAO();
        request.delete(id);
        Assert.assertTrue(request.check_delete_response);
    }

}
