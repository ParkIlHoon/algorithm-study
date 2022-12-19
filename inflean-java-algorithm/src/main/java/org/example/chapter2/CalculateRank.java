package org.example.chapter2;

import java.util.Scanner;

/**
 * <h1>8. 등수구하기</h1>
 * N명의 학생의 점수가 입력되면 각 학생의 등수를 입력된 순서대로 출력하는 프로그램을 작성하세요.
 * 같은 점수가 입력될 경우 높은 등수로 동일 처리한다.
 *
 * <ul>
 *     <li>입력 :
 *          <pre>{@code 5}</pre>
 *          <pre>{@code 87 89 92 100 76}</pre>
 *     </li>
 *
 *     <li>출력 :
 *          <pre>{@code 4 3 2 1 5}</pre>
 *     </li>
 * </ul>
 */
public class CalculateRank {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int length = sc.nextInt();
        int[] input = new int[length];
        for (int i = 0; i < length; i++) {
            input[i] = sc.nextInt();
        }
        System.out.println(solution(input));
    }

    private static String solution(int[] input) {
        int[] result = new int[input.length];

        for (int i = 0; i < input.length; i++) {
            int cnt = 1;
            for (int k : input) {
                if (input[i] < k) {
                    cnt++;
                }
            }

            result[i] += cnt;
        }

        StringBuilder sb = new StringBuilder();
        for (int j : result) {
            sb.append(j).append(" ");
        }
        return sb.toString();
    }

}
