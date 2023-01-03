package org.example.chapter4;

import java.util.Collections;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

/**
 * <h1>5. K번째 큰 수</h1>
 */
public class FindNBiggest {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] numbers = new int[n];
        for (int i = 0; i < n; i++) {
            numbers[i] = sc.nextInt();
        }

        System.out.println(solution(numbers, k));
    }

    private static int solution(int[] numbers, int k) {

        Set<Integer> set = new TreeSet<>(Collections.reverseOrder());

        for (int f = 0; f < numbers.length; f++) {
            for (int s = f + 1; s < numbers.length; s++) {
                for (int t = s + 1; t < numbers.length; t++) {
                    set.add(numbers[f] + numbers[s] + numbers[t]);
                }
            }
        }

        int idx = 1;
        for (int x : set) {
            if (idx == k) return x;
            idx++;
        }
        return -1;
    }
}
