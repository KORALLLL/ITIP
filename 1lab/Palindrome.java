public class Palindrome {
    public static void main(String[] args){
        for (int i = 0; i<args.length; i++){
            System.out.println(isPalindrome(args[i]));
            }
        }
    

    public static String reverseString(String Strings){
        String k = "";
        for (int i = Strings.length() -1; i>=0; i--){
            k += Strings.charAt(i);
        }
        return k;
    }

    public static boolean isPalindrome(String word){
        String reverse_word = reverseString(word);
        for (int i =0; i<word.length(); i++){
            if (word.charAt(i) != reverse_word.charAt(i)){
                return false;
            }
        }
        return true;
    }
}
