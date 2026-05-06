import java.util.*;

class Solution {
    public int[] solution(String[] keymap, String[] targets) {
        int[] answer = new int[targets.length];
        
        Map<Character, Integer> map = new HashMap<>();
        
        for(int i = 0; i < keymap.length; i++) {
            for(int j = 0; j < keymap[i].length(); j++) {
                char ch = keymap[i].charAt(j);
                int value = map.getOrDefault(ch, j+1);
                value = Math.min(value, j+1);
                map.put(ch, value);
            }
        }
        
        for(int i = 0; i < targets.length; i++) {
            for(int j = 0; j < targets[i].length(); j++) {
                if(!map.containsKey(targets[i].charAt(j))) {
                    answer[i] = -1;
                    break;
                }
                answer[i] += map.get(targets[i].charAt(j));
            }
        }
        
        return answer;
    }
}