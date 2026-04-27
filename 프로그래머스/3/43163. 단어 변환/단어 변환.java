import java.util.*;

class Solution {
    class Word {
        String value;
        int depth;
        
        public Word(String value, int depth) {
            this.value = value;
            this.depth = depth;
        }
    }
    
    public int solution(String begin, String target, String[] words) {
        boolean[] visited = new boolean[words.length];
        
        Queue<Word> queue = new LinkedList<>();
        queue.add(new Word(begin, 0));
        
        while(!queue.isEmpty()) {
            Word cur = queue.poll();
            String value = cur.value;
            int depth = cur.depth;
            
            if(value.equals(target)) return depth;
            
            for(int i = 0; i < words.length; i++) {
                if(visited[i]) continue;
                boolean result = isPossible(value, words[i]);
                if(result) {
                    visited[i] = true;
                    queue.add(new Word(words[i], depth+1));
                }
            }
        }
        
        return 0;
    }
    
    public boolean isPossible(String a, String b) {
        int length = a.length();
        char[] a_arr = a.toCharArray();
        char[] b_arr = b.toCharArray();
        
        int cnt = 0;
        for(int i = 0; i < length; i++) {
            if(a_arr[i] != b_arr[i]) cnt++;
            if(cnt > 1) return false;
        }
        return true;
    }
}