//Создайте программу, которая находит и выводит все
//простые числа меньше 100.

import java.lang.Math;

public class Primes {
    public static void main(String[] args){
        for (int i = 2; i<=100; i++){
            if (isPrime(i)){
                System.out.println(i);
            }
        }
    }

    public static boolean isPrime(double n){
        if (n<2){
            return false;
        }
        int end = (int) Math.pow(n, 0.5);
        for (int i = 2; i<=end; i++){
            if (n%i==0){
                return false;
            }
        }
        return true;
    }
}