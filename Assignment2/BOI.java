public class BOI extends Bank {

    private final double rateOfInterest = 7.3;

    public BOI(String accountNumber, String name, AccountType accountType) {
        super(accountNumber, name, "BOI", accountType);
    }

    public String getDetails() {
        return "Bank{" +
                "accountNumber='" + accountNumber + '\'' +
                ", name='" + name + '\'' +
                ", bankName= 'BOI'" +
                ", accountType=" + accountType +
                ", rateOfInterest=" + rateOfInterest + "%" +
                ", accountOpeningDate=" + accountOpeningDate +
                ", balance=" + balance +
                '}';
    }
}
