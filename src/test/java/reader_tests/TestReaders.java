package reader_tests;

import objects.ReaderUser;
import org.testng.Assert;
import org.testng.annotations.Test;
import services.readers.ObtainTheReaderById;

public class TestReaders {

    @Test
    void testObtainReaderById(){
        ReaderUser expect_reader = new ReaderUser();
       expect_reader.setId(3);
       expect_reader.setName("Андрей");
       expect_reader.setSurname("Иванов");
       expect_reader.setBirthday("1988-08-14");
       String expecting_reader = expect_reader.toString();
       ObtainTheReaderById reader = new ObtainTheReaderById();
        reader.obtainReader("3");
        /*
        Assert.assertEquals();
         */
    }
}
