import java.util.*;

class Solution {
    public int[] solution(int []arr) {

        Stack<Integer> stack = new Stack<>();

        for(int i = 0; i < arr.length; i++) {
        	int num = arr[i];
        	
        	if(stack.isEmpty() || stack.peek() != num) {
        		stack.push(num);
        	} else {
        		continue;
        	}
        }
        
      int[] answer = new int[stack.size()];
      
      for(int i = 0; i < answer.length; i++) {
    	  answer[i] = stack.get(i);
      }
        
        return answer;
    }
    
}