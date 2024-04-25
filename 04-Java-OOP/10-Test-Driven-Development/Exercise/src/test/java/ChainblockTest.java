import org.junit.Before;
import org.junit.Test;

import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import static org.junit.Assert.*;

public class ChainblockTest {

    public static final int ID = 1;
    public static final TransactionStatus STATUS = TransactionStatus.SUCCESSFUL;
    public static final String FROM = "a";
    public static final String TO = "b";
    public static final double AMOUNT = 30.00;
    public static final String SENDER = "test_1";
    public static final String RECEIVER = "test_2";
    public static final int EXPECTED_RESULT = 1;
    public static final double MAX_AMOUNT = 250.00;
    public static final int MIN_AMOUNT = 100;
    public static final int LOWER_BOUND = 65;
    public static final int UPPER_BOUND = 100;

    private Chainblock chainblock;
    private Transaction transaction;

    @Before
    public void setUp() {
        chainblock = new ChainblockImpl();
        transaction = new TransactionImpl(ID, STATUS, FROM, TO, AMOUNT);
    }

    @Test
    public void test_Contains_Should_Return_Correct_Value() {
        chainblock.add(transaction);
        assertTrue(chainblock.contains(transaction.getId()));
        assertFalse(chainblock.contains(new TransactionImpl(2, STATUS, FROM, TO, AMOUNT)));
    }

    @Test
    public void test_GetCount_Should_Return_Correct_Value() {
        chainblock.add(transaction);
        assertEquals(1, chainblock.getCount());
    }

    @Test
    public void test_GetById_Should_Return_Correct_Transaction() {
        chainblock.add(transaction);
        Transaction currentTransaction = chainblock.getById(transaction.getId());
        assertNotNull(currentTransaction);

        assertEquals(transaction, currentTransaction);
    }

    @Test(expected = IllegalArgumentException.class)
    public void test_GetById_Should_Throw_When_TransactionNotPresent() {
        chainblock.getById(transaction.getId());
    }

    @Test
    public void test_ChangeTransactionStatus_Should_ChangeStatus_WhenTransactionPresent() {
        chainblock.add(transaction);
        chainblock.getById(transaction.getId()).setStatus(TransactionStatus.ABORTED);

        assertEquals(TransactionStatus.ABORTED, transaction.getStatus());
    }

    @Test(expected = IllegalArgumentException.class)
    public void test_ChangeTransactionStatus_Should_Throw_WhenTransaction_NotPresent() {
        chainblock.getById(transaction.getId()).setStatus(TransactionStatus.ABORTED);
    }

    @Test
    public void test_RemoveTransactionById_Should_RemoveTransaction_Correct() {
        chainblock.add(transaction);
        Transaction currentTransaction = chainblock.getById(transaction.getId());

        assertNotNull(currentTransaction);
        chainblock.removeTransactionById(currentTransaction.getId());

        assertEquals(0, chainblock.getCount());
    }

    @Test(expected = IllegalArgumentException.class)
    public void test_RemoveTransactionById_Should_Throw_WhenTransactionNotPresent() {
        chainblock.removeTransactionById(transaction.getId());
    }


    @Test
    public void test_GetByTransactionStatus_Should_Return_Correct_Transactions() {
        addTransactions();
        List<Transaction> transactions = toList(chainblock.getByTransactionStatus(TransactionStatus.SUCCESSFUL));

        assertEquals(3, transactions.size());
    }


    @Test(expected = IllegalArgumentException.class)
    public void test_GetByTransactionStatus_Should_Throw_When_TransactionsNotPresent() {
        List<Transaction> transactions = toList(chainblock.getByTransactionStatus(TransactionStatus.SUCCESSFUL));
        assertTrue(transactions.isEmpty());
    }


    @Test
    public void test_GetAllOrderedByAmountDescendingThenById_ShouldReturn_CorrectResult() {
        addTransactions();
        List<Transaction> transactions = toList(chainblock.getAllOrderedByAmountDescendingThenById());

        List<Transaction> result = transactions.stream()
                .sorted(Comparator.comparing(Transaction::getAmount).reversed())
                .sorted(Comparator.comparing(Transaction::getId).reversed())
                .collect(Collectors.toList());

        assertNotNull(result);
    }

    @Test
    public void test_GetBySenderOrderedByAmountDescending_ShouldReturn_CorrectResult() {
        addTransactions();
        List<Transaction> transactions = toList(chainblock.getBySenderOrderedByAmountDescending(SENDER));

        List<Transaction> result = transactions.stream()
                .sorted(Comparator.comparing(Transaction::getAmount).reversed())
                .collect(Collectors.toList());

        assertEquals(EXPECTED_RESULT, result.size());
    }

    @Test(expected = IllegalArgumentException.class)
    public void test_GetBySenderOrderedByAmountDescending_Should_Throw_WhenSender_NotPresent() {
        toList(chainblock.getBySenderOrderedByAmountDescending(SENDER));
    }

    @Test
    public void test_getByReceiverOrderedByAmountThenById_ShouldReturn_CorrectResult() {
        addTransactions();
        List<Transaction> transactions = toList(chainblock.getByReceiverOrderedByAmountThenById(RECEIVER));

        List<Transaction> result = transactions.stream()
                .sorted(Comparator.comparing(Transaction::getAmount).reversed())
                .sorted(Comparator.comparing(Transaction::getId))
                .collect(Collectors.toList());

        assertEquals(2, result.size());
    }

    @Test(expected = IllegalArgumentException.class)
    public void test_GetByReceiverOrderedByAmountThenById_Should_Throw_WhenSender_NotPresent() {
        toList(chainblock.getByReceiverOrderedByAmountThenById(RECEIVER));
    }

    @Test
    public void test_GetByTransactionStatusAndMaximumAmount_ShouldReturn_CorrectResult() {
        addTransactions();
        List<Transaction> transactions = toList(chainblock.getByTransactionStatusAndMaximumAmount
                (TransactionStatus.SUCCESSFUL, MAX_AMOUNT));

        List<Transaction> result = transactions.stream()
                .filter(t -> t.getAmount() <= MAX_AMOUNT)
                .sorted(Comparator.comparing(Transaction::getAmount).reversed())
                .collect(Collectors.toList());

        assertEquals(2, result.size());
    }

    @Test
    public void test_GetByTransactionStatusAndMaximumAmount_ShouldReturn_EmptySet_WhenTransactionsNotPresent() {
        addTransactions();
        List<Transaction> transactions = toList(chainblock.getByTransactionStatusAndMaximumAmount
                (TransactionStatus.SUCCESSFUL, MAX_AMOUNT));

        List<Transaction> result = transactions.stream()
                .filter(t -> t.getAmount() <= 0)
                .sorted(Comparator.comparing(Transaction::getAmount).reversed())
                .collect(Collectors.toList());

        assertTrue(result.isEmpty());
    }

    @Test
    public void test_GetBySenderAndMinimumAmountDescending_ShouldReturn_CorrectResult() {
        addTransactions();
        List<Transaction> transactions = toList(chainblock.getBySenderAndMinimumAmountDescending(SENDER, MIN_AMOUNT));

        List<Transaction> result = transactions.stream()
                .filter(t -> t.getFrom().equals(SENDER))
                .filter(t -> t.getAmount() > 100)
                .sorted(Comparator.comparing(Transaction::getAmount).reversed())
                .collect(Collectors.toList());

        assertEquals(EXPECTED_RESULT, result.size());
    }

    @Test(expected = IllegalArgumentException.class)
    public void test_GetBySenderAndMinimumAmountDescending_Should_Throw_WhenTransactionsNotPresent() {
        toList(chainblock.getBySenderAndMinimumAmountDescending(SENDER, MIN_AMOUNT));
    }

    @Test
    public void test_GetByReceiverAndAmountRange_ShouldReturn_CorrectResult() {
        addTransactions();
        List<Transaction> transactions = toList(chainblock.getByReceiverAndAmountRange(RECEIVER, LOWER_BOUND, UPPER_BOUND));

        List<Transaction> result = transactions.stream()
                .filter(t -> t.getTo().equals(RECEIVER))
                .filter(t -> t.getAmount() >= LOWER_BOUND && t.getAmount() < UPPER_BOUND)
                .sorted(Comparator.comparing(Transaction::getAmount).reversed())
                .sorted(Comparator.comparing(Transaction::getId))
                .collect(Collectors.toList());

        assertEquals(EXPECTED_RESULT, result.size());
    }

    @Test(expected = IllegalArgumentException.class)
    public void test_GetByReceiverAndAmountRange_Should_Throw_WhenTransactionsNotPresent() {
        toList(chainblock.getByReceiverAndAmountRange(RECEIVER, LOWER_BOUND, UPPER_BOUND));
    }


    @Test
    public void test_GetAllInAmountRange_ShouldReturn_CorrectResult() {
        addTransactions();
        List<Transaction> transactions = toList(chainblock.getAllInAmountRange(LOWER_BOUND, UPPER_BOUND));

        List<Transaction> result = transactions.stream()
                .filter(t -> t.getAmount() >= LOWER_BOUND && t.getAmount() <= UPPER_BOUND)
                .collect(Collectors.toList());

        assertEquals(EXPECTED_RESULT, result.size());
    }

    @Test
    public void test_GetAllInAmountRange_Should_Return_EmptySet_WhenTransactionsNotPresent() {
        List<Transaction> transactions = toList(chainblock.getAllInAmountRange(3000, 5000));
        assertTrue(transactions.isEmpty());
    }

    @Test
    public void test_Iterator_ShouldReturn_CorrectResult() {
        List<Transaction> expectedTransactions = addTransactions();
        Iterator<Transaction> iterator = chainblock.iterator();

        assertNotNull(iterator);

        Iterable<Transaction> iterable = () -> iterator;

        List<Transaction> actualTransactions = StreamSupport.stream(
                iterable.spliterator(), false)
                .collect(Collectors.toList());

        assertProductListsEquals(expectedTransactions, actualTransactions);
    }

    private List<Transaction> addTransactions() {
        List<Transaction> transactions = List.of(
                new TransactionImpl(2, TransactionStatus.SUCCESSFUL, "test_3", "test_4", 310.00),
                new TransactionImpl(1, TransactionStatus.SUCCESSFUL, SENDER, RECEIVER, 199.00),
                new TransactionImpl(7, TransactionStatus.FAILED, "test_13", RECEIVER, 65.00),
                new TransactionImpl(4, TransactionStatus.UNAUTHORIZED, "test_7", "test_8", 900.00),
                new TransactionImpl(6, TransactionStatus.ABORTED, "test_11", "test_12", 322.00),
                new TransactionImpl(3, TransactionStatus.SUCCESSFUL, "test_5", "test_6", 245.00),
                new TransactionImpl(5, TransactionStatus.FAILED, "test_9", "test_10", 569.00)
        );

        transactions.forEach(chainblock::add);
        return transactions;
    }

    private List<Transaction> toList(Iterable<Transaction> iterable) {
        assertNotNull(iterable);

        return StreamSupport.stream(iterable.spliterator(), false)
                .collect(Collectors.toList());
    }

    private static void assertProductListsEquals(List<Transaction> expectedTransactions, List<Transaction> actualTransactions) {
        assertEquals(expectedTransactions.size(), actualTransactions.size());

        for (int i = 0; i < expectedTransactions.size(); i++) {
            int expectedTransaction = expectedTransactions.get(i).getId();
            int actualTransaction = actualTransactions.get(i).getId();

            assertEquals(expectedTransaction, actualTransaction);
        }
    }


}
