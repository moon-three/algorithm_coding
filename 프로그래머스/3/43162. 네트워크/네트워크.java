class Solution {
    public int solution(int n, int[][] computers) {
        int answer = 0;
        boolean[] visited = new boolean[n];
        
        for(int i = 0; i < n; i++) {
            if(!visited[i]) {
                dfs(i, computers, visited);
                answer++;
            }
        }
        
        return answer;
    }
    
    public void dfs(int num, int[][] computers, boolean[] visited) {
        visited[num] = true;
        for(int i = 0; i < computers.length; i++) {
            if(computers[num][i] == 1 && !visited[i]) {
                dfs(i, computers, visited);
            }
        }
    }
}