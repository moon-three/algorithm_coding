class Solution {
    public int solution(int[] schedules, int[][] timelogs, int startday) {
        int cnt = 0;
        int N = timelogs.length;
        int M = timelogs[0].length;
        
        for(int n = 0; n < N; n++) {
            int day = startday;
            boolean flag = true;
            int hour = schedules[n] / 100;
            int min = schedules[n] % 100 + 10; 
            
            if(min >= 60) {
                hour++;
                min %= 60;   
            }
            
            int time = hour * 100 + min;
            
            for(int m = 0; m < M; m++) {
                if(day % 7 == 0 || day % 7 == 6) {
                    day++;
                    continue;
                }
                if(time < timelogs[n][m]) {
                    flag = false;
                    break;
                }  
                day++;
            }
            if(flag) cnt++;
        }
        
        return cnt;
    }
}