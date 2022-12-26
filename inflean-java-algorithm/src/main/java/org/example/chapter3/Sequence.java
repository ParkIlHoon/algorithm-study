package org.example.chapter3;

import java.util.Scanner;

/**
 * <h1>4. 연속 부분수열</h1>
 * N개의 수로 이루어진 수열이 주어집니다.
 * 이 수열에서 연속부분수열의 합이 특정숫자 M이 되는 경우가 몇 번 있는지 구하는 프로그램을 작성하세요.
 *
 * <ul>
 *     <li>입력 :
 *          <pre>{@code 8 6}</pre>
 *          <pre>{@code 1 2 1 3 1 1 1 2}</pre>
 *     </li>
 *
 *     <li>출력 :
 *          <pre>{@code 3}</pre>
 *     </li>
 * </ul>
 */
public class Sequence {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int count = sc.nextInt();
        int number = sc.nextInt();
        int[] numbers = new int[count];

        for (int i = 0; i < count; i++) {
            numbers[i] = sc.nextInt();
        }

        System.out.println(solution(number, numbers));
    }

    private static int solution(int number, int[] numbers) {
        int result = 0;

        int begin = 0;
        int pos = 0;
        int sum = 0;
        while (begin < numbers.length) {
            if (pos >= numbers.length) {
                begin++;
                pos = begin;
                sum = 0;
                continue;
            }

            sum += numbers[pos];

            if (sum == number) {
                begin++;
                pos = begin;
                sum = 0;
                result++;
            } else if (sum > number) {
                begin++;
                pos = begin;
                sum = 0;
            } else {
                pos++;
            }
        }

        return result;
    }

}
