package org.example.chapter2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * <h1>6. 뒤집은 소수</h1>
 * N개의 자연수가 입력되면 각 자연수를 뒤집은 후 그 뒤집은 수가 소수이면 그 소수를 출력하는 프로그램을 작성하세요.
 *
 * <ul>
 *     <li>입력 :
 *          <pre>{@code 9}</pre>
 *          <pre>{@code 32 55 62 20 250 370 200 30 100}</pre>
 *     </li>
 *
 *     <li>출력 :
 *          <pre>{@code 23 2 73 2 3}</pre>
 *     </li>
 * </ul>
 */
public class ReverseEratos {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int limit = Integer.parseInt(sc.nextLine());
        String input = sc.nextLine();
        System.out.println(solution(limit, input));
    }

    private static String solution(int limit, String input) {
        String[] split = input.split("\\s");
        List<Integer> eratos = new ArrayList<>();

        // 숫자 뒤집기
        for (int i = 0; i < limit; i++) {
            int tmp = Integer.parseInt(split[i]);
            int res = 0;

            while (tmp > 0) {
                int t = tmp % 10;
                res = res * 10 + t;
                tmp = tmp / 10;
            }

            if (isPrime(res)) {
                eratos.add(res);
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int e : eratos) {
            sb.append(e).append(" ");
        }
        return sb.toString();
    }

    private static boolean isPrime(int n) {
        if (n == 1) return false;

        for (int i = 2; i < n; i++) {
            if (n % i == 0) return false;
        }

        return true;
    }

//    private static String solution(int limit, String input) {
//        String[] split = input.split("\\s");
//        List<Boolean> eratos = new ArrayList();
//
//
//        List<Integer> reversedNumbers = new ArrayList<>();
//        int largestNumber = -1;
//        for (int i = 0; i < limit; i++) {
//            if (split[i].length() == 1) {
//                int num = Integer.parseInt(split[i]);
//                reversedNumbers.add(num);
//                if (num > largestNumber) largestNumber = num;
//            } else {
//                char[] chars = split[i].toCharArray();
//                int lt = 0;
//                int rt = chars.length - 1;
//
//                while (lt < rt) {
//                    char tmp = chars[lt];
//                    chars[lt] = chars[rt];
//                    chars[rt] = tmp;
//
//                    lt++;
//                    rt--;
//                }
//                int num = Integer.parseInt(String.valueOf(chars));
//                reversedNumbers.add(num);
//                if (num > largestNumber) largestNumber = num;
//            }
//        }
//
//        eratos.add(0, false);
//        eratos.add(1, false);
//
//        for (int i = 2; i <= largestNumber; i++) {
//            boolean isExist = reversedNumbers.contains(i);
//            eratos.add(i, (isExist)? true : false);
//        }
//
//        for (int i = 2; i <= largestNumber; i++) {
//            int m = 2;
//            while (i * m <= largestNumber) {
//                if (eratos.get(i * m)) {
//                    eratos.set(i * m, false);
//                }
//                m++;
//            }
//        }
//
//        StringBuilder sb = new StringBuilder();
//        for (int i = 0; i <= largestNumber; i++) {
//            if (eratos.get(i)) {
//                sb.append(i).append(" ");
//            }
//        }
//
//        return sb.toString();
//    }

}
