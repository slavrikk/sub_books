package services.subscriptions;

import implementation.SubscriptionDAO;

public class SubscribeReader {
    public void subscribeReader(String id_reader, String id_estimate){
        SubscriptionDAO request = new SubscriptionDAO();
        request.subscribeReaderToEstimate(id_reader,id_estimate);


    }
}
