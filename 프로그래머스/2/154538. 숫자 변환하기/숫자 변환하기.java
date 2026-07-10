import java.util.*;

class Solution {
    public int solution(int x, int y, int n) {        
        int[] visited = new int[y+1];
        Queue<Integer> queue = new LinkedList<>();
        
        if(x == y) return 0;
        
        queue.add(x);
        visited[x] = 0;
        
        while(!queue.isEmpty()) {
            int cur = queue.poll();
            
            for(int next : List.of(cur + n, cur * 2, cur * 3)) {
                if(next > y) continue;
                if(visited[next] != 0) continue;
                queue.add(next);
                visited[next] = visited[cur] + 1;        
            }
        }
        
        return visited[y] == 0 ? -1 : visited[y];
    }
}