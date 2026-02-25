import java.util.*;

class Solution {
    public int solution(int[][] board, int[] moves) {
        int N = board.length;
        int M = board[0].length;
        int result = 0;
        
        Deque<Integer> stack = new ArrayDeque<>();
        for(int move : moves) {
            int moveIdx = move-1;
            int doll = 0;
            for(int i = 0; i < N; i++) {
                if(board[i][moveIdx] != 0) {
                    doll = board[i][moveIdx];
                    board[i][moveIdx] = 0;
                    break;
                }
            }
            if(doll == 0) continue;
            
            if(!stack.isEmpty() && stack.peek() == doll) {
                stack.pop();
                result += 2;
            }
            else stack.push(doll);
            
        }
        return result;
    }
}