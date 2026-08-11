import java.util.*;

class Solution {
    public int[] solution(String[] keymap, String[] targets) {  
        Map<Character, Integer> map = new HashMap<>();
        
        for(int i = 0; i < keymap.length; i++) {
            String key = keymap[i];
            for(int j = 0; j < key.length(); j++) {
                char ch = key.charAt(j);
                if(map.containsKey(ch)) {
                    int min = Math.min(map.get(ch), j + 1);
                    map.put(ch, min);
                } else {
                    map.put(ch, j + 1);
                }
            }
        }
        
       int[] answer = new int[targets.length];
        
        for(int i = 0; i < targets.length; i++) {
            String target = targets[i];
            for(int j = 0; j < target.length(); j++) {
                char ch = target.charAt(j);
                if(!map.containsKey(ch)) {
                    answer[i] = -1;
                    break;
                }
                answer[i] += map.get(ch);
            }
        }
        
        return answer;
    }
}