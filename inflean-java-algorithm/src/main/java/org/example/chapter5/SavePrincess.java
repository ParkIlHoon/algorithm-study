package org.example.chapter5;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class SavePrincess {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int prince = sc.nextInt();
        int number = sc.nextInt();

        System.out.println(solution(prince, number));
    }

    private static int solution(int prince, int number) {
        Queue<Integer> queue = new LinkedList<>();

        for (int i = 1; i <= prince; i++) {
            queue.offer(i);
        }

        int cnt = 1;
        while (queue.size() > 1) {
            Integer poll = queue.poll();

            if (cnt != number) {
                queue.offer(poll);
                cnt++;
            } else {
                cnt = 1;
            }
        }

        return queue.poll();
    }
}
