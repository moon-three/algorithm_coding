import java.util.*;

class Solution {
    public long solution(long n) {
        long answer = 0;
        
        String nToS = String.valueOf(n);
        int[] arr = new int[nToS.length()];
        for(int i = 0; i < nToS.length(); i++) {
            arr[i] = nToS.charAt(i) - '0';
        }
        
        Arrays.sort(arr);
        
        StringBuilder sb = new StringBuilder();
        for(int i = arr.length - 1; i >= 0; i--) {
            sb.append(arr[i]);
        }
  
        answer = Long.parseLong(new String(sb));
        return answer;
    }
}