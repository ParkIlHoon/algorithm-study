package org.example.chapter4;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * <h1>1. 학급 회장(해쉬)</h1>
 * 학급 회장을 뽑는데 후보로 기호 A, B, C, D, E 후보가 등록을 했습니다.
 * 선생님의 발표가 끝난 후 어떤 기호의 후보가 학급 회장이 되었는지 출력하는 프로그램을 작성하세요.
 *
 * <ul>
 *     <li>입력 :
 *          <pre>{@code 15}</pre>
 *          <pre>{@code BACBACCACCBDEDE}</pre>
 *     </li>
 *
 *     <li>출력 :
 *          <pre>{@code C}</pre>
 *     </li>
 * </ul>
 */
public class Election {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int length = sc.nextInt();
        String votes = sc.next();

        System.out.println(solution(votes));
    }

    private static char solution(String votes) {
        Map<Character, Integer> map = new HashMap<>();

        for (char x : votes.toCharArray()) {
            map.put(x, map.getOrDefault(x, 0) + 1);
        }

        int max = 0;
        char answer = ' ';
        for (char key : map.keySet()) {
            if (map.get(key) > max) {
                max = map.get(key);
                answer = key;
            }
        }

        return answer;
    }

}
