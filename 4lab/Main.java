public class Main {
    public static void main(String[] args){
        String input = "123qwe";
        String input1 = "1234";

        ExceptionLogger logger = new ExceptionLogger("log.txt");

        try{
            int number = parseInt(input);
            System.out.println(" " + number);
        }
        catch (CustomNumberFormatException e){
            logger.logException(e);
            System.out.println("Ошибка форматирования: " + e.getMessage());
        }

        try{
            int number = parseInt(input1);
            System.out.println("" + number);
        }
        catch (CustomNumberFormatException e){
            logger.logException(e);
            System.out.println("Ошибка форматирования: " + e.getMessage());
        }
    }
    public static int parseInt(String str) throws CustomNumberFormatException {
        try {
            return Integer.parseInt(str);
        } catch (NumberFormatException e) {
            throw new CustomNumberFormatException("Строка не является числом: " + str);
        }
    }
}   
