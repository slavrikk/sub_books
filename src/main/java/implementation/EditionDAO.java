package implementation;

import interfaces.EditionInterface;
import objects.Edition;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class EditionDAO implements EditionInterface {

    private PreparedStatement statement;
    private ResultSet rs;
    private ConnectionDAOtoDB connect = new ConnectionDAOtoDB();
    private Connection connection = connect.setConnection("root","12345","jdbc:mysql://localhost:3306/periodicals");


    public void create(Edition publication) throws SQLException {
        String sql_query = "INSERT INTO periodicals.edition (name) VALUES ((?))";
        try {
            statement = connection.prepareStatement(sql_query);
            statement.setString(1,publication.getName());
            int result = statement.executeUpdate();
            if(result>0){
                System.out.println("The Edition has been added");
            }
        }
        catch (SQLException e) {
            e.printStackTrace();

        }
        connect.connectionClose(connection,statement);
    }

    public Edition read(String key) {
        final Edition publication = new Edition();
        publication.setId(Integer.parseInt(key));
        String sql_query = "SELECT * FROM edition WHERE id=(?)";

        try{
            statement = connection.prepareStatement(sql_query);
            statement.setString(1, key);
            rs = statement.executeQuery();
            if (rs.next()) {
                publication.setName(rs.getString("name"));

            }
        } catch (SQLException e) {
            e.printStackTrace();

        }
        connect.connectionClose(connection,statement,rs);
        return publication;
    }

    public Edition readByName(String name) {
        final Edition result = new Edition();
        result.setName(name);
        String sql_query = "select * from edition where name = (?)";
        try{
            statement = connection.prepareStatement(sql_query);
            statement.setString(1, name);
            rs = statement.executeQuery();
            if (rs.next()) {
                result.setId(Integer.parseInt(rs.getString("id")));
            }
        } catch (SQLException e) {
            e.printStackTrace();

        }
        connect.connectionClose(connection,statement,rs);
        return result;
    }

    public void update(Edition model) throws SQLException {
        String sql_query = "UPDATE edition SET name = (?) WHERE id = (?)";
        statement = connection.prepareStatement(sql_query);
        statement.setString(1, model.getName());
        statement.setInt(2, model.getId());
        int result = statement.executeUpdate();
        if(result>0){
            System.out.println("The Edition has updated");
        }
        else{
            System.out.println("This Edition does not exist");
        }
        connect.connectionClose(connection,statement);
    }

    public void delete(String key) {
        String sql_query = "DELETE FROM edition WHERE id = (?)";
        try {
            statement = connection.prepareStatement(sql_query);
            statement.setString(1,key);
            int result = statement.executeUpdate();

            if(result>0){
                System.out.println("The Edition has been deleted");
            }
            else{
                System.out.println("This Edition does not exist or has been deleted early");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        connect.connectionClose(connection,statement);
    }


    public ArrayList<Edition> selectALL() {
        ArrayList<Edition> arr_editions = new ArrayList<Edition>();
        String sql_query = "select * from edition";
        try{
            statement = connection.prepareStatement(sql_query);
            rs = statement.executeQuery();
            while(rs.next()){
                Edition edition = new Edition();
                edition.setId(Integer.parseInt(rs.getString("id")));
                edition.setName(rs.getString("name"));

                arr_editions.add(edition);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        connect.connectionClose(connection,statement,rs);
        return arr_editions;

    }


}
