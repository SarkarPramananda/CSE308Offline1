package accountPackage;

public class Savings extends Account{

    private static final double MIN_BALANCE=1000;
    private static final double MAX_LOAN=10000;

    public Savings() {
        super();
    }

    @Override
    public boolean createAccount(String name, String accountType, double initialDeposit) {

        this.setName(name);
        this.setAccountType(accountType);
        this.setBalance(initialDeposit);
        return true;
    }

    @Override
    public boolean deposit(double amount) {
        double balance=getBalance()+amount;
        this.setBalance(balance);
        return true;
    }

    @Override
    public boolean withDraw(double amount) {
        double balance=getBalance()-amount;
        if(balance<MIN_BALANCE)return false;
        setBalance(balance);
        return true;
    }

    @Override
    public boolean requestLoan(double amount) {
        double loan=getLoan()+getRequestedLoan()+amount;
        if(loan>MAX_LOAN){
            return false;
        }
        double requestedLoan=getRequestedLoan()+amount;
        setRequestedLoan(requestedLoan);
        return true;
    }

    @Override
    public double queryDeposit() {
        return getBalance();
    }
}
