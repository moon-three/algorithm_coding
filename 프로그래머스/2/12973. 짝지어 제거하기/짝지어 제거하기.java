import java.util.*;

class Solution {
    public int solution(String s) {
        Deque<Character> stack = new ArrayDeque<>();
        char[] chs = s.toCharArray();
        
        for(int i = 0; i < chs.length; i++) {
            if(!stack.isEmpty() && stack.peek() == chs[i]) {
                stack.pop();
            } else {
                stack.push(chs[i]);
            }
        }
           
        return stack.isEmpty() ? 1 : 0;
    }
}