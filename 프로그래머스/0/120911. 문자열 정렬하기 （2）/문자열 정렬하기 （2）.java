import java.util.*;

class Solution {
    public String solution(String my_string) {
        String answer = "";
        
        my_string = my_string.toLowerCase();
        
        String[] sArr = my_string.split("");
        Arrays.sort(sArr);
        
        for(String s : sArr) {
            answer += s;
        }
        
        return answer;
    }
}