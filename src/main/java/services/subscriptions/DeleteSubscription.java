package services.subscriptions;

import implementation.SubscriptionDAO;

public class DeleteSubscription {

    public void deleteSubscription(String id_reader, String id_estimate){
        SubscriptionDAO request = new SubscriptionDAO();
        request.cancelSubscribe(id_reader,id_estimate);
    }
}
