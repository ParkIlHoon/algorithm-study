package org.example.chapter7;

import java.util.Scanner;

public class Recursion {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
//        solution(sc.nextInt());
//        printBinary(11);
        System.out.println(factorial(5));
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
}
