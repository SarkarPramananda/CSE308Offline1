package accountPackage;

public interface AccountFuctionalities {

     public boolean createAccount(String name,String accountType,double initialDeposit);
     public boolean deposit(double amount);
     public boolean withDraw(double amount);
     public boolean requestLoan(double amount);
     public double queryDeposit();

}
