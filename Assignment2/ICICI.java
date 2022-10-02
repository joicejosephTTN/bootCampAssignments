public class ICICI extends Bank {

    private double rateOfInterest = 8.5;

    public ICICI(String accountNumber, String name, AccountType accountType) {
        super(accountNumber, name, "ICICI", accountType);
    }

    public String getDetails() {
        return "Bank{" +
                "accountNumber='" + accountNumber + '\'' +
                ", name='" + name + '\'' +
                ", bankName= 'ICICI'" +
                ", accountType=" + accountType +
                ", rateOfInterest=" + rateOfInterest + "%" +
                ", accountOpeningDate=" + accountOpeningDate +
                ", balance=" + balance +
                '}';
    }
}
