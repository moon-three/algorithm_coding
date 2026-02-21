import java.util.*;

class Solution {
    boolean solution(String s) {
        Stack<Character> stack = new Stack<>();
        
        if(s.length() % 2 != 0) return false;
        
        for(char ch : s.toCharArray()) {
            if(ch == '(') stack.push(ch);
            else {
                if(stack.isEmpty()) return false;
                stack.pop();
            }
        } 
        
        return stack.isEmpty();
    }
}