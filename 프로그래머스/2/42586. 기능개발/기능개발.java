import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {

        int[] days = new int[progresses.length];
        for(int i =  0; i < progresses.length; i++) {
            int remaining = (100 - progresses[i]);
            int day = remaining % speeds[i] == 0 ? (remaining / speeds[i]) : (remaining / speeds[i]) + 1;
            days[i] = day;
        }

        List<Integer> result = new ArrayList<>();
        int day = days[0];
        int cnt = 1;
        
        for(int i = 1; i < days.length; i++) {
            if(days[i] <= day) {
                cnt++;
            } else {
                result.add(cnt);
                day = days[i];
                cnt = 1;
            }
        }
        result.add(cnt);
        
        return result.stream().mapToInt(Integer::intValue).toArray();
    }
}