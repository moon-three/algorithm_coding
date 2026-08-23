class Solution {
    public int solution(int n, int w, int num) {
        
        int curR = (num + w - 1) / w; // 현재 행
        int curC;   // 현재 열
        
        if(curR % 2 == 0) {
            curC = (w - 1) - (num - 1) % w;
        } else {
            curC = (num - 1) % w;
        }
        
        int floor = n / w;
        int remain = n % w;
        
        int total = floor;
        
        if(remain != 0) {
            if((floor + 1) % 2 == 0) {
                if(curC >= w - remain) total++;
            } else {
                if(curC < remain) total++;
            }
        }
        
        return total - curR + 1;
    }
}