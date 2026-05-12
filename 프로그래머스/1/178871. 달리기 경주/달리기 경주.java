import java.util.*;

class Solution {
    public String[] solution(String[] players, String[] callings) {
        String[] grades = new String[players.length + 1];
        Map<String, Integer> map = new HashMap<>();
        
        for(int i = 1; i < grades.length; i++) {
            grades[i] = players[i-1];
            map.put(players[i-1], i);
        }       
        
        for(int i = 0; i < callings.length; i++) {
            int idx = map.get(callings[i]);
            
            grades[idx] = grades[idx-1]; 
            grades[idx-1] = callings[i];
            
            map.put(grades[idx], idx);
            map.put(callings[i], idx-1);
        }

        String[] answer = new String[players.length];
        for(int i = 1; i < grades.length; i++) {
            answer[i-1] = grades[i];
        }
        
        return answer;
    }
}