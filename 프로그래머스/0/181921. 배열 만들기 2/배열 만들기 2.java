import java.util.ArrayList;
import java.util.List;

class Solution {
    public int[] solution(int l, int r) {
        
        List<Integer> list = new ArrayList<>();
        
        for(int i = l; i <= r; i += 1) {
        	String str = String.valueOf(i);
        	boolean flag = true;
        	for(int j = 0; j < str.length(); j++) {
        		if(str.charAt(j) == '5' || str.charAt(j) == '0') continue;
        		else {
        			flag = false;
        			break;
        		}
        	}
        	if(flag) list.add(i);
        }
        
        int[] answer = new int[list.size()];
        
        if (answer.length == 0) {
        	answer = new int[] {-1};
        }
        else {
        	for(int i = 0; i < list.size(); i++) {
        		answer[i] = list.get(i);
        	}        	
        }
        
        return answer;
    }
}