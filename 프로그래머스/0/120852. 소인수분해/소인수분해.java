import java.util.List;
import java.util.ArrayList;

class Solution {
    public int[] solution(int n) {
        int[] answer = {};
        
        List<Integer> list = new ArrayList<>();
        
        for(int i = 2; i <= n; i++) {
            if(n % i != 0) continue;
            boolean flag = false;
            for(int j = 2; j < i; j++) {
                if(i % j == 0) {
                    flag = true;
                    break;
                }
            }
            if (!flag) list.add(i);
        }
        
        answer = list.stream().mapToInt(Integer::intValue).toArray();
        return answer;
    }
}