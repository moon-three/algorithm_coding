import java.util.*;

class Solution {
    public int solution(int[] A, int[] B) {
        int answer = 0;
        
        Arrays.sort(A);
        Arrays.sort(B);
        
        int idx = 0;
        for(int i = 0; i < A.length; i++) {
            while(idx < B.length && B[idx] <= A[i]) {
                idx++;
            }
            if(idx == B.length) break;
            
            idx++;
            answer++;
        }
        
        return answer;
    }
}