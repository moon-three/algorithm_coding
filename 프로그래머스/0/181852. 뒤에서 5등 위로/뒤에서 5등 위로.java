import java.util.*;

class Solution {
    public int[] solution(int[] num_list) {
        int num = 5;
        int[] answer = new int[num_list.length - num];
        
        Arrays.sort(num_list);
        
        for (int i = 0; i < answer.length; i++) {
            answer[i] = num_list[num + i];
        }
        
        return answer;
    }
}