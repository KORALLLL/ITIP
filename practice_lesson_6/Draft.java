import java.util.ArrayList;
import java.util.Arrays;

public class Draft{
    public static void main(String[] args) {
        System.out.println(generateNonconsecutive("3 + 5 * (2 - 6)")); //-17
        System.out.println(generateNonconsecutive("6 - 18 / (-1 + 4)")); //0
        System.out.println(generateNonconsecutive("2 + 3 * 4")); //14
        // System.out.println(generateNonconsecutive("10 / 0")); //div by zero 
        // System.out.println(generateNonconsecutive("4 * 3 / (6 - 4) +")); // superfluous operation
        // System.out.println(generateNonconsecutive("((2 + 3) * 4")); //error brackets
        // System.out.println(generateNonconsecutive("7 / 2.5")); //2.8
        // System.out.println(generateNonconsecutive("2 + abc * 3")); //incorrect symbol
        // System.out.println(generateNonconsecutive("5 + * 2")); //incorrect operands
        // System.out.println(generateNonconsecutive("5 + / 2")); //incorrect operands
        // System.out.println(generateNonconsecutive("-5-(-3)")); //-2
        // System.out.println(generateNonconsecutive("-3*-7")); //21
        System.out.println(generateNonconsecutive("(((-8)))")); //-8
        System.out.println(generateNonconsecutive("2.5*2.5")); //6.25
        // System.out.println(generateNonconsecutive("2.5/2.5")); //1
        // System.out.println(generateNonconsecutive("2.5+2.5")); //5
        // System.out.println(generateNonconsecutive("2.5-2.5")); //0
        System.out.println(generateNonconsecutive("7/3*4")); //9.333
        System.out.println(generateNonconsecutive("5*2/3")); //3.3333
        System.out.println(generateNonconsecutive("5-2+3")); //6
    }
    
    public static String generateNonconsecutive(String str) {
            str = str.replaceAll("\\(", "( ").replaceAll("\\)", " )");
            String[] array = str.split(" ");
            ArrayList<String> list = new ArrayList<>(Arrays.asList(array));
            list = generateNonList(list);
            return String.valueOf(list.get(0));
        }

    private static ArrayList<String> generateNonList(ArrayList<String> list) {
        boolean flag = false;
        ArrayList<String> subList = new ArrayList<>();
        int first = 0;
        int last;
        while (list.contains("(")) {
            for (int i = 1; i <= list.size(); i++) {
                if (list.get(i-1).equals("(")) {
                    first = i;
                    flag = true;
                    subList = new ArrayList<>();
                }
                if (list.get(i).equals(")")) {
                    last = i - 1;
                    replaceSubList(list, generateNonList(subList).get(0), first, last);
                    flag = false;
                }
                if (flag) {
                    subList.add(list.get(i));
                }
            }
        }
        if (list.contains("*")) {
            countBySign(list, "*");
        }
        if (list.contains("/")) {
            countBySign(list, "/");
        }
        if (list.contains("+")) {
            countBySign(list, "+");
        }
        if (list.contains("-")) {
            countBySign(list, "-");
        }
        return list;
    }
    private static void replaceSubList(ArrayList<String> list, String replaceStr, int firstInd, int lastInd) {
        for (int i = firstInd - 1; i < lastInd; i++) {
            list.remove(firstInd);
        }
        list.set(firstInd - 1, replaceStr);
    }

    private static void countBySign(ArrayList<String> list, String ch) {
        while (list.contains(String.valueOf(ch))) {
            int index = list.indexOf(ch);
            int first = Integer.parseInt(list.get(index - 1));
            int second = Integer.parseInt(list.get(index + 1));
            if (ch.equals("*")) {
                replaceSubList(list, String.valueOf(first * second), index, index);
            } else if (ch.equals("/")) {
                replaceSubList(list, String.valueOf(first / second), index, index);
            } else if (ch.equals("+")) {
                replaceSubList(list, String.valueOf(first + second), index, index);
            } else if (ch.equals("-")) {
                replaceSubList(list, String.valueOf(first - second), index, index);
            }

        }
}
}