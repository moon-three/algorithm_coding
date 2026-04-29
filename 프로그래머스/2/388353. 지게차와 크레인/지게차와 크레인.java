import java.util.*;

class Solution {
    int[][] dirs = new int[][] {
        {-1, 0}, {1, 0}, {0, -1}, {0, 1}
    };
    int N, M;
    char[][] map;
    final char ROAD = '0';
    final char ESCAPE = '1';
    public int solution(String[] storage, String[] requests) {
        N = storage.length;
        M = storage[0].length();
        map = new char[N][M];
        // 초기화
        for(int n = 0; n < N; n++) {
            String s = storage[n];
            for(int m = 0; m < M; m++) {
                map[n][m] = s.charAt(m);
            }
        }
        
        // 반복문 돌면서 
        // 1. 길이가 1인지 2인지 확인
        for(int i = 0; i < requests.length; i++) {
            for(int n = 0; n < N; n++) {
                for(int m = 0; m < M; m++) {
                    if(map[n][m] == requests[i].charAt(0)) {
                         if(requests[i].length() == 1) {
                            useCar(n, m);     
                         } else {
                             map[n][m] = ESCAPE;
                         }
                    }
                }
            }
            resetRoad();
        }
        
        return getCnt();
    }
    
    // 지게차 사용
    // 같은 숫자 지점에서 BFS, 밖으로 연결되어있으면 possible
    public void useCar(int n, int m) {
        Queue<int[]> queue = new LinkedList<>();
        boolean[][] visited = new boolean[N][M];
        queue.add(new int[]{n, m});
        visited[n][m] = true;
        
        while(!queue.isEmpty()) {
            int[] cur = queue.poll();
            int cur_n = cur[0];
            int cur_m = cur[1];
            
            // 사방 돌면서 밖이랑 연결되어있는지 확인
            for(int[] dir : dirs) {
                int next_n = cur_n + dir[0];
                int next_m = cur_m + dir[1];
                // 만약 범위 초과하면 밖이랑 연결된 것
                if(next_n < 0 || next_n >= N || next_m < 0 || next_m >= M) {
                    map[n][m] = ESCAPE;
                    return;
                }
                if(visited[next_n][next_m]) continue;
                // 만약 '길'이면 다시 큐에 담기
                if(map[next_n][next_m] == ROAD) {
                    queue.add(new int[] {next_n, next_m});
                    visited[next_n][next_m] = true;
                }
            }
        }
    }
    
    public void resetRoad() {
        for(int n = 0; n < N; n++) {
            for(int m = 0; m < M; m++) {
                if(map[n][m] == ESCAPE) map[n][m] = ROAD;
            }
        }
    }
    
    public int getCnt() {
        int cnt = 0;
        for(int n = 0; n < N; n++) {
            for(int m = 0; m < M; m++) {
                if(map[n][m] != ROAD) cnt++;
            }
        }
        return cnt;
    }
    
}