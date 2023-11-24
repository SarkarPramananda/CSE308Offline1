package employeePackage;

import accountPackage.Account;

public interface EmplyeeRole {
    public double lookUp(Account account);
    public boolean canApproveLoan();
    public boolean changeInterestRate(Account account, double newDepositInterestRate);
    public  boolean canSeeInternalFund();

}
