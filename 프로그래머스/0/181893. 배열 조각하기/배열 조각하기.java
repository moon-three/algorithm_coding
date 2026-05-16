import java.util.*;

class Solution {
    public int[] solution(int[] arr, int[] query) {
        int startIdx = 0;
        int endIdx = arr.length-1;
        
        for(int i = 0; i < query.length; i++) {
            if(i % 2 == 0) {
                endIdx = startIdx + query[i];
            } else {
                startIdx += query[i];
            }
        }
        List<Integer> result = new ArrayList<>();
        for(int i = startIdx; i <= endIdx; i++) {
            result.add(arr[i]);
        }
        return result.stream().mapToInt(Integer::intValue).toArray();
    }
}