package org.example.chapter1;

import java.util.Scanner;

/**
 * <h1>4. 단어 뒤집기</h1>
 * N개의 단어가 주어지면 각 단어를 뒤집어 출력
 *
 * <ul>
 *     <li>입력 :
 *          <pre>{@code 3}</pre>
 *          <pre>{@code good}</pre>
 *          <pre>{@code time}</pre>
 *          <pre>{@code big}</pre>
 *     </li>
 *
 *     <li>출력 :
 *          <pre>{@code doog}</pre>
 *          <pre>{@code emit}</pre>
 *          <pre>{@code gib}</pre>
 *     </li>
 * </ul>
 */
public class ReverseWord {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int i = in.nextInt();
        solution(in, i);
    }

    // 160ms
    private static void solution(Scanner in, int count) {
        String[] words = new String[count];

        for (int i = 0; i < count; i++) {
            char[] chars = in.next().toCharArray();
            String word = "";
            for (int ci = chars.length - 1; ci >= 0; ci--) {
                word += chars[ci];
            }
            words[i] = word;
        }

        for (String word : words) {
            System.out.println(word);
        }
    }

    // 164ms
    private static void solution2(Scanner in, int count) {
        String[] words = new String[count];

        for (int i = 0; i < count; i++) {
            words[i] = new StringBuilder(in.next()).reverse().toString();
        }

        for (String word : words) {
            System.out.println(word);
        }
    }

    // 157ms
    private static void solution3(Scanner in, int count) {
        String[] words = new String[count];

        for (int i = 0; i < count; i++) {
            char[] chars = in.next().toCharArray();

            int lt = 0;
            int rt = chars.length - 1;
            while (lt < rt) {
                char tmp = chars[lt];

                chars[lt] = chars[rt];
                chars[rt] = tmp;

                lt++;
                rt--;
            }

            words[i] = String.valueOf(chars);
        }

        for (String word : words) {
            System.out.println(word);
        }
    }

}
