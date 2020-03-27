package interfaces;

import objects.ReaderUser;

import java.sql.SQLException;

public interface DAO <Entity> {
    void create(Entity model) throws SQLException;
    Entity read(String key);
    void update(Entity model);
    void delete(Entity model);

}
