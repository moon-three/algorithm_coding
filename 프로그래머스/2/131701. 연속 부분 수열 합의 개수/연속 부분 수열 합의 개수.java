import java.util.*;

class Solution {
    public int solution(int[] elements) {
        int n = elements.length;
        Set<Integer> set = new HashSet<>();

        for(int i = 0; i < n; i++) {
            int sum = 0;

            for(int len = 0; len < n; len++) {
                int idx = (i + len) % n;
                sum += elements[idx];
                set.add(sum);
            }
        }
        
        return set.size();
    }
}