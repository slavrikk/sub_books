package implementation;

import interfaces.SubscriptionInterface;
import objects.Subscribe;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class SubscriptionDAO implements SubscriptionInterface {
    private PreparedStatement statement;
    private ResultSet rs;
    private ConnectionDAOtoDB connect = new ConnectionDAOtoDB();
    private Connection connection = connect.setConnection("root","12345","jdbc:mysql://localhost:3306/periodicals");


    public ArrayList<Subscribe> checkSubByReaderId(String id) {

        ArrayList<Subscribe> subscribeArrayList = new ArrayList<Subscribe>();
        String sql_query ="SELECT subscriptions.id, readers.surname, edition.id, edition.name \n" +
                "FROM readers\n" +
                "INNER JOIN subscriptions\n" +
                "ON readers.id = subscriptions.id_reader\n" +
                "INNER JOIN edition\n" +
                "ON subscriptions.id_edition = edition.id\n" +
                "where readers.id = (?)";

        try{
            statement = connection.prepareStatement(sql_query);
            statement.setString(1, id);
            rs = statement.executeQuery();
            while (rs.next()) {
               Subscribe sub = new Subscribe();
                sub.setId_subscription(Integer.parseInt(rs.getString(1)));
                sub.setReader_surname(rs.getString(2));
                sub.setId_edition(Integer.parseInt(rs.getString(3)));
                sub.setEdition_name(rs.getString(4));
                subscribeArrayList.add(sub);
            }
        } catch (SQLException e) {
            e.printStackTrace();

        }
        connect.connectionClose(connection,statement,rs);
        return subscribeArrayList;
    }
}
