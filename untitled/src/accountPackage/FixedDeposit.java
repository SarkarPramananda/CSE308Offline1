package accountPackage;

public class FixedDeposit extends Account{
    private static final double INITIAL_DEPOSIT_LIMIT=100000;
    private static final double MIN_DEPOSIT=50000;
    private static final double MAX_LOAN=100000;
    public FixedDeposit() {
        super();
    }

    @Override
    public boolean createAccount(String name, String accountType, double initialDeposit) {
        if(initialDeposit<INITIAL_DEPOSIT_LIMIT)return false;
        this.setName(name);
        this.setAccountType(accountType);
        setBalance(initialDeposit);
        return true;
    }

    @Override
    public boolean deposit(double amount) {
        if(amount<MIN_DEPOSIT){
            return false;
        }
        double balance=getBalance()+amount;
        this.setBalance(balance);
        return true;
    }

    @Override
    public boolean withDraw(double amount) {
        int accountAge=getAccountAge();
        if(accountAge<1){
            return false;
        }
        double balance=getBalance()-amount;
        if(balance<0)return false;
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
