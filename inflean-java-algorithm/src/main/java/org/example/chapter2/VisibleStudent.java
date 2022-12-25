package org.example.chapter2;

import java.util.Scanner;

/**
 * <h1>2. 보이는 학생</h1>
 * 일렬로 서 있는 학생의 키가 앞에서부터 순서대로 주어질 때, 맨 앞에 서 있는 선생님이 볼 수 있는 학생의 수를 구하는 프로그램
 * (앞에 서 있는 사람들보다 크면 보이고, 작거나 같으면 보이지 않습니다.)
 *
 *
 * <ul>
 *     <li>입력 :
 *          <pre>{@code 8}</pre>
 *          <pre>{@code 130 135 148 140 145 150 150 153}</pre>
 *     </li>
 *
 *     <li>출력 :
 *          <pre>{@code 5}</pre>
 *     </li>
 * </ul>
 */
public class VisibleStudent {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int length = Integer.parseInt(sc.nextLine());
        String input = sc.nextLine();
        System.out.println(solution(length, input));
    }

    private static int solution(int length, String input) {
        int result = 1;
        String[] students = input.split("\\s");

        int formerTallest = Integer.parseInt(students[0]);
        for (int i = 1; i < length; i++) {
            int now = Integer.parseInt(students[i]);
            if (formerTallest < now) {
                result++;
                formerTallest = now;
            }
        }

        return result;
    }
}
