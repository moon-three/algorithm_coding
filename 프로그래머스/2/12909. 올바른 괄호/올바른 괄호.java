import java.util.*;

class Solution {
    boolean solution(String s) {
        Stack<Character> stack = new Stack<>();
        
        if(s.length() % 2 != 0) return false;
        
        for(char ch : s.toCharArray()) {
            if(stack.isEmpty() || ch == '(') stack.push(ch);
            else if(ch == ')' && stack.peek() == '(') stack.pop();
        } 
        
        return stack.isEmpty();
    }
}