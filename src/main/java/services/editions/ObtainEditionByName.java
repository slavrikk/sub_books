package services.editions;

import implementation.EditionDAO;
import objects.Edition;

import java.sql.SQLException;

public class ObtainEditionByName {

    public void readByName(String name) throws SQLException {
        EditionDAO request = new EditionDAO();
        Edition response = request.readByName(name);
        if(response.getId()==0){
            System.out.println("This Edition does not exist");
        }
        else{
            System.out.println(response.toString());
        }
    }
}
