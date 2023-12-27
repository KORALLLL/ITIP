public class ArrayAverage {
    public static void main(String[] args) {
        String[] arr = {"1", "2", "3", "4", "symbol"};
        int sum = 0;
        int count = 0;

        try {
            for (int i = 0; i < arr.length; i++) {
                sum += Integer.parseInt(arr[i]);
                count++;
            }
            if (count == 0) {
                throw new ArithmeticException("Деление на ноль");
            }
            double average = (double) sum / count;
            System.out.println("Среднее арифметическое: " + average);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Выход за границы массива: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println("Неверные данные: " + e.getMessage());
        } catch (ArithmeticException e) {
            System.out.println("Ошибка при вычислении среднего: " + e.getMessage());
        }
    }
}
