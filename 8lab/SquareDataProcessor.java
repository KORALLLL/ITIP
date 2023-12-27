import java.util.List;

public class SquareDataProcessor {

    @DataProcessor
    public static void squareNumbers(List<Integer> input, List<Integer> output) {
        output.addAll(input.stream().map(num -> num * num).toList());
        //возводим в квадрат.
    }
}
