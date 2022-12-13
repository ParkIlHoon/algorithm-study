package org.example.chapter1;

import java.util.Scanner;

/**
 * <h1>9. 숫자만 추출</h1>
 * 문자와 숫자가 섞여있는 문자열이 주어지면 그 중 숫자만 추출하여 그 순서대로 자연수를 만듭니다.
 *
 * <ul>
 *     <li>입력 :
 *          <pre>{@code g0en2T0s8eSoft}</pre>
 *     </li>
 *
 *     <li>출력 :
 *          <pre>{@code 208}</pre>
 *     </li>
 * </ul>
 */
public class ExtractNumber {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.next();
        System.out.println(solution(input));
    }

    // 154ms
    private static int solution(String input) {
        StringBuilder sb = new StringBuilder();
        char[] chars = input.toCharArray();
        for (char c : chars) {
            if (Character.isDigit(c)) sb.append(c);
        }
        return Integer.parseInt(sb.toString());
    }

}
