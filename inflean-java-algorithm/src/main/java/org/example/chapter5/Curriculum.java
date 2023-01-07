package org.example.chapter5;

import java.util.Scanner;
import java.util.Stack;

public class Curriculum {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String required = sc.next();
        String plan = sc.next();

        System.out.println(solution(required, plan));
    }

    private static String solution(String required, String plan) {

        Stack<Character> stack = new Stack<>();

        for (int i = required.length() - 1; i >= 0; i--) {
            stack.push(required.charAt(i));
        }

        for (char c : plan.toCharArray()) {
            if (stack.isEmpty()) return "YES";

            if (c == stack.peek()) {
                stack.pop();
            }
        }

        return stack.isEmpty()? "YES" : "NO";
    }

}
