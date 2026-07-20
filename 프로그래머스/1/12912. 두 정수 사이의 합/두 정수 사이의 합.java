class Solution {
    public long solution(int a, int b) {
        if(a == b) return a;
        
        int n = Math.min(a, b);
        int m = Math.max(a, b);

        return (long)(n + m) * (m - n + 1) / 2;
    }
}