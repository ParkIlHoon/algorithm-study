package org.example.chapter4;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * <h1>2. 아나그램(해쉬)</h1>
 * Anagram이란 두 문자열이 알파벳의 나열 순서를 다르지만 그 구성이 일치하면 두 단어는 아나그램이라고 합니다.
 * 길이가 같은 두 개의 단어가 주어지면 두 단어가 아나그램인지 판별하는 프로그램을 작성하세요. 아나그램 판별시 대소문자가 구분됩니다.
 *
 *
 * <ul>
 *     <li>입력 :
 *          <pre>{@code AbaAeCe}</pre>
 *          <pre>{@code baeeACA}</pre>
 *     </li>
 *
 *     <li>출력 :
 *          <pre>{@code YES}</pre>
 *     </li>
 * </ul>
 */
public class Anagram {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String first = sc.nextLine();
        String second = sc.nextLine();
        System.out.println(solution(first, second));
    }

    private static String solution(String first, String second) {
        char[] firstArr = first.toCharArray();
        char[] secondArr = second.toCharArray();

        Map<Character, Integer> firstMap = new HashMap<>();
        Map<Character, Integer> secondMap = new HashMap<>();

        for (int i = 0; i < firstArr.length; i++) {
            firstMap.put(firstArr[i], firstMap.getOrDefault(firstArr[i], 0) + 1);
            secondMap.put(secondArr[i], secondMap.getOrDefault(secondArr[i], 0) + 1);
        }

        for (char c : firstMap.keySet()) {
            if (firstMap.get(c) != secondMap.get(c)) return "NO";
        }

        return "YES";
    }

}
