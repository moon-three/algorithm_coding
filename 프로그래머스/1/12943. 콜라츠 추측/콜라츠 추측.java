class Solution {
    public int solution(int num) {    
        if(num == 1) {
            return 0;
        }
        
        int cnt = 0;
        
        while(num > 1) {
            if(cnt >= 500) return -1;
            
            if(num % 2 == 0) {
                num /= 2;
            } else {
                num = num * 3 + 1;
            }
            cnt++;
        }
    
        return num==1? cnt:-1;
    }
}