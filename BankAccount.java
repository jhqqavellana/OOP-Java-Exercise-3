import java.util.ArrayList;
import java.util.List;

/**
 * Represents a bank account with deposit, withdrawal, and freeze operations.
 */
public class BankAccount {
    private String ownerName;
    private double balance;
    private boolean isFrozen;
    private final List<Transaction> transactionHistory;

    /** Creates an account with a zero balance that is not frozen. */
    public BankAccount(String ownerName) {
      this.ownerName = ownerName;
      this.balance = 0;
      this.isFrozen = false;
      this.transactionHistory = new ArrayList<>();
    }

    /** Deposits the specified amount if the account is not frozen. */
    public void deposit(double amount) {
      if (isFrozen) {
        System.out.println("Account is FROZEN. Unable to transact.");
        return;
      }

      if (amount <= 0) {
        System.out.println("Amount deposited: " + amount);
        try {
          throw new InvalidAmountException(
              "Invalid amount. Must be greater than 0.");
        } catch (InvalidAmountException e) {
          System.out.println(e.getMessage());
        }
        return;
      }

      balance += amount;
      transactionHistory.add(new Transaction("Deposit", amount));
      System.out.printf("Current balance: %.2f%n", balance);
    }

    /** Withdraws the specified amount if the account is not frozen. */
    public void withdraw(double amount) {
      if (isFrozen) {
        try {
          throw new AccountFrozenException("Account is FROZEN. Unable to transact.");
        } catch (AccountFrozenException e) {
          System.out.println(e.getMessage());
        }
        return;
      }

      if (amount <= 0) {
        try {
          throw new InvalidAmountException("Invalid balance. Must be greater than 0");
        } catch (InvalidAmountException e) {
          System.out.println(e.getMessage());
        }
        return;
      }

      if (amount > balance) {
        try {
          throw new InsufficientFundsException("Insufficient Balance.");
        } catch (InsufficientFundsException e) {
          System.out.println(e.getMessage());
        }
        return;
      }

      balance -= amount;
      transactionHistory.add(new Transaction("Withdraw", amount));
    }

    /** Returns the current account balance. */
    public double getBalance() {
      return balance;
    }

    /** Returns the account owner's name. */
    public String getOwnerName() {
      return ownerName;
    }

    /** Updates the account owner's name. */
    public void setOwnerName(String ownerName) {
      this.ownerName = ownerName;
    }

    /** Returns the account transaction history. */
    public List<Transaction> getTransactionHistory() {
      return transactionHistory;
    }

    /** Freezes the account. */
    public void freezeAccount() {
      isFrozen = true;
      System.out.println("Account is now FROZEN.");
    }

    /** Unfreezes the account. */
    public void unfreezeAccount() {
      isFrozen = false;
      System.out.println("Account is now UNFROZEN.");
    }
}
