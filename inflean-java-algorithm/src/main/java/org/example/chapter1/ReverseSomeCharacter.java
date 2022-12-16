package org.example.chapter1;

import java.util.Scanner;

/**
 * <h1>5. 특정 문자 뒤집기</h1>
 * 영어 알파벳만 뒤집고, 특수문자는 자기 자리에 그대로 있는 문자열을 만들어 출력
 *
 * <ul>
 *     <li>입력 :
 *          <pre>{@code a#b!GE*T@S}</pre>
 *     </li>
 *
 *     <li>출력 :
 *          <pre>{@code S#T!EG*b@a}</pre>
 *     </li>
 * </ul>
 */
public class ReverseSomeCharacter {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String input = in.next();
        System.out.println(solution(input));
    }

    // 152ms
    private static String solution(String input) {
        char[] chars = input.toCharArray();
        int lt = 0;
        int rt = chars.length - 1;

        while (lt < rt) {
            char former = chars[lt];
            char later = chars[rt];

            if (!Character.isAlphabetic(former)) {
                lt++;
            } else if (!Character.isAlphabetic(later)) {
                rt--;
            } else {
                chars[lt] = later;
                chars[rt] = former;

                lt++;
                rt--;
            }
        }

        return String.valueOf(chars);
    }

}
