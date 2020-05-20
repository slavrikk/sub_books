package services.subscriptions;

import implementation.SubscriptionDAO;
import objects.Subscribe;

import java.sql.SQLException;
import java.util.ArrayList;

public class ObtainSubscriptionsByReaderId {
    public void obtainSubscriptions(String id_reader) throws SQLException {
        SubscriptionDAO response = new SubscriptionDAO();
        ArrayList<Subscribe> subscribeArrayList = response.checkSubByReaderId(id_reader);
        System.out.println(subscribeArrayList.toString());

    }
}
