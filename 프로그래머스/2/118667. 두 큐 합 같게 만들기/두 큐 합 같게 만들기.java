import java.util.*;

class Solution {
    public int solution(int[] queue1, int[] queue2) {
        int cnt = 0;
        
        Queue<Integer> q1 = new ArrayDeque<>();
        Queue<Integer> q2 = new ArrayDeque<>();
        
        long sum1 = 0;
        long sum2 = 0;
        
        for(int n : queue1) {
            q1.add(n);
            sum1 += n;
        }
        
        for(int n : queue2) {
            q2.add(n);
            sum2 += n;
        }
        
        int max = queue1.length * 3;
        
        while(cnt < max) {
            if(sum1 == sum2) break;
            
            if(sum1 > sum2) {
                int n = q1.poll();
                q2.add(n);
                sum1 -= n;
                sum2 += n;
            } else {
                int n = q2.poll();
                q1.add(n);
                sum1 += n;
                sum2 -= n;
            }
            
            cnt++;
        }
     
        return cnt == max ? -1 : cnt;
    }
}