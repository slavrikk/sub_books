package implementation;

import interfaces.DAO;

import objects.ReaderUser;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;

public class ReaderUserDAO  implements DAO <ReaderUser> {
    private PreparedStatement statement;
    private ResultSet rs;

    private ConnectionDAOtoDB connect = new ConnectionDAOtoDB();
    private Connection connection = connect.setConnection("root","12345","jdbc:mysql://localhost:3306/periodicals");
    public ReaderUserDAO() {

    }
    public void create(ReaderUser reader) throws SQLException {
        String sql_query = "INSERT INTO periodicals.readers (name, surname, birthday) VALUES ((?) , (?), (?))";
        try {
            PreparedStatement statement = connection.prepareStatement(sql_query);
            statement.setString(1,reader.getName());
            statement.setString(2, reader.getSurname());
            statement.setString(3,reader.getBirthday());
        }
        catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Ошибка при добавлении");
        }
        finally{
            connection.close();
            statement.close();
        }
    }

public ReaderUser read(String key) {

final ReaderUser result = new ReaderUser();
result.setId(Integer.parseInt(key));
String sql_query = "SELECT * FROM readers WHERE id=(?)";

try{
    PreparedStatement statement = connection.prepareStatement(sql_query);
    statement.setString(1, key);
    final ResultSet rs = statement.executeQuery();
    if (rs.next()) {
        result.setName(rs.getString("name"));
        result.setSurname(rs.getString("surname"));
        result.setBirthday(rs.getString("birthday"));
    }
} catch (SQLException e) {
    e.printStackTrace();
}
        return result;
    }

    public void update(ReaderUser model) {

    }

    public void delete(ReaderUser model) {

    }
}
