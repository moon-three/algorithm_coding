import java.util.*;

class Solution {
    public int solution(int[][] targets) {        
        Arrays.sort(targets, (a, b) -> a[1] - b[1]);
        // System.out.println(Arrays.deepToString(targets));
        int answer = 0;
        int min_e = -1;
        
        for(int[] target : targets) {
            int s = target[0];
            int e = target[1];
            
            if(min_e <= s) {
                answer++;
                min_e = e;
            }
        }
        
        return answer;
    }
}