package org.example.chapter1;

import java.util.Scanner;

/**
 * <h1>12. 암호</h1>
 * 비밀편지는 알파벳 한 문자마다 # 또는 *이 일곱 개로 구성되어 있습니다.
 * 1. “#*****#”를 일곱자리의 이진수로 바꿉니다. #은 이진수의 1로, *이진수의 0으로 변환합니다. 결과는 “1000001”로 변환됩니다.
 * 2. 바뀐 2진수를 10진수화 합니다. “1000001”을 10진수화 하면 65가 됩니다.
 * 3. 아스키 번호가 65문자로 변환합니다. 즉 아스크번호 65는 대문자 'A'입니다.
 *
 * <ul>
 *     <li>입력 :
 *          <pre>{@code 4}</pre>
 *          <pre>{@code #****###**#####**#####**##**}</pre>
 *     </li>
 *
 *     <li>출력 :
 *          <pre>{@code COOL}</pre>
 *     </li>
 * </ul>
 */
public class Password {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int length = sc.nextInt();
        String input = sc.next();
        System.out.println(solution2(input, length));
    }

    // 177ms
    private static String solution(String input, int length) {
        int g = 7;

        char[] chars = input.toCharArray();
        StringBuilder sb = new StringBuilder();

        int pos = 0;
        String binaryValue = "";
        while(pos < chars.length) {
            binaryValue += (chars[pos] == '#')? 1 : 0;

            if ((pos + 1) % g == 0) {
                sb.append((char) Integer.parseInt(binaryValue, 2));
                binaryValue = "";
            }

            pos++;
        }

        return sb.toString();
    }

    // 162ms
    private static String solution2(String input, int length) {
        int g = 7;
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < length; i++) {
            int beginIndex = i * g;
            String encryptChar = input.substring(beginIndex, beginIndex + g);
            String binaryString = encryptChar.replace('#', '1').replace('*', '0');
            sb.append((char) Integer.parseInt(binaryString, 2));
        }

        return sb.toString();
    }

}
