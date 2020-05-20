package interfaces;

import objects.Edition;

import java.sql.SQLException;

public interface EditionInterface extends DAO<Edition>{

    Edition readByName(String name) throws SQLException;


}
