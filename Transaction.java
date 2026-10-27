import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/** Represents a bank account transaction. */

public class Transaction {
  private static final DateTimeFormatter TIMESTAMP_FORMATTER =
      DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");

  private final String type;
  private final double amount;
  private final LocalDateTime dateTime;

  /**
   * Creates a transaction with the specified type and amount.
   *
   * @param type the transaction type
   * @param amount the transaction amount
   */

  public Transaction(String type, double amount) {
    this.type = type;
    this.amount = amount;
    this.dateTime = LocalDateTime.now();
  }

  /** Returns the transaction type. */
  public String getType() {
    return type;
  }

  /** Returns the transaction amount. */
  public double getAmount() {
    return amount;
  }

  /** Returns the transaction date and time. */
  public LocalDateTime getDateTime() {
    return dateTime;
  }

  /**
   * Returns a string representation of this transaction.
   *
   * @return a string representation of this transaction
   */
  @Override
  public String toString() {
    return "\nTransaction:{"
        + "type='"
        + type
        + '\''
        + ", amount="
        + amount
        + ", dateTime="
        + dateTime.format(TIMESTAMP_FORMATTER)
        + "}";
  }
}
