package services.editions;

import implementation.EditionDAO;

public class ObtainAllEditions {
    public void obtainAllEditions(){

        EditionDAO request = new EditionDAO();
        System.out.println(request.selectALL().toString());

    }
}
