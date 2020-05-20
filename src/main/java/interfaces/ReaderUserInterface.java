package interfaces;

import objects.ReaderUser;

import java.sql.SQLException;

public interface ReaderUserInterface extends DAO<ReaderUser> {
    ReaderUser readByName(String name, String surname) throws SQLException;
}
