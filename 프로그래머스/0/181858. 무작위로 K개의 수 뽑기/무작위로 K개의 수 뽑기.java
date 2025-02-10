import java.util.ArrayList;
import java.util.List;

class Solution {
    public int[] solution(int[] arr, int k) {
        int[] answer = {};
        
        List<Integer> result = new ArrayList<>();
        
        for(int i = 0; i < arr.length; i++) {
        	if(!result.contains(arr[i])) {
        		result.add(arr[i]);
        	}
        	
        	if(result.size() == k) {
        		break;
        	}
        }
        
        while(result.size() < k) {
        	result.add(-1);
        }
        
        answer = result.stream().mapToInt(i -> i).toArray();
        
        return answer;
    }
}