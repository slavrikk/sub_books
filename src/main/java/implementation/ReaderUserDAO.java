package implementation;
import interfaces.ReaderUserInterface;
import objects.ReaderUser;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.ArrayList;

public class ReaderUserDAO  implements ReaderUserInterface {

    private PreparedStatement statement;
    private ResultSet rs;
    private ConnectionDAOtoDB connect = new ConnectionDAOtoDB();
    private Connection connection = connect.setConnection("root","12345","jdbc:mysql://localhost:3306/periodicals");

    public ReaderUserDAO() {

    }
    public void create(ReaderUser reader) throws SQLException {

        String sql_query = "INSERT INTO periodicals.readers (name, surname, birthday) VALUES ((?) , (?), (?))";
        try {
            statement = connection.prepareStatement(sql_query);
            statement.setString(1,reader.getName());
            statement.setString(2, reader.getSurname());
            statement.setString(3,reader.getBirthday());
            int result = statement.executeUpdate();
            if(result>0){
                System.out.println("The Reader has been added");
            }
        }
        catch (SQLException e) {
            e.printStackTrace();

        }
        connect.connectionClose(connection,statement);
    }

   public ReaderUser read(String key) throws SQLException {

    final ReaderUser result = new ReaderUser();
    result.setId(Integer.parseInt(key));
    String sql_query = "SELECT * FROM readers WHERE id=(?)";

try{
    statement = connection.prepareStatement(sql_query);
    statement.setString(1, key);
    rs = statement.executeQuery();
    if (rs.next()) {
        result.setName(rs.getString("name"));
        result.setSurname(rs.getString("surname"));
        result.setBirthday(rs.getString("birthday"));
    }
} catch (SQLException e) {
    e.printStackTrace();

}
    connect.connectionClose(connection,statement,rs);
    return result;
    }

    public ReaderUser readByName(String name, String surname) {
        final ReaderUser result = new ReaderUser();
        result.setName(name);
        result.setSurname(surname);
        String sql_query = "select * from readers where name = (?) and surname = (?)";
        try{
            statement = connection.prepareStatement(sql_query);
            statement.setString(1, name);
            statement.setString(2, surname);
            rs = statement.executeQuery();
            if (rs.next()) {
                result.setId(Integer.parseInt(rs.getString("id")));
                result.setBirthday(rs.getString("birthday"));
            }
        } catch (SQLException e) {
            e.printStackTrace();

        }
        connect.connectionClose(connection,statement,rs);
        return result;
    }


/*
 Update Reader`s Surname by id.
 */
    public void update(ReaderUser reader) throws SQLException {
        String sql_query = "UPDATE readers SET surname = (?) WHERE id = (?)";
        statement = connection.prepareStatement(sql_query);
        statement.setString(1, reader.getSurname());
        statement.setInt(2, reader.getId());
        int result = statement.executeUpdate();
        if(result>0){
            System.out.println("The Reader has updated");
        }
        else{
            System.out.println("This Reader does not exist");
        }
        connect.connectionClose(connection,statement);

    }

    public void delete(String key) {
    String sql_query = "DELETE FROM readers WHERE id = (?)";
        try {
            statement = connection.prepareStatement(sql_query);
            statement.setString(1,key);
            int result = statement.executeUpdate();

            if(result>0){
                System.out.println("The Reader has been deleted");
            }
            else{
                System.out.println("This Reader does not exist or has been deleted early");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        connect.connectionClose(connection,statement);
    }


    public ArrayList<ReaderUser> selectALL() {
        ArrayList<ReaderUser> arr_readers = new ArrayList<ReaderUser>();

        String sql_query = "select * from readers";
        try{
            statement = connection.prepareStatement(sql_query);
            rs = statement.executeQuery();
            while(rs.next()){
                ReaderUser readeruser = new ReaderUser();
                readeruser.setId(Integer.parseInt(rs.getString("id")));
                readeruser.setName(rs.getString("name"));
                readeruser.setSurname(rs.getString("surname"));
                readeruser.setBirthday(rs.getString("birthday"));
                arr_readers.add(readeruser);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        connect.connectionClose(connection,statement,rs);
        return arr_readers;
    }

}
