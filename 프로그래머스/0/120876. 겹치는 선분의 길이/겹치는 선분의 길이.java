class Solution {
    public int solution(int[][] lines) {
        int answer = 0;
        
        for(int i = -100; i <= 100; i++) {
            int cnt = 0;
            if(lines[0][0] <= i && i < lines[0][1]) cnt++;
            if(lines[1][0] <= i && i < lines[1][1]) cnt++;
            if(lines[2][0] <= i && i < lines[2][1]) cnt++;
            
            if(cnt >= 2) answer++;
        }
        
        return answer;
    }
}
