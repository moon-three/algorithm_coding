import java.util.*;

class Solution {
    public int[][] solution(int[][] rc, String[] operations) {
        Deque<Integer> left = new ArrayDeque<>();
        Deque<Integer> right = new ArrayDeque<>();
        Deque<Deque<Integer>> middle = new ArrayDeque<>();
        
        int r = rc.length;
        int c = rc[0].length;
        
        for(int i = 0; i < r; i++) {
            Deque<Integer> dq = new ArrayDeque<>();
            for(int j = 0; j < c; j++) {
                if(j == 0) left.add(rc[i][j]);
                else if(j == c - 1) right.add(rc[i][j]);
                else dq.add(rc[i][j]);
            }
            middle.add(dq);
        }
  
        for(String cmd : operations) {
            if(cmd.equals("Rotate")) {
                if(c <= 2) {
                    right.addFirst(left.pollFirst());
                    left.addLast(right.pollLast());
                } else {
                    middle.peekFirst().addFirst(left.pollFirst());
                    right.addFirst(middle.peekFirst().pollLast());
                    middle.peekLast().addLast(right.pollLast());
                    left.addLast(middle.peekLast().pollFirst());
                }
            } else {
                left.addFirst(left.pollLast());
                middle.addFirst(middle.pollLast());
                right.addFirst(right.pollLast());
            }
        }

        int[][] answer = new int[r][c];
        
        for(int i = 0; i < r; i++) {
            Deque<Integer> dq = middle.pollFirst();
            for(int j = 0; j < c; j++) {
                if(j == 0) answer[i][j] = left.pollFirst();
                else if(j == c - 1) answer[i][j] = right.pollFirst();
                else answer[i][j] = dq.pollFirst();
            }
        }
        
        return answer;
    }
}