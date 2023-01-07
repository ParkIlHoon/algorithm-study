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

    private static int solution2(int[] patients, int target) {
        Queue<Patient> queue = new LinkedList<>();
        for (int i = 0; i < patients.length; i++) {
            queue.add(new Patient(i, patients[i]));
        }

        int result = 1;
        while (!queue.isEmpty()) {
            Patient patient = queue.poll();
            for (Patient other : queue) {
                if (other.priority > patient.priority) {
                    queue.add(patient);
                    patient = null;
                    break;
                }
            }
            if (patient != null) {
                if (patient.id == target) {
                    return result;
                } else {
                    result++;
                }
            }
        }

        return result;
    }

    public static class Patient {
        public int id;
        public int priority;

        public Patient(int id, int priority) {
            this.id = id;
            this.priority = priority;
        }
    }
}