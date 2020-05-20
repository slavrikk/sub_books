package services.editions;

import implementation.EditionDAO;

import java.sql.SQLException;

public class ObtainAllEditions {
    public void obtainAllEditions() throws SQLException {

        EditionDAO request = new EditionDAO();
        System.out.println(request.selectALL().toString());

    }
}
