import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;

public class Main {
    public static void main(String[] args){
        System.out.println(nonRepeatable("abracadabra"));
        System.out.println(nonRepeatable("paparazzi"));
        System.out.println("-----------");
        System.out.println(generateBrackets(1));
        System.out.println(generateBrackets(2));
        System.out.println(generateBrackets(3));
        System.out.println("------");
        System.out.println(binarySystem(3));
        System.out.println(binarySystem(4));
        System.out.println("----------");
        System.out.println(alphabeticRow("abcdjuwx"));
        System.out.println(alphabeticRow("klmabzyxw"));
        System.out.println("------");
        System.out.println(countSymbols("aaabbcdd"));
        System.out.println(countSymbols("vvvvaajaaaaa"));
        System.out.println("--------");
        System.out.println(convertToNum("eight") );
        System.out.println(convertToNum("five hundred sixty seven"));
        System.out.println(convertToNum("thirty one"));
        System.out.println("-----------");
        System.out.println(uniqueSubstring("123412324"));
        System.out.println(uniqueSubstring("111111"));
        System.out.println(uniqueSubstring("77897898"));
        System.out.println("---------");
        int[][] data1 = {{1, 3, 1},{1, 5, 1},{4, 2, 1}};
        int[][] data2 = {{2, 7, 3},{1, 4, 8}, {4, 5, 9}};
        System.out.println(shortestWay(data1));
        System.out.println(shortestWay(data2));
        System.out.println("---------");
        System.out.println(numericOrder("t3o the5m 1One all6 r4ule ri2ng"));
        System.out.println(numericOrder("re6sponsibility Wit1h gr5eat power3 4comes g2reat"));
        System.out.println("------");
        System.out.println(switchNums(519, 723));
        System.out.println(switchNums(491, 3912));
        System.out.println(switchNums(6274, 71259));
        System.out.println("---------");
    }

    public static String nonRepeatable(String str){
        if (str.length() <=1){
            return str;
        }
        
        char first = str.charAt(0);

        String remaining = str.substring(1).replaceAll(String.valueOf(first), "");

        String result = nonRepeatable(remaining);

        return first+result;
    }

    public static List<String> generateBrackets(int n){
        List<String> result = new ArrayList<>();
        generateBr(result, 0,0,"", n);
        return result;
        
    }

    public static void generateBr(List<String> s, int openCount, int closeCount,String current, int n){
        if (current.length()==n*2){
            s.add(current);
            return;
        }

        if (openCount < n){
            generateBr(s, openCount+1, closeCount, current+"(", n);
        }

        if (closeCount< openCount){
            generateBr(s, openCount, closeCount+1, current+")", n);
        }
    }

    public static List<String> binarySystem(int n){
        List<String> result = new ArrayList<>();
        generateBs(result, false ,"", n);
        return result;
        
    }

    public static void generateBs(List<String> s, boolean previosZero, String current, int n){
        if (current.length()==n){
            s.add(current);
            return;
        }

        if (previosZero){
            generateBs(s, false, current+"1", n);}
        else{
            generateBs(s, true, current+"0", n);
            generateBs(s, false, current+"1", n);
        }
    }                                                                                       

    public static String alphabeticRow(String row){
        String curr = "";
        char[] myRow = row.toCharArray();
        String tempCurrUp = String.valueOf(myRow[0]);
        String tempCurrDown = String.valueOf(myRow[0]);
        for (int i = 1; i<myRow.length; i++){
            if (myRow[i] - myRow[i-1] == 1){
                tempCurrUp += String.valueOf(myRow[i]);
                
            }
            else{
                if (tempCurrUp.length() > curr.length()){
                    curr = tempCurrUp;
                }
                tempCurrUp = String.valueOf(myRow[i]);
            }
            if (myRow[i-1] - myRow[i] == 1){
                tempCurrDown += String.valueOf(myRow[i]);
                
            }
            else{
                if (tempCurrDown.length() > curr.length()){
                    curr = tempCurrDown;
                }
                tempCurrDown = String.valueOf(myRow[i]);
            }
            
        }
        if (tempCurrUp.length() > curr.length()){
            curr = tempCurrUp;
        }
        if (tempCurrDown.length() > curr.length()){
            curr = tempCurrDown;
        }
        return curr;
    }

     public static String countSymbols(String s){
        char[] seq = s.toCharArray();
        List<String> result = new ArrayList<>();
        char start = seq[0];
        int counter = 1;
        for (int i =1; i<seq.length; i++){
            if (seq[i]==seq[i-1]){
                counter++;
            }
            else{
                result.add(String.valueOf(start)+counter);
                counter = 1;
                start = seq[i];

            }
            
        }
        if (counter>1){
            result.add(String.valueOf(start)+counter);
        }
        String newResult = "";
        while (result.size()!=0){
            int minm = Integer.MAX_VALUE; // const max value -------------------------------------------------------------
            String elem = "";
            for (int i = 0; i<result.size(); i++){
                String curr = result.get(i);
                int num = Integer.parseInt(curr.substring(1));
                if (num<minm){
                    minm = num;
                    elem = curr;
                }
            }
            result.remove(elem);
            newResult+=elem;
        }
        return newResult;
    }

    public static int convertToNum(String number){
        HashMap<String, Integer> converter = new HashMap<>();
        converter.put("zero", 0);
        converter.put("one", 1);
        converter.put("two", 2);
        converter.put("three", 3);
        converter.put("four", 4);
        converter.put("five", 5);
        converter.put("six", 6);
        converter.put("seven", 7);
        converter.put("eight", 8);
        converter.put("nine", 9);
        converter.put("ten", 10);
        converter.put("elevelen", 11);
        converter.put("twelve", 12);
        converter.put("thirteen", 13);
        converter.put("fourteen", 14);
        converter.put("fifteen", 15);
        converter.put("sixteen", 16);
        converter.put("seventeen", 17);
        converter.put("eighteen", 18);
        converter.put("nineteen", 19);
        converter.put("twenty", 20);
        converter.put("thirty", 30);
        converter.put("fourty", 40);
        converter.put("fifty", 50);
        converter.put("sixty", 60);
        converter.put("sevety", 70);
        converter.put("eighty", 80);
        converter.put("ninety", 90);

        int currentNumber = 0;
        String[] words = number.split(" ");
        for (String word: words){
            if (converter.containsKey(word)){
                currentNumber += converter.get(word);
            }
            else if (word.equals("hundred")){
                currentNumber *=100;
            }
        }

        return currentNumber;
    }

    public static String uniqueSubstring(String seq){
        String result = "";
        String tempResult = "";
        for (char a: seq.toCharArray()){
            if (!tempResult.contains(String.valueOf(a))){
                tempResult += String.valueOf(a);
            }
            else{
                if (result.length()<tempResult.length()){
                    result = tempResult;
                }
                tempResult = String.valueOf(a);
            }
        }
        return tempResult.length() > result.length() ? tempResult : result;
    }

    public static int shortestWay(int[][] arr){
        int[][] temp = new int[arr.length][arr[0].length];
        for (int i=0; i<arr.length; i++){
            for (int j=0; j<arr[0].length; j++){
                if (i==0 & j ==0){
                    temp[i][j] = arr[i][j];
                }
                else if (i==0){
                    temp[i][j] = temp[i][j-1] + arr[i][j];
                }
                else if (j==0){
                    temp[i][j] = temp[i-1][j] + arr[i][j];
                }
                else{
                    temp[i][j] = temp[i-1][j]<temp[i][j-1] ? temp[i-1][j] : temp[i][j-1];
                    temp[i][j] += arr[i][j];
                }
            }
        }
        return temp[arr.length - 1][arr[0].length - 1];
    }

    public static String numericOrder(String seq){
        String[] arrSeq = seq.split(" ");
        String[] result = new String[arrSeq.length];
        char[] nums = "1234567890".toCharArray();

        for (String word : arrSeq){
            for (char num:nums){
                if (word.contains(String.valueOf(num))){
                    int currNum = Integer.parseInt(String.valueOf(num)) - 1;
                    int idx = word.indexOf(String.valueOf(num));
                    result[currNum] = word.substring(0, idx) + word.substring(idx+1);
                    break;
                }
            }
        }
        // String s = "";
        // for (int i = 0; i<result.length; i++){
        //     s+=result[i]+ " ";
        // }
        return String.join(" ", result); // join --------------------------------------------------------------------------------
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
        // String result = "";
        // for (char num : num2){
        //     result += String.valueOf(num); //join------------------------------------------------------------
        // }
        return String.valueOf(num2);
    }
}

