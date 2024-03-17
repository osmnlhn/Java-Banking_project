import java.util.Scanner;

public class Bank {

    public static void main(String[] args) throws Exception {
        Bank bank = new Bank();
        bank.run();
    }

    public void run () throws Exception {
     System.out.println("Welcome to Bank! What is your name? ");
        Scanner scanner= new Scanner(System.in);
        String name=scanner.next();
        System.out.println("Hello " + name +" We are creating checking and saving accounts for you ");
        Customer customer=new Customer(name);
        System.out.println("Where do you live?");
        String address=scanner.next();
        customer.setAddress(address);

        BankAccount checkingAccount=new BankAccount("Checking",customer);
        BankAccount savingAccount=new BankAccount("Saving",customer);

        System.out.println();
        System.out.println("Customer info:");
        System.out.println(checkingAccount.getCustomerinfo());

        System.out.println();
        System.out.println("Checking Account");
        System.out.println(checkingAccount.getAccountInfo());

        System.out.println("Saving Account");
        System.out.println(savingAccount.getAccountInfo());

        System.out.println();
        System.out.println("Amount to deposit into your checking account ");
        double amount=scanner.nextDouble();
        checkingAccount.deposit(amount);

        System.out.println();
        System.out.println("Amount to deposit into your saving account ");
         amount=scanner.nextDouble();
        savingAccount.deposit(amount);

        System.out.println(checkingAccount.getAccountInfo());
        System.out.println(savingAccount.getAccountInfo());

        System.out.println();
        System.out.println("Amount to withdraw from your Checking account ");
        amount=scanner.nextDouble();

       try {
           checkingAccount.withdraw(amount);

       } catch (Exception e){
           System.out.println(e.getMessage());
       }

        System.out.println();
        System.out.println("Amount to withdraw from your saving account ");
        amount=scanner.nextDouble();

        try {
            savingAccount.withdraw(amount);

        } catch (Exception e){
            System.out.println(e.getMessage());
        }

        System.out.println(checkingAccount.getAccountInfo());
        System.out.println(savingAccount.getAccountInfo());
        scanner.close();

    }
}
