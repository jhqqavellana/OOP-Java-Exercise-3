import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Manages multiple bank accounts, allowing for adding and retrieving accounts.
 */
public class BankAccountManager implements Bank {
  private Map<Integer, BankAccount> accounts;
  private int nextAccountId;

  /** Constructor for the Bank Account Manager. */
  public BankAccountManager() {
    this.accounts = new LinkedHashMap<>();
    this.nextAccountId = 0;
  }

  @Override
  public void addAccount(BankAccount account) {
    if (accounts.size() >= 100) {
      System.out.println("Cannot add more accounts. Maximum limit reached.");
      return;
    }

    accounts.put(nextAccountId, account);
    System.out.println("Account added with ID: " + nextAccountId);
    nextAccountId++;
  }

  @Override
  public BankAccount getAccount(int id) {
    return accounts.get(id);
  }

  /** Lists all accounts in the manager. */
  public void listAccounts() {
    System.out.println("Listing all accounts:");
    Iterator<Map.Entry<Integer, BankAccount>> bankaccounts = accounts.entrySet().iterator();
    while (bankaccounts.hasNext()) {
      Map.Entry<Integer, BankAccount> entry = bankaccounts.next();
      BankAccount account = entry.getValue();
      System.out.printf(
          "Account ID: %d, Account Name: %s, Balance: %.2f%n",
          entry.getKey(), account.getOwnerName(), account.getBalance());
    }
  }

  /** Filters transactions whose amount is at or above the given threshold. */
  public List<Transaction> filterTransactionsAtOrAbove(double amount, List<Transaction> txList) {
    List<Transaction> filteredTransactions = txList.stream()
        .filter(transaction -> transaction.getAmount() >= amount)
        .collect(Collectors.toList());

    System.out.println("Filtering transactions at or above " + amount + "...");
    System.out.println(filteredTransactions);
    return filteredTransactions;
  }

  /** Sorts transactions by amount in ascending order. */
  public List<Transaction> sortTransactionsByAmount(List<Transaction> txList) {
    List<Transaction> sortedTransactions = txList.stream()
        .sorted(Comparator.comparingDouble(Transaction::getAmount))
        .collect(Collectors.toList());

    System.out.println("Sorting transactions by amount...");
    System.out.println(sortedTransactions);
    return sortedTransactions;
  }
}
