package app;

import accountPackage.Account;
import employeePackage.Cashier;
import employeePackage.Employee;
import employeePackage.ManagingDirector;
import employeePackage.Officer;

import java.util.ArrayList;

public class Bank implements BankActivities {

    private static final double INITIAL_FUND=1000000;
    private ArrayList<Account> accounts;
    private ArrayList<Employee> employees;
    private static int year;
    private double internalFund;


    public Bank() {
        this.internalFund=INITIAL_FUND;
        accounts  =new ArrayList<>();
        employees=new ArrayList<>();
        ManagingDirector managingDirector=new ManagingDirector("MD");
        Officer officer1=new Officer("O1");
        Officer officer2=new Officer("O2");
        Cashier cashier1=new Cashier("C1");
        Cashier cashier2=new Cashier("C2");
        Cashier cashier3=new Cashier("C3");
        Cashier cashier4=new Cashier("C4");
        Cashier cashier5=new Cashier("C5");

        year=2023;

        employees.add(managingDirector);
        employees.add(officer1);
        employees.add(officer2);
        employees.add(cashier1);
        employees.add(cashier2);
        employees.add(cashier3);
        employees.add(cashier4);
        employees.add(cashier5);


    }


    @Override
    public boolean addAccount(Account account) {
        if(account==null)return false;
        accounts.add(account);
        return true;
    }

    @Override
    public boolean increaseYear() {
        return false;
    }

    @Override
    public boolean findAccount(String accountHolderName) {
        for(Account account:accounts){
            String name=account.getName();
            if(name.equals(accountHolderName))return true;
        }
        return false;
    }

    @Override
    public boolean hasRequestedLoan() {
        for(Account account:accounts){
            if(account.getRequestedLoan()!=0)return true;
        }
        return false;
    }

    @Override
    public boolean approveLoan() {
        for(Account account:accounts){
            if(account.getRequestedLoan()!=0){
                account.addBalance(account.getRequestedLoan());
                account.setRequestedLoan(0);
            }
        }
        return true;
    }

    @Override
    public double getInternalFund() {
        return internalFund;
    }

    public void addInternalFund(double amount) {
        internalFund+=amount;

    }

    public ArrayList<Account> getAccounts() {
        return accounts;
    }

    public ArrayList<Employee> getEmployees() {
        return employees;
    }

    public static int getYear() {
        return year;
    }

    public void subtractInternalFund(double amount) {
        internalFund-=amount;
    }
}
