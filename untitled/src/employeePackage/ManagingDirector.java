package employeePackage;

import accountPackage.Account;

public class ManagingDirector extends Employee{
    public ManagingDirector(String name) {
        this.setName(name);
        this.setEmployeeType("Managing Director");
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
        account.setDepositInterestRate(newDepositInterestRate);
        return true;
    }

    @Override
    public boolean canSeeInternalFund() {
        return true;
    }


}
