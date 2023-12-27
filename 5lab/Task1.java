import java.util.regex.*;

public class Task1 {
    public static void main(String[] args) {
        String text = "е23 The 43о43 price is $-25.99 and the quantity is 10. The total is $259.90.";
        // Текст для анализа
        Pattern pattern = Pattern.compile("-?\\b?\\d+(\\.\\d+)?\\b");
        // \\b - граница слова, то есть мы обозначаем начало ряда цифр
        // \\d+ одна или несколько цифр
        // (\\.\\d+)? десятичная часть числа может быть, а может и не быть
        // \\b граница цифрового ряда
        Matcher matcher = pattern.matcher(text);
        while (matcher.find()) {
            System.out.println(matcher.group());
        }
        }
}
