package org.example.chapter2;

import java.util.Scanner;

/**
 * <h1>11. 임시반장 정하기</h1>
 * 1학년부터 5학년까지 지내오면서 한번이라도 같은 반이었던 사람이 가장 많은 학생을 임시 반장으로 정하려 한다.
 * 각 학생들이 1학년부터 5학년까지 속했던 반이 주어질 때, 임시 반장을 정하는 프로그램을 작성하시오.
 *
 * <ul>
 *     <li>입력 :
 *          <pre>{@code 5}</pre>
 *          <pre>{@code 2 3 1 7 3}</pre>
 *          <pre>{@code 4 1 9 6 8}</pre>
 *          <pre>{@code 5 5 2 4 4}</pre>
 *          <pre>{@code 6 5 2 6 7}</pre>
 *          <pre>{@code 8 4 2 2 2}</pre>
 *     </li>
 *
 *     <li>출력 :
 *          <pre>{@code 4}</pre>
 *     </li>
 * </ul>
 */
public class SelectLeader {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int count = sc.nextInt();
        int[][] input = new int[count][5];
        for (int i = 0; i < count; i++) {
            for (int j = 0; j < 5; j++) {
                input[i][j] = sc.nextInt();
            }
        }
        System.out.println(solution(count, input));
    }

    private static int solution(int count, int[][] input) {
        int result = 0;
        int max = 0;

        for (int i = 0; i < count; i++) {
            int cnt = 0;
            for (int j = 0; j < 5; j++) {
                for (int k = 0; k < count; k++) {
                    if (j == k) continue;

                    if (input[i][k] == input[j][k]) {
                        cnt++;
                        break;
                    }
                }
            }
            if (cnt > max) {
                max = cnt;
                result = i;
            }
        }

        return result + 1;
    }

}
