package employeePackage;

import accountPackage.Account;

public class Officer extends Employee{
    public Officer(String name) {
        this.setName(name);
        this.setEmployeeType("Officer");
    }

    @Override
    public double lookUp(Account account) {
        return account.getBalance();
    }

    @Override
    public boolean canApproveLoan() {
        return true;
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
