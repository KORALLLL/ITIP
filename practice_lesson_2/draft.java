import java.util.Arrays;

public class draft {
    public static void main(String[] args){
        System.out.println(isAnagram("hello", "world"));
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
