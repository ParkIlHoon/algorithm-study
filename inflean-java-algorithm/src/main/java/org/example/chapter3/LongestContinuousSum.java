package org.example.chapter3;

import java.util.Scanner;

/**
 * <h1>6. 최대 길이 연속부분수열</h1>
 * 0과 1로 구성된 길이가 N인 수열이 주어집니다. 여러분은 이 수열에서 최대 k번을 0을 1로 변경할 수 있습니다. 여러분이 최대 k번의 변경을 통해 이 수열에서 1로만 구성된 최대 길이의 연속부분수열을 찾는 프로그램을 작성하세요.
 *
 * <ul>
 *     <li>입력 :
 *          <pre>{@code 14 2}</pre>
 *          <pre>{@code 1 1 0 0 1 1 0 1 1 0 1 1 0 1}</pre>
 *     </li>
 *
 *     <li>출력 :
 *          <pre>{@code 8}</pre>
 *     </li>
 * </ul>
 */
public class LongestContinuousSum {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int length = sc.nextInt();
        int chance = sc.nextInt();
        int[] arr = new int[length];
        for (int i = 0; i < length; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.println(solution(arr, chance));
    }

    private static int solution(int[] arr, int chance) {
        int result = 0;

        int begin = 0;
        int pos = 0;
        int length = 0;
        int maxLength = 0;
        int remainChance = chance;

        while (begin < arr.length) {

            if (pos >= arr.length) {
                if (length > maxLength) maxLength = length;
                begin++;
                pos = begin;
                remainChance = chance;
                length = 0;
                continue;
            }

            if (arr[pos] == 0) {
                if (remainChance > 0) {
                    remainChance--;
                    length++;
                    pos++;
                } else {
                    begin++;
                    pos = begin;
                    remainChance = chance;
                    if (length > maxLength) maxLength = length;
                    length = 0;
                }
            } else {
                length++;
                pos++;
            }

        }

        return maxLength;
    }

}
