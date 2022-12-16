package org.example.chapter1;

import java.util.Scanner;

/**
 * <h1>3. 문장 속 단어</h1>
 * 문장 속에서 가장 긴 단어를 출력
 *
 * <ul>
 *     <li>입력 :
 *          <pre>{@code it is time to study}</pre>
 *     </li>
 *
 *     <li>출력 :
 *          <pre>{@code study}</pre>
 *     </li>
 * </ul>
 */
public class WordInSentence {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String input = in.nextLine();
        System.out.println(solution(input));
    }

    // 161ms
    private static String solution(String input) {
        String result = "";
        String[] split = input.split("\\s");
        for (String word : split) {
            if (word.length() > result.length()) result = word;
        }
        return result;
    }

    // 148ms
    private static String solution2(String input) {
        String result = "";

        int m = Integer.MIN_VALUE;
        int pos;

        while ((pos = input.indexOf(' ')) != -1) {
            String tmp = input.substring(0, pos);
            int len = tmp.length();
            if (len > m) {
                m = len;
                result = tmp;
            }

            input = input.substring(pos + 1);
        }

        if (input.length() > m) {
            result = input;
        }

        return result;
    }
}
