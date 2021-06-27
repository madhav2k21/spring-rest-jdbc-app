package com.spring.jdbc.app.common;

public class PrimeNums {
    public static void main(String[] args) {
        int start = 1;
        int end = 50;
        for (int num = start; num <= end; num++) {
            if (isPrime(num)) {
                System.out.println(num + " is a prime number");
            }
        }
    }
    public static boolean isPrime(int num) {
        return num == 2 ? true : (num <= 1 || num % 2 == 0) ? false : checkOddCondition(num);
    }
    private static boolean checkOddCondition(int num) {
        for (int i = 3; i <= Math.sqrt(num); i += 2) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }
}
