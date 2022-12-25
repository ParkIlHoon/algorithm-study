package org.example.chapter2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * <h1>5. 소수(에라토스테네스 체)</h1>
 * 자연수 N이 입력되면 1부터 N까지의 소수의 개수를 출력하는 프로그램을 작성하세요.
 *
 * <ul>
 *     <li>입력 :
 *          <pre>{@code 20}</pre>
 *     </li>
 *
 *     <li>출력 :
 *          <pre>{@code 8}</pre>
 *     </li>
 * </ul>
 */
public class Eratos {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int limit = sc.nextInt();
        System.out.println(solution(limit));
    }

    private static int solution(int limit) {
        List<Boolean> eratos = new ArrayList<>(limit + 1);

        eratos.add(0, false);
        eratos.add(1, false);

        for (int i = 2; i <= limit; i++) {
            eratos.add(true);
        }

        for (int i = 2; i <= limit; i++) {
            int m = 2;
            while (i * m <= limit) {
                Boolean isEratos = eratos.get(i * m);
                if (isEratos) {
                    eratos.set(i * m, false);
                }
                m++;
            }
        }

        int eratosCount = 0;
        for (boolean b : eratos) {
            if (b) eratosCount++;
        }

        return eratosCount;
    }
}
