package org.example.chapter5;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class EmergencyRoom {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int patientCnt = sc.nextInt();
        int target = sc.nextInt();
        int[] patients = new int[patientCnt];

        for (int i = 0; i < patientCnt; i++) {
            patients[i] = sc.nextInt();
        }

        System.out.println(solution(patients, target));
    }

    private static int solution(int[] patients, int target) {
        Queue<Integer> queue = new LinkedList<>();

        for (int i : patients) {
            queue.offer(i);
        }

        int pollCnt = 0;
        int index = target;

        while (true) {
            Integer poll = queue.poll();

            boolean isBiggest = true;
            for (Integer i : queue) {
                if (poll  < i) {
                    isBiggest = false;
                    break;
                }
            }

            if (isBiggest) {
                pollCnt++;
                if (index == 0) {
                    return pollCnt;
                }
            } else {
                queue.offer(poll);
                if (index == 0) {
                    index = queue.size();
                }
            }

            index--;
        }
    }
}