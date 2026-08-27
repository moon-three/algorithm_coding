class Solution {
    public int solution(int[][] signals) {

        int limit = signals[0][0] + signals[0][1] + signals[0][2];
        for(int i = 1; i < signals.length; i++) {
            int period = signals[i][0] + signals[i][1] + signals[i][2];
            limit = lcm(limit, period);
        }
        
        for(int time = 1; time <= limit; time++) {
            
            boolean isYellow = true;
            
            for(int i = 0; i < signals.length; i++) {
                int g = signals[i][0];
                int y = signals[i][1];
                int r = signals[i][2];
                
                int cycle = g + y + r;
                int cur = time % cycle;
                
                if(!(g < cur && cur <= g + y)) {
                    isYellow = false;
                    break;
                }
            }
            
            if(isYellow) {
                return time;
            }
            
        }
        
        return -1;
    }
    
    int gcd(int a, int b) {
        while(b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }
    
    int lcm(int a, int b) {
        return a / gcd(a, b) * b;
    }
}
