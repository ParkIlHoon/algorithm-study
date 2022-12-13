package org.example.chapter1;

import java.util.Scanner;

/**
 * <h1>11. 문자열 압축</h1>
 * 같은 문자가 연속으로 반복되는 경우 반복되는 문자 바로 오른쪽에 반복 횟수를 표기하는 방법으로 문자열을 압축(반복횟수가 1인 경우 생략)
 *
 * <ul>
 *     <li>입력1 :
 *          <pre>{@code KKHSSSSSSSE}</pre>
 *     </li>
 *
 *     <li>출력1 :
 *          <pre>{@code K2HS7E}</pre>
 *     </li>
 *     <li>입력2 :
 *          <pre>{@code KSTTTSEEKFKKKDJJGG}</pre>
 *     </li>
 *
 *     <li>출력2 :
 *          <pre>{@code KST3SE2KFK3DJ2G2}</pre>
 *     </li>
 * </ul>
 */
public class StringCompression {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.next();
        System.out.println(solution(input));
    }

    // 153ms
    private static String solution(String input) {
        char[] chars = input.toCharArray();
        StringBuilder sb = new StringBuilder();

        int pos = 1;
        int count = 1;
        char former = 0;

        while (pos < chars.length) {
            former = chars[pos - 1];
            if (former == chars[pos]) {
                count++;
            } else {
                sb.append(former);
                if (count > 1) sb.append(count);
                count = 1;
            }
            pos++;
        }

        char last = chars[chars.length - 1];
        if (former == last) {
            sb.append(last).append(count);
        } else {
            if (count > 1) sb.append(count);
            sb.append(last);
        }

        return sb.toString();
    }

    // 157ms
    private static String solution2(String input) {
        char[] chars = (input + "@").toCharArray();
        StringBuilder sb = new StringBuilder();

        int count = 1;
        for (int i = 0; i < chars.length - 1; i++) {
            if (chars[i] == chars[i + 1]) {
                count++;
            } else {
                sb.append(chars[i]);
                if (count > 1) sb.append(count);
                count = 1;
            }
        }

        return sb.toString();
    }
}
