/** Exception thrown when an account has insufficient funds. */
public class InsufficientFundsException extends Exception {
  String message;

  public InsufficientFundsException(String message){
    this.message = message;
  } 
  
  public String getMessage() {
    return message;
  }

}
