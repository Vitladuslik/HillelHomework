public class Subscriber {

    private int id;
    private String lastName;
    private String firstName;
    private String fathersName;
    private String city;
    private String phone;
    private String contractId;
    private double balance;
    private int localCalls;
    private int intercityCall;
    private int internetTraffic;

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

    public int getLocalCalls() {
        return localCalls;
    }

    public void setLocalCalls(int localCalls) {
        this.localCalls = localCalls;
    }

    public int getIntercityCall() {
        return intercityCall;
    }

    public void setIntercityCall(int intercityCall) {
        this.intercityCall = intercityCall;
    }

    public int getInternetTraffic() {
        return internetTraffic;
    }

    public void setInternetTraffic(int internetTraffic) {
        this.internetTraffic = internetTraffic;
    }

    public Subscriber() {
    }

    public Subscriber(int id, String lastName, String firstName, String fathersName, String city, String phone,
                      String contractId, double balance, int localCalls, int intercityCall, int internetTraffic) {
        this.id = id;
        this.lastName = lastName;
        this.firstName = firstName;
        this.fathersName = fathersName;
        this.city = city;
        this.phone = phone;
        this.contractId = contractId;
        this.balance = balance;
        this.localCalls = localCalls;
        this.intercityCall = intercityCall;
        this.internetTraffic = internetTraffic;
    }

    @Override
    public String toString() {
        return
                "id=" + id +
                ", lastName='" + lastName + '\'' +
                ", firstName='" + firstName + '\'' +
                ", fathersName='" + fathersName + '\'' +
                ", city='" + city + '\'' +
                ", phone='" + phone + '\'' +
                ", contractId='" + contractId + '\'' +
                ", balance=" + balance +
                ", localCalls=" + localCalls +
                ", intercityCall=" + intercityCall +
                ", internetTraffic=" + internetTraffic +
                '}';
    }
}
