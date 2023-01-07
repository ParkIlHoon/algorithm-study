package org.example.chapter6;

import java.util.Arrays;
import java.util.Scanner;

public class BisectionSearch {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int cnt = sc.nextInt();
        int target = sc.nextInt();
        int[] numbers = new int[cnt];
        for (int i = 0; i < cnt; i++) {
            numbers[i] = sc.nextInt();
        }

        System.out.println(solution(numbers, target));
    }

    private static int solution(int[] numbers, int target) {
        int result = -1;

        int pos = 0;
        int addition = numbers.length / 2;
        boolean n = numbers.length % 2 > 0;

        Arrays.sort(numbers);

        for (;pos + addition < numbers.length; pos++) {
            if (numbers[pos] == target) return pos + 1;
            if (numbers[pos + addition] == target) return pos + addition + 1;
        }

        if (n && numbers[pos + addition] == target) {
            return pos + addition + 1;
        }

        return result;
    }
}
