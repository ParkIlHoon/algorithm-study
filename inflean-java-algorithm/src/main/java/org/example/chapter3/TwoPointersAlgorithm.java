package org.example.chapter3;

import java.util.Scanner;

/**
 * <h1>1. 두 배열 합치기</h1>
 * 오름차순으로 정렬이 된 두 배열이 주어지면 두 배열을 오름차순으로 합쳐 출력하는 프로그램을 작성하세요.
 *
 * <ul>
 *     <li>입력 :
 *          <pre>{@code 3}</pre>
 *          <pre>{@code 1 3 5}</pre>
 *          <pre>{@code 5}</pre>
 *          <pre>{@code 2 3 6 7 9}</pre>
 *     </li>
 *
 *     <li>출력 :
 *          <pre>{@code 1 2 3 3 5 6 7 9}</pre>
 *     </li>
 * </ul>
 */
public class TwoPointersAlgorithm {

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

        int fpos = 0;
        int spos = 0;

        while (fpos < first.length || spos < second.length) {
            int f = (fpos >= first.length)? Integer.MAX_VALUE : first[fpos];
            int s = (spos >= second.length)? Integer.MAX_VALUE : second[spos];

            if (f > s) {
                sb.append(s).append(" ");
                spos++;
            } else if (f < s) {
                sb.append(f).append(" ");
                fpos++;
            } else {
                sb.append(f).append(" ").append(s).append(" ");
                fpos++;
                spos++;
            }
        }

        return sb.toString();
    }

}
