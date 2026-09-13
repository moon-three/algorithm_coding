class Solution {
    public long solution(long n) {        
        double x = Math.pow(n, 0.5);
        
        if(x == (int) x) return (long) Math.pow(x+1, 2);

        return -1;
    }
}