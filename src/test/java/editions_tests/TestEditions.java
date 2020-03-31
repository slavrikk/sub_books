package editions_tests;

import implementation.EditionDAO;
import objects.Edition;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.sql.SQLException;

public class TestEditions {


    @Test(priority = 1)
    void testCreateEdition(){
        Edition expect_edition = new Edition();
        expect_edition.setName("РБК");
        expect_edition.setId(4);
        EditionDAO response = new EditionDAO();
        try {
            response.create(expect_edition);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        Assert.assertTrue(response.check_create_response);
    }

    @Test(priority = 2)
    void testReadEditionByName(){
        Edition edition_expected = new Edition();
        edition_expected.setId(4);
        edition_expected.setName("РБК");
        EditionDAO response = new EditionDAO();
        Edition actual_edition = response.readByName("РБК");
        Assert.assertEquals(actual_edition.toString(),edition_expected.toString());
    }

    @Test(priority = 3)
    void testUpdateEditionName(){
     Edition edition = new Edition();
     edition.setName("Комерсантъ");
     edition.setId(4);
     EditionDAO request = new EditionDAO();
        try {
            request.update(edition);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        Assert.assertTrue(request.check_update_response);
    }

    @Test(priority = 4)
    void testDeleteEditionById(){
     EditionDAO request = new EditionDAO();
     request.delete("4");
     Assert.assertTrue(request.check_delete_response);
    }
}
