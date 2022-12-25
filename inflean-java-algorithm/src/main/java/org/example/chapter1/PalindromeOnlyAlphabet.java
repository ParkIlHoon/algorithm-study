package org.example.chapter1;

import java.util.Scanner;

/**
 * <h1>8. 알파벳 회문 문자열</h1>
 * 입력된 문자열이 회문 문자열이면 "YES", 회문 문자열이 아니면 “NO"를 출력(알파벳 외에는 무시)
 *
 * <ul>
 *     <li>입력 :
 *          <pre>{@code found7, time: study; Yduts; emit, 7Dnuof}</pre>
 *     </li>
 *
 *     <li>출력 :
 *          <pre>{@code YES}</pre>
 *     </li>
 * </ul>
 */
public class PalindromeOnlyAlphabet {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        System.out.println(solution(input));
    }

    // 161ms
    private static String solution(String input) {
        char[] chars = input.toUpperCase().toCharArray();

        int lt = 0;
        int rt = chars.length - 1;

        while (lt < rt) {
            if (!Character.isAlphabetic(chars[lt])) {
                lt++;
            } else if (!Character.isAlphabetic(chars[rt])) {
                rt--;
            } else {
                if (chars[lt] != chars[rt]) {
                    return "NO";
                }

                lt++;
                rt--;
            }
        }

        return "YES";
    }

}


