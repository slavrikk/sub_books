package interfaces;

import objects.Subscribe;
import java.util.ArrayList;

public interface SubscriptionInterface {
    ArrayList<Subscribe> checkSubByReaderId(String id);

    void subscribeReaderToEstimate(String id_reader, String id_edition);

    void cancelSubscribe(String id_reader, String id_edition);

}
