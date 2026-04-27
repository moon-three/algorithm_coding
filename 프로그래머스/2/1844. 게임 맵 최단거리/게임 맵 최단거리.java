import java.util.*;

class Solution {
    public int solution(int[][] maps) {
        int[][] dirs = new int[][] {
            {-1, 0}, {1, 0}, {0, -1}, {0, 1}  
        };
        int N = maps.length;
        int M = maps[0].length;
        
        int[][] dist = new int[N][M];
        
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0,0});
        dist[0][0] = 1;
        
        while(!queue.isEmpty()) {
            int[] cur = queue.poll();
            int n = cur[0];
            int m = cur[1];
            
            for(int[] dir : dirs) {
                int next_n = n + dir[0];
                int next_m = m + dir[1];
                
                if(next_n < 0 || next_n >= N || next_m < 0 || next_m >= M) continue;
                if(maps[next_n][next_m] == 0) continue;
                if(dist[next_n][next_m] != 0) continue;
                
                dist[next_n][next_m] = dist[n][m] + 1;
                queue.add(new int[]{next_n, next_m});
            }   
        }
        return dist[N-1][M-1] == 0 ?-1 : dist[N-1][M-1];
    }
}