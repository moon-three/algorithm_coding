import java.util.*;

class Solution {
    public String solution(String s, String skip, int index) {
        StringBuilder sb = new StringBuilder();
        
        for(int i = 0; i < s.length(); i++) {
            char target = s.charAt(i);
           
            for(int j = 1; j <= index; j++) {
                target++;
                if(target > 'z') target -= 26;
                if(skip.contains(String.valueOf(target))) {
                    j--;
                }
            }
            sb.append(target);
        }
        
        return sb.toString();
    }
}