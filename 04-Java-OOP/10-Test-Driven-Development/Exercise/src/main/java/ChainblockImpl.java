import java.util.*;
import java.util.stream.Collectors;

public class ChainblockImpl implements Chainblock {

    private LinkedHashMap<Integer, Transaction> chainblock;

    public ChainblockImpl() {
        this.chainblock = new LinkedHashMap<>();
    }

    public int getCount() {
        return chainblock.size();
    }

    public void add(Transaction transaction) {
        if (!chainblock.containsKey(transaction.getId())) {
            chainblock.put(transaction.getId(), transaction);
        }
    }

    public boolean contains(Transaction transaction) {
        return chainblock.containsKey(transaction.getId());
    }

    public boolean contains(int id) {
        return chainblock.containsKey(id);
    }

    public void changeTransactionStatus(int id, TransactionStatus newStatus) {
        if (!chainblock.containsKey(id)) {
            throw new IllegalArgumentException();
        }

        chainblock.get(id).setStatus(newStatus);
    }

    public void removeTransactionById(int id) {
        if (!chainblock.containsKey(id)) {
            throw new IllegalArgumentException();
        }

        chainblock.remove(id);
    }

    public Transaction getById(int id) {
        return chainblock.values().stream()
                .filter(transaction -> transaction.getId() == id)
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }

    public Iterable<Transaction> getByTransactionStatus(TransactionStatus status) {
        List<Transaction> result = chainblock.values()
                .stream()
                .filter(transaction -> transaction.getStatus().equals(status))
                .sorted(Comparator.comparing(Transaction::getAmount).reversed())
                .collect(Collectors.toList());

        if (result.isEmpty()) {
            throw new IllegalArgumentException();
        }

        return result;
    }

    public Iterable<String> getAllSendersWithTransactionStatus(TransactionStatus status) {
        return null;
    }

    public Iterable<String> getAllReceiversWithTransactionStatus(TransactionStatus status) {
        return null;
    }

    public Iterable<Transaction> getAllOrderedByAmountDescendingThenById() {
        return chainblock.values()
                .stream()
                .sorted(Comparator.comparing(Transaction::getAmount).reversed())
                .sorted(Comparator.comparing(Transaction::getId).reversed())
                .collect(Collectors.toList());
    }

    public Iterable<Transaction> getBySenderOrderedByAmountDescending(String sender) {
        List<Transaction> result = chainblock.values()
                .stream()
                .filter(transaction -> transaction.getFrom().equals(sender))
                .sorted(Comparator.comparing(Transaction::getAmount).reversed())
                .collect(Collectors.toList());

        if (result.isEmpty()) {
            throw new IllegalArgumentException();
        }

        return result;
    }

    public Iterable<Transaction> getByReceiverOrderedByAmountThenById(String receiver) {
        List<Transaction> result = chainblock.values()
                .stream()
                .filter(transaction -> transaction.getTo().equals(receiver))
                .sorted(Comparator.comparing(Transaction::getAmount).reversed())
                .sorted(Comparator.comparing(Transaction::getId))
                .collect(Collectors.toList());


        if (result.isEmpty()) {
            throw new IllegalArgumentException();
        }

        return result;
    }

    public Iterable<Transaction> getByTransactionStatusAndMaximumAmount(TransactionStatus status, double amount) {
        List<Transaction> result = chainblock.values()
                .stream()
                .filter(transaction -> transaction.getStatus().equals(status))
                .filter(transaction -> transaction.getAmount() <= amount)
                .sorted(Comparator.comparing(Transaction::getAmount).reversed())
                .collect(Collectors.toList());

        if (result.isEmpty()) {
            return new ArrayList<>();
        }

        return result;
    }

    public Iterable<Transaction> getBySenderAndMinimumAmountDescending(String sender, double amount) {
        List<Transaction> result = chainblock.values().stream()
                .filter(transaction -> transaction.getFrom().equals(sender))
                .filter(transaction -> transaction.getAmount() > amount)
                .sorted(Comparator.comparing(Transaction::getAmount).reversed())
                .collect(Collectors.toList());

        if (result.isEmpty()) {
            throw new IllegalArgumentException();
        }

        return result;
    }

    public Iterable<Transaction> getByReceiverAndAmountRange(String receiver, double lo, double hi) {
        List<Transaction> result = chainblock.values().stream()
                .filter(t -> t.getTo().equals(receiver))
                .filter(t -> t.getAmount() >= lo && t.getAmount() < hi)
                .sorted(Comparator.comparing(Transaction::getAmount).reversed())
                .sorted(Comparator.comparing(Transaction::getId))
                .collect(Collectors.toList());

        if (result.isEmpty()) {
            throw new IllegalArgumentException();
        }

        return result;
    }

    public Iterable<Transaction> getAllInAmountRange(double lo, double hi) {
        List<Transaction> result = chainblock.values().stream()
                .filter(t -> t.getAmount() >= lo && t.getAmount() <= hi)
                .collect(Collectors.toList());

        if (result.isEmpty()) {
            return new ArrayList<>();
        }

        return result;
    }

    public Iterator<Transaction> iterator() {
        return chainblock.values().iterator();
    }
}
