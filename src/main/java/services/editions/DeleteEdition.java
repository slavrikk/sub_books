package services.editions;

import implementation.EditionDAO;

public class DeleteEdition {
    public void deleteEdition(String id){
        try{
            EditionDAO request = new EditionDAO();
            request.delete(id);
            if(request.isCheck_delete_response()){
                System.out.println("The Edition has been deleted");
            }
            else if(request.isCheck_fail_response()){
                System.out.println("You can`t delete this Edition because a lot of subscriptions use it");
            }
            else{
                System.out.println("This Edition does not exist or has been deleted early");
            }
        } catch (Exception e) {
            System.out.println("wad");
            e.printStackTrace();
        }

    }
}
