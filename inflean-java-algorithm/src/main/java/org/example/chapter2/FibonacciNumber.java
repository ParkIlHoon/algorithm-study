package org.example.chapter2;

import java.util.Scanner;

/**
 * <h1>4. 피보나치 수열</h1>
 * <ul>
 *     <li>입력 :
 *          <pre>{@code 10}</pre>
 *     </li>
 *
 *     <li>출력 :
 *          <pre>{@code 1 1 2 3 5 8 13 21 34 55}</pre>
 *     </li>
 * </ul>
 */
public class FibonacciNumber {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int length = sc.nextInt();
        System.out.println(solution(length));
    }

    private static String solution(int length) {
        StringBuilder sb = new StringBuilder();

        sb.append(1).append(" ").append(1).append(" ").append(2);

        int former = 1;
        int later = 2;
        for (int i = 3; i < length; i++) {
            int now = former + later;
            sb.append(" ").append(now);
            former = later;
            later = now;
        }

        return sb.toString();
    }

}
