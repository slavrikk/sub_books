package services.subscriptions;

import implementation.SubscriptionDAO;

public class DeleteSubscription {

    public void deleteSubscription(String id_reader, String id_estimate){
        SubscriptionDAO request = new SubscriptionDAO();
        request.cancelSubscribe(id_reader,id_estimate);
        if(request.check_cancel_subscribe){
            System.out.println("The Subscription has been deleted");
        }
        else{
            System.out.println("This Subscription does not exist due to reader or estimate does not exist");
        }
    }
}
