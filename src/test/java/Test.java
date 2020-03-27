import implementation.ReaderUserDAO;
import objects.ReaderUser;
import services.ObtainTheReaderById;

public class Test {
    public static void main(String[] args) {
        ObtainTheReaderById reader =new ObtainTheReaderById();
        reader.obtainReader("6");

    }
}
