import java.util.Stack;

class Solution {
    public int solution(String s) {
        int answer = 0;

        Stack<Character> stack = new Stack<>();
        for(char ch : s.toCharArray()) {
            if(!stack.isEmpty() && stack.peek() == ch) {
                stack.pop();
                continue;
            }
            stack.push(ch);
        }
        if(stack.isEmpty()) {
            answer = 1;
        }
        
        return answer;
    }
}