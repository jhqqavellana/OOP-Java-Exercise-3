/**
 * Represents a savings account with owner details.
 */
public class SavingsAccount extends BankAccount {
  /**
   * Creates a savings account for the given owner.
   *
   * @param ownerName the owner's name
   */
  public SavingsAccount(String ownerName) {
    super(ownerName);
    System.out.println("Savings Account Name: " + getOwnerName());
  }
}
