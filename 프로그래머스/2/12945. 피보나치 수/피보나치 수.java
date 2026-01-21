class Solution {
    static int[] dp;
    public int solution(int n) {
        return fibonacci(n);
    }
    
    public int fibonacci(int n) {
        dp = new int[n+1];
        dp[1] = 1;
        for(int i = 2; i <= n; i++) {
            dp[i] = (dp[i-2] % 1234567 + dp[i-1] % 1234567) % 1234567;
        }
        return dp[n];
    }
}