public class CustomNumberFormatException extends Exception{
    public CustomNumberFormatException(String message){
        super(message);
    }
}
// при бросании этого исключения можно сделать поясняющее сообщение