import java.util.*;

class Solution {
    public int solution(int[] people, int limit) {
        Arrays.sort(people);
        
        int thin = 0;
        int pig = people.length-1;
        int cnt = 0;
        
        while(thin <= pig) {
            int weight = people[pig] + people[thin];
            if(weight <= limit) thin++;
            pig--;
            cnt++;
        }
        
        return cnt;
    }
}