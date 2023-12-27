public class Draft {
    public static void main(String[] args) {
        System.out.println(commonVovel("Hello world"));
        System.out.println(commonVovel("Actions speak louder than words."));
    }

    public static char commonVovel(String str){
        int[] counts = new int[26];

        str = str.toLowerCase();

        for (char c: str.toCharArray()){
            if ("aioeyu".indexOf(c) != -1){
                counts[c - 'a'] ++;
            }
        }

        char mostCommonVovel = ' ';
        int maxCount = 0;

        for (char c: "aeyuio".toCharArray()){
            int count = counts[c-'a'];
            if (count>maxCount){
                maxCount = count;
                mostCommonVovel = c;
            }
        }

        return mostCommonVovel;
    
    }

    
}
