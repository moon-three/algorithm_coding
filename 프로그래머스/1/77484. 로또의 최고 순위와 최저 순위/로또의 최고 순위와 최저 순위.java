import java.util.*;

class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {
        int[] answer = new int[2];
        
        Map<Integer, Integer> map = Map.of(
            6, 1, 
            5, 2, 
            4, 3, 
            3, 4, 
            2, 5, 
            1, 6, 
            0, 6
        );
        
        int[] lottoNum = new int[46];
        int max = 0;
        int min = 0;
        
        for(int i = 0; i < win_nums.length; i++) {
            lottoNum[win_nums[i]]++;
        }
        
        for(int i = 0; i < lottos.length; i++) {
            if(lottos[i] == 0) {
                max++;
                continue;
            }
            if(lottoNum[lottos[i]] == 1) {
                max++;
                min++;
            }
        }
        
        answer[0] = map.get(max);
        answer[1] = map.get(min);
        return answer;
    }
}