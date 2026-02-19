import java.util.*;

class Solution {
    public int solution(String[][] clothes) {
        Map<String, Integer> map = new HashMap<>();
        
        for(String[] cloth : clothes) {
            map.put(cloth[1], map.getOrDefault(cloth[1], 1) + 1);
        }
        
        int result = 1;
        for(String key : map.keySet()) {
            result *= map.get(key);
        }
        
        return result-1;
    }
}