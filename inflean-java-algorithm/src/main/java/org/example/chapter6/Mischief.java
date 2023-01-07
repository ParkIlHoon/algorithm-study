package org.example.chapter6;

import java.util.Arrays;
import java.util.Scanner;

public class Mischief {

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
        int c = -1;
        int j = -1;

        for (int i = 0; i < students.length-1; i++) {
            if (students[i] > students[i+1]) {
                if (c != -1) j = i+1;
                if (c == -1) c = i;
            }
        }

        return (c+1) + " " + (j+1);
    }

    private static String solution2(int[] students) {
        int[] copy = students.clone();
        Arrays.sort(copy);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < students.length; i++) {
            if (students[i] != copy[i]) sb.append(i+1).append(" ");
        }

        return sb.toString();
    }
}
