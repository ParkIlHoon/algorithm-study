package org.example.chapter3;

import java.util.Arrays;
import java.util.Scanner;

/**
 * <h1>2. 공통원소 구하기</h1>
 * A, B 두 개의 집합이 주어지면 두 집합의 공통 원소를 추출하여 오름차순으로 출력하는 프로그램을 작성하세요.
 *
 * <ul>
 *     <li>입력 :
 *          <pre>{@code 5}</pre>
 *          <pre>{@code 1 3 9 5 2}</pre>
 *          <pre>{@code 5}</pre>
 *          <pre>{@code 3 2 5 7 8}</pre>
 *     </li>
 *
 *     <li>출력 :
 *          <pre>{@code 2 3 5}</pre>
 *     </li>
 * </ul>
 */
public class GetCommonElements {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int firstLength = sc.nextInt();
        int[] first = new int[firstLength];
        for (int i = 0; i < firstLength; i++) {
            first[i] = sc.nextInt();
        }

        int secondLength = sc.nextInt();
        int[] second = new int[secondLength];
        for (int i = 0; i < secondLength; i++) {
            second[i] = sc.nextInt();
        }

        System.out.println(solution(first, second));
    }

    private static String solution(int[] first, int[] second) {
        StringBuilder sb = new StringBuilder();

        Arrays.sort(first);
        Arrays.sort(second);

        int fpos = 0;
        int spos = 0;

        while (fpos < first.length && spos < second.length) {
            int f = first[fpos];
            int s = second[spos];

            if (f > s) {
                spos++;
            } else if (f < s) {
                fpos++;
            } else {
                sb.append(f).append(" ");
                fpos++;
                spos++;
            }
        }
        return sb.toString();
    }

}
