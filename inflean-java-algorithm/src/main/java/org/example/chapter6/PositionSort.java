package org.example.chapter6;

import java.util.Scanner;

public class PositionSort {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int cnt = sc.nextInt();
        int[][] map = new int[cnt][2];
        for (int i = 0; i < cnt; i++) {
            map[i][0] = sc.nextInt();
            map[i][1] = sc.nextInt();
        }

        System.out.println(solution(map));
    }

    private static String solution(int[][] map) {
        Position[] positions = new Position[map.length];

        for (int i = 0; i < map.length; i++) {
            positions[i] = new Position(map[i][0], map[i][1]);
        }

        for (int i = 0; i < positions.length; i++) {
            int leastIndex = i;

            for (int j = i + 1; j < positions.length; j++) {
                if (positions[leastIndex].x > positions[j].x) {
                    leastIndex = j;
                } else if (positions[leastIndex].x == positions[j].x) {
                    if (positions[leastIndex].y > positions[j].y) {
                        leastIndex = j;
                    }
                }
            }

            if (i != leastIndex) {
                Position tmp = positions[i];
                positions[i] = positions[leastIndex];
                positions[leastIndex] = tmp;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (Position pos : positions) {
            sb.append(pos.x).append(" ").append(pos.y).append("\n");
        }
        return sb.toString();
    }

    private static class Position {
        public int x;
        public int y;

        public Position(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
