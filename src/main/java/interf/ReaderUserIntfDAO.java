package interf;

import objects.ReaderUser;

import java.sql.SQLException;

public interface ReaderUserIntfDAO {
    void create(ReaderUser model) throws SQLException;
    ReaderUser read(String key);
    void update(ReaderUser model);
    void delete(ReaderUser model);

}
