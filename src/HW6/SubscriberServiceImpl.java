package HW6;

public class SubscriberServiceImpl implements SubscriberService {

    @Override
    public void findSubscribersByFirstLetter(Subscriber[] array, String letter) {

        System.out.println("Subscribers, whose lastname starts with " + letter.toUpperCase() + " :");
        for (Subscriber s : array) {
            if (s.getLastName().indexOf(letter.toUpperCase()) == 0) {
                System.out.println(s.getLastName() + " " + s.getFirstName() + " " + s.getFathersName() + " , " +
                        s.getPhone() + " , " + s.getBalance() + ".");
            }
        }
        System.out.println("-----------------------------------------------------------------------------------------");

    }

    @Override
    public void findSubscriberByLocalCalls(Subscriber[] array, int localCallsMin) {

        System.out.println("Subscribers, who used more than " + localCallsMin + " minutes of local calls :");
        for (Subscriber s : array) {
            if (s.getLocalCallsMin() > localCallsMin) {
                System.out.println(s);
            }
        }
        System.out.println("-----------------------------------------------------------------------------------------");

    }

    @Override
    public void findSubscribersUsedIntercity(Subscriber[] array) {
        System.out.println("Subscribers, who used intercity calls :");
        for (Subscriber s : array) {
            if (s.getIntercityCallMin() > 0) {
                System.out.println(s);
            }
        }
        System.out.println("-----------------------------------------------------------------------------------------");
    }

    @Override
    public void findSubscribersWithDebt(Subscriber[] array) {

        System.out.println("Subscribers with debt :");
        for (Subscriber s : array) {
            if (s.getBalance() < 0) {
                System.out.println(s);
            }
        }
        System.out.println("-----------------------------------------------------------------------------------------");

    }

    @Override
    public void calculateCityTraffic(Subscriber[] array, String city) {


        int totalTrafficUsed = 0;
        for (Subscriber s : array) {
            if (s.getCity().equalsIgnoreCase(city)) {
                totalTrafficUsed += s.getInternetTrafficGb();
            }
        }
        System.out.println("City of " + city + " total internet traffic used : " + totalTrafficUsed + " Gb.");
        System.out.println("-----------------------------------------------------------------------------------------");

    }
}
