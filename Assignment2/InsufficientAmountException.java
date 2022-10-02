public class InsufficientAmountException extends Exception{
    public InsufficientAmountException(String errorMessage){
        System.out.println(errorMessage);
    }
}
