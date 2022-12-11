package org.example.chapter1;

import java.util.Scanner;

/**
 * 4. 단어 뒤집기
 * 설명
 *
 * N개의 단어가 주어지면 각 단어를 뒤집어 출력하는 프로그램을 작성하세요.
 *
 *
 * 입력
 * 첫 줄에 자연수 N(3<=N<=20)이 주어집니다.
 *
 * 두 번째 줄부터 N개의 단어가 각 줄에 하나씩 주어집니다. 단어는 영어 알파벳으로만 구성되어 있습니다.
 *
 *
 * 출력
 * N개의 단어를 입력된 순서대로 한 줄에 하나씩 뒤집어서 출력합니다.
 *
 *
 * 예시 입력 1
 *
 * 3
 * good
 * Time
 * Big
 * 예시 출력 1
 *
 * doog
 * emiT
 * giB
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
