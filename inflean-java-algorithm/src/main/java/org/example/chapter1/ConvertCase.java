package org.example.chapter1;

import java.util.Scanner;

/**
 * <h1>2. 대소문자 변환</h1>
 * 대문자와 소문자가 같이 존재하는 문자열을 입력받아 대문자는 소문자로 소문자는 대문자로 변환하여 출력
 *
 * <ul>
 *     <li>입력 : {@code StuDY}</li>
 *     <li>출력 : {@code sTUdy}</li>
 * </ul>
 */
public class ConvertCase {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String input = in.next();
        System.out.println(solution(input));
    }

    // 155ms
    private static String solution(String input) {
        StringBuilder result = new StringBuilder();
        for (char c : input.toCharArray()) {
            result.append((Character.isLowerCase(c)) ? Character.toUpperCase(c) : Character.toLowerCase(c));
        }
        return result.toString();
    }
}
