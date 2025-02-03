import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

class Solution {
    public String solution(String s) {
        String answer = "";
        
        char[] cArr = s.toCharArray();
        HashMap<Character, Integer> map = new HashMap<>();
        
        for(int i = 0; i < cArr.length; i++) {
        	map.put(cArr[i], map.getOrDefault(cArr[i], 0) + 1);
        }
        
        List<Character> list = new ArrayList<>(map.keySet());
        Collections.sort(list);

        for (char ch : list) {
        	if(map.get(ch) == 1) {
        		answer += ch;
        	}
        }
        return answer;
    }
}
