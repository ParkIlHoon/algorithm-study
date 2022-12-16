package org.example.chapter1;

import java.util.Scanner;

/**
 * <h1>7. 회문 문자열</h1>
 * 입력된 문자열이 회문 문자열이면 "YES", 회문 문자열이 아니면 “NO"를 출력
 *
 * <ul>
 *     <li>입력 :
 *          <pre>{@code gooG}</pre>
 *     </li>
 *
 *     <li>출력 :
 *          <pre>{@code YES}</pre>
 *     </li>
 * </ul>
 */
public class Palindrome {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.next();
        System.out.println(solution(input));
    }

    // 152ms
    private static String solution(String input) {
        char[] chars = input.toUpperCase().toCharArray();

        int lt = 0;
        int rt = chars.length - 1;

        while (lt < rt) {
            if (chars[lt] != chars[rt]) {
                return "NO";
            }

            lt++;
            rt--;
        }

        return "YES";
    }

}
