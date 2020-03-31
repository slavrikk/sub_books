package services.editions;

import implementation.EditionDAO;
import objects.Edition;
import java.sql.SQLException;

public class CreateEdition {

    public void createEdition(String name){
        Edition new_edition = new Edition();
        new_edition.setName(name);
        EditionDAO request = new EditionDAO();
        try {
            request.create(new_edition);

        } catch (SQLException e) {
            e.printStackTrace();
        }
        if(request.check_create_response){
            System.out.println("The Edition has been added");
        }
    }
}
