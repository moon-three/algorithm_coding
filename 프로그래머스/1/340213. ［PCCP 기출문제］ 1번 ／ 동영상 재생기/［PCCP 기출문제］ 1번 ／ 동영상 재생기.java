class Solution {
    public String solution(String video_len, String pos, String op_start, String op_end, String[] commands) {

        int v_len = minuteToSecond(video_len);
        int cur = minuteToSecond(pos);
        int op_s = minuteToSecond(op_start);
        int op_e = minuteToSecond(op_end);
        
        for(int i = 0; i < commands.length; i++) {
            if(op_s <= cur && cur < op_e) cur = op_e;
            
            String cmd = commands[i];
            if(cmd.equals("next")) cur = Math.min(cur + 10, v_len);
            if(cmd.equals("prev")) cur = Math.max(cur - 10, 0);
        }
        
        if(op_s <= cur && cur < op_e) cur = op_e;

        return String.format("%02d:%02d", cur / 60, cur % 60);
    }
    
    int minuteToSecond(String str) {
        String[] time = str.split(":");
        int min = Integer.parseInt(time[0]);
        int sec = Integer.parseInt(time[1]);
        
        return min * 60 + sec; 
    }
}
