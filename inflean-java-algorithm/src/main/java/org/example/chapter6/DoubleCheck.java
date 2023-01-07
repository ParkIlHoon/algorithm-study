package org.example.chapter6;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class DoubleCheck {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int cnt = sc.nextInt();
        int[] students = new int[cnt];
        for (int i = 0; i < cnt; i++) {
            students[i] = sc.nextInt();
        }

        System.out.println(solution(students));
    }

    private static String solution(int[] students) {
        for (int i = 0; i < students.length; i++) {
            for (int j = i+1; j < students.length; j++) {
                if (students[i] == students[j]) return "D";
            }
        }

        return "U";
    }

    private static String solution2(int[] students) {
        HashMap<Integer, Boolean> map = new HashMap<>();
        for (int i = 0; i < students.length; i++) {
            if (map.containsKey(students[i])) return "D";
            map.put(i, true);
        }

        return "U";
    }

    private static String solution3(int[] students) {
        Arrays.sort(students);
        for (int i = 1; i < students.length; i++) {
            if (students[i-1] == students[i]) return "D";
        }
        return "U";
    }
}
