import java.util.HashMap;

class Solution {
    public int solution(String[] strArr) {
        int answer = 0;
        
        HashMap<Integer, Integer> hm = new HashMap<>();
        
        for(int i = 0; i < strArr.length; i++) {
        	int length = strArr[i].length();
        	hm.put(length, hm.getOrDefault(length, 0) + 1);
        }
                
        for(int key : hm.keySet()) {
        	if(hm.get(key) > answer) answer = hm.get(key);
        }
        	
        return answer;
    }
}