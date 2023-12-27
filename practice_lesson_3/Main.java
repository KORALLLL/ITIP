import java.util.Arrays;
import java.lang.Math;

public class Main {
    public static void main(String[] args){
        System.out.println(replaceVovels("apple"));
        System.out.println(replaceVovels("Even if you did this task not by yourself, you have to understand every single line of code."));
        System.out.println("---------");
        
        System.out.println(stringTransform("hello"));
        System.out.println(stringTransform("bookkeeper"));
        System.out.println("------------");
        
        System.out.println(doesBlockFit(1, 3, 5, 4, 5));
        System.out.println(doesBlockFit(1, 8, 1, 1, 1));
        System.out.println(doesBlockFit(1, 2, 2, 1, 1));
        System.out.println("-----------");

        System.out.println(numCheck(243));
        System.out.println(numCheck(52));
        System.out.println("---------------");

        int[] arr={1, -3, 2};
        System.out.println(countRoots(arr));
        int[] arr1 ={5, 2, 2};
        System.out.println(countRoots(arr1));
        int[] arr2 = {1, -6, 9};
        System.out.println(countRoots(arr2));
        System.out.println("---------");

        String[][] data1 = {
            {"Apple", "Shop1", "Shop2", "Shop3", "Shop4"},
            {"Banana", "Shop2", "Shop3", "Shop4"},
            {"Orange", "Shop1", "Shop3", "Shop4"},
            {"Pear", "Shop2", "Shop4"}
        };
        String[][] data2 ={{"Fridge", "Shop2", "Shop3"},
            {"Microwave", "Shop1", "Shop2", "Shop3", "Shop4"},
            {"Laptop", "Shop3", "Shop4"},
            {"Phone", "Shop1", "Shop2", "Shop3", "Shop4"}
        };
        System.out.println(Arrays.toString(salesData(data1)));
        System.out.println(Arrays.toString(salesData(data2)));
        System.out.println("---------");

        System.out.println(validSplit("apple eagle egg goat"));
        System.out.println(validSplit("cat dog goose fish"));
        System.out.println("--------");

        int[] wf1 = {3, 1, 4, 2, 7, 5};
        int[] wf2 = {1, 2, 3, 4, 5};
        int[] wf3 = {1, 2, -6, 10, 3};
        System.out.println(waveForm(wf1));
        System.out.println(waveForm(wf2));
        System.out.println(waveForm(wf3));
        System.out.println("-------");

        System.out.println(commonVovel("Hello world"));
        System.out.println(commonVovel("Actions speak louder than words."));
        System.out.println("-----------");

        int[][] ds1 = {
            {1, 2, 3, 4, 5},
            {6, 7, 8, 9, 10},
            {5, 5, 5, 5, 5},
            {7, 4, 3, 14, 2},
            {1, 0, 11, 10, 1}
            };
        
        int[][] arrds1 = dataScience(ds1);
        for (int i=0; i<ds1.length; i++){
            for (int j=0; j<ds1.length; j++){
                System.out.print(arrds1[i][j] + " ");
            }
            System.out.println("");
        }
        System.out.println("");
        int[][] ds2 = {
            {6, 4, 19, 0, 0},
            {81, 25, 3, 1, 17},
            {48, 12, 60, 32, 14},
            {91, 47, 16, 65, 217},
            {5, 73, 0, 4, 21}
        };
        int[][] arrds2 = dataScience(ds2);
        for (int i=0; i<ds2.length; i++){
            for (int j=0; j<ds2.length; j++){
                System.out.print(arrds2[i][j]+ " ");
            }
            System.out.println("");
        }
    }

    public static String replaceVovels(String str){
        String tempStr = "";
        String vovels = "aeyuoiIAEYUO";
        for (int i=0; i<str.length(); i++){
            if (vovels.contains(String.valueOf(str.charAt(i)))){
                tempStr += "*";
            }
            else{
                tempStr += str.charAt(i);
            }
        }
        return tempStr;
    }

    public static String stringTransform(String str){
        str+=" ";
        String newStr = "";
        int flag = 0;
        for (int i=0; i<str.length()-1; i++){
            if (flag==0){
                String symbol1 = String.valueOf(str.charAt(i));
                String symbol2 = String.valueOf(str.charAt(i+1));
                if (symbol1.equals(symbol2)){
                    flag = 1;
                    newStr += "Double" + symbol1.toUpperCase();
                }
                else{
                    newStr += symbol1;
                }
            }
            else{
                flag = 0;
            }
        }
        return newStr;
    }

    public static boolean doesBlockFit(int a, int b, int c, int w, int h){
        int maxim = Math.max(Math.max(a,b), c);
        int minim = Math.min(Math.min(a,b),c);
        int middle = a+b+c - maxim - minim;

        if (minim<=Math.min(w,h) & middle<=Math.max(w, h)){
            return true;
        }
        else{return false;}
        
    }

    public static boolean numCheck(int num){
        String strNum = "" + num;
        int squares = 0;
        for (int i=0; i<strNum.length(); i++){
            squares += Integer.parseInt(String.valueOf(strNum.charAt(i)));
        }
        if ((squares %2) == (num%2)){
            return true;
        }
        else{
            return false;
        }
    }

    public static int countRoots(int[] arr){
        if (arr.length!=3){
            return -1;
        }
        int a = arr[0];
        int b = arr[1];
        int c = arr[2];
        if (a==0){
            if (b!=0){
                if (c%b==0){
                    return 1;
                }
                else{
                    return 0;
                }
            }
            else{
                return 0;
            }
        }
        else{
            double d = b * b - 4 * a * c;
            if (d < 0){
                return 0;
            }
            else if (d == 0){
                return 1;
            }
            else{
                double x1 = (-b - Math.pow(d, 0.5))/2/a;
                double x2 = (-b + Math.pow(d, 0.5))/2/a;
                int check1 = (int) x1;
                int check2 = (int) x2;
                int cnt = 0;
                if ((x1 == (double) check1)){
                    cnt++;}
                if ((x2 == (double) check2)){
                    cnt++;
                }
                return cnt;
                
            }
        }
    }

    public static String[] salesData(String[][] arr){
        String[] shops = new String[10];
        for (int supply=0; supply<arr.length; supply++){ //iteration by input array
            for (int shop=1; shop<arr[supply].length; shop++){ //iteraration by shops in input array
                for (int i=0; i<10; i++){ //itaretion by shops in array of shops
                    if (shops[i]==null){
                        shops[i] = arr[supply][shop];
                        break;
                    }
                    else if (shops[i].equals(arr[supply][shop])){
                        break;
                    }
                }
            }
        }
        int countShops = 0;
        for (int i = 0; i<=10; i++){
            if (shops[i]==null){
                break;
            }
            else{
                countShops ++;
            }
        }
        String supplies = "";
        for (int i = 0; i<arr.length; i++){
            if ((arr[i].length - 1)==countShops){
                supplies+= arr[i][0] + " ";
            }
        }
        return supplies.split(" ");
    }

    // public static boolean validSplit(String sentence){
    //     String[] words = sentence.split(" "); //array of all words
    //     boolean[] used = new boolean[words.length]; //traccking used words for reccurent function

    //     return backtrack(words, used, 0, "");
    // }

    // public static boolean backtrack(String[] words,boolean[] used, int count, String lastLetter){
    //     if (count == words.length){return true;} 
    //     for (int i=0; i<words.length; i++){
    //         if (!used[i] & words[i].startsWith(lastLetter)){
    //             used[i] = true;
    //             String nextLetter = words[i].substring(words[i].length()-1);

    //             if (backtrack(words, used, count + 1, nextLetter)){
    //                 return true;
    //             }
                
    //             used[i] = false;
    //         }
    //     }
    //     return false;
    // }

    public static boolean validSplit(String sentence){
        String alphabet = "qwertyuiopasdfghjklzxcvbnm";
        String ending = "";
        String begining = "";
        String[] newSec = sentence.toLowerCase().split(" ");

        for (int i =0; i<newSec.length; i++){
            begining+= String.valueOf(newSec[i].charAt(0));
            ending += String.valueOf(newSec[i].charAt(newSec[i].length() - 1));
        }

        int difference = 0;

        for (int letter=0; letter<26; letter++){
            int currDiff = 0;
            for (int letStart = 0; letStart<newSec.length; letStart++){
                if (begining.charAt(letStart) == alphabet.charAt(letter)){
                    currDiff++;
                }
                if (ending.charAt(letStart) == alphabet.charAt(letter)){
                    currDiff--;
                }
            }
            difference += Math.abs(currDiff);
            if (difference>2){
                return false;
            }
        }
        return true;
    }


    public static boolean waveForm(int[] arr){
        boolean flag;
        if (arr[0]>arr[1]){
            flag = true; //flag of alternation
        }
        else if (arr[0]<arr[1]){
            flag = false;
        }
        else{
            return false;
        }
        for (int i=1; i<arr.length-1; i++){
            if ((arr[i]>arr[i-1]) & (flag==false)){
                flag = true;
            }
            else if ((arr[i]<arr[i-1]) & (flag==true)){
                flag = false;
            }
            else{
                return false;
            }
        }
        return true;
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

    public static int[][] dataScience(int[][] arr){
        int n = arr.length;
        int[] avg = new int[n];
        double temp = 0;

        for (int i=0; i<n; i++){
            temp = 0;
            for (int j=0; j<n; j++){
                if (i!=j){
                    temp += arr[j][i];
                    // System.out.printf("%s %s %s\n", j,i, arr[j][i]);
                }
            }
            
            temp /= (n-1);
            temp = Math.round(temp);
            // System.out.println(temp);
            avg[i] = (int) temp;
            
        }

        for (int i=0; i<n; i++){
            arr[i][i] = avg[i];
        }
        return arr;
    }
   
}

