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
      
                // 만약 (면 넣자
                // ) 이거면 비었는지 안 비었음 안에가 (인지 확인하자
                if(map.keySet().contains(cur)) {    // 닫는 괄호에
                    if(stack.isEmpty() || stack.pop() != map.get(cur)) { // 비어있거나 꺼낸게 짝이 아니면
                        flag = false;
                        break;
                    }
                } else {
                    stack.push(cur);
                }
            }
            if(flag && stack.isEmpty()) answer++;
        }   
        return answer;
    }
}