package org.example.chapter5;

import java.util.Scanner;
import java.util.Stack;

public class SteelBar {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String next = sc.next();
        System.out.println(solution(next));
    }

    private static int solution(String str) {
        int result = 0;
        Stack<Character> stack = new Stack<>();

        boolean cut = false;
        for (char c : str.toCharArray()) {
            if (c == '(') {
                stack.push(c);
                cut = false;
            } else {
                stack.pop();
                if (cut) {
                    result++;
                } else {
                    result += stack.size();
                    cut = true;
                }
            }
        }

        return result;
    }

}
