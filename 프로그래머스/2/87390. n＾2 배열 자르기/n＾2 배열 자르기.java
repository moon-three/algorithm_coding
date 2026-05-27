import java.util.*;

class Solution {
    public int[] solution(int n, long left, long right) {
        
        List<Integer> list = new ArrayList<>();
        for(long i = left; i <= right; i++) {
            long a = i / n;
            long b = i % n;
            list.add((int)Math.max(a, b) + 1);
        }
        
        return list.stream().mapToInt(Integer::intValue).toArray();
    }
}