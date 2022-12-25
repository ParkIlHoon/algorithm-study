package org.example.chapter2;

import java.util.Scanner;

/**
 * <h1>7. 점수계산</h1>
 * 연속적으로 답을 맞히는 경우에는 가산점을 주기 위해서 다음과 같이 점수 계산
 * 1번 문제가 맞는 경우에는 1점으로 계산한다. 앞의 문제에 대해서는 답을 틀리다가 답이 맞는 처음 문제는 1점으로 계산한다.
 * 또한, 연속으로 문제의 답이 맞는 경우에서 두 번째 문제는 2점, 세 번째 문제는 3점, ..., K번째 문제는 K점으로 계산한다. 틀린 문제는 0점으로 계산한다.
 *
 * <ul>
 *     <li>입력 :
 *          <pre>{@code 10}</pre>
 *          <pre>{@code 1 0 1 1 1 0 0 1 1 0}</pre>
 *     </li>
 *
 *     <li>출력 :
 *          <pre>{@code 10}</pre>
 *     </li>
 * </ul>
 */
public class CalculateScore {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int length = sc.nextInt();
        int[] scoring = new int[length];
        for (int i = 0; i < length; i++) {
            scoring[i] = sc.nextInt();
        }
        System.out.println(solution(scoring));
    }

    private static int solution(int[] scoring) {
        int total = 0;
        int additional = 0;

        for (int s : scoring) {
            if (s == 0) {
                additional = 0;
            } else {
                additional++;
                total += additional;
            }
        }
        return total;
    }
}
