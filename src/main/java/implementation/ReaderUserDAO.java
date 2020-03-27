package implementation;

import interfaces.DAO;

import objects.ReaderUser;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ReaderUserDAO  implements DAO <ReaderUser> {
    private Connection connection;

    public ReaderUserDAO() {

    }

    public ReaderUserDAO(Connection connection) {
        this.connection = connection;
    }

    public void create(ReaderUser reader) throws SQLException {
        String sql_query = "INSERT INTO periodicals.readers (name, surname, birthday) VALUES ((?) , (?), (?))";


        try {
            String user = "root";
            String password = "12345";
            String url = "jdbc:mysql://localhost:3306/library";
            connection = DriverManager.getConnection(url, user, password);
            PreparedStatement statement = connection.prepareStatement(sql_query);
            statement.setString(1,reader.getName());
            statement.setString(2, reader.getSurname());
            statement.setInt(3,reader.getBirthday());
        }
        catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Ошибка при добавлении");
        }
        finally{
            connection.close();
        }
    }

    public ReaderUser read(String key) {

        return null;
    }

    public void update(ReaderUser model) {

    }

    public void delete(ReaderUser model) {

    }
}
