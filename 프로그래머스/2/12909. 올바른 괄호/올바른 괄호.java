import java.util.Stack;

class Solution {
    boolean solution(String s) {

        Stack<Character> stack = new Stack<>();
        char[] chs = s.toCharArray();

        for (char cur : chs) {
            if (cur == ')') {
                if (stack.isEmpty()) {
                    return false;
                } else if (stack.peek() == '(') {
                    stack.pop();
                    continue;
                } else {
                    return false;
                }
            }
            stack.push(cur);
        }

        return stack.isEmpty();
    }
}