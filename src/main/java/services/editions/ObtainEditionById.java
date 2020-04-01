package services.editions;

import implementation.EditionDAO;
import objects.Edition;

public class ObtainEditionById {

    public void readEdition(String id){
        EditionDAO response = new EditionDAO();
        Edition edition =  response.read(id);
        Edition edition1 = new Edition();
        edition1.setId(Integer.parseInt(id));
        if(edition.equals(edition1)){
            System.out.println("This Edition does not exist");
        }
        else{
            System.out.println(edition.toString());
        }

    }
}
