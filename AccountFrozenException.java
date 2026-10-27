/**
 * Indicates that an operation was attempted on a frozen account.
 */
public class AccountFrozenException extends Exception {
  private final String message;

  /**
   * Creates a frozen account exception with the given message.
   *
   * @param message the error message
   */
  public AccountFrozenException(String message) {
    this.message = message;
  }

  @Override
  public String getMessage() {
    return message;
  }
}
