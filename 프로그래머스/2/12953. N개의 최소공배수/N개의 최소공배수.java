import java.util.*;

class Solution {
    public int solution(int[] arr) {
        Queue<Integer> queue = new LinkedList<>();
        for(int n : arr) {
            queue.add(n);
        }
        
        while(queue.size() >= 2) {
            int n1 = queue.poll();
            int n2 = queue.poll();
            
            int lcm = n1 * (n2 / gcd(n1, n2));
            
            queue.add(lcm);
        }
        
        return queue.poll();
    }
    
    public int gcd(int a, int b) {
        if(b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }
    
}