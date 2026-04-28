class Solution {
    static int maxDepth = 0;
    public int solution(int k, int[][] dungeons) {
        boolean[] visited = new boolean[dungeons.length];
        
        dfs(dungeons, visited, k, 0);
        
        return maxDepth;
    }
    
    public void dfs(int[][] dungeons, boolean[] visited, int k, int depth) {
        maxDepth = Math.max(maxDepth, depth);
        
        for(int i = 0; i < dungeons.length; i++) {
            // 방문한적 없고, k가 필요피로도 보다 크면 던전 들어가기
            if(!visited[i] && k >= dungeons[i][0]) { 
                visited[i] = true;
                dfs(dungeons, visited, k-dungeons[i][1], depth+1);
                visited[i] = false;
            }
        }
        
    }
}