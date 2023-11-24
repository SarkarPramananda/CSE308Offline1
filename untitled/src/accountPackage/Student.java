package accountPackage;

public class Student extends Account{
    private static final double ONE_TRANSITION_WITHDRAW_LIMIT=10000;
    private static final double MAX_LOAN=1000;
    public Student() {
        super();
    }

    @Override
    public boolean createAccount(String name, String accountType, double initialDeposit) {
        this.setName(name);
        this.setAccountType(accountType);
        setBalance(initialDeposit);
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
        if(amount>ONE_TRANSITION_WITHDRAW_LIMIT)return false;
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
