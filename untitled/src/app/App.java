package app;

import accountPackage.Account;
import accountPackage.FixedDeposit;
import accountPackage.Savings;
import accountPackage.Student;
import employeePackage.Employee;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner=new Scanner(new File("src/app/input.txt"));




        Bank bank=new Bank();
        Employee currentEmployee=null;
        Account currentAccount=null;

        while(true){
            if(!scanner.hasNext())break;
            String line=scanner.nextLine();

            System.out.println(line);
            String[] instructions=line.split("\\s+");
            String instruction=instructions[0];


            if(instruction.isEmpty()){
                continue;
            }
            if(instruction.equals("Exit"))break;
            processInstruction(bank,currentEmployee,currentAccount,instruction,instructions);




        }
    }

    private static void processInstruction(Bank bank,Employee currentEmployee,Account currentAccount,String instruction, String[] instructions) {
        switch (instruction){
            case "create":
            case "Create":
                executeCreate(bank,instructions,currentEmployee,currentAccount);
                break;
            case "deposit":
            case "Deposit":
                executeDeposit(bank,instructions,currentEmployee,currentAccount);
                break;
            case "withdraw":
            case "Withdraw":
                executeWithDraw(bank,instructions,currentEmployee,currentAccount);
                break;
            case "Query":
            case "query":
                executeQuery(bank,instructions,currentEmployee,currentAccount);
                break;
            case "request":
            case "Request":
                executeRequest(bank,instructions,currentEmployee,currentAccount);
                break;
            case "open":
            case "Open":
                executeOpen(bank,instructions,currentEmployee,currentAccount);
                break;
            case "close":
            case "Close":
                executeClose(bank,instructions,currentEmployee,currentAccount);
                break;
            case "approve":
            case "Approve":
                exeuteApprove(bank,instructions,currentEmployee,currentAccount);
                break;
            case "change":
            case "Change":
                executeChange(bank,instructions,currentEmployee,currentAccount);
                break;
            case "lookup":
            case "Lookup":
                executeLookup(bank,instructions,currentEmployee,currentAccount);
                break;
            case "see":
            case "See":
                executeSee(bank,instructions,currentEmployee,currentAccount);
                break;
            case "inc":
            case "Inc":
            case "INC":
                executeINC(bank,instructions,currentEmployee,currentAccount);
                break;

        }
    }

    private static void executeWithDraw(Bank bank, String[] instructions, Employee currentEmployee, Account currentAccount) {

    }

    private static void executeDeposit(Bank bank, String[] instructions, Employee currentEmployee, Account currentAccount) {
        double amount=Double.parseDouble(instructions[1]);

        for(Account account: bank.getAccounts()){
            if(account.getName().equals(currentAccount.getName())){
                account.deposit(amount);
                String message=""+amount+"$ deposited; Current balanced is "+account.getBalance()+"$";
            }
        }

    }


    private static void executeCreate(Bank bank,String[] instructions,Employee currentEmployee,Account currentAccount) {
        String name=instructions[1];
        String accountType=instructions[2];
        double initialDeposit=Double.parseDouble(instructions[3]);



        if(bank.findAccount(name)){
            System.out.println("Account already exist.");
            return ;
        }

        Account account = null;
        if(accountType.equals("Savings")||accountType.equals("savings"))account=new Savings();
        if(accountType.equals("Student")||accountType.equals("student"))account=new Student();
        if(accountType.equals("FixedDeposit")||accountType.equals("fixedDeposit"))account=new FixedDeposit();
        String message;

        if(account==null) {
            message="Failed to create account.";
        }

        assert account != null;
        if(account.createAccount(name,accountType,initialDeposit)){
            message=account.getAccountType()+" account for "+account.getName()+" Created; initial balance "+account.getBalance()+"$";

        }
        else {


            // try to retrieve information which error happened by exception handling.


            message="Failed to create account for irrelevant information";
        }
        bank.addAccount(account);
        currentAccount=account;
        System.out.println(message);
        return;
    }


}
