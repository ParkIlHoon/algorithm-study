package org.example.chapter7;

import java.util.Scanner;

public class Recursion {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
//        solution(sc.nextInt());
//        printBinary(11);
//        System.out.println(factorial(5));

        int f = 45;
        fibo = new int[f + 1];
        fibonacci(f);
        for (int i = 0; i <= f; i++) {
            System.out.print(fibo[i] + " ");
        }
    }

    private static void solution(int num) {
        if (num == 0) return;
        solution(num  - 1);
        System.out.println(num);
    }

    private static void printBinary(int num) {
        if (num == 0) return;
        printBinary(num / 2);
        System.out.print(num % 2);
    }

    private static int factorial(int num) {
        if (num == 1) {
            return 1;
        } else {
            return num * factorial(num - 1);
        }
    }

    private static int[] fibo;
    private static int fibonacci(int num) {
        if (fibo[num] > 0) return fibo[num];
        if (num == 1 || num == 2) {
            return fibo[num] = 1;
        } else {
            return fibo[num] = fibonacci(num - 2) + fibonacci(num - 1);
        }
    }
}
