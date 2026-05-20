import java.util.*;

class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;
        
        Map<String, Integer> map = new HashMap<>();
        
        for(int i = 0; i < want.length; i++) {
            map.put(want[i], number[i]);
        }
        
        for(int i = 0; i < discount.length; i++) {
            Map<String, Integer> buy = new HashMap<>();
            boolean flag = true;
            if(i + 10 > discount.length) break;
            for(int j = i; j < i + 10; j++) {
                buy.put(discount[j], buy.getOrDefault(discount[j], 0) + 1);
            }
            
            for(Map.Entry<String, Integer> entry : map.entrySet()) {
                int need = entry.getValue();
                int have = buy.getOrDefault(entry.getKey(), 0);
                if(have < need) {
                    flag = false;
                    break;
                }
            }
            
            if(flag) {
                answer++;
            }
        }
        
        return answer;
    }
}