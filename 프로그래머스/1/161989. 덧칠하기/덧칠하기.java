import java.util.*;

class Solution {
    public int solution(int n, int m, int[] section) {
        
        int[] arr = new int[n+1];
        Arrays.fill(arr, 1);
        
        for(int i = 0; i < section.length; i++) {
            arr[section[i]] = 0;
        }
        
        int colorCnt = 0;
        
        for(int i = 1; i <= n; i++) {
            if(arr[i] == 1) continue;
            for(int j = i; j < i + m; j++) {
                if(j > n) break;
                arr[j] = 1;
            }
            colorCnt++;
        }
        
        return colorCnt;
    }
}