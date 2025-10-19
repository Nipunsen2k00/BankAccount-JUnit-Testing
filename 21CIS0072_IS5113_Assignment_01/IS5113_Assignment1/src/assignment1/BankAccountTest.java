package assignment1;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class BankAccountTest {
    private BankAccount account1;
    private BankAccount account2;

    @BeforeClass
    public static void setUpBeforeClass() {
        System.out.println("Starting BankAccount test suite...");
    }

    @AfterClass
    public static void tearDownAfterClass() {
        System.out.println("All tests completed!");
    }

    @Before
    public void setUp() {
        account1 = new BankAccount("A001", "John Doe", 1000.0);
        account2 = new BankAccount("A002", "Jane Smith", 500.0);
    }

    @After
    public void tearDown() {
        System.out.println("Test finished!");
    }

    @Test
    public void testDeposit() {
        account1.deposit(200);
        assertEquals(1200.0, account1.getBalance(), 0.001);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testDepositInvalidAmount() {
        account1.deposit(-50);
    }

    @Test
    public void testWithdraw() {
        account1.withdraw(200);
        assertEquals(800.0, account1.getBalance(), 0.001);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testWithdrawInsufficientFunds() {
        account1.withdraw(2000);
    }

    @Test(timeout = 1000)
    public void testTransfer() {
        account1.transfer(account2, 300);
        assertEquals(700.0, account1.getBalance(), 0.001);
        assertEquals(800.0, account2.getBalance(), 0.001);
    }

    @Test
    public void testAssertions() {
        assertNotNull(account1);
        assertTrue(account1.getBalance() > 0);
        assertFalse(account1.getOwnerName().isEmpty());
    }
}

