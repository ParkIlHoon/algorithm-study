package org.example.chapter4;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * <h1>4. 모든 아나그램 찾기</h1>
 * S문자열에서 T문자열과 아나그램이 되는 S의 부분문자열의 개수를 구하는 프로그램을 작성하세요.
 * 아나그램 판별시 대소문자가 구분됩니다. 부분문자열은 연속된 문자열이어야 합니다.
 *
 * <ul>
 *     <li>입력 :
 *          <pre>{@code bacaAacba}</pre>
 *          <pre>{@code abc}</pre>
 *     </li>
 *
 *     <li>출력 :
 *          <pre>{@code 3}</pre>
 *     </li>
 * </ul>
 */
public class FindAllAnagram {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String s = sc.next();
        String t = sc.next();

        System.out.println(solution(s, t));
    }

    private static int solution(String s, String t) {
        int result = 0;

        Map<Character, Integer> sm = new HashMap<>();
        Map<Character, Integer> tm = new HashMap<>();

        for (char x : t.toCharArray()) {
            tm.put(x, tm.getOrDefault(x, 0) + 1);
        }

        for (int i = 0; i < t.length() - 1; i++) {
            sm.put(s.charAt(i), sm.getOrDefault(s.charAt(i), 0) + 1);
        }

        int lt = 0;
        for (int rt = t.length() - 1; rt < s.length(); rt++) {
            sm.put(s.charAt(rt), sm.getOrDefault(s.charAt(rt), 0) + 1);

            if (sm.equals(tm)) result++;

            sm.put(s.charAt(lt), sm.get(s.charAt(lt)) - 1);
            if (sm.get(s.charAt(lt)) == 0) sm.remove(s.charAt(lt));

            lt++;
        }

        return result;
    }
}
