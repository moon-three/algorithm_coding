import java.util.*;
// 1. 글자 붙이기 : s + s 
// 2. 인덱스 
class Solution {
    public int solution(String s) {
        int answer = 0;

        
        Map<Character, Character> map = Map.of(
            ')', '(', ']', '[', '}', '{');
        
        int length = s.length();
        for(int i = 0; i < length; i++) {
            Deque<Character> stack = new ArrayDeque<>();
            boolean flag = true;
            for(int j = i; j < i + length; j++) {
                int idx = (j % length);
                char cur = s.charAt(idx);
      
                if(stack.isEmpty()) {
                    if(map.keySet().contains(cur)) {
                        flag = false;
                        break;
                    }
                } else if(stack.peek() == map.get(cur)) {
                    stack.pop();
                    continue;
                }
                stack.push(cur);
            }
            if(flag && stack.isEmpty()) answer++;
        }   
        return answer;
    }
}