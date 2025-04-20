package programmers.stack_queue;

import java.util.*;

public class Correct_Parentheses {
    public static boolean solution(String s) {
        boolean answer = true;

        Stack<String> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(")");
            } else if (s.charAt(i) == ')') {
                if (stack.isEmpty()) {
                    return false;
                } else if (stack.peek().equals(")")) {
                    stack.pop();
                }
            }
        }

        if (!stack.isEmpty()) answer = false;
        return answer;
    }

    public static void main(String[] args) {
        String[] s = {
            "()()()",
            "(())()",
            ")()(",
            "(()("
        };

        for (String item : s) {
            System.out.println(solution(item));
        }
    }
}
