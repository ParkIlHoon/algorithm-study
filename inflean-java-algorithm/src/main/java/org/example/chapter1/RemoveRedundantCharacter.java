package org.example.chapter1;

import java.util.Scanner;

/**
 * <h1>6. 중복문자제거</h1>
 * 소문자로 문자열의 중복된 문자를 제거하고 출력
 *
 * <ul>
 *     <li>입력 :
 *          <pre>{@code ksekkset}</pre>
 *     </li>
 *
 *     <li>출력 :
 *          <pre>{@code kset}</pre>
 *     </li>
 * </ul>
 */
public class RemoveRedundantCharacter {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.next();
        System.out.println(solution(input));
    }

    // 160ms
    private static String solution(String input) {
        int pos = 0;
        char[] chars = input.toCharArray();
        StringBuilder sb = new StringBuilder();

        while (pos < chars.length) {
            boolean isRedundant = false;

            for (int i = 0; i < pos; i++) {
                if (chars[pos] == chars[i]) {
                    isRedundant = true;
                    break;
                }
            }

            if (!isRedundant) {
                sb.append(chars[pos]);
            }

            pos++;
        }

        return sb.toString();
    }

    // 152ms
    private static String solution2(String input) {
        StringBuilder sb = new StringBuilder();
        char[] chars = input.toCharArray();

        for (int i = 0; i < chars.length; i++) {
            if (i == input.indexOf(chars[i])) {
                sb.append(chars[i]);
            }
        }

        return sb.toString();
    }

}
