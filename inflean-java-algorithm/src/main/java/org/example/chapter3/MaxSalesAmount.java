package org.example.chapter3;

import java.util.Scanner;

/**
 * <h1>3. 최대 매출</h1>
 * N일 동안의 매출기록을 주고 연속된 K일 동안의 최대 매출액이 얼마인지 구하라고 했습니다.
 *
 *
 * <ul>
 *     <li>입력 :
 *          <pre>{@code 10 3}</pre>
 *          <pre>{@code 12 15 11 20 25 10 20 19 13 15}</pre>
 *     </li>
 *
 *     <li>출력 :
 *          <pre>{@code 56}</pre>
 *     </li>
 * </ul>
 */
public class MaxSalesAmount {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int days = sc.nextInt();
        int unitDays = sc.nextInt();

        int[] amounts = new int[days];
        for (int i = 0; i < days; i++) {
            amounts[i] = sc.nextInt();
        }

        System.out.println(solution(unitDays, amounts));
    }

    private static int solution(int unitDays, int[] amounts) {
        int result = 0;
        int former = 0;

        int pos = 0;
        while (pos + unitDays < amounts.length) {
            if (pos < unitDays) {
                former += amounts[pos];
                result = former;
            } else {
                former = former - amounts[pos - unitDays] + amounts[pos];
                if (former > result) {
                    result = former;
                }
            }
            pos++;
        }

        return result;
    }

}
