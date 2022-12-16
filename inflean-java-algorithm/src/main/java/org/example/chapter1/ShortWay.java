package org.example.chapter1;

import java.util.Scanner;

/**
 * <h1>10. 가장 짧은 문자거리 🚩</h1>
 * 한 개의 문자열 s와 문자 t가 주어지면 문자열 s의 각 문자가 문자 t와 떨어진 최소거리를 출력
 * <ul>
 *     <li>입력 :
 *          <pre>{@code teachermode}</pre>
 *          <pre>{@code e}</pre>
 *     </li>
 *
 *     <li>출력 :
 *          <pre>{@code 1 0 1 2 1 0 1 2 2 1 0}</pre>
 *     </li>
 * </ul>
 */
public class ShortWay {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        String t = sc.next();
        System.out.println(solution(s, t));
    }

    /**
     *          0       1   2   3   4   5   6   7   8   9   10
     *  word    t       e   a   c   h   e   r   m   o   d   e
     *  answer
     *  p=1000  1001    0   1   2   3   0   1   2   3   4   0   ->
     *  p=1000  1       0   3   2   1   0   4   3   2   1   0   <-
     *  --------------------------------------------------------
     *  작은값    1       0   1   2   1   0   1   2   2   1   0
     */
    // 155ms
    private static String solution(String word, String target) {
        char t = target.charAt(0);
        char[] chars = word.toCharArray();
        int[] result = new int[chars.length];
        StringBuilder sb = new StringBuilder();

        int p = chars.length;
        for (int lt = 0; lt < chars.length; lt++) {
            if (chars[lt] == t) {
                result[lt] = 0;
                p = 0;
            } else {
                result[lt] = ++p;
            }
        }

        p = chars.length;
        for (int rt = chars.length - 1; rt >= 0; rt--) {
            if (chars[rt] == t) {
                p = 0;
            } else {
                result[rt] = Math.min(++p, result[rt]);
            }
        }

        for (int i : result) {
            sb.append(i).append(" ");
        }

        return sb.toString();
    }

}