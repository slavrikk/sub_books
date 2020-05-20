package services.subscriptions;

import implementation.SubscriptionDAO;

import java.sql.SQLException;

public class SubscribeReader {
    public void subscribeReader(String id_reader, String id_edition) throws SQLException {
        SubscriptionDAO request = new SubscriptionDAO();
        request.subscribeReaderToEstimate(id_reader,id_edition);
        if(request.isCheck_subscribe()){
            System.out.println("The Subscription has already existed");
        }
        if(request.isCheck_subscribe_creation()){
            System.out.println("The Subscription has been added successfully");
        }


    }
}
