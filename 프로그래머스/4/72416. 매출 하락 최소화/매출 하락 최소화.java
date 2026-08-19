import java.util.*;

class Solution {
    List<Integer>[] tree;
    int[][] dp;
    int[] _sales;
    
    public int solution(int[] sales, int[][] links) {
        int answer = 0;
        
        int n = sales.length;
        _sales = new int[n+1];
        for(int i = 1; i <= n; i++) {
            _sales[i] = sales[i-1];
        }
        
        tree = new ArrayList[n+1];
        for(int i = 0; i <= n; i++) {
            tree[i] = new ArrayList<>();
        }
        
        for(int i = 0; i < links.length; i++) {
            tree[links[i][0]].add(links[i][1]);
        }
        
        dp = new int[n+1][2];   // 0: 참여X, 1: 참여O
        
        dfs(1);
        
        return Math.min(dp[1][0], dp[1][1]);
    }
    
    public void dfs(int cur) {
        dp[cur][1] = _sales[cur];
        
        if(tree[cur].size() == 0) return;
        
        int minChild = -1;
        int diff = Integer.MAX_VALUE;
        
        for(int child : tree[cur]) {
            dfs(child);
            
            // 내가 참여하는 경우에는 자식의 참여여부와 상관없이 작은 값을 가져오면 된다
            dp[cur][1] += Math.min(dp[child][0], dp[child][1]);
            
            // 내가 참여하지 않는 경우에는? 
            // 각 자식은 참여/불참 중 더 싼 상태를 선택, 비용이 가장 적게 드는 자식을 저장
            dp[cur][0] += Math.min(dp[child][0], dp[child][1]);
            int temp = dp[child][1] - dp[child][0];

            if(diff > temp) {
                minChild = child;
                diff = temp;
            }
        }
        
        dp[cur][0] -= Math.min(dp[minChild][0], dp[minChild][1]);
        dp[cur][0] += dp[minChild][1];
   
    }
    
}