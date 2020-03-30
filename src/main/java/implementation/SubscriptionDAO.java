package implementation;

import interfaces.SubscriptionInterface;
import objects.Subscribe;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class SubscriptionDAO implements SubscriptionInterface {
    private PreparedStatement statement_check;
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

    public void subscribeReaderToEstimate(String id_reader, String id_edition) {
        String sql_query_check = "select subscriptions.id from subscriptions where subscriptions.id_reader =(?) and subscriptions.id_edition =(?)";
         try {
             statement_check = connection.prepareStatement(sql_query_check);
             statement_check.setString(1,id_reader);
             statement_check.setString(2, id_edition);
             rs = statement_check.executeQuery();

             if(rs.next()){
                 System.out.println("The subscribe has already exist");
                 connect.connectionClose(connection,statement_check);
             }
             else{
                 String sql_query = "insert into subscriptions (id_reader, id_edition) VALUE ((?),(?))";
                 try {
                     statement = connection.prepareStatement(sql_query);
                     statement.setString(1,id_reader);
                     statement.setString(2, id_edition);
                     int result = statement.executeUpdate();
                     if(result>0){
                         System.out.println("The Subscription has been added successfully");
                     }
                 }
                 catch (SQLException e) {
                     System.out.println("Error! The Reader does not exist or the estimate not found");
                     e.printStackTrace();

                 }
                 connect.connectionClose(connection,statement_check);
                 connect.connectionClose(connection,statement);
             }

         } catch (SQLException e) {
             e.printStackTrace();
         }


    }

    public void cancelSubscribe(String id_reader, String id_edition) {
        String sql_query = "DELETE FROM subscriptions WHERE subscriptions.id_reader = (?) and subscriptions.id_edition = (?)";
        try {
            statement = connection.prepareStatement(sql_query);
            statement.setString(1,id_reader);
            statement.setString(2,id_edition);
            int result = statement.executeUpdate();

            if(result>0){
                System.out.println("The Subscription has been deleted");
            }
            else{
                System.out.println("This Subscription does not exist due to reader or estimate does not exist");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        connect.connectionClose(connection,statement);
    }


}
