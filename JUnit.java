import org.junit.Test;
import static org.junit.Assert.*;

public class BankAccountTest {
    @Test
    public void testDeposit() {
        BankAccount account = new SavingsAccount("John Doe", 1234, 500);
        account.deposit(200);
        assertEquals(700, account.getBalance(), 0.01);
    }

    @Test
    public void testWithdraw() {
        BankAccount account = new SavingsAccount("John Doe", 1234, 500);
        account.withdraw(300);
        assertEquals(200, account.getBalance(), 0.01);
    }
}