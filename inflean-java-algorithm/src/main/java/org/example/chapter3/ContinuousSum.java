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

    private static int solution2(int number) {
        int answer = 0, sum = 0, lt = 0;
        int m = number / 2 + 1;
        int[] arr = new int[m];

        for (int i = 0; i < m; i++) {
            arr[i] = i + 1;
        }

        for (int rt = 0; rt < m; rt++) {
            sum += arr[rt];

            if (sum == number) answer++;

            while (sum >= number) {
                sum -= arr[lt++];
                if (sum == number) answer++;
            }
        }

        return answer;
    }

    private static int solution3(int number) {
        int answer = 0, cnt = 1;

        number--;
        while (number > 0) {
            cnt++;
            number = number - cnt;

            if (number % cnt == 0) answer++;
        }

        return answer;
    }

}
