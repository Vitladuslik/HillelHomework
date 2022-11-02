public class Subscriber {

    private int id;
    private String lastName;
    private String firstName;
    private String fathersName;
    private String city;
    private String phone;
    private String contractId;
    private double balance;
    private int localCallsMin;
    private int intercityCallMin;
    private int internetTrafficGb;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getFathersName() {
        return fathersName;
    }

    public void setFathersName(String fathersName) {
        this.fathersName = fathersName;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getContractId() {
        return contractId;
    }

    public void setContractId(String contractId) {
        this.contractId = contractId;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public int getLocalCallsMin() {
        return localCallsMin;
    }

    public void setLocalCallsMin(int localCallsMin) {
        this.localCallsMin = localCallsMin;
    }

    public int getIntercityCallMin() {
        return intercityCallMin;
    }

    public void setIntercityCallMin(int intercityCallMin) {
        this.intercityCallMin = intercityCallMin;
    }

    public int getInternetTrafficGb() {
        return internetTrafficGb;
    }

    public void setInternetTrafficGb(int internetTrafficGb) {
        this.internetTrafficGb = internetTrafficGb;
    }

    public Subscriber() {
    }

    public Subscriber(int id, String lastName, String firstName, String fathersName, String city, String phone,
                      String contractId, double balance, int localCallsMin, int intercityCallMin, int internetTrafficGb) {
        this.id = id;
        this.lastName = lastName;
        this.firstName = firstName;
        this.fathersName = fathersName;
        this.city = city;
        this.phone = phone;
        this.contractId = contractId;
        this.balance = balance;
        this.localCallsMin = localCallsMin;
        this.intercityCallMin = intercityCallMin;
        this.internetTrafficGb = internetTrafficGb;
    }

    @Override
    public String toString() {
        return
                "id=" + id +
                ", lastName = '" + lastName + '\'' +
                ", firstName = '" + firstName + '\'' +
                ", fathersName = '" + fathersName + '\'' +
                ", city = '" + city + '\'' +
                ", phone = '" + phone + '\'' +
                ", contractId = '" + contractId + '\'' +
                ", balance = " + balance +
                ", localCalls = " + localCallsMin +
                ", intercityCall = " + intercityCallMin +
                ", internetTraffic = " + internetTrafficGb +
                '}';
    }
}
