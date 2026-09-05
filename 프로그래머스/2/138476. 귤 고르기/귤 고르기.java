import java.util.*;

class Solution {
    public int solution(int k, int[] tangerine) {
        Map<Integer, Integer> map = new HashMap<>();
        
        for(int i = 0; i < tangerine.length; i++) {
            int size = tangerine[i];
            map.put(size, map.getOrDefault(size, 0) + 1);
        }
        
        List<Map.Entry<Integer, Integer>> list = new ArrayList<>(map.entrySet());
        Collections.sort(list, (a, b) -> b.getValue() - a.getValue());
        
        int cnt = 0;
        int type = 0;
        for(Map.Entry<Integer, Integer> entry : list) {
            cnt += entry.getValue();
            type++;
            if(cnt >= k) break;
        }
        
        return type;
    }
}