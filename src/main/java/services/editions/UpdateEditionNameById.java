package services.editions;

import implementation.EditionDAO;
import objects.Edition;
import java.sql.SQLException;

public class UpdateEditionNameById {
    public void updateEditionName(int id, String changing_name) {
        Edition edition = new Edition();
        edition.setId(id);
        edition.setName(changing_name);
        EditionDAO request = new EditionDAO();
        try {
            request.update(edition);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
