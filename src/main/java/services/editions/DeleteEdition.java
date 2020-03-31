package services.editions;

import implementation.EditionDAO;

public class DeleteEdition {
    public void deleteEdition(String id){
        EditionDAO request = new EditionDAO();
        request.delete(id);
        if(request.check_delete_response){
            System.out.println("The Edition has been deleted");
        }
        else{
            System.out.println("This Edition does not exist or has been deleted early");
        }
    }
}
