package employeePackage;

import accountPackage.Account;

public class Cashier extends Employee{
    public Cashier(String name) {
        this.setName(name);
        this.setEmployeeType("Cashier");

    }

    @Override
    public double lookUp(Account account) {
        return account.getBalance();
    }

    @Override
    public boolean canApproveLoan() {
        return false;
    }

    @Override
    public boolean changeInterestRate(Account account,double newDepositInterestRate) {
        return false;
    }

    @Override
    public boolean canSeeInternalFund() {
        return false;
    }


}
