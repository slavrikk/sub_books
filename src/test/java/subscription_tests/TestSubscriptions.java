package subscription_tests;


import implementation.EditionDAO;
import implementation.ReaderUserDAO;
import implementation.SubscriptionDAO;
import objects.Edition;
import objects.ReaderUser;
import objects.Subscribe;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import java.sql.SQLException;
import java.util.ArrayList;

public class TestSubscriptions {

    @BeforeClass()
    void createReader() throws SQLException {
        ReaderUser new_reader =new ReaderUser();
        new_reader.setId(14);
        new_reader.setName("Василий");
        new_reader.setSurname("Петров");
        new_reader.setBirthday("1988-08-14");
        ReaderUserDAO req = new ReaderUserDAO();
        try {
            req.create(new_reader);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @BeforeClass()
    void createEdition() throws SQLException {
        Edition new_edition = new Edition();
        new_edition.setId(10);
        new_edition.setName("РБК");
        EditionDAO req = new EditionDAO();
        try {
            req.create(new_edition);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Test(priority = 1)
    void testCreateSubscription() throws SQLException {
        SubscriptionDAO req = new SubscriptionDAO();
        req.subscribeReaderToEstimate("14", "10");
        Assert.assertTrue(req.isCheck_subscribe_creation());
    }

    @Test(priority = 2)
    void testReadSubscription() throws SQLException {
        String expected_surname = "Петров";
        SubscriptionDAO resp = new SubscriptionDAO();
        ArrayList<Subscribe> array_list = resp.checkSubByReaderId("14");
        String actual_surname = array_list.get(0).getReader_surname();
        Assert.assertEquals(actual_surname, expected_surname);
    }

    @Test(priority = 3)
    void testDeleteSubscription() throws SQLException {
        SubscriptionDAO req = new SubscriptionDAO();
        req.cancelSubscribe("14", "10");
        Assert.assertTrue(req.isCheck_cancel_subscribe());
    }

   @AfterClass()
    void deleteReaderAndEdition() throws SQLException {
       ReaderUserDAO req_reader = new ReaderUserDAO();
       req_reader.delete("14");
       EditionDAO req_estimate = new EditionDAO();
       req_estimate.delete("10");
   }
}
