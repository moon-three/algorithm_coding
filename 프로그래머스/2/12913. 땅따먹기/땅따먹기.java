class Solution {
    int solution(int[][] land) {
        int n = land.length;
        int m = land[0].length;
        
        int[][] dp = new int[n][m];
        
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                dp[i][j] = land[i][j];
                if(i != 0) {
                    int max = 0;
                    for(int k = 0; k < m; k++) {
                        if(j == k) continue;
                        max = Math.max(max, dp[i-1][k]);
                    }
                    dp[i][j] += max;
                }
            }
        }
        
        int result = 0;
        for(int i = 0; i < 4; i++) {
            result = Math.max(result, dp[n-1][i]);
        }
        
        return result;
    }
}