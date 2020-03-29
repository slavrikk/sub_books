package interfaces;

import objects.Subscribe;

import java.util.ArrayList;

public interface SubscriptionInterface {
    ArrayList<Subscribe> checkSubByReaderId(String id);
}
