package org.example.chapter7;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class FindCalf {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int hyeonsu = sc.nextInt();
        int calf = sc.nextInt();

        System.out.println(solution(hyeonsu, calf));
    }

    // time limit exceed
    private static int solution(int hyeonsu, int calf) {
        // +1 or -1 or 5
        int[] moves = {1, -1, 5};
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(hyeonsu);
        int level = 0;

        while (!queue.isEmpty()) {
            int len = queue.size();
            level++;
            for (int j = 0; j < len; j++) {
                Integer poll = queue.poll();

                for (int i = 0; i < moves.length; i++) {
                    int nx = poll + moves[i];
                    if (1 <= nx && nx <= 10000) {
                        if (nx == calf) {
                            return level;
                        } else {
                            queue.offer(nx);
                        }
                    }
                }
            }
        }

        return level;
    }

    private static int solution2(int hyeonsu, int calf) {
        int answer = 0;
        int[] dis = {1, -1, 5};
        int[] ch = new int[10001];
        Queue<Integer> queue = new LinkedList<>();

        ch[hyeonsu] = 1;
        queue.offer(hyeonsu);
        int level = 0;

        while (!queue.isEmpty()) {
            int len = queue.size();

            for (int i = 0; i < len; i++) {
                Integer poll = queue.poll();

                if (poll == calf) return level;

                for (int j = 0; j < 3; j++) {
                    int nx = poll + dis[j];
                    if (1 <= nx && nx <= 10000 && ch[nx] == 0) {
                        ch[nx] = 1;
                        queue.offer(nx);
                    }
                }
            }

            level++;
        }

        return level;
    }
}
