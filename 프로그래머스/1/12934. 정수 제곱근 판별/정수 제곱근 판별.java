class Solution {
    public long solution(long n) {
        long answer = -1;
        
        double d = Math.sqrt(n);
        if(d == (long)d) answer = (long)((d+1)*(d+1));
        
        return answer;
    }
}