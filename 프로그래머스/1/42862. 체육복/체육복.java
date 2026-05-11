import java.util.*;

// 1. 앞에 애가 2개 가지고 있는 경우
// 2. 뒤에 애는 1개 있는거 뺏어도 뒤에 다른애가 여분 있으면 받으면 되니까.. > 아니네..

class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        
        int[] students = new int[n+1];
        Arrays.fill(students, 1);
        for(int i = 0; i < lost.length; i++) {
            students[lost[i]] = 0;
        }
        
        for(int i = 0; i < reserve.length; i++) {
            students[reserve[i]] += 1;
        }
        
        for(int i = 1; i <= n; i++) {
            if(students[i] != 0) continue;
            
            if(i > 1 && students[i-1] >= 2) {
                students[i-1]--;
                students[i]++;
            } else if(i < n && students[i+1] >= 2) {
                students[i]++;
                students[i+1]--;
            }
        }
        
        int result = 0;
        for(int i = 1; i <= n; i++) {
            if(students[i] >= 1) result++;
        }

        return result;
    }
}