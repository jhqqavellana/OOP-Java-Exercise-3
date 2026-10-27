/**
 * Exception thrown when an amount is invalid.
 */
public class InvalidAmountException extends Exception {
  private final String message;

  /**
   * Creates an invalid amount exception with the given message.
   *
   * @param message the error message
   */
  public InvalidAmountException(String message) {
    this.message = message;
  }

  @Override
  public String getMessage() {
    return message;
  }
}