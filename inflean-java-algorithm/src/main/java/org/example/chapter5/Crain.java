package org.example.chapter5;

import java.util.Scanner;
import java.util.Stack;

public class Crain {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int line = sc.nextInt();
        int[][] map = new int[line][line];

        for (int i = 0; i < line; i++) {
            for (int j = 0; j < line; j++) {
                map[i][j] = sc.nextInt();
            }
        }

        int moving = sc.nextInt();
        int[] moves = new int[moving];
        for (int i = 0; i < moving; i++) {
            moves[i] = sc.nextInt();
        }

        System.out.println(solution(line, map, moves));
    }

    private static int solution(int line, int[][] map, int[] moves) {
        int result = 0;
        Stack<Integer> stack = new Stack<>();

        for (int m : moves) {
            int movingIndex = m - 1;
            for (int i = 0; i < line; i++) {
                if(map[i][movingIndex] != 0) {
                    if (!stack.isEmpty()) {
                        if (stack.peek() == map[i][movingIndex]) {
                            result++;
                            stack.pop();
                            map[i][movingIndex] = 0;
                            break;
                        }
                    }
                    stack.push(map[i][movingIndex]);
                    map[i][movingIndex] = 0;
                    break;
                }
            }
        }

        return result * 2;
    }
}
