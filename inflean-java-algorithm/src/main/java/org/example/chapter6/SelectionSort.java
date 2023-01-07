package org.example.chapter6;

import java.util.Scanner;

public class SelectionSort {

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
        for (int i = 0; i < numbers.length; i++) {
            int leastIndex = i;

            for (int j = i + 1; j < numbers.length; j++) {
                if (numbers[leastIndex] > numbers[j]) {
                    leastIndex = j;
                }
            }

            if (i != leastIndex) {
                int tmp = numbers[i];
                numbers[i] = numbers[leastIndex];
                numbers[leastIndex] = tmp;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i : numbers) {
            sb.append(i).append(" ");
        }

        return sb.toString();
    }

}
