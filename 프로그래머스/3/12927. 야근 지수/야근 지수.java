import java.util.*;

class Solution {
    public long solution(int n, int[] works) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        
        for(int i = 0; i < works.length; i++) {
            pq.add(works[i]);
        }
        
        while(!pq.isEmpty()) {
            int cur = pq.poll();
            cur--;
            n--;
            
            if(cur != 0) pq.add(cur);
            if(n == 0) {
                break;
            }
        }
        
        long result = 0;
        while(!pq.isEmpty()) {
            int cur = pq.poll();
            result += cur * cur;
        }
        
        return result;
    }
}