class Solution {
    public int solution(int[][] board) {
        int answer = 0;
        int n = board.length;
        
        int[][] dirs = {
            {-1, -1}, {-1, 0}, {-1, 1},
            {0, -1}, {0, 1}, {1, -1}, {1, 0}, {1, 1}
        };
        
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(board[i][j] == 1) {
                    for(int[] dir : dirs) {
                        int next_i = i + dir[0];
                        int next_j = j + dir[1];
                        
                        if(next_i < 0 || next_i >= n || next_j < 0 || next_j >= n) continue;
                        if(board[next_i][next_j] == 1) continue;
                        
                        board[next_i][next_j] = 2;
                    }
                }
            }
        }
        
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(board[i][j] == 0) answer++;
            }
        }
        
        return answer;
    }
}