import java.util.*;

class Solution {
    public String solution(String s, String skip, int index) {
        String answer = "";
        
        Set<Integer> skips = new HashSet<>();
        
        for(int i = 0; i < skip.length(); i++) {
            int value = skip.charAt(i) - 'a';
            skips.add(value);
        }
        
        for(int i = 0; i < s.length(); i++) {
            int target = s.charAt(i) - 'a';
           
            for(int j = 1; j <= index; j++) {
                target++;
                if(target >= 26) target %= 26;
                if(skips.contains(target)) {
                    j--;
                }
            }
            answer += (char)('a' + target);
        }
        
        return answer;
    }
}