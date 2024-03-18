public class BankAccount {
    String accountType;
    double balance;
    Customer customer;
    double fastCashAmount;

    public BankAccount(String accountType, Customer customer) {
        this.accountType = accountType;
        this.customer = customer;
        this.fastCashAmount=58;
    }

    public void deposit(double amount){
        if (amount >0){
            this.balance +=amount;}

    }

    public void withdraw(double amount) throws Exception {
        if (amount>this.balance){
            throw new Exception("Amount is greater than available balance");
        }
        this.balance -=amount;
    }

    public void fastWithdraw() throws Exception {
        this.withdraw(this.fastCashAmount);
    }
    public String getAccountInfo(){
        return this.accountType + ":" + this.balance;
    }

    public String getCustomerinfo(){
        return this.customer.getName() + " from " + this.customer.getAddress();
    }

    public void setFastCashAmount(double amount) {
        this.fastCashAmount = amount;
    }


}
