package org.example.chapter2;

import java.util.Scanner;

/**
 * <h1>10. 봉우리</h1>
 * 각 격자판의 숫자 중 자신의 상하좌우 숫자보다 큰 숫자는 봉우리 지역입니다. 봉우리 지역이 몇 개 있는 지 알아내는 프로그램을 작성하세요.
 * 격자의 가장자리는 0으로 초기화 되었다고 가정한다.
 *
 * <ul>
 *     <li>입력 :
 *          <pre>{@code 5}</pre>
 *          <pre>{@code 5 3 7 2 3}</pre>
 *          <pre>{@code 3 7 1 6 1}</pre>
 *          <pre>{@code 7 2 5 3 4}</pre>
 *          <pre>{@code 4 3 6 4 1}</pre>
 *          <pre>{@code 8 7 3 5 2}</pre>
 *     </li>
 *
 *     <li>출력 :
 *          <pre>{@code 155}</pre>
 *     </li>
 * </ul>
 */
public class Peak {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int length = sc.nextInt();
        int[][] input = new int[length][length];
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                input[i][j] = sc.nextInt();
            }
        }
        System.out.println(solution(length, input));
    }

    private static int solution(int size, int[][] input) {
        int result = 0;

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                int now = input[i][j];

                int w = (i == 0)? 0 : input[i - 1][j];
                int a = (j == 0)? 0 : input[i][j - 1];
                int s = (i + 1 == size)? 0 : input[i + 1][j];
                int d = (j + 1 == size)? 0 : input[i][j + 1];

                if (now > w && now > a && now > s && now > d) result++;
            }
        }

        return result;
    }

}
