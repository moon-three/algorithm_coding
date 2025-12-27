import java.util.*;

class Solution {
    public int solution(String[][] clothes) {
        int answer = 0;
        
        HashMap<String, Integer> hm = new HashMap<>();
        
        for(int i = 0; i < clothes.length; i++) {
            // 각각 의상 종류에 해당하는 옷을 안 착용하는 경우를 위해 default를 1로 잡음
            hm.put(clothes[i][1], hm.getOrDefault(clothes[i][1], 1) + 1);
        }
        
        int result = 1;
        for(Map.Entry<String, Integer> entry : hm.entrySet()) {
            result *= entry.getValue();
        }
        
        return result-1;
    }
}