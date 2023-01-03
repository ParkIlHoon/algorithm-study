package org.example.chapter2;

import java.util.Scanner;

/**
 * <h1>1. 큰 수 출력하기</h1>
 * N개의 정수를 입력받아, 자신의 바로 앞 수보다 큰 수만 출력(첫 번째 수는 무조건 출력한다)
 *
 * <ul>
 *     <li>입력 :
 *          <pre>{@code 6}</pre>
 *          <pre>{@code 7 3 9 5 6 12}</pre>
 *     </li>
 *
 *     <li>출력 :
 *          <pre>{@code 7 9 6 12}</pre>
 *     </li>
 * </ul>
 */
public class BiggestNumber {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int length = Integer.parseInt(sc.nextLine());
        String input = sc.nextLine();
        System.out.println(solution(length, input));
    }

    // 160ms
    private static String solution(int length, String input) {
        StringBuilder sb = new StringBuilder();

        String[] numbers = input.split("\\s");
        sb.append(numbers[0]);

        for (int i = 1; i < length; i++) {
            int former = Integer.parseInt(numbers[i - 1]);
            int now = Integer.parseInt(numbers[i]);

            if (former < now) {
                sb.append(" ").append(now);
            }
        }

        return sb.toString();
    }

}
