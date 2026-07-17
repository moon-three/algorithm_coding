import java.util.*;

class Solution {
    public int solution(int n, int[] stations, int w) {
        int answer = 0;
        
        List<Integer> gap = new ArrayList<>();
        
        int last = 0;
        for(int i = 0; i < stations.length; i++) {
            int s = stations[i] - w;
            if(s - last - 1 > 0) gap.add(s - last - 1);
            last = stations[i] + w;
        }
        if(n - last > 0)  gap.add(n - last);
        
        int available = w * 2 + 1;
        
        for(int num : gap) {
            answer += num % available == 0 ? (num / available) : (num / available) + 1;
        }
        
        return answer;
    }
}