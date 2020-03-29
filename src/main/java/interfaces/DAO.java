package interfaces;
import java.sql.SQLException;
import java.util.ArrayList;

public interface DAO <Entity> {
    void create(Entity model) throws SQLException;
    Entity read(String key) throws SQLException;
    void update(Entity model) throws SQLException;
    void delete(String key);
    ArrayList<Entity> selectALL();

}
