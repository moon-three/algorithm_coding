import java.util.*;

class Solution {
    public int[] solution(String msg) {
        Map<String, Integer> map = new HashMap<>();
        
        for(int i = 1; i <= 26; i++) {
            char ch = (char)('A' + i - 1);
            map.put(ch + "", i);
        }

        List<Integer> result = new ArrayList<>();
        
        int idx = 0;
        int value = 27;
        while(idx < msg.length()) {
            String cur = msg.charAt(idx++) + "";
            while(idx < msg.length() && map.containsKey(cur + msg.charAt(idx))) {
                cur += msg.charAt(idx++); 
            }
            
            result.add(map.get(cur));

            if(idx < msg.length()) {
                map.put(cur + msg.charAt(idx), value++);
            }
        }
        
        return result.stream().mapToInt(Integer::intValue).toArray();
    }
}