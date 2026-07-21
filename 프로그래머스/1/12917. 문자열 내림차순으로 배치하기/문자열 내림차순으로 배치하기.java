import java.util.*;

class Solution {
    public String solution(String s) {
        char[] chs = s.toCharArray();
        Arrays.sort(chs);
        
        String answer = "";
        
        for(int i = chs.length - 1; i >= 0; i--) {
            answer += chs[i];
        }
        
        return answer;
    }
}