package org.example.chapter1;

import java.util.Scanner;

/**
 * <h1>1. 문자 찾기</h1>
 * 한 개의 문자열을 입력받고, 특정 문자를 입력받아 해당 특정문자가 입력받은 문자열에 몇 개 존재하는지 알아내기
 *
 * <ul>
 *     <li>입력 :
 *          <pre>{@code Computercooler}</pre>
 *          <pre>{@code c}</pre>
 *     </li>
 *
 *     <li>출력 :
 *          <pre>{@code 2}</pre>
 *     </li>
 * </ul>
 */
public class FindCharacter {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String input1 = in.next();
        String input2 = in.next();
        System.out.println(solution(input1, input2));
    }

    // 155ms
    private static int solution(String input1, String input2) {
        int result = 0;
        char[] input1Chars = input1.toLowerCase().toCharArray();
        char input2Char = input2.toLowerCase().charAt(0);
        for (char c : input1Chars) {
            if (c == input2Char) result++;
        }
        return result;
    }

}
