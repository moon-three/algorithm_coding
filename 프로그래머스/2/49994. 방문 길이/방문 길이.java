import java.util.*;

class Solution {
    public int solution(String dirs) {
        int answer = 0;
        int[][] mat = new int[11][11];
        Set<String> set = new HashSet<>();
        
        int x = 0;
        int y = 0;
        for(int i = 0; i < dirs.length(); i++) {
            char ch = dirs.charAt(i);
            int next_x = x;
            int next_y = y;
            if(ch == 'U' && y + 1 <= 5) {
                next_y++;
            } else if(ch == 'D' && y - 1 >= -5) {
                next_y--;
            } else if(ch == 'R' && x + 1 <= 5) {
                next_x++;
            } else if(ch == 'L' && x - 1 >= -5) {
                next_x--;
            }
            
            if(x == next_x && y == next_y) continue;
            
            if(!set.contains(x + " " + y + " -> " + next_x + " " + next_y)) {
                answer++;
                set.add(x + " " + y + " -> " + next_x + " " + next_y);
                set.add(next_x + " " + next_y + " -> " + x + " " + y);
            }
            x = next_x;
            y = next_y;  
        }

        return answer;
    }
}