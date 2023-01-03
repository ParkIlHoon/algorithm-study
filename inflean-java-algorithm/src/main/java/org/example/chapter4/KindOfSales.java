package org.example.chapter4;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

/**
 * <h1>3. 매출액의 종류</h1>
 * N일 동안의 매출기록을 주고 연속된 K일 동안의 매출액의 종류를 각 구간별로 구하기
 *
 * <ul>
 *     <li>입력 :
 *          <pre>{@code 7 4}</pre>
 *          <pre>{@code 20 12 20 10 23 17 10}</pre>
 *     </li>
 *
 *     <li>출력 :
 *          <pre>{@code 3 4 4 3}</pre>
 *     </li>
 * </ul>
 */
public class KindOfSales {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int days = sc.nextInt();
        int unit = sc.nextInt();
        int[] sales = new int[days];
        for (int i = 0; i < days; i++) {
            sales[i] = sc.nextInt();
        }
        System.out.println(solution2(days, unit, sales));
    }

    // Time Limit Exceeded
    private static String solution(int days, int unit, int[] sales) {
        StringBuilder sb = new StringBuilder();

        int lt = 0;
        int pos = 0;
        Set<Integer> set = new HashSet<>();
        while (lt <= days - unit) {
            if (pos < lt + unit) {
                set.add(sales[pos]);
                pos++;
            } else {
                sb.append(set.size()).append(" ");
                set.clear();
                lt++;
                pos = lt;
            }
        }

        return sb.toString();
    }

    private static String solution2(int days, int unit, int[] sales) {
        StringBuilder sb = new StringBuilder();
        Map<Integer, Integer> map = new HashMap<>();

        int pos = 0;
        while (pos < unit) {
            map.put(sales[pos], map.getOrDefault(sales[pos], 0) + 1);
            pos++;
        }
        sb.append(map.keySet().size()).append(" ");

        while (pos < days) {
            int deleteKey = sales[pos - unit];
            if (map.get(deleteKey) > 1) {
                map.put(deleteKey, map.get(deleteKey) - 1);
            } else {
                map.remove(deleteKey);
            }
            map.put(sales[pos], map.getOrDefault(sales[pos], 0) + 1);
            sb.append(map.keySet().size()).append(" ");
            pos++;
        }

        return sb.toString();
    }
}