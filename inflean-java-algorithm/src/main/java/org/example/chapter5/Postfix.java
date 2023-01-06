package org.example.chapter5;

import java.util.Scanner;
import java.util.Stack;

public class Postfix {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String next = sc.next();
        System.out.println(solution(next));
    }

    private static int solution(String next) {
        Stack<Integer> stack = new Stack<>();

        for (char c : next.toCharArray()) {
            if (Character.isDigit(c)) {
                stack.push(Integer.parseInt(String.valueOf(c)));
            } else {
                if (!stack.isEmpty() && stack.size() >= 2) {
                    int right = stack.pop();
                    int left = stack.pop();

                    int result = 0;
                    switch (c) {
                        case '+' : result = left + right; break;
                        case '-' : result = left - right; break;
                        case '*' : result = left * right; break;
                        case '/' : result = left / right; break;
                    }

                    stack.push(result);
                }
            }
        }

        return stack.pop();
    }
}
