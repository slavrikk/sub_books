package services.subscriptions;

import implementation.SubscriptionDAO;

public class SubscribeReader {
    public void subscribeReader(String id_reader, String id_edition){
        SubscriptionDAO request = new SubscriptionDAO();
        request.subscribeReaderToEstimate(id_reader,id_edition);
        if(request.check_subscribe){
            System.out.println("The Subscription has already existed");
        }
        if(request.check_subscribe_creation){
            System.out.println("The Subscription has been added successfully");
        }


    }
}
