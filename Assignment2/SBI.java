public class SBI extends Bank {

    private final double rateOfInterest = 5.1;

    public SBI() {
    }

    public SBI(String accountNumber, String name, AccountType accountType) {
        super(accountNumber, name, "SBI", accountType);
    }

    public String getDetails() {
        return "Bank{" +
                "accountNumber='" + accountNumber + '\'' +
                ", name='" + name + '\'' +
                ", bankName= 'SBI'" +
                ", accountType=" + accountType +
                ", rateOfInterest=" + rateOfInterest + "%" +
                ", accountOpeningDate=" + accountOpeningDate +
                ", balance=" + balance +
                '}';
    }

}
