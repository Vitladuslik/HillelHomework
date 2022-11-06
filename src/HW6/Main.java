package HW6;

public class Main extends SubscriberServiceImpl{

    private static Subscriber[] subscribers;

    public static void main(String[] args) {

        initSubscribers();

        makeSearch();

    }


    private static void makeSearch() {

        SubscriberServiceImpl service = new SubscriberServiceImpl();

        service.findSubscriberByLocalCalls(subscribers,17);

        service.findSubscribersUsedIntercity(subscribers);

        service.findSubscribersByFirstLetter(subscribers,"k");

        service.findSubscribersWithDebt(subscribers);

        service.calculateCityTraffic(subscribers,"kyiv");

    }



    private static void initSubscribers() {

        Subscriber testSubscriber = new Subscriber();
        testSubscriber.setId(1);
        testSubscriber.setFirstName("Artem");
        testSubscriber.setLastName("Korolyov");
        testSubscriber.setFathersName("Maximovich");
        testSubscriber.setCity("Kyiv");
        testSubscriber.setPhone("0985609725");
        testSubscriber.setContractId("901365125");
        testSubscriber.setBalance(-245.15);
        testSubscriber.setLocalCallsMin(15);
        testSubscriber.setIntercityCallMin(0);
        testSubscriber.setInternetTrafficGb(10);

        subscribers = new Subscriber[] {testSubscriber,
                new Subscriber(2, "Antonov", "Valentin", "Anatolievich", "Odesa",
                        "0958932650", "900044576", 149.67, 24, 0,8),

                new Subscriber(3, "Vorobey", "Meriem", "Maksimovich", "Lviv",
                        "0993389671", "901987265", 524.11, 13, 0,11),

                new Subscriber(4, "Kuznetsov", "Alex", "Tykhomyrovich", "Cherkassy",
                        "0970024376", "900165742", -154.98, 1, 14,7),

                new Subscriber(5, "Patton", "Fox", "Valerievich", "Kyiv",
                        "0980295381", "901762592", -785.45, 24, 28,4),

                new Subscriber(6, "Orlyk", "Phylyp", "Pavlovich", "Lviv",
                        "0968819467", "900744055", 352.15,11, 0, 12),

                new Subscriber(7, "Synytsa", "Andrey", "Victorovoch", "Odesa",
                        "0990138275", "901239094", 138.25, 23, 0,19),

                new Subscriber(8, "Tref", "Alex", "Sergeevich", "Cherkassy",
                        "0980001532", "901894275", -220.18, 22, 14,3),

                new Subscriber(9, "Sumka", "Denis", "Petorich", "Kyiv",
                        "0991827364", "901876490", 11.48, 17, 9,23),

                new Subscriber(10, "Goldstein", "Rokfor", "Stepanovich", "Odesa",
                        "0956574832", "901167902", 152.16, 14, 0,14)};

    }

}
