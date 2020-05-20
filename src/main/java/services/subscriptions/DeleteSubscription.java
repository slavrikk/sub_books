package services.subscriptions;

import implementation.SubscriptionDAO;

import java.sql.SQLException;

public class DeleteSubscription {

    public void deleteSubscription(String id_reader, String id_edition) throws SQLException {
        SubscriptionDAO request = new SubscriptionDAO();
        request.cancelSubscribe(id_reader,id_edition);
        if(request.isCheck_cancel_subscribe()){
            System.out.println("The Subscription has been deleted");
        }
        else{
            System.out.println("This Subscription does not exist either Reader does not exist or Edition ");
        }
    }
}
