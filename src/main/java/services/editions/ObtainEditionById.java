package services.editions;

import implementation.EditionDAO;
import objects.Edition;

public class ObtainEditionById {

    public void readEdition(String id){
        EditionDAO response = new EditionDAO();
        Edition edition =  response.read(id);
        if(edition.getName().equals(null)){
            System.out.println("This Edition does not exist");
        }
        else{
            System.out.println(edition.toString());
        }

    }
}
