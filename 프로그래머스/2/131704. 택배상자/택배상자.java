import java.util.*;

class Solution {
    public int solution(int[] order) {
        int answer = 0;
       
        ArrayDeque<Integer> stack = new ArrayDeque();
        
        int cur = 1;
        for(int target : order) {
            while(cur < target) {
                stack.push(cur++);
            }
            if(cur == target) {
                answer++;
                cur++;
            } else if(!stack.isEmpty() && stack.peek() == target) {
                answer++;
                stack.pop();
            } else {
                break;
            }
        }
        
        return answer;
    }
}