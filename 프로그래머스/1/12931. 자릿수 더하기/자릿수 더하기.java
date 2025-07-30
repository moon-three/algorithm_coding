import java.util.*;

public class Solution {
    public int solution(int n) {
        int answer = 0;

        String nToStr = String.valueOf(n);
        for(int i = 0; i < nToStr.length(); i++) {
            answer += nToStr.charAt(i) - '0';
        }
        
        return answer;
    }
}