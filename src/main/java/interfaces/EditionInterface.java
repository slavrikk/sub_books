package interfaces;

import objects.Edition;

public interface EditionInterface extends DAO<Edition>{

    Edition readByName(String name);


}
