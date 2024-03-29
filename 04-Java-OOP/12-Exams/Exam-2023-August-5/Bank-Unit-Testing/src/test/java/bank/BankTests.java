package bank;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class BankTests {

    private static final String BANK_NAME = "DSK";
    private static final int BANK_CAPACITY = 100;
    private static final String CLIENT_NAME = "George";
    private static final int BELOW_ZERO_BANK_CAPACITY = -12;
    private static final String DUMMY_CLIENT = "Test";

    Bank bank;
    Client client;

    @Before
    public void setUp() {
        bank = new Bank(BANK_NAME, BANK_CAPACITY);
        client = new Client(CLIENT_NAME);
        bank.addClient(client);
    }

    @Test
    public void test_Constructor_ShouldCreate_CorrectObject() {
        assertEquals(BANK_NAME, bank.getName());
        assertEquals(BANK_CAPACITY, bank.getCapacity());
    }

    @Test(expected = IllegalArgumentException.class)
    public void test_Constructor_ShouldCThrowException_WhenCapacityIsBelowZero() {
        bank = new Bank(BANK_NAME, BELOW_ZERO_BANK_CAPACITY);
    }


    @Test(expected = NullPointerException.class)
    public void test_Constructor_ShouldCThrowException_WhenNameIsNull() {
        bank = new Bank(null, BANK_CAPACITY);
    }

    @Test(expected = NullPointerException.class)
    public void test_Constructor_ShouldCThrowException_WhenNameIsEmpty() {
        bank = new Bank(" ", BANK_CAPACITY);
    }

    @Test
    public void test_GetNameMethod_ShouldReturnCorrectBankName() {
        String actualName = bank.getName();
        assertEquals(BANK_NAME, actualName);
    }

    @Test
    public void test_GetCapacityMethod_ShouldReturnCorrectBankCapacity() {
        int actualCapacity = bank.getCapacity();
        assertEquals(BANK_CAPACITY, actualCapacity);
    }

    @Test
    public void test_GetCountMethod_ShouldReturnCorrectSizeOfClientCollection() {
        int actualCount = bank.getCount();
        assertEquals(1, actualCount);
    }

    @Test
    public void test_AddClientMethod_ShouldAddClientCorrect() {
        assertEquals(1, bank.getCount());
    }

    @Test(expected = IllegalArgumentException.class)
    public void test_AddClientMethod_ShouldThrowException_WhenClientCollectionSizeIsEqualToBankCapacity() {
        bank = new Bank(BANK_NAME, 0);
        bank.addClient(client);
    }

    @Test
    public void test_RemoveClientMethod_ShouldRemoveClientCorrect() {
        bank.removeClient(client.getName());
    }

    @Test(expected = IllegalArgumentException.class)
    public void test_RemoveClientMethod_ShouldThrowException_WhenClientDoesNotExist() {
        bank.removeClient(DUMMY_CLIENT);
        assertEquals(0, bank.getCount());
    }

    @Test
    public void test_LoanWithdrawalMethod_ShouldReturnCorrectClient() {
        bank.loanWithdrawal(client.getName());
        assertFalse(client.isApprovedForLoan());
    }

    @Test(expected = IllegalArgumentException.class)
    public void test_LoanWithdrawalMethod_ShouldThrowException_WhenClientDoesNotExist() {
        bank.loanWithdrawal(DUMMY_CLIENT);
    }

    @Test
    public void test_GetStatisticsMethod_ShouldReturnCorrectAnswer() {
        String actualStatistics = bank.statistics();
        String expectedStatistics = "The client George is at the DSK bank!";

        assertEquals(expectedStatistics, actualStatistics);
    }


}
