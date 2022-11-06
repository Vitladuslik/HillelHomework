package HW6;

public interface SubscriberService {
    void findSubscriberByLocalCalls(Subscriber[] array, int localCallsMin);

    void findSubscribersUsedIntercity(Subscriber[] array);

    void findSubscribersByFirstLetter(Subscriber[] array, String letter);

    void calculateCityTraffic(Subscriber[] array, String city);

    void findSubscribersWithDebt(Subscriber[] array);

}
