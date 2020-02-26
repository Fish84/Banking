package com.fish;

import org.junit.*;

import static junit.framework.TestCase.*;

public class BankAccountTest {

    private BankAccount account;

    private static int count;

    @org.junit.BeforeClass
    public static void beforeClass(){
        System.out.println("This executes before any test cases. Count = "+ count++);
    }

    @Before
    public void setUp() throws Exception {
        account = new BankAccount("Craig", "Carr", 1000.00, BankAccount.CHECKING);
        System.out.println("Running a test...");
    }

    @Test
    public void deposit() {
        double balance = account.deposit(200.00, true);
        assertEquals(1200, balance, 0);
        assertEquals(1200, account.getBalance(), 0);
    }

    @Test
    public void withdraw_branch() {
        double balance = account.withdraw(600.00, true);
        assertEquals(400.00, balance, 0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void withdraw_notBranch() {
        account.withdraw(600.00, false);
    }

    @Test
    public void withdraw() {
        fail("This is a fail");
    }

    @Test
    public void getBalance_deposit() {
        account.deposit(200.00, true);
        assertEquals(1200, account.getBalance(), 0);
    }

    @Test
    public void getBalance_withdraw() {
        account.withdraw(200.00, true);
        assertEquals(800.00, account.getBalance(), 0);
    }

    @Test
    public void isChecking_true() {
        assertTrue("The account is NOT a checking account", account.isChecking());
    }

    @Ignore("Test is ignored as a demo")
    @Test(timeout = 500)
    public void testInfiniteTametakingLoop() throws InterruptedException
    {
        while (true)
        {
            Thread.currentThread().sleep(1000);
        }
    }

    @AfterClass
    public static void afterClass(){
        System.out.println("This executes after any test cases. Count = "+ count++);
    }
    @After
    public void tearDown() throws Exception {
        System.out.println("Count = "+ count++);
    }

}