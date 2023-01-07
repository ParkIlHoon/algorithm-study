package org.example.chapter6;

import java.util.Scanner;

public class LeastRecentlyUsed {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int cacheSize = sc.nextInt();
        int jobCnt = sc.nextInt();
        int[] jobs = new int[jobCnt];
        for (int i = 0; i < jobCnt; i++) {
            jobs[i] = sc.nextInt();
        }

        System.out.println(solution(cacheSize, jobs));
    }

    private static String solution(int cacheSize, int[] jobs) {
        int[] cache = new int[cacheSize];

        for (int i = 0; i < cacheSize; i++) {
            cache[i] = 0;
        }

        for (int i = 0; i < jobs.length; i++) {
            int recentJob = jobs[i];
            int beginIndex = cacheSize - 1;

            for (int j = 0; j < cacheSize; j++) {
                if (recentJob == cache[j]) {
                    recentJob = cache[j];
                    beginIndex = j;
                    break;
                }
            }

            for (int j = beginIndex; j > 0; j--) {
                cache[j] = cache[j - 1];
            }
            cache[0] = recentJob;
        }

        StringBuilder sb = new StringBuilder();
        for (int i : cache) {
            sb.append(i).append(" ");
        }
        return sb.toString();
    }
}
