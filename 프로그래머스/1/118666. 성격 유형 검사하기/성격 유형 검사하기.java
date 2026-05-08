import java.util.*;

class Solution {
    public String solution(String[] survey, int[] choices) {
        Map<Character, Integer> map = new HashMap<>();
        
        for(int i = 0; i < choices.length; i++) {
            String s = survey[i];
            int choice = choices[i];
            if(choice == 4) continue;
            char target = 0;
            if(choice < 4) {
                target = s.charAt(0);
            } else {
                target = s.charAt(1);
            }
            map.put(target, map.getOrDefault(target, 0) + Math.abs(4-choice));
        }
        
        String result  = "";
        result += map.getOrDefault('R', 0) >= map.getOrDefault('T', 0) ? 'R' : 'T';
        result += map.getOrDefault('C', 0) >= map.getOrDefault('F', 0) ? 'C' : 'F';
        result += map.getOrDefault('J', 0) >= map.getOrDefault('M', 0) ? 'J' : 'M';
        result += map.getOrDefault('A', 0) >= map.getOrDefault('N', 0) ? 'A' : 'N';
        
        return result;
    }
}