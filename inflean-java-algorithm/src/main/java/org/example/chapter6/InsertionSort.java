package org.example.chapter6;

import java.util.Scanner;

public class InsertionSort {

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
        for (int i = 1; i < numbers.length; i++) {
            int k = numbers[i];
            int j;

            for(j = i-1; j >= 0 && numbers[j] > k; j--){
                numbers[j+1] = numbers[j];
            }

            numbers[j + 1] = k;
        }

        StringBuilder sb = new StringBuilder();
        for (int i : numbers) {
            sb.append(i).append(" ");
        }
        return sb.toString();
    }
}
