import java.security.SecureRandom;
import java.util.Arrays;

public class Main {
    public static void main(String[] args){
        System.out.printf("%s %s\n",
            duplicateChars("Donalnd"),
            duplicateChars("orange"));

        System.out.println("-----------");

        System.out.printf("%s %s\n",
            getInitials("Ryan Gosling"),
            getInitials("Barack Obama"));

        System.out.println("--------------");

        int[] numbers1 = {44, 32, 86, 19};
        int[] numbers2 = {22, 50, 16, 63, 31, 55};
        System.out.printf("%s %s\n",
            differenceEvenOdd(numbers1),
            differenceEvenOdd(numbers2));
        System.out.println("----------");

        double[] numbers3 = {1,2,3,4,5};
        double[] numbers4 = {1,2,3,4,6};
        System.out.printf("%s %s\n",
            equalToAvg(numbers3),
            equalToAvg(numbers4));
        System.out.println("----------");

        int[] numbers5 = {1,2,3};
        int[] numbers6 = {3, 3, -2, 408, 3, 31};
        System.out.printf("%s %s\n",
            Arrays.toString(indexMult(numbers5)),
            Arrays.toString(indexMult(numbers6)));
        System.out.println("------");

        System.out.printf("%s\n%s\n",
            reverse("Hello World"),
            reverse("The quick brown fox."));
        System.out.println("-------");

        System.out.printf("%s %s\n",
            Tribonacci(7),
            Tribonacci(11));
        System.out.println("---------");

        System.out.println(pseudoHash(5));
        System.out.println(pseudoHash(10));
        System.out.println(pseudoHash(0));
        System.out.println("---------");

        System.out.println(botHelper("Hello, I’m under the water, please help me"));
        System.out.println(botHelper("Two pepperoni pizzas please"));
        System.out.println("--------");

        System.out.println(isAnagram("listen", "silent"));
        System.out.println(isAnagram("eleven plus two", "twelve plus one"));
        System.out.println(isAnagram("hello", "world"));
    }

    public static boolean duplicateChars(String str){
        str = str.toLowerCase(); //преобразование строки в нижний регистр
        boolean[] charSet = new boolean[256];

        //boolean[] создания массива
        //new выделение памяти для создания нового массива
        // boolean[256] создания массива с длиной 256

        for (int i=0; i<str.length(); i++){ // .length() метод для определения длины строки
            int charValue = str.charAt(i); //.charAt(i) метод для получения символа из строки по индексу
            if (charSet[charValue]){
                return true;
            }
            charSet[charValue] = true;
        }
        return false;
    }

    public static String getInitials(String names){
        String word[] = names.split(" ");
        String s1 = String.valueOf(word[0].charAt(0)); //String.valueOf - превращение символа в строку
        String s2 = String.valueOf(word[1].charAt(0));
        return s1+s2;
    }

    public static int differenceEvenOdd(int[] nums){
        int even = 0;
        int odd = 0;
        for (int i=0; i<nums.length; i++){
            if (nums[i]%2 ==0){
                even += nums[i];
            }
            else {
                odd += nums[i];
            }
        }
        if (even-odd>0){
            return even-odd;
        }
        else{
            return odd-even;
        }
    }

    public static boolean equalToAvg(double[] nums){
        double avg = 0;
        for (int i = 0; i<nums.length; i++){
            avg +=nums[i];
        }
        avg /= nums.length;

        for (int i=0; i<nums.length; i++){
            if (avg==nums[i]){
                return true;
            }
        }
        return false;
    }

    public static int[] indexMult(int[] arr){
        for (int i=0; i<arr.length; i++){
            arr[i] *= i;
        }
        return arr;
    }

    public static String reverse(String phrase){
        char[] char_of_phrase = phrase.toCharArray();

        StringBuilder new_phrase = new StringBuilder();

        for (int i= char_of_phrase.length - 1; i>=0; i--){
            new_phrase.append(char_of_phrase[i]);
        }
        return new_phrase.toString();
    }

    public static int Tribonacci(int num){
        if (num<1){
            return -1;
        }
        else if (num==1){
            return 0;
        }
        else if (num==2){
            return 0;
        }
        else if (num==3){
            return 1;
        }
        else{
            int[] seq = new int[num];
            seq[0] = 0;
            seq[1] = 0;
            seq[2] = 1;
            for (int i = 3; i<num; i++){
                seq[i] = seq[i-1] + seq[i-2] + seq[i-3];
            }
            return seq[num - 1];
        }
    }

    public static String pseudoHash(int len){
        if (len<=0){
            return "";
        }
        String chars = "1234567890abcdef";
        StringBuilder hash = new StringBuilder();
        SecureRandom rand = new SecureRandom();

        for (int i = 1; i<len+1; i++){
            int idx = rand.nextInt(chars.length());
            char chr = chars.charAt(idx);
            hash.append(chr);
        }
        return hash.toString();
   }

   public static String botHelper(String phrase){
        String[] words = phrase.toLowerCase().split(" ");
        for (int i=0; i<words.length; i++){
            if (words[i].equals("help")){
                return "Calling for a staff member";
            }
        
        }
        return "Keep waiting";
    }

    public static boolean isAnagram(String phrase1, String phrase2){
        phrase1 = phrase1.toLowerCase();
        phrase2 = phrase2.toLowerCase();

        if (phrase1.length() != phrase1.length()){
            return false;
        }

        int[] chars1 = new int[256];
        int[] chars2 = new int[256];
        Arrays.fill(chars1, 0);
        Arrays.fill(chars2, 0);

        for (int i=0; i<phrase1.length(); i++){
            int chVal1 = phrase1.charAt(i);
            int chVal2 = phrase2.charAt(i);
            chars1[chVal1] +=1;
            chars2[chVal2] +=1;
        }

        if (Arrays.equals(chars1, chars2)){
            return true;
        }
        else{
            return false;
        }
    }
}
