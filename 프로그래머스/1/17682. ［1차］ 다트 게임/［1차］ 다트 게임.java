import java.util.*;

class Solution {
    public int solution(String dartResult) {
        int answer = 0;
        
        Map<Integer, Integer> map = new HashMap<>();
        
        String value = "";
        int idx = 1;
        for(int i = 0; i < dartResult.length(); i++) {
            char ch = dartResult.charAt(i);
            if(ch == 'S') {
                map.put(idx++, Integer.parseInt(value));
                value = "";
            } else if(ch == 'D') {
                map.put(idx++, Integer.parseInt(value) * Integer.parseInt(value));
                value = "";
            } else if(ch == 'T') {
                map.put(idx++, Integer.parseInt(value) * Integer.parseInt(value) * Integer.parseInt(value));
                value = "";
            } else if(ch == '*') {
                map.put(idx-1, map.get(idx-1)*2);
                if(idx >= 3) map.put(idx-2, map.get(idx-2)*2);
            } else if(ch == '#') {
                map.put(idx-1, map.get(idx-1)*-1);
            } else {
                value += ch;
            }
        }
        
        return map.get(1) + map.get(2) + map.get(3);
    }
}