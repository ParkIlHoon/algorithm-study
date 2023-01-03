package org.example.chapter2;

import java.util.Scanner;

/**
 * <h1>12. 멘토링</h1>
 * 만약 A학생이 멘토이고, B학생이 멘티가 되는 짝이 되었다면, A학생은 M번의 수학테스트에서 모두 B학생보다 등수가 앞서야 합니다.
 * M번의 수학성적이 주어지면 멘토와 멘티가 되는 짝을 만들 수 있는 경우가 총 몇 가지 인지 출력하는 프로그램을 작성하세요.
 *
 * <ul>
 *     <li>입력 :
 *          <pre>{@code 4 3}</pre>
 *          <pre>{@code 3 4 1 2}</pre>
 *          <pre>{@code 4 3 2 1}</pre>
 *          <pre>{@code 3 1 4 2}</pre>
 *     </li>
 *
 *     <li>출력 :
 *          <pre>{@code 3}</pre>
 *     </li>
 * </ul>
 */
public class Mentoring {

    private static final int TRUE = 1;
    private static final int FALSE = -1;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int studentCount = sc.nextInt();
        int questionCount = sc.nextInt();
        int[][] map = new int[questionCount][studentCount];
        for (int i = 0; i < questionCount; i++) {
            for (int j = 0; j < studentCount; j++) {
                map[i][j] = sc.nextInt();
            }
        }

        System.out.println(solution(studentCount, questionCount, map));
    }

    private static int solution(int studentCount, int questionCount, int[][] map) {
        int result = 0;

        int[][] resultMap = new int[studentCount + 1][studentCount + 1];

        for (int i = 0; i < questionCount; i++) {
            for (int j = 0; j < studentCount; j++) {
                int mentorNum = map[i][j];

                for (int k = j + 1; k < studentCount; k++) {
                    int menteeNum = map[i][k];

                    switch (resultMap[menteeNum][mentorNum]) {
                        case TRUE:
                            resultMap[mentorNum][menteeNum] = FALSE;
                            resultMap[menteeNum][mentorNum] = FALSE;
                            break;
                        case FALSE:
                            resultMap[mentorNum][menteeNum] = FALSE;
                            break;
                        default:
                            resultMap[mentorNum][menteeNum] = TRUE;
                            break;
                    }
                }
            }
        }

        for (int[] row : resultMap) {
            for (int r : row) {
                if (r == TRUE) result++;
            }
        }

        return result;
    }

    private static int solution2(int studentCount, int questionCount, int[][] map) {
        int result = 0;
        for (int i = 1; i <= studentCount; i++) {
            for (int j = 1; j <= studentCount; j++) {
                int cnt = 0;
                for (int k = 0; k < questionCount; k++) {
                    int pi = 0, pj = 0;
                    for (int s = 0; s < studentCount; s++) {
                        if (map[k][s] == i) pi = s;
                        if (map[k][s] == j) pj = s;
                    }
                    if (pi < pj) cnt++;
                }
                if (cnt == questionCount) {
                    result++;
                }
            }
        }
        return result;
    }
}
