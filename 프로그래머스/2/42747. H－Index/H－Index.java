import java.util.*;

class Solution {
    public int solution(int[] citations) {
        Arrays.sort(citations); // [0, 1, 3, 5, 6]
        
        for(int i = 0; i < citations.length; i++) {
            int h = citations.length - i; // 인용된 논문 개수 (큰값부터 시작)
            if(citations[i] >= h) return h; // 현재 논문이 h번 이상 인용됐는지 확인
        }
        
        return 0;
    }
}