package app;

import accountPackage.Account;

public interface BankActivities {
    public boolean addAccount(Account account);
    public boolean increaseYear();
    public boolean findAccount(String accountHolderName);
    public boolean hasRequestedLoan();
    public boolean approveLoan();

    public double getInternalFund();




    // add option to manage employee

}
