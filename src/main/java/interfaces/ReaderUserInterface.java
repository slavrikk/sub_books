package interfaces;

import objects.ReaderUser;


public interface ReaderUserInterface extends DAO<ReaderUser> {
    ReaderUser readByName(String name, String surname);
}
