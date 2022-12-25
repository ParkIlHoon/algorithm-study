package org.example.chapter3;

import java.util.Scanner;

/**
 * <h1>5. 연속된 자연수의 합</h1>
 * N입력으로 양의 정수 N이 입력되면 2개 이상의 연속된 자연수의 합으로 정수 N을 표현하는 방법의 가짓수를 출력하는 프로그램을 작성하세요.
 *
 * <ul>
 *     <li>입력 :
 *          <pre>{@code 15}</pre>
 *     </li>
 *
 *     <li>출력 :
 *          <pre>{@code 3}</pre>
 *     </li>
 * </ul>
 */
public class ContinuousSum {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int number = sc.nextInt();

        System.out.println(solution(number));
    }

    private static int solution(int number) {
        int result = 0;
        int begin = 1;
        int pos = begin;
        int sum = 0;

        while (begin < number) {
            if (pos >= number) {
                begin++;
                pos = begin;
                sum = 0;
                continue;
            }

            sum += pos;

            if (sum == number) {
                result++;
                begin++;
                pos = begin;
                sum = 0;
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
