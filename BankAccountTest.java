import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BankAccountTest {
    Customer customer;
    BankAccount myCheckingAccount;
    BankAccount mySavingAccount;

    @BeforeEach
    void setUp() {
        this.customer=new Customer("Osman");
        this.myCheckingAccount=new BankAccount("checking",this.customer);
        this.mySavingAccount=new BankAccount("saving",this.customer);
    }

    @Test
    void deposit() {
        this.myCheckingAccount.deposit(100);
        assertEquals(100,this.myCheckingAccount.balance);

        this.myCheckingAccount.deposit(-100);
        assertEquals(100,this.myCheckingAccount.balance);

        this.myCheckingAccount.deposit(0);
        assertEquals(100,this.myCheckingAccount.balance);

    }

    @Test
    void withdraw() throws Exception {
        this.mySavingAccount.deposit(50);
        assertEquals(50,this.mySavingAccount.balance);
      try {
          this.mySavingAccount.withdraw(40);
      } catch (Exception e){
        e.printStackTrace();
    }
      assertEquals(10,this.mySavingAccount.balance);
      assertThrows(Exception.class,()->{this.mySavingAccount.withdraw(11);});
      assertEquals(10,this.mySavingAccount.balance);
      assertDoesNotThrow(()->{
          this.mySavingAccount.withdraw(9);
      });
    }

    @Test
    void fastWithdraw() {
        this.myCheckingAccount.deposit(100);
        try {
            this.myCheckingAccount.fastWithdraw();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        assertEquals(42,myCheckingAccount.balance);
        this.myCheckingAccount.setFastCashAmount(15);
        assertDoesNotThrow(()->{this.myCheckingAccount.fastWithdraw();});
        assertEquals(27,this.myCheckingAccount.balance);

        this.myCheckingAccount.setFastCashAmount(-50);
        try {
            this.myCheckingAccount.fastWithdraw();
        } catch (Exception e){
            e.printStackTrace();
        }
        assertEquals(77,this.myCheckingAccount.balance);

    }
}