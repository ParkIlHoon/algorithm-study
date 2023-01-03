package org.example.chapter2;

import java.util.Scanner;

/**
 * <h1>9. 격자판 최대합</h1>
 * N*N의 격자판이 주어지면 각 행의 합, 각 열의 합, 두 대각선의 합 중 가 장 큰 합을 출력합니다.
 *
 * <ul>
 *     <li>입력 :
 *          <pre>{@code 5}</pre>
 *          <pre>{@code 10 13 10 12 15}</pre>
 *          <pre>{@code 12 39 30 23 11}</pre>
 *          <pre>{@code 11 25 50 53 15}</pre>
 *          <pre>{@code 19 27 29 37 27}</pre>
 *          <pre>{@code 19 13 30 13 19}</pre>
 *     </li>
 *
 *     <li>출력 :
 *          <pre>{@code 155}</pre>
 *     </li>
 * </ul>
 */
public class GridMaximum {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int length = sc.nextInt();
        int[] input = new int[length * length];
        for (int i = 0; i < length * length; i++) {
            input[i] = sc.nextInt();
        }
        System.out.println(solution(length, input));
    }

    private static int solution(int size, int[] input) {
        int result = 0;

        int x = 0;  // 행
        int y = 0;  // 열
        int d1 = 0; // 대각(좌->우)
        int d2 = 0; // 대각(우->좌)

        for (int i = 0; i < size; i++) {
            x = 0;
            y = 0;

            for (int j = 0; j < size; j++) {
                x += input[i * size + j];
                y += input[i + size * j];
            }

            d1 += input[i * (size + 1)];
            d2 += input[i * (size - 1)];

            if (x > result) result = x;
            if (y > result) result = y;
            if (d1 > result) result = d1;
            if (d2 > result) result = d2;
        }

        return result;
    }

    private static int solution(int size, int[][] input) {
        int result = 0;

        int x = 0;  // 행
        int y = 0;  // 열
        int d1 = 0; // 대각(좌->우)
        int d2 = 0; // 대각(우->좌)

        for (int i = 0; i < size; i++) {
            x = 0;
            y = 0;

            for (int j = 0; j < size; j++) {
                x += input[i][j];
                y += input[j][i];
            }

            d1 += input[i][i];
            d2 += input[i][size - i - 1];

            result = Math.max(x, result);
            result = Math.max(y, result);
            result = Math.max(d1, result);
            result = Math.max(d2, result);
        }

        return result;
    }
}
