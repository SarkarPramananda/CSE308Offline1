package accountPackage;

public abstract class Account implements AccountFuctionalities {
    private String name ;
    private String accountType ;
    private double balance;
    private double loan;
    private double requestedLoan;
    private int accountAge;

    private static final double LOAN_INTEREST_RATE=10.0;
    private static final double SERVICE_CHARGE=500.0;
    private double depositInterestRate;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public double getLoan() {
        return loan;
    }

    public void setLoan(double loan) {
        this.loan = loan;
    }

    public double getRequestedLoan() {
        return requestedLoan;
    }

    public void setRequestedLoan(double requestedLoan) {
        this.requestedLoan = requestedLoan;
    }

    public int getAccountAge() {
        return accountAge;
    }

    public void setAccountAge(int accountAge) {
        this.accountAge = accountAge;
    }

    public double getDepositInterestRate() {
        return depositInterestRate;
    }

    public void setDepositInterestRate(double depositInterestRate) {
        this.depositInterestRate = depositInterestRate;
    }

    Account() {
        this.balance=0;
        this.loan=0;
        this.requestedLoan=0;
        this.accountAge=0;
    }

    public void addBalance(double amount){
        balance+=amount;
    }
    public void subtractBalance(double amount){
        balance-=amount;
    }
}
