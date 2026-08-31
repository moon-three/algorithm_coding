class Solution {
    public int solution(int m, int n, String[] board) {
        int answer = 0;
        
        char[][] table = new char[m][n];
        
        for(int i = 0; i < m; i++) {
            String data = board[i];
            for(int j = 0; j < n; j++) {
                table[i][j] = data.charAt(j);
            }
        }
        
        while(true) {
            boolean[][] remove = new boolean[m][n];
            int cnt = 0;

            for(int i = 0; i < m - 1; i++) {
                for(int j = 0; j < n - 1; j++) {
                    char cur = table[i][j];
                    if(cur != ' ' 
                        && cur == table[i+1][j] 
                        && cur == table[i][j+1] 
                        && cur == table[i+1][j+1]) {
                        remove[i][j] = true;
                        remove[i+1][j] = true;
                        remove[i][j+1] = true;
                        remove[i+1][j+1] = true;
                    }
                }
            }
            
            for(int i = 0; i < m; i++) {
                for(int j = 0; j < n; j++) {
                    if(remove[i][j]) {
                        cnt++;
                        table[i][j] = ' ';
                    }
                }
            }
            
            if(cnt == 0) break;
        
            answer += cnt;
            
            // 밑으로 내리기
            for(int i = m - 2; i >= 0; i--) {
                for(int j = 0; j < n; j++) {
                    if(table[i][j] == ' ') continue;
                    int move = 0;
                    while(i + move + 1 < m 
                          && table[i + move + 1][j] == ' ') {
                        move++;
                    }
                    if(move > 0) {
                        table[i + move][j] = table[i][j];
                        table[i][j] = ' ';
                    }
                }
            }
            
        }
        
        return answer;
    }
}