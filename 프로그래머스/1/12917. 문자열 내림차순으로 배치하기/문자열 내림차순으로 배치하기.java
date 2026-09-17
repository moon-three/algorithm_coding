import java.util.*;

class Solution {
    public String solution(String s) {

        char[] chs = s.toCharArray();
        Arrays.sort(chs);
        
        StringBuilder sb = new StringBuilder();
        
        for(int i = chs.length - 1; i >= 0; i--) {
            sb.append(chs[i]);
        }
        
        return sb.toString();
    }
}