package org.example.chapter6;

import java.util.Scanner;

public class BubbleSort {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int cnt = sc.nextInt();
        int[] numbers = new int[cnt];
        for (int i = 0; i < cnt; i++) {
            numbers[i] = sc.nextInt();
        }

        System.out.println(solution(numbers));
    }

    private static String solution(int[] numbers) {

        for (int i = numbers.length-1  ; i > 0 ; i--) {
            for (int j = 0 ; j < i; j++) {
                if (numbers[j] > numbers[j+1]) {
                    int tmp = numbers[j];
                    numbers[j] = numbers[j+1];
                    numbers[j+1] = tmp;
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i : numbers) {
            sb.append(i).append(" ");
        }
        return sb.toString();
    }
}
