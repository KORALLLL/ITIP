import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;

public class draft {
    public static void main(String[] args){
        System.out.println(switchNums(519, 723));
        System.out.println(switchNums(491, 3912));
        System.out.println(switchNums(6274, 71259));
    }

    public static String switchNums(int a, int b){
        char[] num1 = ("" +a).toCharArray();
        char[] num2 = ("" + b).toCharArray();

        for (int j = 0; j<num1.length; j++){
            char maxm = '0';
            int idx = -1;
            for (int i = 0; i<num1.length; i++){
                if (maxm<num1[i]){
                    maxm = num1[i];
                    idx = i;
                }
            }
            for (int i=0; i<num2.length; i++){
                if (num2[i]<maxm){
                    num2[i] = maxm;
                    break;
                }
            }
            if (idx!=-1){
                num1[idx] = '0';}
        }
        String result = "";
        for (char num : num2){
            result += String.valueOf(num);
        }
        return result;
    }

    
    
}
