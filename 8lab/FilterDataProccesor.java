import java.util.List;

public class FilterDataProccesor {

    @DataProcessor
    public static void filterNumbers(List<Integer> input, List<Integer> output) {
        output.addAll(input.stream().filter(num -> num > 5).toList());
        //возвращем число, если оно больше 5
    }
}
