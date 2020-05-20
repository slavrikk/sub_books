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
    //Input your own settings to DataBase connection
    private Connection connection = connect.setConnection("root","12345","jdbc:mysql://localhost:3306/periodicals");
    private boolean check_delete_response = false;
    private boolean check_update_response = false;
    private boolean check_create_response = false;
    private boolean check_fail_response = false;

    public boolean isCheck_delete_response() {
        return check_delete_response;
    }

    public void setCheck_delete_response(boolean check_delete_response) {
        this.check_delete_response = check_delete_response;
    }

    public boolean isCheck_update_response() {
        return check_update_response;
    }

    public void setCheck_update_response(boolean check_update_response) {
        this.check_update_response = check_update_response;
    }

    public boolean isCheck_create_response() {
        return check_create_response;
    }

    public void setCheck_create_response(boolean check_create_response) {
        this.check_create_response = check_create_response;
    }

    public boolean isCheck_fail_response() {
        return check_fail_response;
    }

    public void setCheck_fail_response(boolean check_fail_response) {
        this.check_fail_response = check_fail_response;
    }

    public EditionDAO() throws SQLException {
    }

    public void create(Edition publication) throws SQLException {
        String sql_query_with_id = "INSERT INTO periodicals.edition (name, id) VALUES ((?), (?))";
        String sql_query_no_id = "INSERT INTO periodicals.edition (name) VALUES ((?))";
        String sql_query = "";
        if(publication.getId()==0){
            sql_query=sql_query_no_id;
            statement = connection.prepareStatement(sql_query);
            statement.setString(1,publication.getName());
        }
        else{
            sql_query=sql_query_with_id;
            statement = connection.prepareStatement(sql_query);
            statement.setString(1,publication.getName());
            statement.setString(2, String.valueOf(publication.getId()));
        }

        int result = statement.executeUpdate();
        if(result>0){
            check_create_response = true;
        }
        connect.connectionClose(connection,statement);
    }

    public Edition read(String key) throws SQLException {
        final Edition publication = new Edition();
        publication.setId(Integer.parseInt(key));
        String sql_query = "SELECT * FROM edition WHERE id=(?)";
        statement = connection.prepareStatement(sql_query);
        statement.setString(1, key);
        rs = statement.executeQuery();
        if (rs.next()) {
            publication.setName(rs.getString("name"));

        }

        connect.connectionClose(connection,statement,rs);

        return publication;
    }

    public Edition readByName(String name) throws SQLException {
        final Edition result = new Edition();
        result.setName(name);
        String sql_query = "select * from edition where name = (?)";

        statement = connection.prepareStatement(sql_query);
        statement.setString(1, name);
        rs = statement.executeQuery();
        if (rs.next()) {
            result.setId(Integer.parseInt(rs.getString("id")));
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
            check_update_response = true;
        }
        connect.connectionClose(connection,statement);
    }

    public void delete(String key) throws SQLException {
        String sql_query = "DELETE FROM edition WHERE id = (?)";
        statement = connection.prepareStatement(sql_query);
        statement.setString(1,key);
        int result = statement.executeUpdate();
        if(result>0){
            check_delete_response =true;
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
