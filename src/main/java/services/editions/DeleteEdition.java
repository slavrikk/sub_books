package services.editions;

import implementation.EditionDAO;

public class DeleteEdition {
    public void deleteEdition(String id){
        EditionDAO request = new EditionDAO();
        request.delete(id);
    }
}
