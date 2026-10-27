/**
 * Exception thrown when an account has insufficient funds.
 */
public class InsufficientFundsException extends Exception {
  private final String message;

  /**
   * Creates an insufficient funds exception with the given message.
   *
   * @param message the error message
   */
  public InsufficientFundsException(String message) {
    this.message = message;
  }

  @Override
  public String getMessage() {
    return message;
  }
}
